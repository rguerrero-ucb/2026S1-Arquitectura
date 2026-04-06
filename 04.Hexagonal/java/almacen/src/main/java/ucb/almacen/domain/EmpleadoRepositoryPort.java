package ucb.almacen.domain;

import java.util.List;

public interface EmpleadoRepositoryPort {
    public Empleado getById(int id) throws Exception;
    public List<Empleado> getAll() throws Exception;
    public void save(Empleado empleado) throws Exception;
    public void update(Empleado empleado) throws Exception;
    public void delete(int id) throws Exception;
}