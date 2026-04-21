import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Sistema de Registro de notificaciones");
        System.out.println("Seleccione el medio de envío:");
        System.out.println("1. Email\n2. SMS\n3. App");
        System.out.print("Seleccione (1-3): ");
        int opcion = input.nextInt();
        input.nextLine();

        System.out.println("Asunto (situación de la notificación):");
        System.out.println("1. Publicación de calificaciones");
        System.out.println("2. Recordatorio de pago de matrícula");
        System.out.println("3. Aviso de cancelación de clase");
        System.out.println("4. Confirmación de inscripción a eventos académicos");
        System.out.print("Seleccione (1-4): ");
        int opcionSituacion = input.nextInt();
        input.nextLine();
        SituacionNotificacion situacion;
        switch (opcionSituacion) {
            case 1:
                situacion = SituacionNotificacion.PUBLICACION_CALIFICACIONES;
                break;
            case 2:
                situacion = SituacionNotificacion.RECORDATORIO_PAGO_MATRICULA;
                break;
            case 3:
                situacion = SituacionNotificacion.AVISO_CANCELACION_CLASE;
                break;
            case 4:
                situacion = SituacionNotificacion.CONFIRMACION_INSCRIPCION_EVENTOS;
                break;
            default:
                System.out.println("Situación no soportada.");
                input.close();
                return;
        }

        String email = null;
        String celular = null;
        String prov = null;
        String token = null;
        PrioridadNotificacion prio = null;

        switch (opcion) {
            case 1:
                System.out.print("Correo: ");
                email = input.nextLine();
                break;
            case 2:
                System.out.print("Celular: ");
                celular = input.nextLine();
                System.out.print("Proveedor: ");
                prov = input.nextLine();
                break;
            case 3:
                System.out.print("Token: ");
                token = input.nextLine();
                System.out.print("Prioridad (1: ALTA, 2: MEDIA, 3: BAJA): ");
                int opcionPrioridad = Integer.parseInt(input.nextLine());
                switch (opcionPrioridad) {
                    case 1:
                        prio = PrioridadNotificacion.ALTA;
                        break;
                    case 2:
                        prio = PrioridadNotificacion.MEDIA;
                        break;
                    case 3:
                        prio = PrioridadNotificacion.BAJA;
                        break;
                    default:
                        System.out.println("Prioridad no soportada.");
                        input.close();
                        return;
                }
                break;
            default:
                System.out.println("Medio no soportado.");
                input.close();
                return;
        }

        System.out.print("Código: ");
        String codigo = input.nextLine();
        System.out.print("Destinatario: ");
        String dest = input.nextLine();
        System.out.print("Mensaje: ");
        String msg = input.nextLine();

        Notification notificacion = null;
        if (opcion == 1) {
            notificacion = new NotificationEmail(codigo, dest, msg, situacion, email);
        } else if (opcion == 2) {
            notificacion = new NotificationSMS(codigo, dest, msg, situacion, celular, prov);
        } else if (opcion == 3) {
            notificacion = new NotificationApp(codigo, dest, msg, situacion, token, prio);
        }

        if (notificacion != null) {
            notificacion.enviar();
            String medio = "";
            String detalleMedio = "";

            if (notificacion instanceof NotificationEmail emailNotif) {
                medio = "Correo electrónico";
                detalleMedio = "Para: " + emailNotif.getDireccionEmail() + " | Asunto: " + notificacion.getSituacion();
            } else if (notificacion instanceof NotificationSMS smsNotif) {
                medio = "Mensaje de texto (SMS)";
                detalleMedio = "Número: " + smsNotif.getNumeroCelular() + " | Proveedor: " + smsNotif.getProveedor();
            } else if (notificacion instanceof NotificationApp appNotif) {
                medio = "Notificación móvil";
                detalleMedio = "Token: " + appNotif.getTokenDispositivo() + " | Prioridad: " + appNotif.getPrioridad();
            }


            System.out.println("NOTIFICACIÓN ENVIADA CON ÉXITO");
            System.out.println("Código       : " + notificacion.getCodigo());
            System.out.println("Destinatario : " + notificacion.getDestinatario());
            System.out.println("Medio        : " + medio);
            System.out.println("Detalle      : " + detalleMedio);
            System.out.println("Situación    : " + notificacion.getSituacion());
            System.out.println("Mensaje      : " + notificacion.getMensaje());
            System.out.println("Fecha envío  : " + notificacion.getFechaEnvio());
            System.out.println("Estado       : " + notificacion.getEstado());
        }

        input.close();
    }
}