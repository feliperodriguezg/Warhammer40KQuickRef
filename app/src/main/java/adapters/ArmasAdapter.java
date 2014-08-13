package adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.frg.solutions.warhammer40kquickref.ArmaOnClickListener;
import com.frg.solutions.warhammer40kquickref.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

import model.Arma;
import model.TipoArma;

/**
 * Created by felipe on 9/08/14.
 */
public class ArmasAdapter extends W40KAdapterBase {

    private Activity activity;

    public ArmasAdapter(Context context, Activity activity, ArrayList datos){
        super(context, datos);
        this.activity = activity;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.item_armas, null);
            holder = new ViewHolder();
            holder.nombre = (TextView) convertView.findViewById(R.id.item_armas_nombre);
            holder.alcance = (TextView) convertView.findViewById(R.id.item_arma_alcance);
            holder.fuerza = (TextView) convertView.findViewById(R.id.item_arma_fuerza);
            holder.fp = (TextView) convertView.findViewById(R.id.item_arma_fp);
            holder.pagina = (TextView) convertView.findViewById(R.id.item_arma_pagina);
            holder.listaTiposArmas = (LinearLayout) convertView.findViewById(R.id.layout_lista_tipo_arma);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Arma arma = (Arma)datos.get(position);

        holder.nombre.setText(arma.getNombre());
        holder.alcance.setText(arma.getAlcance());
        holder.fuerza.setText(arma.getF());
        holder.fp.setText(arma.getFP());
        AddTiposArmas(arma.getTiposArma(), holder);


        return convertView;
    }

    private void AddTiposArmas(ArrayList<TipoArma> listaTipoArmas, ViewHolder holder){

        for(int i = 0; i < listaTipoArmas.size(); i++){
            TipoArma tArma = listaTipoArmas.get(i);

            LayoutInflater layoutInflaterTArmas = (LayoutInflater)
                    super.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            LinearLayout lyTipoArma =
                    (LinearLayout) layoutInflaterTArmas.inflate(R.layout.item_tipo_arma, null);

            ((TextView) lyTipoArma.findViewById(R.id.item_tipo_arma_nombre)).setText(tArma.getNombre());
            if(tArma.getCantidad() > 0)
                ((TextView) lyTipoArma.findViewById(R.id.item_tipo_arma_cantidad)).setText(tArma.getCantidad().toString());
            else
                ((TextView) lyTipoArma.findViewById(R.id.item_tipo_arma_cantidad)).setText("");

            //Programamos evento on click para lanzar un modal con el título y la descripción
            lyTipoArma.setOnClickListener(new ArmaOnClickListener(tArma.getNombre(), tArma.getDescripcion()) {
                @Override
                public void onClick(View view) {
                    String nombre = ((TextView) view.findViewById(R.id.item_tipo_arma_nombre)).getText().toString();
                    String descripcion = ((TextView) view.findViewById(R.id.item_tipo_arma_nombre)).getText().toString();
                    Log.d("TEST", nombre);
                    //Toast.makeText(context, value, Toast.LENGTH_LONG).show();
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder
                            .setMessage(this.getDescripcion())
                            .setTitle(this.getTitulo());

                    AlertDialog dialog = builder.create();
                    dialog.show();

                }
            });

            holder.listaTiposArmas.addView(lyTipoArma);
        }
    }

    static class ViewHolder{
        TextView nombre;
        TextView alcance;
        TextView fuerza;
        TextView fp;
        TextView tipo;
        TextView pagina;
        LinearLayout listaTiposArmas;
        ArrayList<TipoArma> tiposArma;
    }
}
