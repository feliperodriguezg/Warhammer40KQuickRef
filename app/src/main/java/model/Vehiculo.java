package model;

import java.util.ArrayList;

/**
 * Created by felipe on 14/08/14.
 */
public class Vehiculo {
    private String nombre;
    private String codigo;
    private String slot;
    private Integer hp;
    private Integer bf;
    private Integer bl;
    private Integer bt;
    private Integer pa;
    private Integer pagina;
    private ArrayList<Regla> listaReglas;
    private ArrayList<Arma> listaArmas;

    public ArrayList<TipoVehiculo> getListaTipoVehiculo() {
        return listaTipoVehiculo;
    }

    public void setListaTipoVehiculo(ArrayList<TipoVehiculo> listaTipoVehiculo) {
        this.listaTipoVehiculo = listaTipoVehiculo;
    }

    public ArrayList<Arma> getListaArmas() {
        return listaArmas;
    }

    public void setListaArmas(ArrayList<Arma> listaArmas) {
        this.listaArmas = listaArmas;
    }

    public ArrayList<Regla> getListaReglas() {
        return listaReglas;
    }

    public void setListaReglas(ArrayList<Regla> listaReglas) {
        this.listaReglas = listaReglas;
    }
    public void setTipoVehiculo(TipoVehiculo tVehiculo){
        this.listaTipoVehiculo.add(tVehiculo);
    }
    private ArrayList<TipoVehiculo> listaTipoVehiculo;

    public Vehiculo(){
        this.listaReglas = new ArrayList<Regla>();
        this.listaArmas = new ArrayList<Arma>();
        this.listaTipoVehiculo = new ArrayList<TipoVehiculo>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getBf() {
        return bf;
    }

    public void setBf(Integer bf) {
        this.bf = bf;
    }

    public Integer getBl() {
        return bl;
    }

    public void setBl(Integer bl) {
        this.bl = bl;
    }

    public Integer getBt() {
        return bt;
    }

    public void setBt(Integer bt) {
        this.bt = bt;
    }

    public Integer getPa() {
        return pa;
    }

    public void setPa(Integer pa) {
        this.pa = pa;
    }

    public Integer getPagina() {
        return pagina;
    }

    public void setPagina(Integer pagina) {
        this.pagina = pagina;
    }
}
