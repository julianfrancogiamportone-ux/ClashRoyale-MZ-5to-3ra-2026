package clashroyale.entidades;
import java.util.ArrayList;

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
        private ArrayList<arma> inventario;
        private ArrayList<ataque> habilidades;
        
        
        
        public peleador(long id, String nombre, int puntosVida, int energia, float defensaBase, arma armaEquipada, ArrayList<arma> inventario, ArrayList<ataque> habilidades) {
            this.id = id;
            this.nombre = nombre;
            this.puntosVida = puntosVida;
            this.energia = energia;
            this.defensaBase = defensaBase;
            this.armaEquipada = armaEquipada;
            this.inventario = inventario;
            this.habilidades = habilidades;
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



        public ArrayList<arma> getInventario() {
            return inventario;
        }



        public ArrayList<ataque> getHabilidades() {
            return habilidades;
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



        public void setInventario(ArrayList<arma> inventario) {
            this.inventario = inventario;
        }



        public void setHabilidades(ArrayList<ataque> habilidades) {
            this.habilidades = habilidades;
        }


        

    

 








        
}
