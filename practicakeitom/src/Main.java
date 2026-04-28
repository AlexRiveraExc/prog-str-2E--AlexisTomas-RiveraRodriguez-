import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalValidos = 0;

        int totalSoporte = 0, totalDev = 0, totalInfra = 0;
        int totalU1 = 0, totalU2 = 0, totalU3 = 0;
        int totalBajo = 0, totalMedio = 0, totalAlto = 0;

        double sumaHoras = 0;
        boolean alerta = false;

        while (true) {
            System.out.print("ID o SALIR: ");
            String id = sc.next();

            if (id.equalsIgnoreCase("SALIR")) break;

            if (!ExtraU2Service.esIdValido(id)) {
                System.out.println("ID inválido");
                continue;
            }

            System.out.print("Categoría (1-3): ");
            if (!sc.hasNextInt()) {
                System.out.println("Categoría inválida");
                return;
            }
            int cat = sc.nextInt();

            if (!ExtraU2Service.esCategoriaValida(cat)) {
                System.out.println("Categoría inválida");
                continue;
            }

            System.out.print("Urgencia (1-5): ");
            if (!sc.hasNextInt()) {
                System.out.println("Urgencia inválida");
                return;
            }
            int urg = sc.nextInt();

            if (!ExtraU2Service.esUrgenciaValida(urg)) {
                System.out.println("Urgencia inválida");
                continue;
            }

            System.out.print("Escalado (true/false): ");
            if (!sc.hasNextBoolean()) {
                System.out.println("Escalado inválido");
                return;
            }
            boolean esc = sc.nextBoolean();

            System.out.print("Horas (0.5-40): ");
            if (!sc.hasNextDouble()) {
                System.out.println("Horas inválidas");
                return;
            }
            double hrs = sc.nextDouble();

            if (!ExtraU2Service.esHorasValida(hrs)) {
                System.out.println("Horas inválidas");
                continue;
            }

            // Incidencia válida
            totalValidos++;
            sumaHoras += hrs;

            // TODO A) Conteo por categoría
            // if cat == 1 -> totalSoporte++
            // else if cat == 2 -> totalDev++
            // else -> totalInfra++

            String u = ExtraU2Service.clasificarUrgencia(urg);

            // TODO B) Conteo por urgencia
            // U1, U2, U3

            String t = ExtraU2Service.clasificarTiempo(hrs);

            // TODO C) Conteo por tiempo
            // BAJO, MEDIO, ALTO

            // TODO D) Alerta sistema
            // usar método y hacer break
        }

        System.out.println("\n=== RESUMEN ===");
        System.out.println("Total: " + totalValidos);

        // TODO E) imprimir conteos

        double prom = totalValidos == 0 ? 0 : sumaHoras / totalValidos;
        System.out.printf("Promedio: %.2f\n", prom);

        System.out.println("Alerta: " + (alerta ? "SI" : "NO"));
    }
}
