package entidades;
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
        private Arma armaEquipada;
        private ArrayList [] inventario;
        private ArrayList [] habilidades;
        
        
        
        public peleador(long id, String nombre, int puntosVida, int energia, float defensaBase, Arma armaEquipada, ArrayList[] inventario, ArrayList[] habilidades) {
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



        public Arma getArmaEquipada() {
            return armaEquipada;
        }



        public ArrayList[] getInventario() {
            return inventario;
        }



        public ArrayList[] getHabilidades() {
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



        public void setArmaEquipada(Arma armaEquipada) {
            this.armaEquipada = armaEquipada;
        }



        public void setInventario(ArrayList[] inventario) {
            this.inventario = inventario;
        }



        public void setHabilidades(ArrayList[] habilidades) {
            this.habilidades = habilidades;
        }


        

    

 








        
}
