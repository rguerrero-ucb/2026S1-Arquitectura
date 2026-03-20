public class Procesador {
    public Notificador notificador;

    public Procesador(Notificador notificador){
        this.notificador = notificador;
    }

    public void procesar() {
        System.out.println("Procesando..");
        this.notificador.notificar("Proceso finalizado");
    }

}
