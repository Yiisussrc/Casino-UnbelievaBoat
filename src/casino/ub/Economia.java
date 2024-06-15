
package casino.ub;

import java.util.Scanner;
public class Economia {
    /*
    UnbelievaBoat tiene un sistema de economia como el de la vida real, con efectivo, dinero en banco,
    y tambien podemos ver el total de dinero que tenemos entre el banco y efectivo, en discord, UnbelievaBoat
    tiene registro siempre de nuestro balance, no se borra a menos que lo reseteemos, pero aqui es diferente,
    si paramos en programa, se resetea todas nuestras stats, ya que UnbelieBoat recopila estos datos del usuario
    de discord y los mantiene en su servidor, entonces podremos jugar pero si cerramos el programa, todo se resetea.
    */
    private double efectivo;
    private double banco;

    public Economia() {
        this.efectivo = 0;
        this.banco = 0;
    }

    public void mostrarDinero() {
        System.out.println("Efectivo: "+efectivo);
        System.out.println("Banco: "+banco);
        System.out.println("Total: "+(efectivo+banco));
    }

    public void depositar(double cantidad) {
        if (cantidad <= efectivo) {
            efectivo -= cantidad;
            banco += cantidad;
            System.out.println("Depositaste: "+cantidad);
        }else{
            System.out.println("No tienes suficiente efectivo.");
        }
    }

    public void retirar(double cantidad) {
        if (cantidad <= banco) {
            banco -= cantidad;
            efectivo += cantidad;
            System.out.println("Retiraste: "+cantidad);
        }else{
            System.out.println("No tienes suficiente dinero en el banco.");
        }
    }

    public void agregarEfectivo(double cantidad) {
        efectivo += cantidad;
    }

    public boolean usarEfectivo(double cantidad) {
        if (cantidad <= efectivo) {
            efectivo -= cantidad;
            return true;
        }else{
            System.out.println("No tienes suficiente efectivo.");
            return false;
        }
    }
}

