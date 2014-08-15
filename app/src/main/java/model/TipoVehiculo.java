package model;

/**
 * Created by felipe on 14/08/14.
 */
public class TipoVehiculo {
    private Integer id;
    private String codigoTipoVehiculo;
    private String nombre;
    private String descripcion;
    private Integer pagina;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoTipoVehiculo() {
        return codigoTipoVehiculo;
    }

    public void setCodigoTipoVehiculo(String codigoTipoVehiculo) {
        this.codigoTipoVehiculo = codigoTipoVehiculo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPagina() {
        return pagina;
    }

    public void setPagina(Integer pagina) {
        this.pagina = pagina;
    }
}
