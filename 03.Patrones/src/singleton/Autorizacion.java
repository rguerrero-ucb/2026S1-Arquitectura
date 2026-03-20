package singleton;


class Autorizacion {

    private static Autorizacion instance;

    public static Autorizacion getInstance() {
        if (instance == null) {
            instance = new Autorizacion();
        }
        return instance;
    }

    public boolean puede(String usuario, String permiso) {
        // Lógica de autorización (ejemplo simple)
        return true;
    }
}