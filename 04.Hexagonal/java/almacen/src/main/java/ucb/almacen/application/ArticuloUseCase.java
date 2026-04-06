package ucb.almacen.application;

import java.util.List;

import ucb.almacen.domain.Articulo;

public interface ArticuloUseCase {
    public Articulo create(String nombre, String codigo) throws Exception;
    public List<ArticuloDTO> getAll() throws Exception;
}
