
package casino.ub;

import java.util.Random;
import java.util.Scanner;
public class PeleaDeGallos {
    
    private String gallo1;
    private String gallo2;
    private double apuesta;
    private String galloSeleccionado;
    
    public PeleaDeGallos(String gallo1, String gallo2) {
        this.gallo1 = gallo1;
        this.gallo2 = gallo2;
    }

    public void apostar(double cantidad, String gallo) {
        this.apuesta = cantidad;
        this.galloSeleccionado = gallo;
    }

    public void iniciarPelea(Economia economia) {
        Random random = new Random();
        String ganador;
        
        if (random.nextBoolean()) {
            ganador = gallo1;
        } else {
            ganador = gallo2;
        }
        
        System.out.println("Gano: "+ganador);
        if (galloSeleccionado.equals(ganador)) {
            double ganancia = apuesta * 3;
            economia.agregarEfectivo(ganancia);
            System.out.println("Eso mi bro, apostaste y ganaste: "+ganancia);
        } else {
            System.out.println("No bro, te mandaron a dormir y perdiste: "+apuesta);
        }
    }
    
    public void ejecutar(Economia economia) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bet:");
        double cantidad = scanner.nextDouble();
        
        if (!economia.usarEfectivo(cantidad)) {
            return;
        }
        
        System.out.println("Elige tu gallo mas gallo (Ramiro/Clementino) : ");
        String gallo = scanner.next();
        
        apostar(cantidad, gallo);
        iniciarPelea(economia);
    }
}