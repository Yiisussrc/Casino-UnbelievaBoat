
package casino.ub;

import java.util.Random;
public class Crimen {
    /*
    El crimen en UnbelievaBoat es diferente, tu escribes el comando de /crime y aleatoriamente
    tira un mensaje random relacionado con crimen, y si se cometio el crimen una cantidad aleatoria
    de dinero ganado, o si no se cometio, automaticamente te quitan tambien una cantidad aleatoria
    de dinero de tu efectivo, en este caso solo tenemos un mensaje y es la de robarle a un anciano
    y hay una probabilidad 50/50 de que cometamos o no cometamos este crimen.
    */
    private Random random;

    public Crimen() {
        random = new Random();
    }

    public void robarAnciano(Economia economia) {
        int probabilidad = random.nextInt(100);
        if (probabilidad < 50) {
            int ganancia = random.nextInt(4001) + 2000;
            economia.agregarEfectivo(ganancia);
            System.out.println("Robaste a un anciano y ganaste: "+ganancia);
        }else{
            int perdida = random.nextInt(1001) + 1000;
            economia.usarEfectivo(perdida);
            System.out.println("Fallaste al robar al anciano y perdiste: "+perdida);
        }
    }
}
