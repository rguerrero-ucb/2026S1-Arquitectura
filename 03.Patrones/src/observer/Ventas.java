package observer;

public class Ventas extends Observable {
    public void realizarVenta(String producto) {
        // Lógica para realizar la venta
        System.out.println("Venta realizada: " + producto);
        notifyObservers("Se ha realizado una venta de: " + producto);
    }
    
}
