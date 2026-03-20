public class WhatsappNotificador extends Object implements Notificador{
    public void conectar() {
        System.out.println("conectando...");        
    }

    public void notificar(String msg) {
        System.out.println("WP: " + msg);
    }

    public void log(String audit) {
        System.out.println("Log...wp");
    }

    
}
