package clashroyale;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import clashroyale.entidades.Peleador;
import clashroyale.entidades.Arma;
import clashroyale.entidades.Ataque;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		Peleador peleador1 = new Peleador(1L, "Peleador1", 100, 50, 10.0f);
		Peleador peleador2 = new Peleador(2L, "Peleador2", 120, 40, 12.0f);
		Ataque ataque1 = new Ataque(1L, "Ataque", 20, 30);
		Ataque ataque2 = new Ataque(2L, "Ataque2", 30, 40);
		Ataque ataque3 = new Ataque(3L, "Ataque3", 25, 35);
		Arma arma1 = new Arma(1L, "Arma1", 25, 50f);
		Arma arma2 = new Arma(2L, "Arma2", 20, 40f);
		System.out.println(peleador1.getNombre());
		System.out.println(peleador1.getPuntosVida());
		peleador1.setListaarmas(List.of(arma1));
		peleador2.setListaarmas(List.of(arma2));
		if(arma1.getBonificadorDanio() > arma2.getBonificadorDanio()) {
			System.out.println(peleador1.getNombre() + " tiene el arma más fuerte: " + arma1.getNombre());
		} else if (arma1.getBonificadorDanio() < arma2.getBonificadorDanio()) {
			System.out.println(peleador2.getNombre() + " tiene el arma más fuerte: " + arma2.getNombre());
		} else {
			System.out.println("Ambos peleadores tienen armas igual de fuertes.");
		}

}



}
