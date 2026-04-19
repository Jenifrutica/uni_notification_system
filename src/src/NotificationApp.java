public class NotificationApp extends Notification {
    private String tokenDispositivo;
    private PrioridadNotificacion prioridad;

    public NotificationApp(String codigo, String destinatario, String mensaje, String tokenDispositivo, PrioridadNotificacion prioridad) {
        super(codigo, destinatario, mensaje);
        this.tokenDispositivo = tokenDispositivo;
        this.prioridad = prioridad;
    }

    public String getTokenDispositivo() {
        return tokenDispositivo;
    }

    public void setTokenDispositivo(String tokenDispositivo) {
        this.tokenDispositivo = tokenDispositivo;
    }

    public PrioridadNotificacion getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(PrioridadNotificacion prioridad) {
        this.prioridad = prioridad;
    }


    @Override
    public void enviar() {
        this.setEstado(EstadoNotificacion.ENVIADO);
    }

    @Override
    public String toString() {
        // Usamos super.toString() para traer los datos de la madre y le pegamos los de la hija
        return super.toString() + " -> NotificationApp{" +
                "tokenDispositivo='" + tokenDispositivo + '\'' +
                ", prioridad=" + prioridad +
                '}';
    }
}