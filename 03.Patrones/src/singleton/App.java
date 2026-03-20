package singleton;
public class App {
    public static void main(String[] args) throws Exception {
        
        String databaseUrl = Config.getInstance().getDatabaseUrl();
        String apiKey = Config.getInstance().getApiKey();
        
        
        // Ejemplo de uso
       if (Autorizacion.getInstance().puede("usuario1", "permiso1")) {
            System.out.println("Acceso concedido a " + "usuario1" + " para " + "permiso1");
        } else {
            System.out.println("Acceso denegado a " + "usuario1" + " para " + "permiso1");
        }
    }
}
