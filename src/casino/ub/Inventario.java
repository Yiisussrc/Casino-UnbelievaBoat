
package casino.ub;

import java.util.ArrayList;
public class Inventario {
    /*
    En discord, con UnbelievaBoat, no existe un inventario, pero aqui se creo con la 
    finalidad de saber que objetos tenemos ya comprados, y que objetos no hemos comprado.
    */
    private ArrayList<String> itemsComprados;

    public Inventario() {
        itemsComprados = new ArrayList<>();
    }
    public void agregarItem(String item) {
        itemsComprados.add(item);
    }
    public void mostrarInventario() {
        if (itemsComprados.isEmpty()) {
            System.out.println("No has comprado ningún item.");
        } else {
            System.out.println("Items comprados:");
            for (String item : itemsComprados) {
                System.out.println("- "+item);
            }
        }
    }
}
