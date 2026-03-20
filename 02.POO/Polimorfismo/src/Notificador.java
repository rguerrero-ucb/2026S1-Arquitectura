public interface Notificador {
    public abstract void notificar(String msg);
    
    public void log(String audit);
}
