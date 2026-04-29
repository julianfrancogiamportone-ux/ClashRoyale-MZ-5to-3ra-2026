package clashroyale.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Ataque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int costoEnergia;
    private int danioBase;

    @ManyToMany(mappedBy = "listaataques")
    private List<Peleador> listapeleadores;

    public Ataque(Long id, String nombre, int costoEnergia, int danioBase) {
        this.id = id;
        this.nombre = nombre;
        this.costoEnergia = costoEnergia;
        this.danioBase = danioBase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getcostoEnergia() {
        return costoEnergia;
    }

    public void setcostoEnergia(int costoEnergia) {
        this.costoEnergia = costoEnergia;
    }

    public int getdanioBase() {
        return danioBase;
    }

    public void setdanioBase(int danioBase) {
        this.danioBase = danioBase;
    }

    public void imprimir() {
        System.out.println("Ataque: " + nombre);
        System.out.println("Costo de energía: " + costoEnergia);
        System.out.println("Daño base: " + danioBase);
    }
}
