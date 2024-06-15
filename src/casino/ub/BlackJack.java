
package casino.ub;

import java.util.Random;
import java.util.Scanner;
public class BlackJack {
    /*
    Este es un famoso juego de UnbelievaBoat que intenta replicar lo que es el BlackJack en la vida real,
    y es que basicamente si sacamos mas de 15, ganaremos, pero si sacamos menos de 15, perdemos automaticamente,
    y dependiendo la apuesta que hagamos si ganamos se nos multiplica doble la apuesta, y si perdemos, perdemos
    lo apostado.
    */
    private Random random;

    public BlackJack() {
        random = new Random();
    }

    public void jugar(Economia economia) {
        Scanner luisa = new Scanner(System.in);
        System.out.println("Bet: ");
        int apuesta = luisa.nextInt();
        if (economia.usarEfectivo(apuesta)) {
            int resultado = random.nextInt(21) + 1;
            if (resultado > 15) {
                economia.agregarEfectivo(apuesta*2);
                System.out.println("Ganaste! Tu resultado fue "+resultado);
            }else{
                System.out.println("Perdiste. Tu resultado fue "+resultado);
            }
        }
    }
}
