/**
 * Nombre del alumno: Alexis Tomas Rivera Rodriguez
 * Carrera: DSM
 * Materia: Programación Estructurada
 * Universidad: Universidad Emiliano Zapata
 * Profesor: Eliel
 * Cuatrimestre: 2
 * Grupo: E
 * Fecha: 27/01/2026
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion;
        //contadores
        int CaF = 0;
        int faC = 0;
        int kmAM = 0;
        int mAKm = 0;
        int totalConversiones = 0;

        //menu de opciones
        do {
            System.out.println("\n--- menu---");
            System.out.println("1) °C a °F");
            System.out.println("2) °F a °C");
            System.out.println("3) Km a Millas");
            System.out.println("4) Millas a Km");
            System.out.println("5) salir");
            System.out.print("ingresa una opcion: ");

            while (!sc.hasNextInt()) {  //validacion de datos
                System.out.print("pcion no valida, selecciona otra");
                sc.next();
            }
            opcion = sc.nextInt();

            if (opcion < 1 || opcion > 5) {
                System.out.println("su opccion no esta dentro del rango.");
                return;
            }

            if (opcion == 5) {
                break;
            }

            System.out.print("ingresa el valor: ");
            while (!sc.hasNextDouble()) {  //validacion de datos
                System.out.print("valor no valido, intenta de nuevo: ");
                sc.next();
            }
            double valor = sc.nextDouble();
            double resultado;

            switch (opcion) {  //conversion de datos
                case 1:
                    resultado = (valor * 9 / 5) + 32;
                    System.out.println(valor + " °C = " + resultado + " °F");
                    CaF++;
                    break;
                case 2:
                    resultado = (valor - 32) * 5 / 9;
                    System.out.println(valor + " °F = " + resultado + " °C");
                    faC++;
                    break;3
                case 3:
                    resultado = valor * 0.621371;
                    System.out.println(valor + " Km = " + resultado + " Millas");
                    kmAM++;
                    break;
                case 4:
                    resultado = valor / 0.621371;
                    System.out.println(valor + " Millas = " + resultado + " Km");
                    mAKm++;
                    break;
            }

            totalConversiones++;

        } while (true);

        //impresion de resultados
        System.out.println("\n--total de datos conertidos--");
        System.out.println("total de conversiones: " + totalConversiones);
        System.out.println("°C a °F: " + CaF);
        System.out.println("°F a °C: " + faC);
        System.out.println("Km a Millas: " + kmAM);
        System.out.println("Millas a Km: " + mAKm);

        sc.close();
    }
}