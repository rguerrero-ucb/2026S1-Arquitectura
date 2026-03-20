package almacen.application;

import almacen.domain.Articulo;

public class CrearArticuloService {
    private ArticuloRepository articuloRepository;
    
    public CrearArticuloService(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    public int execute(String nombre, String codigo) {
        Articulo articulo = new Articulo(0, nombre, codigo);





        articuloRepository.save(articulo);

        return articulo.getId();
    }
}
