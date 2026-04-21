public class NotificationEmail extends Notification {
    private String direccionEmail;

    public NotificationEmail(String codigo, String destinatario, String mensaje, SituacionNotificacion situacion, String direccionEmail) {
        super(codigo, destinatario, mensaje, situacion);
        this.direccionEmail = direccionEmail;
    }


    public String getDireccionEmail() {
        return direccionEmail;
    }

    public void setDireccionEmail(String direccionEmail) {
        this.direccionEmail = direccionEmail;
    }

    @Override
    public void enviar() {
        this.setEstado(EstadoNotificacion.ENVIADO);
    }
    @Override
    public String toString() {
        return super.toString() + " -> NotificationEmail{" +
                "direccionEmail='" + direccionEmail + '\'' +
                '}';
    }

}