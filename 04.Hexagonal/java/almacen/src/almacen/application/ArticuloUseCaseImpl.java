package almacen.application;

import almacen.domain.Articulo;
import almacen.domain.ArticuloRepositoryPort;

public class ArticuloUseCaseImpl implements ArticuloUseCase {
    private ArticuloRepositoryPort articuloRepository;
    
    public ArticuloUseCaseImpl(ArticuloRepositoryPort articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    public Articulo create(String nombre, String codigo) throws Exception {
        Articulo articulo = new Articulo(0, nombre, codigo);
        articuloRepository.save(articulo);

        return articulo;
    }
}
