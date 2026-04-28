

package JavadocRiveraRodriguezAlexis;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menu");
            System.out.println("1. calcular IMC");
            System.out.println("2. calcular area de un rectangulo");
            System.out.println("3. convertir grados C a F");
            System.out.println("4. calcular area de un circulo");
            System.out.println("5. salir");
            System.out.print("Escoge una opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    calcularIMC(sc);
                    break;
                case 2:
                    calcularAreaRectangulo(sc);
                    break;
                case 3:
                    convertirCelsiusAFahrenheit(sc);
                    break;
                case 4:
                    calcularAreaCirculo(sc);
                    break;
                case 5:
                    salirPrograma();
                    break;
                default:
                    System.out.println("opcion no valida");
            }

            System.out.println();

        } while (opcion != 3);
    }

    /** * opccion que devuelve el IMC con formula - peso/altura²
     * @param pesoKg - en milos
     * @param alturaM - en metros
     * @return -> double de IMC */

    public static void calcularIMC(Scanner sc) {
        System.out.print("ingresa tu peso en kilogramos: ");
        double peso = sc.nextDouble();

        System.out.print("ingresa tu altura en metros: ");
        double altura = sc.nextDouble();

        double imc = peso / (altura * altura);
        System.out.println("yu IMC es: " + imc);
    }

    /**
     * calcula el area de un rectangulo usando base y altura
     */
    public static void calcularAreaRectangulo(Scanner sc) {
        System.out.print("ingresa la base: ");
        double base = sc.nextDouble();

        System.out.print("ingresa la altura: ");
        double altura = sc.nextDouble();

        double area = base * altura;
        System.out.println("la area es: " + area);
    }

    /**
     * convierte grados Celsius a Fahrenhei
     */
    public static void convertirCelsiusAFahrenheit(Scanner sc) {
        System.out.print("ingresa los grados Celsius: ");
        double celsius = sc.nextDouble();

        double fahrenheit = (celsius * 1.8) + 32;
        System.out.println("grados Fahrenheit: " + fahrenheit);
    }

    /**  calcula el area de un circulo *
     * @param radio - radio del circulo */

    public static void calcularAreaCirculo(Scanner sc) {
        System.out.print("ingresa el radio del circulo: ");
        double radio = sc.nextDouble();

        double area = Math.PI * (radio * radio);
        System.out.println("el area es: " + area);
    }

    /**
     * Muestra un mensaje de salida del programa
     */
    public static void salirPrograma() {
        System.out.println("saliendo...");
    }
}
