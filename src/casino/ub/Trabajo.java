
package casino.ub;

import java.util.Random;
public class Trabajo {
    /*
    En UnbelievaBoat tenemos la opcion de trabajar, y nos da cierto dinero, este es aleatorio
    nunca es lo mismo, cual es la diferencia, en discord, con UnbelievaBoat este tiene un limite
    de cuantas veces podemos trabajar, esto lo pone un moderador, y hay un cooldown o un tiempo 
    de espera para poder volver a trabajar, aqui es diferente, no hay un cooldown o tiempo de espera
    podemos trabajar y tener ganancias infinitas.
    */
    private Random random;

    public Trabajo() {
        random = new Random();
    }

    public void trabajar(Economia economia) {
        int ganancia = random.nextInt(9001) + 1000;
        economia.agregarEfectivo(ganancia);
        System.out.println("Chambeaste y te dieron: "+ganancia);
    }
}
