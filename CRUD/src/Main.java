import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Persona[] personas = new Persona[20];
        int opcion;

        do {
            System.out.println("\nmenu");
            System.out.println("1) alta");
            System.out.println("2) buscar por id");
            System.out.println("3) baja logica por id");
            System.out.println("4) listar activas");
            System.out.println("5) actualizar nombre por id");
            System.out.println("0) salir");
            System.out.print("elige una opcion: ");
            opcion = sc.nextInt();

            if (opcion == 1) {

                System.out.print("ingresa id: ");
                int id = sc.nextInt();

                if (id <= 0) {
                    System.out.println("id invalido");
                    continue;
                }

                boolean repetido = false;

                for (int i = 0; i < personas.length; i++) {
                    if (personas[i] != null && personas[i].id == id) {
                        repetido = true;
                        break;
                    }
                }

                if (repetido) {
                    System.out.println("id repetido");
                    continue;
                }

                sc.nextLine();
                System.out.print("ingresa nombre: ");
                String nombre = sc.nextLine();

                if (nombre.equals("")) {
                    System.out.println("nombre vacio");
                    continue;
                }

                for (int i = 0; i < personas.length; i++) {
                    if (personas[i] == null) {
                        personas[i] = new Persona();
                        personas[i].id = id;
                        personas[i].nombre = nombre;
                        personas[i].activa = true;
                        System.out.println("persona agregada");
                        break;
                    }
                }
            }

            else if (opcion == 2) {

                System.out.print("ingresa id a buscar: ");
                int id = sc.nextInt();
                boolean encontrada = false;

                for (int i = 0; i < personas.length; i++) {
                    if (personas[i] != null && personas[i].id == id && personas[i].activa) {
                        System.out.println("id: " + personas[i].id);
                        System.out.println("nombre: " + personas[i].nombre);
                        encontrada = true;
                        break;
                    }
                }

                if (!encontrada) {
                    System.out.println("no encontrada o inactiva");
                }
            }

            else if (opcion == 3) {

                System.out.print("ingresa id para baja: ");
                int id = sc.nextInt();
                boolean baja = false;

                for (int i = 0; i < personas.length; i++) {
                    if (personas[i] != null && personas[i].id == id && personas[i].activa) {
                        personas[i].activa = false;
                        System.out.println("persona dada de baja");
                        baja = true;
                        break;
                    }
                }

                if (!baja) {
                    System.out.println("no encontrada o inactiva");
                }
            }

            else if (opcion == 4) {

                System.out.println("personas activas:");

                for (int i = 0; i < personas.length; i++) {
                    if (personas[i] != null && personas[i].activa) {
                        System.out.println("id: " + personas[i].id + " nombre: " + personas[i].nombre);
                    }
                }
            }

            else if (opcion == 5) {

                System.out.print("ingresa id para actualizar: ");
                int id = sc.nextInt();
                sc.nextLine();
                boolean actualizado = false;

                for (int i = 0; i < personas.length; i++) {
                    if (personas[i] != null && personas[i].id == id && personas[i].activa) {

                        System.out.print("nuevo nombre: ");
                        String nuevo = sc.nextLine();

                        if (nuevo.equals("")) {
                            System.out.println("nombre vacio");
                        } else {
                            personas[i].nombre = nuevo;
                            System.out.println("nombre actualizado");
                        }

                        actualizado = true;
                        break;
                    }
                }

                if (!actualizado) {
                    System.out.println("no encontrada o inactiva");
                }
            }

            else if (opcion != 0) {
                System.out.println("opcion invalida");
            }

        } while (opcion != 0);

        System.out.println("programa terminado");
    }
}