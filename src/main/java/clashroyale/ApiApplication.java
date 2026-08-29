package clashroyale;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import clashroyale.entidades.Peleador;
import clashroyale.entidades.Arma;
import clashroyale.entidades.Ataque;
import java.util.ArrayList;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		//1. Crear instancias de peleadores, armas y ataques
		SpringApplication.run(ApiApplication.class, args);
	}

}
