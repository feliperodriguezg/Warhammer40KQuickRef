package model;

/**
 * Created by felipe on 7/08/14.
 */
public class Arma
{
    private String Alcance;

    private String F;

    private String Codigo;

    private String FP;

    private String Id;

    private String Nombre;

    private String Pagina;

    private String Descripcion;

    private String Tipo;

    public String getTipo(){return Tipo;}
    public void setTipo(String tipo){this.Tipo = tipo;}

    public String getAlcance ()
    {
        return Alcance;
    }

    public void setAlcance (String Alcance)
    {
        this.Alcance = Alcance;
    }

    public String getF ()
    {
        return F;
    }

    public void setF (String F)
    {
        this.F = F;
    }

    public String getCodigo ()
    {
        return Codigo;
    }

    public void setCodigo (String Codigo)
    {
        this.Codigo = Codigo;
    }

    public String getFP ()
    {
        return FP;
    }

    public void setFP (String FP)
    {
        this.FP = FP;
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

    public String getPagina ()
    {
        return Pagina;
    }

    public void setPagina (String Pagina)
    {
        this.Pagina = Pagina;
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
