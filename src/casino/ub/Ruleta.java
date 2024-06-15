
package casino.ub;

import java.util.Random;
import java.util.Scanner;
public class Ruleta {
    /*
    La ruleta es otro juego tambien famoso de UnbelievaBoat que tambien intenta replicar
    lo que es la ruleta en un casino real, UnbelievaBoat ofrece mas tipos de apuesta,
    aqui intentamos replicar lo necesario para que sea divertida la ruleta. Si aciertas
    un numero exacto tu apuesta se multiplica por 100, si aciertas el color del espacio, tu
    apuesta se multiplica por 5, y si aciertas si el numero es par o impar, tu apuesta
    se multiplica por 3, en cambio si no aciertas perderas el dinero apostado.
    */
    private Random random;

    public Ruleta() {
        random = new Random();
    }

    public void jugar(Economia economia) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bet: ");
        double cantidadApostar = scanner.nextDouble();
        if (!economia.usarEfectivo(cantidadApostar)) {
            return;
        }
        System.out.println("-------------------");
        System.out.println("1. Número (1-21)");
        System.out.println("2. Color (Rojo/Negro)");
        System.out.println("3. Par/Impar");
        System.out.println("Space: ");
        int tipoApuesta = scanner.nextInt();
        int numeroGanador = random.nextInt(21) + 1;
        boolean esRojo = numeroGanador % 2 == 0;
        boolean esPar = numeroGanador % 2 == 0;
        switch (tipoApuesta) {
            case 1:
                System.out.println("Apuesta a un número (1-21):");
                int numeroApostado = scanner.nextInt();
                if (numeroApostado == numeroGanador) {
                    economia.agregarEfectivo(cantidadApostar*100);
                    System.out.println("¡Ganaste! El número ganador es: "+numeroGanador);
                }else{
                    System.out.println("Perdiste. El número ganador es: "+numeroGanador);
                }
                break;
            case 2:
                System.out.println("Apuesta a un color (1 para Rojo, 2 para Negro):");
                int colorApostado = scanner.nextInt();
                if (colorApostado == 1 && esRojo) {
                    economia.agregarEfectivo(cantidadApostar*5);
                    System.out.println("¡Ganaste! El número ganador es: "+numeroGanador+" Rojo");
                }else if (colorApostado == 2 && !esRojo) {
                    economia.agregarEfectivo(cantidadApostar*5);
                    System.out.println("¡Ganaste! El número ganador es: "+numeroGanador+" Negro");
                }else{
                    if (esRojo) {
                        System.out.println("Perdiste. El número ganador es: "+numeroGanador+" Rojo");
                    }else{
                        System.out.println("Perdiste. El número ganador es: "+numeroGanador+" Negro");
                    }
                }
                break;
            case 3:
                System.out.println("Apuesta a Par (1) o Impar (2):");
                int paridadApostada = scanner.nextInt();
                if (paridadApostada == 1 && esPar) {
                    economia.agregarEfectivo(cantidadApostar*3);
                    System.out.println("¡Ganaste! El número ganador es: "+numeroGanador+" Par");
                }else if (paridadApostada == 2 && !esPar) {
                    economia.agregarEfectivo(cantidadApostar*3);
                    System.out.println("¡Ganaste! El número ganador es: "+numeroGanador+" Impar");
                }else{
                    if (esPar) {
                        System.out.println("Perdiste. El número ganador es: "+numeroGanador+" Par");
                    }else{
                        System.out.println("Perdiste. El número ganador es: "+numeroGanador+" Impar");
                    }
                }
                break;
            default:
                System.out.println("Tipo de apuesta no válido.");
                economia.agregarEfectivo(cantidadApostar);
        }
    }
}
