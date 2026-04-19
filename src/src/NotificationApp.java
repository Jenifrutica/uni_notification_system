public class NotificationApp extends Notification {
    private String tokenDispositivo;
    private int prioridad; // 1: Alta, 2: Media, 3: Baja

    public NotificationApp(String codigo, String destinatario, String mensaje, String tokenDispositivo, int prioridad) {
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

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }


    @Override
    public void enviar() {
        System.out.println("Enviando Push Notification al token: " + tokenDispositivo);
        System.out.println("Prioridad: " + prioridad);
        System.out.println("Mensaje: " + getMensaje());
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