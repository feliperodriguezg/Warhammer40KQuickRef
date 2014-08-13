package adapters;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.frg.solutions.warhammer40kquickref.R;

import java.util.ArrayList;
import model.Infanteria;

/**
 * Created by felipe on 10/08/14.
 */
public class InfanteriaAdapter extends W40KAdapterBase {
    public InfanteriaAdapter(Context context, ArrayList datos) {
        super(context, datos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.item_infanteria, null);

            holder = new ViewHolder();
            holder.nombre = (TextView) convertView.findViewById(R.id.item_infanteria_nombre);
            holder.ha = (TextView)  convertView.findViewById(R.id.item_infanteria_ha);
            holder.hp = (TextView) convertView.findViewById(R.id.item_infanteria_hp);
            holder.f = (TextView) convertView.findViewById(R.id.item_infanteria_f);
            holder.r = (TextView) convertView.findViewById(R.id.item_infanteria_r);
            holder.i = (TextView) convertView.findViewById(R.id.item_infanteria_i);
            holder.h = (TextView) convertView.findViewById(R.id.item_infanteria_h);
            holder.a = (TextView) convertView.findViewById(R.id.item_infanteria_a);
            holder.l = (TextView) convertView.findViewById(R.id.item_infanteria_l);
            holder.s = (TextView) convertView.findViewById(R.id.item_infanteria_s);
            holder.si = (TextView) convertView.findViewById(R.id.item_infanteria_si);
            holder.pagina = (TextView) convertView.findViewById(R.id.item_infanteria_pagina);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Infanteria infanteria = (Infanteria)datos.get(position);

        holder.nombre.setText(infanteria.getNombre());
        holder.ha.setText(infanteria.getHabilidadArma().toString());
        holder.pagina.setText(infanteria.getPagina().toString());
        holder.hp.setText(infanteria.getHabilidadProyectiles().toString());
        holder.f.setText(infanteria.getFuerza().toString());
        holder.r.setText(infanteria.getResistencia().toString());
        holder.h.setText(infanteria.getHeridas().toString());
        holder.i.setText(infanteria.getIniciativa().toString());
        holder.a.setText(infanteria.getAtaque().toString());
        holder.l.setText(infanteria.getLiderazgo().toString());
        holder.s.setText(infanteria.getSalvacion().toString());
        holder.si.setText(infanteria.getSalvacionInvulnerable().toString());

        return convertView;
    }

    static class ViewHolder{
        TextView nombre;
        TextView ha;
        TextView hp;
        TextView f;
        TextView r;
        TextView i;
        TextView h;
        TextView a;
        TextView l;
        TextView s;
        TextView si;
        TextView pagina;
    }
}
