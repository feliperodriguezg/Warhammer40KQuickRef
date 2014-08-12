package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.frg.solutions.warhammer40kquickref.R;

import java.util.ArrayList;

import model.Arma;

/**
 * Created by felipe on 9/08/14.
 */
public class ArmasAdapter extends W40KAdapterBase {

    public ArmasAdapter(Context context, ArrayList datos){
        super(context, datos);
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
            holder.tipo = (TextView) convertView.findViewById(R.id.item_arma_tipo);
            holder.pagina = (TextView) convertView.findViewById(R.id.item_arma_pagina);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Arma arma = (Arma)datos.get(position);

        holder.nombre.setText(arma.getNombre());
        holder.alcance.setText(arma.getAlcance());
        holder.fuerza.setText(arma.getF());
        holder.fp.setText(arma.getFP());
        holder.tipo.setText(arma.getTipo());

        return convertView;
    }

    static class ViewHolder{
        TextView nombre;
        TextView alcance;
        TextView fuerza;
        TextView fp;
        TextView tipo;
        TextView pagina;
    }
}
