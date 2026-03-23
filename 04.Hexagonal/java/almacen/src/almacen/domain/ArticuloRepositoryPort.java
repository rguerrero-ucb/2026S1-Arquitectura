package almacen.domain;

import java.util.List;

public interface ArticuloRepositoryPort {
    public Articulo getById(int id) throws Exception; 
    public List<Articulo> getAll() throws Exception;
    public void save(Articulo articulo) throws Exception;
}
