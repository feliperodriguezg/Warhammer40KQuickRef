package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by felipe on 10/08/14.
 */
public class W40KAdapterBase extends BaseAdapter {
    protected ArrayList datos;
    protected LayoutInflater layoutInflater;

    public W40KAdapterBase(Context context, ArrayList datos){
        this.datos = datos;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int i) {
        return datos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        return null;
    }
}
