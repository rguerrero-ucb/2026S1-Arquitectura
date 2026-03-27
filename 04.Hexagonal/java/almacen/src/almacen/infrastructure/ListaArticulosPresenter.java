package almacen.infrastructure;

import java.util.List;

import almacen.application.ArticuloDTO;

public class ListaArticulosPresenter {
    private List<ArticuloDTO> articulos;

    public ListaArticulosPresenter(List<ArticuloDTO> articulos) {
        this.articulos = articulos;
    }

    public void present() {
        for (ArticuloDTO articulo : articulos) {
            System.out.println(articulo.getNombre());
        }
    }
}
