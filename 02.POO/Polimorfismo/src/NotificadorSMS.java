public class NotificadorSMS implements Notificador {

    public void notificar(String msg) {
        System.out.println("Notificando por SMS" + msg);
        this.log("mensaje notificado");
    }

    public void log(String msg) {
        System.out.println("Log...");
    }
}
