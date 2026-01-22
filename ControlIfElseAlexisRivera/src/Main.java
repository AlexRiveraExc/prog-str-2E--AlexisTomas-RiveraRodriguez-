/**
 * Nombre del alumno: Alexis Tomas Rivera Rodriguez
 * Carrera: DSM
 * Materia: Programación Estructurada
 * Universidad: Universidad Emiliano Zapata
 * Profesor: Eliel
 * Cuatrimestre: 2
 * Grupo: E
 * Fecha: 22/01/2026
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("ingresa tu edad: ");
        int edad = sc.nextInt();

        if (edad < 0 || edad > 120) {
            System.out.println("edad invalida");
            return;
        }

        System.out.print("eres estudiante? (si/no): ");
        String estudiante = sc.next().toLowerCase();

        int tarifa = 0;

        if (edad < 12) {
            tarifa = 50;
        } else if (edad <= 17) {
            if (estudiante.equals("si") || estudiante.equals("estudiante")) {
                tarifa = 60;
            } else {
                tarifa = 80;
            }
        } else {
            if (estudiante.equals("si") || estudiante.equals("estudiant")) {
                tarifa = 90;
            } else {
                tarifa = 120;
            }
        }

        System.out.println("edad ingresada: " + edad);
        System.out.println("es estudiante: " + (estudiante.equals("si") || estudiante.equals("estudiante") ? "Si" : "No"));
        System.out.println("tarifa final: " + tarifa);
    }
}
