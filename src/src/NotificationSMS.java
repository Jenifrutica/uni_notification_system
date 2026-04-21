public class NotificationSMS extends Notification {
    private String numeroCelular;
    private String proveedor;

    public NotificationSMS(String codigo, String destinatario, String mensaje, SituacionNotificacion situacion, String numeroCelular, String proveedor) {
        super(codigo, destinatario, mensaje, situacion);
        this.numeroCelular = numeroCelular;
        this.proveedor = proveedor;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public void enviar() {
        this.setEstado(EstadoNotificacion.ENVIADO);
    }

    @Override
    public String toString() {
        return super.toString() + " -> NotificationSMS{" +
                "numeroCelular='" + numeroCelular + '\'' +
                ", proveedor='" + proveedor + '\'' +
                '}';
    }
}