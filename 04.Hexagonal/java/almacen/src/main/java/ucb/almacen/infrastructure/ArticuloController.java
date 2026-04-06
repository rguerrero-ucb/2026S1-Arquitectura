package ucb.almacen.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ucb.almacen.application.ArticuloDTO;
import ucb.almacen.application.ArticuloUseCase;

import java.util.List;

@RestController
public class ArticuloController {

    @Autowired
    private ArticuloUseCase articuloUseCase;

    @GetMapping("/")
    public ResponseEntity<String> saludo() {
        return ResponseEntity.ok("¡Bienvenido al almacén!");
    }

    @GetMapping("/articulos")
    public ResponseEntity<List<ArticuloDTO>> listarArticulos() throws Exception {
        List<ArticuloDTO> articulos = articuloUseCase.getAll();
        return ResponseEntity.ok(articulos);
    }
}
