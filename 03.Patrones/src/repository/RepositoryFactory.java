package repository;

public class RepositoryFactory {
    public static ClientesRepository createClientesRepository() {
        return new ClientesRepositoryPg();
    }
}
