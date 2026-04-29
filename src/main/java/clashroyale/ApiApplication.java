package clashroyale;

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
}

Ataque ataque1 = new Ataque(1L, "Ataque", 20, 30);
Ataque ataque2 = new Ataque(2L, "Ataque2", 30, 40);
Ataque ataque3 = new Ataque(3L, "Ataque3", 25, 35);

}
