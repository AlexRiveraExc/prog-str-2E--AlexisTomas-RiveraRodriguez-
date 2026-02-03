/**
 * Nombre del alumno: Alexis Tomas Rivera Rodriguez
 * Carrera: DSM
 * Materia: Programación Estructurada
 * Universidad: Universidad Emiliano Zapata
 * Profesor: Eliel
 * Cuatrimestre: 2
 * Grupo: E
 * Fecha: 07/01/2026
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ShippingCalculator calc = new ShippingCalculator();

        double pesoKg = leerDoubleEnRango(sc, "peso (kg): ", 0.1, 50.0);
        int distanciaKm = leerIntEnRango(sc, "distancia (km): ", 1, 2000);
        int tipoServicio = leerIntEnRango(sc, "servicio (1=estandar, 2=express): ", 1, 2);
        boolean zonaRemota = leerBoolean(sc, "zona remota (TRUE/FALSE): ");

        double subtotal = calc.calcularSubtotal(pesoKg, distanciaKm, tipoServicio, zonaRemota);
        double iva = calc.calcularIVA(subtotal);
        double total = calc.calcularTotal(subtotal, iva);

        imprimirTicket(pesoKg, distanciaKm, tipoServicio, zonaRemota, subtotal, iva, total);
    }

    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double valor;
        do {
            System.out.print(msg);
            valor = sc.nextDouble();
        } while (valor < min || valor > max);
        return valor;
    }

    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int valor;
        do {
            System.out.print(msg);
            valor = sc.nextInt();
        } while (valor < min || valor > max);
        return valor;
    }

    public static boolean leerBoolean(Scanner sc, String msg) {
        System.out.print(msg);
        return sc.nextBoolean();
    }

    public static void imprimirTicket(double pesoKg, int distanciaKm, int tipoServicio,
                                      boolean zonaRemota, double subtotal, double iva, double total) {

        System.out.println("\nTICKET");

        if (tipoServicio == 1) {
            System.out.println("servicio: estandar");
        } else {
            System.out.println("servicio: express");
        }

        System.out.println("peso: " + pesoKg + " kg");
        System.out.println("distancia: " + distanciaKm + " km");
        System.out.println("zona remota: " + zonaRemota);
        System.out.println("subtotal: $" + subtotal);
        System.out.println("iva: $" + iva);
        System.out.println("total: $" + total);
    }
}