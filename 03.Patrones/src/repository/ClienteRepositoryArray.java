package repository;

import java.util.List;

public class ClienteRepositoryArray  implements ClientesRepository {
    private Cliente[] clientes;
    private int count;

    public ClienteRepositoryArray() {
        this.clientes = new Cliente[10]; // Capacidade padrão de 10 clientes
        this.count = 0;
    }

    public void adicionarCliente(Cliente cliente) {
        if (count < clientes.length) {
            clientes[count] = cliente;
            count++;
        } else {
            System.out.println("Capacidade máxima de clientes atingida.");
        }
    }

    public Cliente[] listarClientes() {
        Cliente[] listaClientes = new Cliente[count];
        System.arraycopy(clientes, 0, listaClientes, 0, count);
        return listaClientes;
    }    

    public List<ComprasCliente> listarComprasPorCliente(int clienteId){
        return null;
    }

    @Override
    public int getIndentity() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIndentity'");
    }
}
