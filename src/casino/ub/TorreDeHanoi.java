
package casino.ub;

import java.util.Scanner;
public class TorreDeHanoi {
    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Juego de la Torre de Hanoi");
        System.out.println("Introduce el número de discos:");
        int numDiscos = scanner.nextInt();

        resolverHanoi(numDiscos, 'A', 'C', 'B');
        }

        private void resolverHanoi(int numDiscos, char origen, char destino, char auxiliar) {
        if (numDiscos == 1) {
        System.out.println("Mover disco 1 de " + origen + " a " + destino);
        return;
        }

        resolverHanoi(numDiscos - 1, origen, auxiliar, destino);
        System.out.println("Mover disco "+numDiscos+" de "+origen+" a "+destino);
        resolverHanoi(numDiscos - 1, auxiliar, destino, origen);
        System.out.println();
    }
}
