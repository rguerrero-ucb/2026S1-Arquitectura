package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ClientesRepositoryPg implements ClientesRepository {
    public int getIndentity() {
        Connection conn = DB.getConnection();

        String sql = "SELECT nextval('cliente_id_seq') AS id";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             java.sql.ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (java.sql.SQLException e) {
            System.out.println("Error retrieving identity from PostgreSQL database.");
            e.printStackTrace();
        }
        return 0;

    }

    // Implementação usando PostgreSQL (simulada)
    public void adicionarCliente(Cliente cliente) {
        Connection conn = DB.getConnection();

        // Código para adicionar cliente ao banco de dados PostgreSQL
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO cliente (nombre, email, telefono) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            stmt.executeUpdate();
            System.out.println("Cliente adicionado ao PostgreSQL: " + cliente.getNome());
        } catch (java.sql.SQLException e) {
            System.out.println("Error adding client to PostgreSQL database.");
            e.printStackTrace();
        } 
    }

    public Cliente[] listarClientes() {
        Connection conn = DB.getConnection();

        String sql = "SELECT id, nombre, email, telefono FROM cliente";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             java.sql.ResultSet rs = stmt.executeQuery()) {
            java.util.List<Cliente> clientesList = new java.util.ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nombre");
                String email = rs.getString("email");
                String telefone = rs.getString("telefono");
                clientesList.add(new Cliente(id, nome, email, telefone));
            }
            return clientesList.toArray(new Cliente[0]);
        } catch (java.sql.SQLException e) {
            System.out.println("Error retrieving clients from PostgreSQL database.");
            e.printStackTrace();
        }
        return new Cliente[0];
    }

    public List<ComprasCliente> listarComprasPorCliente(int clienteId){
        List<ComprasCliente> comprasList = new ArrayList<>();

        Connection conn = DB.getConnection();

        String sql = "SELECT nombre, 100 cantidad FROM cliente";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             java.sql.ResultSet rs = stmt.executeQuery()) {            
            while (rs.next()) {
                String nome = rs.getString("nombre");
                int cantidad = rs.getInt("cantidad");
                comprasList.add(new ComprasCliente(nome, cantidad));
            }
            return comprasList;
        } catch (java.sql.SQLException e) {
            System.out.println("Error retrieving clients from PostgreSQL database.");
            e.printStackTrace();
        }
        return comprasList;
    }
    
}
