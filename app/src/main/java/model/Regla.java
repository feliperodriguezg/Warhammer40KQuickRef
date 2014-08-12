package model;

/**
 * Created by felipe on 7/08/14.
 */
public class Regla
{
    private String Codigo;
    private String Id;
    private String Nombre;
    private String Descripcion;

    public String getCodigo ()
    {
        return Codigo;
    }

    public void setCodigo (String Codigo)
    {
        this.Codigo = Codigo;
    }

    public String getId ()
    {
        return Id;
    }

    public void setId (String Id)
    {
        this.Id = Id;
    }

    public String getNombre ()
    {
        return Nombre;
    }

    public void setNombre (String Nombre)
    {
        this.Nombre = Nombre;
    }

    public String getDescripcion ()
    {
        return Descripcion;
    }

    public void setDescripcion (String Descripcion)
    {
        this.Descripcion = Descripcion;
    }
}
