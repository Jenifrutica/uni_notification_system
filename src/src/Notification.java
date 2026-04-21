import java.time.LocalDateTime;

public abstract class Notification {
    private String codigo;
    private String destinatario;
    private String mensaje;
    private SituacionNotificacion situacion;
    private LocalDateTime fechaEnvio;
    private EstadoNotificacion estado;

    public Notification(String codigo, String destinatario, String mensaje, SituacionNotificacion situacion) {
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.mensaje = mensaje;
        this.situacion = situacion;
        this.fechaEnvio = LocalDateTime.now();
        this.estado = EstadoNotificacion.PENDIENTE;
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

    public SituacionNotificacion getSituacion() {
        return situacion;
    }

    public void setSituacion(SituacionNotificacion situacion) {
        this.situacion = situacion;
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
                ", situacion=" + situacion +
                ", fechaEnvio=" + fechaEnvio +
                ", estado=" + estado +
                '}';
    }
}
