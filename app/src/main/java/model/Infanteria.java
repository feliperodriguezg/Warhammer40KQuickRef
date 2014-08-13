package model;

/**
 * Created by felipe on 7/08/14.
 */
public class Infanteria {
    private String nombre;
    private Integer habilidadArma;
    private Integer habilidadProyectiles;
    private Integer fuerza;
    private Integer resistencia;
    private Integer heridas;
    private Integer iniciativa;
    private Integer ataque;
    private Integer liderazgo;
    private Integer salvacion;
    private Integer salvacionInvulnerable;
    private Integer pagina;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getHabilidadArma() {
        if(habilidadArma == null)
            return 0;
        return habilidadArma;
    }

    public void setHabilidadArma(int habilidadArma) {
        this.habilidadArma = habilidadArma;
    }

    public Integer getHabilidadProyectiles() {
        if(habilidadProyectiles == null)
            return 0;
        return habilidadProyectiles;
    }

    public void setHabilidadProyectiles(int habilidadProyectiles) {
        this.habilidadProyectiles = habilidadProyectiles;
    }

    public Integer getFuerza() {
        if(fuerza== null)
            return 0;
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public Integer getResistencia() {
        if(resistencia == null)
            return 0;

        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public Integer getHeridas() {
        if(heridas == null)
            return 0;
        return heridas;
    }

    public void setHeridas(int heridas) {
        this.heridas = heridas;
    }

    public Integer getIniciativa() {
        if(iniciativa == null)
            return 0;
        return iniciativa;
    }

    public void setIniciativa(int iniciativa) {
        this.iniciativa = iniciativa;
    }

    public Integer getAtaque() {
        if(ataque == null)
            return 0;
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public Integer getLiderazgo() {
        if(liderazgo == null)
            return 0;
        return liderazgo;
    }

    public void setLiderazgo(int liderazgo) {
        this.liderazgo = liderazgo;
    }

    public Integer getSalvacion() {
        if(salvacion == null)
            return 0;
        return salvacion;
    }

    public void setSalvacion(int salvacion) {
        this.salvacion = salvacion;
    }

    public Integer getSalvacionInvulnerable() {
        if(salvacionInvulnerable == null)
            return 0;
        return salvacionInvulnerable;
    }

    public void setSalvacionInvulnerable(int salvacionInvulnerable) {
        this.salvacionInvulnerable = salvacionInvulnerable;
    }

    public Integer getPagina() {
        if(pagina == null)
            return 0;
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }
}
