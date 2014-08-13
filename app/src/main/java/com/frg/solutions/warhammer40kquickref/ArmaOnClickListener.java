package com.frg.solutions.warhammer40kquickref;

import android.view.View;

/**
 * Created by felipe on 14/08/14.
 */
public class ArmaOnClickListener implements View.OnClickListener {
    private String titulo;
    private String descripcion;

    @Override
    public void onClick(View view) {

    }
    public ArmaOnClickListener(String titulo, String descripcion){
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getDescripcion(){
        return descripcion;
    }
}
