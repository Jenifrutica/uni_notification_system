public class NotificationEmail extends Notification {
    private String direccionEmail;
    private String asunto;

    public NotificationEmail(String codigo, String destinatario, String mensaje, String direccionEmail, String asunto) {
        super(codigo, destinatario, mensaje);
        this.direccionEmail = direccionEmail;
        this.asunto = asunto;
    }


    public String getDireccionEmail() {
        return direccionEmail;
    }

    public void setDireccionEmail(String direccionEmail) {
        this.direccionEmail = direccionEmail;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    @Override
    public void enviar() {
        this.setEstado(EstadoNotificacion.ENVIADO);
    }
    @Override
    public String toString() {
        return super.toString() + " -> NotificationEmail{" +
                "direccionEmail='" + direccionEmail + '\'' +
                ", asunto='" + asunto + '\'' +
                '}';
    }

}