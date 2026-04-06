package ucb.almacen.infrastructure;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import ucb.almacen.domain.Articulo;
import ucb.almacen.domain.ArticuloRepositoryPort;
import ucb.almacen.infrastructure.db.DB;

public class ArticuloRepositoryAdapter implements ArticuloRepositoryPort {

    @Override
    public Articulo getById(int id) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT id, nombre, codigo");
        sql.append(" FROM almacen.articulo WHERE id = ?");
        PreparedStatement stmt = DB.getConnection().prepareStatement(sql.toString());
        stmt.setInt(1, id);
        var rs = stmt.executeQuery();
        if (rs.next()) {
            return new Articulo(rs.getInt("id"), rs.getString("nombre"), rs.getString("codigo"));
        }
        return null;
    }

    @Override
    public List<Articulo> getAll() throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT id, nombre, codigo");
        sql.append(" FROM almacen.articulo");
        PreparedStatement stmt = DB.getConnection().prepareStatement(sql.toString());
        var rs = stmt.executeQuery();
        List<Articulo> articulos = new ArrayList<>();
        while (rs.next()) {
            articulos.add(new Articulo(rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("codigo")));
        }
        return articulos;
    }

    @Override
    public void save(Articulo articulo) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" INSERT INTO almacen.articulo (id, nombre, codigo)");
        sql.append(" VALUES (?, ?, ?)") ;
        sql.append(" ON CONFLICT (id)");
        sql.append(" DO UPDATE SET ");
        sql.append(" nombre = EXCLUDED.nombre,");
        sql.append(" codigo = EXCLUDED.codigo");
        PreparedStatement stmt = DB.getConnection().prepareStatement(sql.toString());
        stmt.setInt(1, articulo.getId());
        stmt.setString(2, articulo.getNombre());
        stmt.setString(3, articulo.getCodigo());
        stmt.executeUpdate();
    }

}
