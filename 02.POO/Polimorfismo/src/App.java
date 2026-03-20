public class App {

    public static void main(String[] args) throws Exception {

        //NotificadorSMS notificador = new NotificadorSMS();
        //EmailNotificador notificador = new EmailNotificador();
        WhatsappNotificador notificador = new WhatsappNotificador();

        //Notificador n = new Notificador();

        Procesador proc = new Procesador(notificador);
        proc.procesar();
    }
}
