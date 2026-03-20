package observer;

public class Main {
    public static void main(String[] args) {
        Ventas ventas = new Ventas();
        
        Clientes cliente1 = new Clientes("Juan");
        Clientes cliente2 = new Clientes("Maria");
        
        ventas.addObserver(cliente1);
        ventas.addObserver(cliente2);
        
        ventas.realizarVenta("Laptop");
    }   
}
