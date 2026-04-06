package ucb.almacen.application;

import java.util.List;

import ucb.almacen.domain.Empleado;

public interface EmpleadoUseCase {
    public Empleado create(String nombre) throws Exception;
    public Empleado getById(int id) throws Exception;
    public List<EmpleadoDTO> getAll() throws Exception;
    public Empleado update(int id, String nombre) throws Exception;
    public void delete(int id) throws Exception;
}