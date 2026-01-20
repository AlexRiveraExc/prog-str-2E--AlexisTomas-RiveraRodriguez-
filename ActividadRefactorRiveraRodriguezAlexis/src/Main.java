import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = pedirEntero(scanner, "a: ");
        int b = pedirEntero(scanner, "b: ");
        int c = pedirEntero(scanner, "c: ");

        int suma = calcularSuma(a, b, c);
        double prom = calcularPromedio(suma);

        System.out.println("suma=" + suma);
        System.out.println("prom=" + prom);
    }

    public static int pedirEntero(Scanner scanner, String mensaje){
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    public static int calcularSuma(int a, int b, int c){
        return a + b + c;
    }

    public static double calcularPromedio(int suma){
        return suma / 3.0;
    }
}
