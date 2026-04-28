/**
 * Nombre del alumno: Alexis Tomas Rivera Rodriguez
 * Carrera: DSM
 * Materia: Programación Estructurada
 * Universidad: Universidad Emiliano Zapata
 * Profesor: Eliel
 * Cuatrimestre: 2
 * Grupo: E
 * Fecha: 23/01/2026
 */

import java.util.Scanner;

public class ActividadSwitchCalculadora {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("--Calculadora--");
        System.out.println("1.suma");
        System.out.println("2. restar");
        System.out.println("3. multiplicar");
        System.out.println("4. dividir");
        System.out.print("selecciona una opccion : ");
        int opcion = sc.nextInt();

        System.out.print("ingresa el ptimrr numero: ");
        double primerNumero = sc.nextDouble();

        System.out.print("Ingresa el segundo numero: ");
        double segundoNumero = sc.nextDouble();

        double resultado;
        String operacion;

        switch (opcion) {
            case 1:
                operacion = "suma";
                resultado = primerNumero + segundoNumero;
                System.out.println("Operacion: " + operacion);
                System.out.println("Valores: primerNumero = " + primerNumero + ", segundoNumero = " + segundoNumero);
                System.out.println("Resultado: " + resultado);
                break;

            case 2:
                operacion = "resta";
                resultado = primerNumero - segundoNumero;
                System.out.println("Operacion: " + operacion);
                System.out.println("Valores: primerNumero = " + primerNumero + ", segundoNumero = " + segundoNumero);
                System.out.println("Resultado: " + resultado);
                break;

            case 3:
                operacion = "multiplicacion";
                resultado = primerNumero * segundoNumero;
                System.out.println("Operacion: " + operacion);
                System.out.println("Valores: primerNumero = " + primerNumero + ", segundoNumero = " + segundoNumero);
                System.out.println("Resultado: " + resultado);
                break;

            case 4:
                operacion = "Division";
                System.out.println("Operacion: " + operacion);
                System.out.println("Valores: primerNumero = " + primerNumero + ", segundoNumero = " + segundoNumero);

                if (segundoNumero == 0) {
                    System.out.println("No se puede dividir entre cero");
                } else {
                    resultado = primerNumero / segundoNumero;
                    System.out.println("Resultado: " + resultado);
                }
                break;

            default:
                System.out.println("Opcion invalida");
                break;
        }

        sc.close();
    }
}
