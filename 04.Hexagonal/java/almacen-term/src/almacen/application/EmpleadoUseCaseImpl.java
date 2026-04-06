package almacen.application;

import java.util.ArrayList;
import java.util.List;

import almacen.domain.Empleado;
import almacen.domain.EmpleadoRepositoryPort;

public class EmpleadoUseCaseImpl implements EmpleadoUseCase {
    private EmpleadoRepositoryPort empleadoRepository;

    public EmpleadoUseCaseImpl(EmpleadoRepositoryPort empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public Empleado create(String nombre) throws Exception {
        Empleado empleado = new Empleado(0, nombre);
        empleadoRepository.save(empleado);
        // Después de guardar, obtener el empleado con el ID correcto
        // Buscamos el último empleado insertado por nombre (esto es simplificado)
        List<Empleado> empleados = empleadoRepository.getAll();
        for (Empleado emp : empleados) {
            if (emp.getNombre().equals(nombre)) {
                return emp;
            }
        }
        return empleado;
    }

    @Override
    public Empleado getById(int id) throws Exception {
        return empleadoRepository.getById(id);
    }

    @Override
    public List<EmpleadoDTO> getAll() throws Exception {
        List<Empleado> empleados = this.empleadoRepository.getAll();
        List<EmpleadoDTO> empleadosDTO = new ArrayList<>();
        for (Empleado empleado : empleados) {
            empleadosDTO.add(new EmpleadoDTO(empleado.getNombre()));
        }
        return empleadosDTO;
    }

    @Override
    public Empleado update(int id, String nombre) throws Exception {
        Empleado empleado = empleadoRepository.getById(id);
        if (empleado != null) {
            empleado.setNombre(nombre);
            empleadoRepository.update(empleado);
        }
        return empleado;
    }

    @Override
    public void delete(int id) throws Exception {
        empleadoRepository.delete(id);
    }
}