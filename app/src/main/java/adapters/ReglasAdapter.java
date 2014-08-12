package adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.frg.solutions.warhammer40kquickref.R;

import java.util.ArrayList;

import model.Regla;

/**
 * Created by felipe on 9/08/14.
 */
public class ReglasAdapter extends W40KAdapterBase {

    public ReglasAdapter(Context context, ArrayList datos){
        super(context, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.item_reglas, null);
            holder = new ViewHolder();
            holder.titulo = (TextView) convertView.findViewById(R.id.txtTituloRegla);
            holder.descripcion = (TextView) convertView.findViewById(R.id.txtDescripcionRegla);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Regla regla = (Regla)datos.get(position);

        holder.titulo.setText(regla.getNombre());
        holder.descripcion.setText(regla.getDescripcion());

        return convertView;
    }

    static class ViewHolder{
        TextView titulo;
        TextView descripcion;
    }
}
