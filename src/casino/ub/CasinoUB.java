
package casino.ub;

import java.util.Scanner;
public class CasinoUB {

    
    public static void main(String[] args) {
        /*
        UnbelievaBoat es un bot de discord que ofrece muchas funciones, una de ellas un casino, en el cual tiene
        una variedad de juegos y opciones las cuales puede jugar y ganar dinero, o jugar y perder dinero, ya sea
        apostado o dinero perdido de su efectivo por cometer un crimen, etc. En este programa se ha intentado hacer 
        algo similar a lo que vemos en el bot cuando jugamos discord, intentando ser lo mas parecido en lo que es 
        el funcionamiento.
        */
        Scanner euceda = new Scanner(System.in);
        Economia economia = new Economia();
        BlackJack blackJack = new BlackJack();
        Ruleta ruleta = new Ruleta();
        PeleaDeGallos peleaDeGallos = new PeleaDeGallos("Ramiro", "Clementino");
        Trabajo trabajo = new Trabajo();
        Crimen crimen = new Crimen();
        Tienda tienda = new Tienda();
        Inventario inventario = new Inventario();
        boolean bandera = true;
        while (bandera) {
            System.out.println();
            System.out.println();
            System.out.println("UnbelievaBoat Casino: ");
            System.out.println("0. /OUT");
            System.out.println("1. /Balance");
            System.out.println("2. /Deposit");
            System.out.println("3. /Remove-money");
            System.out.println("4. /Games");
            System.out.println("5. /Work");
            System.out.println("6. /Rob");
            System.out.println("7. /Store");
            System.out.println("8. /Inventory");
            System.out.println("9. /Item buy");
            System.out.print("/");
            int opcion = euceda.nextInt();
            System.out.println();
            System.out.println();
            switch (opcion) {
                case 0:
                    bandera = false;
                    break;
                case 1:
                    economia.mostrarDinero();
                    break;
                case 2:
                    System.out.println("Amount: ");
                    double cantidadDepositar = euceda.nextDouble();
                    economia.depositar(cantidadDepositar);
                    break;
                case 3:
                    System.out.println("Amount: ");
                    double cantidadRetirar = euceda.nextDouble();
                    economia.retirar(cantidadRetirar);
                    break;
                case 4:
                    boolean banderaJuegos = true;
                    while (banderaJuegos) {
                        System.out.println("Juegos Disponibles:");
                        System.out.println("0. /Back");
                        System.out.println("1. /BlackJack");
                        System.out.println("2. /Roulette");
                        System.out.println("3. /Pelea de Gallos");
                        System.out.print("/");
                        int opcionJuegos = euceda.nextInt();
                        switch (opcionJuegos) {
                            case 0:
                                banderaJuegos = false;
                                break;
                            case 1:
                                blackJack.jugar(economia);
                                break;
                            case 2:
                                ruleta.jugar(economia);
                                break;
                            case 3:
                                peleaDeGallos.ejecutar(economia);
                                break;
                            default:
                                System.out.println("Opción no válida.");
                        }
                    }
                    break;
                case 5:
                    trabajo.trabajar(economia);
                    break;
                case 6:
                    crimen.robarAnciano(economia);
                    break;
                case 7:
                    tienda.mostrarItems();
                    break;
                case 8:
                    inventario.mostrarInventario();
                    break;
                case 9:
                    System.out.println("# Item: ");
                    int itemIndice = euceda.nextInt();
                    tienda.comprarItem(itemIndice - 1, economia, inventario);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
