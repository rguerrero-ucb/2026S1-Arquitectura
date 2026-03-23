package almacen.application;

import almacen.domain.Articulo;

public interface ArticuloUseCase {
    public Articulo create(String nombre, String codigo) throws Exception;
}
