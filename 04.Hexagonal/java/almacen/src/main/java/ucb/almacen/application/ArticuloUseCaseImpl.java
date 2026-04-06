package ucb.almacen.application;

import java.util.ArrayList;
import java.util.List;

import ucb.almacen.domain.Articulo;
import ucb.almacen.domain.ArticuloRepositoryPort;

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

    @Override
    public List<ArticuloDTO> getAll() throws Exception {
        List<Articulo> articulos = this.articuloRepository.getAll();
        List<ArticuloDTO> articulosDTO = new ArrayList<>();
        for (Articulo articulo : articulos) {
            articulosDTO.add(new ArticuloDTO(articulo.getNombre()));
        }
        return articulosDTO;
    }
}
