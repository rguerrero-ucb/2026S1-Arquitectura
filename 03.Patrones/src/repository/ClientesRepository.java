package repository;

import java.util.List;

public interface ClientesRepository {
    int getIndentity();
    void adicionarCliente(Cliente cliente);
    Cliente[] listarClientes();
    List<ComprasCliente> listarComprasPorCliente(int clienteId);
}
