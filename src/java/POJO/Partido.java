package POJO;
// Generated 04-jun-2015 19:06:18 by Hibernate Tools 4.3.1



/**
 * Partido generated by hbm2java
 */
public class Partido  implements java.io.Serializable {


     private Integer idPartido;
     private String nombre;
     private Integer votos;

    public Partido() {
    }

    public Partido(String nombre, Integer votos) {
       this.nombre = nombre;
       this.votos = votos;
    }
   
    public Integer getIdPartido() {
        return this.idPartido;
    }
    
    public void setIdPartido(Integer idPartido) {
        this.idPartido = idPartido;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getVotos() {
        return this.votos;
    }
    
    public void setVotos(Integer votos) {
        this.votos = votos;
    }




}

