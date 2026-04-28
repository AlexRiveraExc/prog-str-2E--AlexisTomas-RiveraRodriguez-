/**
 * Nombre del alumno: Alexis Tomas Rivera Rodriguez
 * Carrera: DSM
 * Materia: Programación Estructurada
 * Universidad: Universidad Emiliano Zapata
 * Profesor: Eliel
 * Cuatrimestre: 2
 * Grupo: E
 * Fecha: 19/01/2026
 */


import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // se piden los valores al usuario
        int a = pedirEntero(scanner, "a: ");
        int b = pedirEntero(scanner, "b: ");
        int c = pedirEntero(scanner, "c: ");

        // calcula la suma
        int suma = calcularSuma(a, b, c);

        // calcula el promedio
        double prom = calcularPromedio(suma);

        // muestra los resultados
        System.out.println("suma=" + suma);
        System.out.println("prom=" + prom);
    }

    public static int pedirEntero(Scanner scanner, String mensaje){
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    // metodo que suma tres numeros
    public static int calcularSuma(int a, int b, int c){
        return a + b + c;
    }

    // metodo que calcula el promedio a partir de la suma
    public static double calcularPromedio(int suma){
        return suma / 3.0;
    }
}