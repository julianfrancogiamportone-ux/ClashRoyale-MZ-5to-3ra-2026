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
		Peleador duo = new Peleador(1L, "duo", 10000, 500, 10.0f);
		Peleador adri = new Peleador(2L, "adri", 10000, 400, 12.0f);
		Ataque kamekameka = new Ataque(1L, "kamekameka", 20, 30);
		Ataque quieroqueque = new Ataque(2L, "quieroqueque", 30, 40);
		Ataque lechazo = new Ataque(3L, "lechazo", 25, 35);
		Arma chistecruz = new Arma(1L, "chistecruz", 25, 50f);
		Arma lentesadri = new Arma(2L, "lentesadri", 20, 40f);
		Arma peron = new Arma(3L, "peron", 30, 60f);
		Arma cascoduo = new Arma(4L, "cascoduo", 25, 50f);
		Arma ak47 = new Arma(5L, "ak47", 35, 70f);
		//2. Asignar armas y ataques a los peleadores
		System.out.println(duo.getNombre());
		System.out.println(duo.getPuntosVida());
		List<Arma> armas1 = new ArrayList<Arma>(java.util.Arrays.asList(chistecruz, peron, ak47));
		List<Arma> armas2 = new ArrayList<Arma>(java.util.Arrays.asList(lentesadri, cascoduo));
		//3. Comparar las armas de los peleadores y mostrar cuál es más fuerte

		duo.setListaarmas(armas1);
		adri.setListaarmas(armas2);
		if(chistecruz.getBonificadorDanio() > lentesadri.getBonificadorDanio()) {
			System.out.println(duo.getNombre() + " tiene el arma más fuerte: " + chistecruz.getNombre());
		} else if (chistecruz.getBonificadorDanio() < lentesadri.getBonificadorDanio()) {
			System.out.println(adri.getNombre() + " tiene el arma más fuerte: " + lentesadri.getNombre());
		} else {
			System.out.println("Ambos peleadores tienen armas igual de fuertes.");
		}
		//4. Comparar los ataques de los peleadores y mostrar cuál es más fuerte
		List <Ataque> habilidades = new ArrayList<Ataque>(java.util.Arrays.asList(kamekameka, quieroqueque, lechazo));
		for (Ataque ataque : habilidades) {
			duo.getListaataques().add(ataque);
		}
		Ataque mejorAtaque = null;
		for (Ataque ataque : duo.getListaataques()) {
			if (mejorAtaque == null || ataque.getdanioBase() > mejorAtaque.getdanioBase()) {
				mejorAtaque = ataque;
			}
		}
		System.out.println("El mejor ataque de " + duo.getNombre() + " es: " + mejorAtaque.getNombre());

		//5. Calcular el promedio de costo de energía de los ataques de un peleador y mostrar una advertencia si el promedio es mayor a 50
		double sumaCostoEnergia = 0;
		for (Ataque ataque : duo.getListaataques()) {
			sumaCostoEnergia += ataque.getcostoEnergia();
		}
		double promedioCostoEnergia = (double) sumaCostoEnergia / duo.getListaataques().size();
		System.out.println("El promedio de costo de energía de " + duo.getNombre() + " es: " + promedioCostoEnergia);
		if (promedioCostoEnergia > 50) {
			System.out.println("Advertencia: El promedio de costo de energía es mayor a 50.");
		} else {
			System.out.println("El promedio de costo de energía es aceptable.");
		}

		descansoTactico(adri);
		//9. Mostrar los ataques que el peleador puede realizar con la energía actual
		for (Ataque ataque : duo.getListaataques()) {
			if (ataque.getcostoEnergia() <= duo.getEnergia()) {	
				System.out.println("Ataque: " + ataque.getNombre() + ", Costo de Energía: " + ataque.getcostoEnergia());
			}
			else {
				System.out.println("No puedes realizar el ataque: " + ataque.getNombre() + " porque no tienes suficiente energía.");
			}
		}
		//10. Simular un combate entre dos peleadores utilizando sus ataques y mostrar el resultado del combate (quién gana o si es un empate)
		while (duo.getPuntosVida() > 0 && adri.getPuntosVida() > 0) {
			if (duo.getEnergia() < kamekameka.getcostoEnergia() && adri.getEnergia() < quieroqueque.getcostoEnergia()) {
				System.out.println("Ambos peleadores no tienen suficiente energía para realizar un ataque. El combate termina en empate.");
				break;
			}
			primerGolpe(duo, adri, kamekameka);
			if (adri.getPuntosVida() <= 0) {
				System.out.println(adri.getNombre() + " ha sido derrotado.");
				break;
			}
			primerGolpe(adri, duo, quieroqueque);
			if (duo.getPuntosVida() <= 0) {
				System.out.println(duo.getNombre() + " ha sido derrotado.");
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
