package ucb.almacen.infrastructure;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import ucb.almacen.domain.Empleado;
import ucb.almacen.domain.EmpleadoRepositoryPort;
import ucb.almacen.infrastructure.db.DB;

public class EmpleadoRepositoryAdapter implements EmpleadoRepositoryPort {

    @Override
    public Empleado getById(int id) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT id, nombre");
        sql.append(" FROM almacen.empleado WHERE id = ?");
        PreparedStatement stmt = DB.getConnection().prepareStatement(sql.toString());
        stmt.setInt(1, id);
        var rs = stmt.executeQuery();
        if (rs.next()) {
            return new Empleado(rs.getInt("id"), rs.getString("nombre"));
        }
        return null;
    }

    @Override
    public List<Empleado> getAll() throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT id, nombre");
        sql.append(" FROM almacen.empleado");
        PreparedStatement stmt = DB.getConnection().prepareStatement(sql.toString());
        var rs = stmt.executeQuery();
        List<Empleado> empleados = new ArrayList<>();
        while (rs.next()) {
            empleados.add(new Empleado(rs.getInt("id"), rs.getString("nombre")));
        }
        return empleados;
    }

    @Override
    public void save(Empleado empleado) throws Exception {
        // Si el ID es 0, buscar el próximo ID disponible
        if (empleado.getId() == 0) {
            int nextId = getNextId();
            empleado = new Empleado(nextId, empleado.getNombre());
        }

        StringBuilder sql = new StringBuilder();
        sql.append(" INSERT INTO almacen.empleado (id, nombre)");
        sql.append(" VALUES (?, ?)");
        sql.append(" ON CONFLICT (id)");
        sql.append(" DO UPDATE SET ");
        sql.append(" nombre = EXCLUDED.nombre");
        PreparedStatement stmt = DB.getConnection().prepareStatement(sql.toString());
        stmt.setInt(1, empleado.getId());
        stmt.setString(2, empleado.getNombre());
        stmt.executeUpdate();
    }

    private int getNextId() throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT COALESCE(MAX(id), 0) + 1 as next_id");
        sql.append(" FROM almacen.empleado");
        PreparedStatement stmt = DB.getConnection().prepareStatement(sql.toString());
        var rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("next_id");
        }
        return 1; // Si no hay registros, empezar con 1
    }

    @Override
    public void update(Empleado empleado) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE almacen.empleado");
        sql.append(" SET nombre = ?");
        sql.append(" WHERE id = ?");
        PreparedStatement stmt = DB.getConnection().prepareStatement(sql.toString());
        stmt.setString(1, empleado.getNombre());
        stmt.setInt(2, empleado.getId());
        stmt.executeUpdate();
    }

    @Override
    public void delete(int id) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" DELETE FROM almacen.empleado");
        sql.append(" WHERE id = ?");
        PreparedStatement stmt = DB.getConnection().prepareStatement(sql.toString());
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

}