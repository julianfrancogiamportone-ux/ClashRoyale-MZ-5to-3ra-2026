package clashroyale.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ataque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int costoEnergia;
    private int danioBase;

    @ManyToMany(mappedBy = "ataques")
    private List<ataque> ataques ;


    public Long getId() {
        return id;
    }
    public void setId(Long Id) {
        this.id = id;
    }
    public  String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getcostoEnergia() {
        return costoEnergia;
    }
    public void setcostoEnergia(int costoEnergia){
        this.costoEnergia = costoEnergia;
    }
    public int getdanioBase() {
        return danioBase;
    }
    public void setdanioBase(int danioBase){
        this.danioBase = danioBase;
    }
}
    



