package clashroyale.entidades;
import java.util.List;

import jakarta.persistence.*;
@Entity
public class peleador {
    @Id 
        @GeneratedValue(strategy = GenerationType.IDENTITY) 
        private long id; 
        private String nombre;
        private int puntosVida; 
        private int energia; 
        private float defensaBase;
        private arma armaEquipada;
        @ManyToMany 
        @JoinTable( 
        // Nombre de la tabla intermedia en SQL 
        name = "peleador_arma", 
        // FK de esta entidad 
        joinColumns = @JoinColumn(name = "peleador_id"),  
        // FK de la otra entidad 
        inverseJoinColumns = @JoinColumn(name = "arma_id")
        ) 
        private List<arma> armas;



        @ManyToMany 
        @JoinTable( 
        // Nombre de la tabla intermedia en SQL 
        name = "peleador_ataque", 
        // FK de esta entidad 
        joinColumns = @JoinColumn(name = "peleador_id"),  
        // FK de la otra entidad 
        inverseJoinColumns = @JoinColumn(name = "ataque_id")  
        ) 
        private List<ataque> ataques;
        
        
        
        public peleador(long id, String nombre, int puntosVida, int energia, float defensaBase, arma armaEquipada, List<arma> armas, List<ataque> ataques) {
            this.id = id;
            this.nombre = nombre;
            this.puntosVida = puntosVida;
            this.energia = energia;
            this.defensaBase = defensaBase;
            this.armaEquipada = armaEquipada;
            this.armas = armas;
            this.ataques = ataques;
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



        public arma getArmaEquipada() {
            return armaEquipada;
        }



        public List<arma> getarmas() {
            return armas;
        }



        public List<ataque> getataques() {
            return ataques;
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



        public void setArmaEquipada(arma armaEquipada) {
            this.armaEquipada = armaEquipada;
        }



        public void setarmas(List<arma> armas) {
            this.armas = armas;
        }



        public void setataques(List<ataque> ataques) {
            this.ataques = ataques;
        }


        

}
