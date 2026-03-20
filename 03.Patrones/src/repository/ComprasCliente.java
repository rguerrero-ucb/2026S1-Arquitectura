package repository;

public class ComprasCliente {
    private String nombreCliente;
    private int cantidadCompras;

    public ComprasCliente(String nombreCliente, int cantidadCompras) {
        this.nombreCliente = nombreCliente;
        this.cantidadCompras = cantidadCompras;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public int getCantidadCompras() {
        return cantidadCompras;
    }
}