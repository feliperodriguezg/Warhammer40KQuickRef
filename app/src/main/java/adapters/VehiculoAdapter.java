package adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.frg.solutions.warhammer40kquickref.R;
import com.frg.solutions.warhammer40kquickref.VehiculoOnClickListener;

import java.util.ArrayList;

import model.TipoVehiculo;
import model.Vehiculo;

/**
 * Created by felipe on 14/08/14.
 */
public class VehiculoAdapter extends W40KAdapterBase {

    private Activity activity;

    public VehiculoAdapter(Context context, Activity activity, ArrayList datos) {
        super(context, datos);
        this.activity = activity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.item_vehiculo, null);
            holder = new ViewHolder();
            holder.nombre = (TextView) convertView.findViewById(R.id.item_vehiculo_nombre);
            holder.hp = (TextView) convertView.findViewById(R.id.item_vehiculo_hp);
            holder.bf = (TextView) convertView.findViewById(R.id.item_vehiculo_bf);
            holder.bl = (TextView) convertView.findViewById(R.id.item_vehiculo_bl);
            holder.bt = (TextView) convertView.findViewById(R.id.item_vehiculo_bt);
            holder.pa = (TextView) convertView.findViewById(R.id.item_vehiculo_pa);
            holder.pagina = (TextView) convertView.findViewById(R.id.item_vehiculo_pagina);
            holder.tiposVehiculo = (LinearLayout) convertView.findViewById(R.id.layout_lista_tipo_vehiculo);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Vehiculo vehiculo = (Vehiculo)datos.get(position);
        holder.nombre.setText(vehiculo.getNombre());
        holder.hp.setText(vehiculo.getHp().toString());
        holder.bf.setText(vehiculo.getBf().toString());
        holder.bl.setText(vehiculo.getBl().toString());
        holder.bt.setText(vehiculo.getBt().toString());
        holder.pa.setText(vehiculo.getPa().toString());
        holder.pagina.setText(vehiculo.getPagina().toString());

        AddTiposVehiculo(vehiculo, holder);


        return convertView;
    }

    private void AddTiposVehiculo(Vehiculo vehiculo, ViewHolder holder){

        ArrayList<TipoVehiculo> listaTipoVehiculo = vehiculo.getListaTipoVehiculo();
        Log.d("TEST", "TIPOS EN ADAPTER:" + vehiculo.getListaTipoVehiculo().size());
        for(int i = 0; i < listaTipoVehiculo.size(); i++){
            TipoVehiculo tVehiculo = listaTipoVehiculo.get(i);

            LayoutInflater layoutInflaterTVehiculo = (LayoutInflater)
                    super.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            LinearLayout lyTipoVehiculo =
                    (LinearLayout) layoutInflaterTVehiculo.inflate(R.layout.item_tipo_vehiculo, null);

            ((TextView) lyTipoVehiculo.findViewById(R.id.item_tipo_vehiculo_nombre)).setText(tVehiculo.getNombre());
            //Programamos evento on click para lanzar un modal con el título y la descripción
            /*lyTipoVehiculo.setOnClickListener(new VehiculoOnClickListener(tVehiculo) {
                @Override
                public void onClick(View view) {
                    TipoVehiculo vehiculoOnClick = this.getTVehiculo();
                    String nombre = vehiculoOnClick.getNombre();
                    String descripcion = vehiculoOnClick.getDescripcion();
                    Log.d("TEST", nombre);
                    //Toast.makeText(context, value, Toast.LENGTH_LONG).show();
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder
                            .setMessage(nombre)
                            .setTitle(descripcion);

                    AlertDialog dialog = builder.create();
                    dialog.show();

                }
            });*/

            holder.tiposVehiculo.addView(lyTipoVehiculo);
        }
    }

    static class ViewHolder{
        static TextView nombre;
        static TextView hp;
        static TextView bf;
        static TextView bl;
        static TextView bt;
        static TextView pa;
        static TextView pagina;
        static LinearLayout tiposVehiculo;
    }
}
