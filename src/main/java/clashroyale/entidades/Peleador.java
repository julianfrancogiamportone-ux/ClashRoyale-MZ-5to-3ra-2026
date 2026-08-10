package clashroyale.entidades;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.*;
@Entity
public class Peleador {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long id; 
    private String nombre;
    private int puntosVida; 
    private int energia; 
    private float defensaBase;
    private String url_imagen; 

    @ManyToMany 
    @JoinTable( 
        // Nombre de la tabla intermedia en SQL 
        name = "peleador_arma", 
        // FK de esta entidad 
        joinColumns = @JoinColumn(name = "peleador_id"),  
        // FK de la otra entidad 
        inverseJoinColumns = @JoinColumn(name = "arma_id")
    ) 
    private List<Arma> listaarmas = new ArrayList<>();

    @ManyToMany 
    @JoinTable( 
        // Nombre de la tabla intermedia en SQL 
        name = "peleador_ataque", 
        // FK de esta entidad 
        joinColumns = @JoinColumn(name = "peleador_id"),  
        // FK de la otra entidad 
        inverseJoinColumns = @JoinColumn(name = "ataque_id")  
    ) 
    private List<Ataque> listaataques = new ArrayList<>();

    public Peleador() {
        // Constructor requerido por JPA
    }

    public Peleador(long id, String nombre, int puntosVida, int energia, float defensaBase) {
        this.id = id;
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.energia = energia;
        this.defensaBase = defensaBase;
    }



        public long getId() {
            return id;
        }



        public String getNombre() {
            return nombre;
        }



        public int getPuntosVida() {
            return puntosVida;
        }



        public int getEnergia() {
            return energia;
        }



        public float getDefensaBase() {
            return defensaBase;
        }









        public void setId(long id) {
            this.id = id;
        }



        public void setNombre(String nombre) {
            this.nombre = nombre;
        }



        public void setPuntosVida(int puntosVida) {
            this.puntosVida = puntosVida;
        }



        public void setEnergia(int energia) {
            this.energia = energia;
        }



        public void setDefensaBase(float defensaBase) {
            this.defensaBase = defensaBase;
        }



        public List<Arma> getListaarmas() {
            return listaarmas;
        }



        public void setListaarmas(List<Arma> listaarmas) {
            this.listaarmas = listaarmas;
        }



        public List<Ataque> getListaataques() {
            return listaataques;
        }



        public void setListaataques(List<Ataque> listaataques) {
            this.listaataques = listaataques;
        }

        public String getUrl_imagen() {
            return url_imagen;
        }

        public void setUrl_imagen(String url_imagen) {
            this.url_imagen = url_imagen;
        }

}
