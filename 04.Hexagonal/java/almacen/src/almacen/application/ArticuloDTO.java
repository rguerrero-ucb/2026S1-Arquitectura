package almacen.application;

public class ArticuloDTO {
    private String nombre;
    
    public ArticuloDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
