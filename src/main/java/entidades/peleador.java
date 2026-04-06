package entidades;
import jakarta.persistence.*;
@Entity
public class peleador {
    @Id 
        @GeneratedValue(strategy = GenerationType.IDENTITY) 
        private int id; 
    private String nombre;
    private int puntosVida; 
    private int energia; 
    private float defensaBase; 
    private String nombre; 
    private String nombre; 
    private String nombre; 

}
