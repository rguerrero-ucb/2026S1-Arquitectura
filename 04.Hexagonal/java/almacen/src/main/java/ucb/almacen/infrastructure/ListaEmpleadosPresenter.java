package ucb.almacen.infrastructure;

import java.util.List;

import ucb.almacen.application.EmpleadoDTO;

public class ListaEmpleadosPresenter {
    private List<EmpleadoDTO> empleados;

    public ListaEmpleadosPresenter(List<EmpleadoDTO> empleados) {
        this.empleados = empleados;
    }

    public void present() {
        for (EmpleadoDTO empleado : empleados) {
            System.out.println(empleado.getNombre());
        }
    }
}