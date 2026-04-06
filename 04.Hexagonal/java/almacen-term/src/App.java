import java.util.List;

import almacen.application.ArticuloDTO;
import almacen.application.ArticuloUseCase;
import almacen.application.ArticuloUseCaseImpl;
import almacen.application.EmpleadoDTO;
import almacen.application.EmpleadoUseCase;
import almacen.application.EmpleadoUseCaseImpl;
import almacen.domain.ArticuloRepositoryPort;
import almacen.domain.Empleado;
import almacen.domain.EmpleadoRepositoryPort;
import almacen.infrastructure.ArticuloRepositoryAdapter;
import almacen.infrastructure.EmpleadoRepositoryAdapter;
import almacen.infrastructure.ListaArticulosPresenter;
import almacen.infrastructure.ListaEmpleadosPresenter;

public class App {
    public static void main(String[] args) throws Exception {
        // Funcionalidad de artículos
        System.out.println("=== Artículos ===");
        ArticuloRepositoryPort articuloRepository = new ArticuloRepositoryAdapter();
        ArticuloUseCase articuloUC = new ArticuloUseCaseImpl(articuloRepository);

        articuloUC.create("Articulo 2", "A002");

        List<ArticuloDTO> articulos = articuloUC.getAll();

        ListaArticulosPresenter articuloPresenter = new ListaArticulosPresenter(articulos);
        articuloPresenter.present();

        // Funcionalidad de empleados
        System.out.println("\n=== Empleados ===");
        EmpleadoRepositoryPort empleadoRepository = new EmpleadoRepositoryAdapter();
        EmpleadoUseCase empleadoUC = new EmpleadoUseCaseImpl(empleadoRepository);

        // Crear empleados
        System.out.println("Creando empleados...");
        empleadoUC.create("Juan Pérez");
        empleadoUC.create("María García");
        empleadoUC.create("Carlos López");

        // Listar todos los empleados
        System.out.println("\nLista de empleados:");
        List<EmpleadoDTO> empleados = empleadoUC.getAll();
        ListaEmpleadosPresenter empleadoPresenter = new ListaEmpleadosPresenter(empleados);
        empleadoPresenter.present();

        // Obtener un empleado por ID
        System.out.println("\nObteniendo empleado con ID 1:");
        Empleado empleado1 = empleadoUC.getById(1);
        if (empleado1 != null) {
            System.out.println("Empleado encontrado: " + empleado1.getNombre());
        }

        // Actualizar un empleado
        System.out.println("\nActualizando empleado con ID 2...");
        Empleado empleadoActualizado = empleadoUC.update(2, "María García Rodríguez");
        if (empleadoActualizado != null) {
            System.out.println("Empleado actualizado: " + empleadoActualizado.getNombre());
        }

        // Listar empleados después de actualizar
        System.out.println("\nLista de empleados después de actualizar:");
        List<EmpleadoDTO> empleadosActualizados = empleadoUC.getAll();
        ListaEmpleadosPresenter empleadoPresenter2 = new ListaEmpleadosPresenter(empleadosActualizados);
        empleadoPresenter2.present();

        // Eliminar un empleado
        System.out.println("\nEliminando empleado con ID 3...");
        empleadoUC.delete(3);

        // Listar empleados después de eliminar
        System.out.println("\nLista de empleados después de eliminar:");
        List<EmpleadoDTO> empleadosFinales = empleadoUC.getAll();
        ListaEmpleadosPresenter empleadoPresenter3 = new ListaEmpleadosPresenter(empleadosFinales);
        empleadoPresenter3.present();

    }
}
