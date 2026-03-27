import java.util.List;

import almacen.application.ArticuloDTO;
import almacen.application.ArticuloUseCase;
import almacen.application.ArticuloUseCaseImpl;
import almacen.domain.ArticuloRepositoryPort;
import almacen.infrastructure.ArticuloRepositoryAdapter;
import almacen.infrastructure.ListaArticulosPresenter;

public class App {
    public static void main(String[] args) throws Exception {
        ArticuloRepositoryPort articuloRepository = new ArticuloRepositoryAdapter();
        ArticuloUseCase uc = new ArticuloUseCaseImpl(articuloRepository);

        uc.create("Articulo 2", "A002");

        List<ArticuloDTO> articulos = uc.getAll();
        
        ListaArticulosPresenter presenter = new ListaArticulosPresenter(articulos);
        presenter.present();

    }
}
