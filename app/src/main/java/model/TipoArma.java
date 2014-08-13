package model;

/**
 * Created by felipe on 13/08/14.
 */
public class TipoArma {
    private String codigo;
    private String nombre;
    private Integer cantidad;

    public TipoArma(String codigo, String nombre, Integer cantidad){
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
    public TipoArma(){

    }

    public String getCodigo(){
        return codigo;
    }
    public String getNombre(){
        return nombre;
    }
    public Integer getCantidad(){
        return cantidad;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setCantidad(Integer cantidad){
        this.cantidad = cantidad;
    }
}
