import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Usando 'input' como le gusta a tu profe

        System.out.println("=== REGISTRO DE NOTIFICACIÓN UNIVERSITARIA ===");

        // Menú de opciones
        System.out.println("\nPrimero, seleccione el medio de envío:");
        System.out.println("1. Email\n2. SMS\n3. App");
        System.out.print("Seleccione (1-3): ");

        // Leemos como String y convertimos a int para evitar errores de buffer
        int opcion = Integer.parseInt(input.nextLine());

        // Datos generales (después de elegir el medio)
        System.out.print("Código: ");
        String codigo = input.nextLine();

        System.out.print("Destinatario: ");
        String dest = input.nextLine();

        System.out.print("Mensaje: ");
        String msg = input.nextLine();

        Notification notificacion = null;

        switch (opcion) {
            case 1:
                System.out.print("Correo: ");
                String email = input.nextLine();
                System.out.print("Asunto: ");
                String asunto = input.nextLine();
                notificacion = new NotificationEmail(codigo, dest, msg, email, asunto);
                break;

            case 2:
                System.out.print("Celular: ");
                String celular = input.nextLine();
                System.out.print("Proveedor: ");
                String prov = input.nextLine();
                notificacion = new NotificationSMS(codigo, dest, msg, celular, prov);
                break;

            case 3:
                System.out.print("Token: ");
                String token = input.nextLine();
                System.out.print("Prioridad (1: ALTA, 2: MEDIA, 3: BAJA): ");
                int opcionPrioridad = Integer.parseInt(input.nextLine());
                PrioridadNotificacion prio = PrioridadNotificacion.fromOpcion(opcionPrioridad);
                notificacion = new NotificationApp(codigo, dest, msg, token, prio);
                break;
        }

        if (notificacion != null) {
            notificacion.enviar();
            String medio = "";
            String detalleMedio = "";

            if (notificacion instanceof NotificationEmail emailNotif) {
                medio = "Correo electrónico";
                detalleMedio = "Para: " + emailNotif.getDireccionEmail() + " | Asunto: " + emailNotif.getAsunto();
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
            System.out.println("Mensaje      : " + notificacion.getMensaje());
            System.out.println("Fecha envío  : " + notificacion.getFechaEnvio());
            System.out.println("Estado       : " + notificacion.getEstado());
        }

        input.close();
    }
}