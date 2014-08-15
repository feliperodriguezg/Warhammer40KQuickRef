package com.frg.solutions.warhammer40kquickref;

import android.view.View;

import model.TipoVehiculo;
import model.Vehiculo;

/**
 * Created by felipe on 14/08/14.
 */
public class VehiculoOnClickListener implements View.OnClickListener {
    private TipoVehiculo tVehiculo;

    @Override
    public void onClick(View view) {

    }
    public VehiculoOnClickListener(TipoVehiculo tVehiculo){
        this.tVehiculo = tVehiculo;
    }
    public TipoVehiculo getTVehiculo(){
        return this.tVehiculo;
    }

}
