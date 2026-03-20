package observer;

public class Clientes implements Observer {
    private String nombre;

    public Clientes(String nombre) {
        this.nombre = nombre;
    }

    public void notify(String message) {
        System.out.println("Cliente " + nombre + " ha sido notificado: " + message);
    }
}
