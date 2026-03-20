package almacen.application;

import java.util.List;

import almacen.domain.Articulo;

public interface ArticuloRepository {
    public Articulo getById(int id); 
    public List<Articulo> getAll();
    public void save(Articulo articulo);
}
