package data;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.frg.solutions.warhammer40kquickref.R;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import adapters.ArmasAdapter;
import adapters.InfanteriaAdapter;
import adapters.ReglasAdapter;
import model.Arma;
import model.Infanteria;
import model.Regla;
import model.TipoArma;

/**
 * Created by felipe on 7/08/14.
 */
public class ReaderJsonData extends AsyncTask<String, Integer, Boolean> {

    private final static String KEY_PREFERENCES_DATA = "JSONData";
    public ListView lista;
    public Context context;
    public JSONObject jsonResp;
    public int Tab;
    public SharedPreferences prefs;
    //Para el tab de infantería
    public ListView listaCG;
    public ListView listaLinea;
    public ListView listaElite;
    public ListView listaApoyoPesado;
    public ListView listaAtaqueRapido;

    @Override
    protected Boolean doInBackground(String... strings) {

        Boolean result = false;

        try {
            prefs.edit().remove(KEY_PREFERENCES_DATA).apply();

            String dataStr = prefs.getString(KEY_PREFERENCES_DATA, "");

            if( !dataStr.isEmpty() ){
                result = true;
                jsonResp = new JSONObject(dataStr);
            }else {


                HttpClient httpClient = new DefaultHttpClient();
                HttpGet get = new HttpGet("http://192.168.1.7:3000/ejercitos/1");
                get.setHeader("content-type", "application/json");

                HttpResponse resp = httpClient.execute(get);
                String respStr = EntityUtils.toString(resp.getEntity());

                prefs
                        .edit()
                        .putString(KEY_PREFERENCES_DATA, respStr)
                        .apply();

                jsonResp = new JSONObject(respStr);



                Log.d("TEST", "Resultado: " + respStr);
                result = true;
            }
            return result;

        } catch (Exception e) {
            Log.e("doInBackground ERROR", "Error: " + e.getMessage());
            e.printStackTrace();
        }


        return result;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        Log.d("TEST", "Insertado: " + aBoolean.toString());
        if(jsonResp != null) {
            ArrayList datosLista = new ArrayList();
            try {
                JSONArray jsonArray;
                int i;
                if (Tab == R.layout.tab_reglas) {
                    jsonArray = jsonResp.getJSONArray("Reglas");
                    for (i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Regla r = new Regla();
                        r.setNombre(jsonObject.getString("Nombre"));
                        r.setDescripcion(jsonObject.getString("Descripcion").replace("<br>", "\r\n"));

                        datosLista.add(r);
                    }

                    ReglasAdapter reglasAdapter = new ReglasAdapter(context, datosLista);
                    lista.setAdapter(reglasAdapter);
                }
                if (Tab == R.layout.tab_armas) {
                    jsonArray = jsonResp.getJSONArray("Armas");

                    for (i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonArma = jsonArray.getJSONObject(i);
                        Arma a = new Arma();
                        a.setNombre(jsonArma.getString("Nombre"));
                        a.setAlcance(jsonArma.getString("Alcance"));
                        a.setF(jsonArma.getString("F"));
                        a.setFP(jsonArma.getString("FP"));
                        a.setPagina(jsonArma.getString("Pagina"));
                        a.setTipo("Fuego rápido 2, Gauss");

                        JSONArray jsonTiposArmas = jsonArma.getJSONArray("TiposArmas");
                        Log.d("TEST", "Tipos armas: " + jsonTiposArmas.length());
                        for(int j = 0; j < jsonTiposArmas.length(); j++){

                            TipoArma tipoArma = new TipoArma();
                            JSONObject jsonTipoArma = jsonTiposArmas.getJSONObject(j);

                            tipoArma.setNombre(jsonTipoArma.getString("NombreTipoArma"));
                            tipoArma.setCodigo(jsonTipoArma.getString("CodigoTipoArma"));
                            tipoArma.setCantidad(jsonTipoArma.getInt("Cantidad"));

                            a.setTipoArma(tipoArma);
                        }

                        datosLista.add(a);
                    }

                    ArmasAdapter armasAdapter = new ArmasAdapter(context, datosLista);
                    lista.setAdapter(armasAdapter);

                }
                if (Tab == R.layout.tab_infanteria) {
                    JSONObject objInfanteria = jsonResp.getJSONObject("Infanteria");
                    if (objInfanteria != null) {
                        JSONArray cg = objInfanteria.getJSONArray("CG");
                        JSONArray linea = objInfanteria.getJSONArray("Linea");
                        JSONArray elite = objInfanteria.getJSONArray("Elite");
                        JSONArray apoyoPesado = objInfanteria.getJSONArray("ApoyoPesado");
                        JSONArray ataqueRapido = objInfanteria.getJSONArray("AtaqueRapido");

                        listaCG.setAdapter(new InfanteriaAdapter(context, RellenarListadoInfanteria(cg)));
                        listaLinea.setAdapter(new InfanteriaAdapter(context, RellenarListadoInfanteria(linea)));
                        listaElite.setAdapter(new InfanteriaAdapter(context, RellenarListadoInfanteria(elite)));
                        listaApoyoPesado.setAdapter(new InfanteriaAdapter(context, RellenarListadoInfanteria(apoyoPesado)));
                        listaAtaqueRapido.setAdapter(new InfanteriaAdapter(context, RellenarListadoInfanteria(ataqueRapido)));
                    }

                }
            } catch (Exception Ex) {

                Log.e("ERROR ReaderJSONData", Ex.getMessage());
            }
        }else{
            Log.w("TEST", "No hay datos de respuesta para mostrar");
        }
    }

