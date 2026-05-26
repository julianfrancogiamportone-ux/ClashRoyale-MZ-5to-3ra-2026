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
		Peleador peleador1 = new Peleador(1L, "peleador1", 10000, 500, 10.0f);
		Peleador peleador2 = new Peleador(2L, "peleador2", 10000, 400, 12.0f);
		Ataque ataque1 = new Ataque(1L, "ataque1", 20, 30);
		Ataque ataque2 = new Ataque(2L, "ataque2", 30, 40);
		Ataque ataque3 = new Ataque(3L, "ataque3", 25, 35);
		Arma arma1 = new Arma(1L, "arma1", 25, 50f);
		Arma arma2 = new Arma(2L, "arma2", 20, 40f);
		Arma arma3 = new Arma(3L, "arma3", 30, 60f);
		Arma arma4 = new Arma(4L, "arma4", 25, 50f);
		Arma arma5 = new Arma(5L, "arma5", 35, 70f);
		//2. Asignar armas y ataques a los peleadores
		System.out.println(peleador1.getNombre());
		System.out.println(peleador1.getPuntosVida());
		List<Arma> armas1 = new ArrayList<Arma>(java.util.Arrays.asList(arma1, arma3, arma5));
		List<Arma> armas2 = new ArrayList<Arma>(java.util.Arrays.asList(arma2, arma4));
		//3. Comparar las armas de los peleadores y mostrar cuál es más fuerte

		peleador1.setListaarmas(armas1);
		peleador2.setListaarmas(armas2);
		if(arma1.getBonificadorDanio() > arma2.getBonificadorDanio()) {
			System.out.println(peleador1.getNombre() + " tiene el arma más fuerte: " + arma1.getNombre());
		} else if (arma1.getBonificadorDanio() < arma2.getBonificadorDanio()) {
			System.out.println(peleador2.getNombre() + " tiene el arma más fuerte: " + arma2.getNombre());
		} else {
			System.out.println("Ambos peleadores tienen armas igual de fuertes.");
		}
		//4. Comparar los ataques de los peleadores y mostrar cuál es más fuerte
		List <Ataque> habilidades = new ArrayList<Ataque>(java.util.Arrays.asList(ataque1, ataque2, ataque3));
		for (Ataque ataque : habilidades) {
			peleador1.getListaataques().add(ataque);
		}
		Ataque mejorAtaque = null;
		for (Ataque ataque : peleador1.getListaataques()) {
			if (mejorAtaque == null || ataque.getdanioBase() > mejorAtaque.getdanioBase()) {
				mejorAtaque = ataque;
			}
		}
		System.out.println("El mejor ataque de " + peleador1.getNombre() + " es: " + mejorAtaque.getNombre());

		//5. Calcular el promedio de costo de energía de los ataques de un peleador y mostrar una advertencia si el promedio es mayor a 50
		double sumaCostoEnergia = 0;
		for (Ataque ataque : peleador1.getListaataques()) {
			sumaCostoEnergia += ataque.getcostoEnergia();
		}
		double promedioCostoEnergia = (double) sumaCostoEnergia / peleador1.getListaataques().size();
		System.out.println("El promedio de costo de energía de " + peleador1.getNombre() + " es: " + promedioCostoEnergia);
		if (promedioCostoEnergia > 50) {
			System.out.println("Advertencia: El promedio de costo de energía es mayor a 50.");
		} else {
			System.out.println("El promedio de costo de energía es aceptable.");
		}

		descansoTactico(peleador2);
		//9. Mostrar los ataques que el peleador puede realizar con la energía actual
		for (Ataque ataque : peleador1.getListaataques()) {
			if (ataque.getcostoEnergia() <= peleador1.getEnergia()) {	
				System.out.println("Ataque: " + ataque.getNombre() + ", Costo de Energía: " + ataque.getcostoEnergia());
			}
			else {
				System.out.println("No puedes realizar el ataque: " + ataque.getNombre() + " porque no tienes suficiente energía.");
			}
		}
		//10. Simular un combate entre dos peleadores utilizando sus ataques y mostrar el resultado del combate (quién gana o si es un empate)
		while (peleador1.getPuntosVida() > 0 && peleador2.getPuntosVida() > 0) {
			if (peleador1.getEnergia() < ataque1.getcostoEnergia() && peleador2.getEnergia() < ataque2.getcostoEnergia()) {
				System.out.println("Ambos peleadores no tienen suficiente energía para realizar un ataque. El combate termina en empate.");
				break;
			}
			primerGolpe(peleador1, peleador2, ataque1);
			if (peleador2.getPuntosVida() <= 0) {
				System.out.println(peleador2.getNombre() + " ha sido derrotado.");
				break;
			}
			primerGolpe(peleador2, peleador1, ataque2);
			if (peleador1.getPuntosVida() <= 0) {
				System.out.println(peleador1.getNombre() + " ha sido derrotado.");
				break;
			}
		}


	}
	//6. Simular un ataque entre dos peleadores utilizando uno de los ataques y mostrar el resultado del ataque (puntos de vida restantes del defensor)
	public static void primerGolpe(Peleador atacante, Peleador defensor, Ataque ataque) {
		//7. Verificar si el atacante tiene suficiente energía para realizar el ataque, si no, mostrar un mensaje indicando que no puede realizar el ataque
		if (atacante.getEnergia() < ataque.getcostoEnergia()) {
			System.out.println(atacante.getNombre() + " no tiene suficiente energía para realizar el ataque.");
			return;
		} else {
			atacante.setEnergia(atacante.getEnergia() - ataque.getcostoEnergia());
			System.out.println(atacante.getNombre() + " ataca a " + defensor.getNombre() + " con " + ataque.getNombre());
		}
		float bonificadorDanio = 0;
		for (Arma arma : atacante.getListaarmas()) {
			bonificadorDanio += arma.getBonificadorDanio();
		}
		float danioTotal = ataque.getdanioBase() + bonificadorDanio;
		defensor.setPuntosVida(defensor.getPuntosVida() - (int) danioTotal);
		System.out.println(defensor.getNombre() + " tiene " + defensor.getPuntosVida() + " puntos de vida restantes.");

	}

	public static void descansoTactico(Peleador peleador) {
		if (peleador.getPuntosVida() < 200) {
			peleador.setPuntosVida(peleador.getPuntosVida() + 500);
			peleador.setEnergia(0);	
			System.out.println(peleador.getNombre() + " ha realizado un descanso táctico y ha recuperado puntos de vida, pero ha perdido toda su energía.");
		} else if (peleador.getPuntosVida() >= 200) {
			peleador.setPuntosVida(peleador.getPuntosVida() + 100);
			peleador.setEnergia(peleador.getEnergia() - 50);
			System.out.println(peleador.getNombre() + " ha realizado un descanso táctico y ha recuperado puntos de vida.");
		}
	}
	

}
