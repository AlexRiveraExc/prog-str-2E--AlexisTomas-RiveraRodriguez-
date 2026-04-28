import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GradeService gs = new GradeService();

        System.out.print("nombre: ");
        String nombre = sc.nextLine();

        System.out.print("parcial 1: ");
        double p1 = sc.nextDouble();

        System.out.print("parcial 2: ");
        double p2 = sc.nextDouble();

        System.out.print("parcial 3: ");
        double p3 = sc.nextDouble();

        System.out.print("asistencia: ");
        int asistencia = sc.nextInt();

        System.out.print("entrego proyecto (true/false): ");
        boolean entregoProyecto = sc.nextBoolean();

        double promedio = gs.calcularPromedio(p1, p2, p3);
        double finalCal = gs.calcularFinal(promedio, asistencia);
        String estado = gs.determinarEstado(finalCal, asistencia, entregoProyecto);

        System.out.println("\n--- resultado ---");
        System.out.println("alumno: " + nombre);
        System.out.println("calificaciones: " + p1 + ", " + p2 + ", " + p3);
        System.out.println("promedio: " + promedio);
        System.out.println("asistencia: " + asistencia);
        System.out.println("proyecto entregado: " + entregoProyecto);
        System.out.println("calificacion final: " + finalCal);
        System.out.println("estado: " + estado);

        sc.close();
    }
}
