public class NotificationSMS extends Notification {
    private String numeroCelular;
    private String proveedor;

    public NotificationSMS(String codigo, String destinatario, String mensaje, String numeroCelular, String proveedor) {
        super(codigo, destinatario, mensaje);
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
        System.out.println("Enviando SMS vía [" + proveedor + "] al número: " + numeroCelular);
        System.out.println("Mensaje: " + getMensaje());
        this.setEstado(EstadoNotificacion.ENVIADO);
    }

    @Override
    public String toString() {
        return "NotificationSMS{" +
                "numeroCelular='" + numeroCelular + '\'' +
                ", proveedor='" + proveedor + '\'' +
                '}';
    }
}