package repository;

public class Main {
    public static void main(String[] args) {
        ClientesRepository clienteRepo = RepositoryFactory.createClientesRepository();

        int id = clienteRepo.getIndentity();
        Cliente cliente1 = new Cliente(id, "João Silva", "joao.silva@email.com", "(11) 99999-9999");
        clienteRepo.adicionarCliente(cliente1);

        Cliente[] clientes = clienteRepo.listarClientes();
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId() + ", Nome: " + cliente.getNome() + ", Email: " + cliente.getEmail() + ", Telefone: " + cliente.getTelefone());
        }
    }
}
