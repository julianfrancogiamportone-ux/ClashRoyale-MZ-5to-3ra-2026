package clashroyale.entidades;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Arma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int bonificadorDanio;
    private float peso;
    
	@ManyToMany(mappedBy = "listaarmas")
	private List<Peleador> listapeleadores;
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getBonificadorDanio() {
		return bonificadorDanio;
	}
	public void setBonificadorDanio(int bonificadorDanio) {
		this.bonificadorDanio = bonificadorDanio;
	}
    public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public Arma(Long id, String nombre, int bonificadorDanio, float peso) {
		this.id = id;
		this.nombre = nombre;
		this.bonificadorDanio = bonificadorDanio;
		this.peso = peso;
	}
}
