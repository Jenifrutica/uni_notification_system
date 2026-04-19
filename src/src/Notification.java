import java.time.LocalDateTime;

public abstract class Notification {
    private String codigo;
    private String destinatario;
    private String mensaje;
    private LocalDateTime fechaEnvio;
    private EstadoNotificacion estado;

    public Notification(String codigo, String destinatario, String mensaje) {
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.mensaje = mensaje;
        this.fechaEnvio = LocalDateTime.now(); // Se asigna automáticamente al crearla
        this.estado = EstadoNotificacion.PENDIENTE; // Empieza siempre en pendiente

    }


    public abstract void enviar();

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public EstadoNotificacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoNotificacion estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "codigo='" + codigo + '\'' +
                ", destinatario='" + destinatario + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", fechaEnvio=" + fechaEnvio +
                ", estado=" + estado +
                '}';
    }
}
