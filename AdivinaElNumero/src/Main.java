/**
 * Nombre del alumno: Alexis Tomas Rivera Rodriguez
 * Carrera: DSM
 * Materia: Programación Estructurada
 * Universidad: Universidad Emiliano Zapata
 * Profesor: Eliel
 * Cuatrimestre: 2
 * Grupo: E
 * Fecha: 29/01/2026
 */

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int numeroSecreto = rand.nextInt(100) + 1;
        int intentos = 0;
        int maxIntentos = 7;
        boolean gano = false;

        int fueraDeRango = 0;
        int noNumerico = 0;

        System.out.println("adivina el numero entre 1 y 100");
        System.out.println("tienes 7 intentos.\n");
        System.out.println("El número secreto es: " + numeroSecreto);

        while (intentos < maxIntentos && !gano) {
            System.out.print("ingresa tu intento: ");
            String entrada = sc.nextLine();

            // Validamos que sea un numero
            boolean esNumero = true;
            for (int i = 0; i < entrada.length(); i++) {
                char c = entrada.charAt(i);
                if (c < '0' || c > '9') {
                    esNumero = false;
                    break;
                }
            }

            if (!esNumero) {
                noNumerico++;
                System.out.println("dato no valido, ingresa un numero entero.");
                continue;
            }

            int intento = Integer.parseInt(entrada);

            if (intento < 1 || intento > 100) {
                fueraDeRango++;
                System.out.println("numero fuera de rango\n tiene que ser entre 1 y 100.");
                continue;
            }

            intentos++;

            if (intento == numeroSecreto) {
                System.out.println("GANASTE adivinaste el numero en " + intentos + " intentos.");
                gano = true;
            } else if (intento < numeroSecreto) {
                System.out.println("el numero secreto es mayor.");
            } else {
                System.out.println("el numero secreto es menor.");
            }
        }

        if (!gano) {
            System.out.println("\nPERIDSTE El numero secreto era: " + numeroSecreto);
        }

        System.out.println("\nContador");
        System.out.println("intentos fuera de rango: " + fueraDeRango);
        System.out.println("intentos no numericos: " + noNumerico);
    }
}