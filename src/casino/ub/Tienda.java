
package casino.ub;

import java.util.ArrayList;
public class Tienda {
    /*
    En discord, con UnbelievaBoat el moderador o el que este encargado del casino en el servidor
    puede crear una tienda a su gusto de objetos los cuales tengan recompensas como roles, gift cards
    u otro premio, en este caso ya estan predeterminados y estos pues no generan ninguna recompensa 
    real, pero si en el juego en donde si vemos inventario, veremos que objetos hemos comprado.
    */
    private ArrayList<String> items;
    private ArrayList<Integer> precios;

    public Tienda() {
        items = new ArrayList<>();
        precios = new ArrayList<>();
        items.add("Monster Energy Ilimitadas");
        precios.add(100);
        items.add("Hamburguesa Ilimitadas");
        precios.add(300);
        items.add("PC gamer");
        precios.add(1000);
        items.add("Carro basico");
        precios.add(2500);
        items.add("Carro clase media");
        precios.add(4000);
        items.add("Carro clase alta");
        precios.add(8000);
        items.add("Carro multimillonario");
        precios.add(15000);
        items.add("Un avion B2 Spirit");
        precios.add(100000);
        items.add("Casa basica");
        precios.add(100000);
        items.add("Casa clase media");
        precios.add(200000);
        items.add("Casa clase alta");
        precios.add(500000);
        items.add("Casa multimillonaria");
        precios.add(800000);
        items.add("Bunker");
        precios.add(999999999);
    }
    public void mostrarItems() {
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1)+". "+items.get(i)+" - "+precios.get(i)+"💲");
        }
    }
    public void comprarItem(int indice, Economia economia, Inventario inventario) {
        if (indice >= 0 && indice < items.size()) {
            int precio = precios.get(indice);
            if (economia.usarEfectivo(precio)) {
                String item = items.get(indice);
                inventario.agregarItem(item);
                System.out.println("Compraste: "+item);
            }else{
                System.out.println("No tienes suficiente efectivo para comprar "+items.get(indice));
            }
        }else{
            System.out.println("Índice de item no válido.");
        }
    }
}