    private ArrayList RellenarListadoInfanteria(JSONArray arrayInfanteria){
        ArrayList listaDatos = new ArrayList();
        try {
            Infanteria infanteria;


            for (int i = 0; i < arrayInfanteria.length(); i++) {
                infanteria = new Infanteria();
                JSONObject jsonInfanteria = arrayInfanteria.getJSONObject(i);

                infanteria.setNombre(jsonInfanteria.getString("Nombre"));
                infanteria.setHabilidadArma(GetMinValue(jsonInfanteria.get("HA")));
                infanteria.setHabilidadProyectiles(GetMinValue(jsonInfanteria.get("HP")));
                infanteria.setFuerza(GetMinValue(jsonInfanteria.get("F")));
                infanteria.setResistencia(GetMinValue(jsonInfanteria.get("R")));
                infanteria.setHeridas(GetMinValue(jsonInfanteria.get("H")));
                infanteria.setIniciativa(GetMinValue(jsonInfanteria.get("I")));
                infanteria.setAtaque(GetMinValue(jsonInfanteria.get("A")));
                infanteria.setLiderazgo(GetMinValue(jsonInfanteria.get("L")));
                infanteria.setSalvacion(GetMinValue(jsonInfanteria.get("S")));
                infanteria.setSalvacionInvulnerable(GetMinValue(jsonInfanteria.get("SI")));
                infanteria.setPagina(GetMinValue(jsonInfanteria.get("Pagina")));
                /*Log.d("TEST", "NOMBRE: " + infanteria.getNombre());
                Log.d("TEST", "ha: " + infanteria.getHabilidadArma());
                Log.d("TEST", "hp: " + infanteria.getHabilidadProyectiles());
                Log.d("TEST", "f: " + infanteria.getFuerza());
                Log.d("TEST", "r: " + infanteria.getResistencia());
                Log.d("TEST", "i: " + infanteria.getIniciativa());
                Log.d("TEST", "h: " + infanteria.getHeridas());
                Log.d("TEST", "a: " + infanteria.getAtaque());
                Log.d("TEST", "l: " + infanteria.getLiderazgo());
                Log.d("TEST", "s: " + infanteria.getSalvacion());
                Log.d("TEST", "si: " + infanteria.getSalvacionInvulnerable());
*/
                listaDatos.add(infanteria);
            }
        }catch (Exception ex){
            Log.d("TEST ERROR", ex.getMessage());
        }
        return listaDatos;
    }
    private Integer GetMinValue(Object value){
        try{
            return (Integer)value;
        }catch (Exception ex){
            return 0;
        }
    }
}
