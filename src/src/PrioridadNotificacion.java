public enum PrioridadNotificacion {
    ALTA("alta"),
    MEDIA("media"),
    BAJA("baja");

    private final String etiqueta;

    PrioridadNotificacion(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public static PrioridadNotificacion fromOpcion(int opcion) {
        return switch (opcion) {
            case 1 -> ALTA;
            case 2 -> MEDIA;
            case 3 -> BAJA;
            default -> throw new IllegalArgumentException("Prioridad inválida. Use 1 (ALTA), 2 (MEDIA) o 3 (BAJA).");
        };
    }

    @Override
    public String toString() {
        return etiqueta;
    }
}
