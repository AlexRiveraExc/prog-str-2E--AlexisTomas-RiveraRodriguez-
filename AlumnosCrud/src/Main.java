import java.util.Scanner;

public class Main {

    static class Alumno {
        int id;
        String nombre;
        double promedio;
        boolean activo;

        Alumno(int id, String nombre, double promedio) {
            this.id = id;
            this.nombre = nombre;
            this.promedio = promedio;
            this.activo = true;
        }
    }

    static Alumno[] alumnos = new Alumno[25];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\nMENU ");
            System.out.println("1) Alta alumno");
            System.out.println("2) Buscar por ID (solo activos)");
            System.out.println("3) Actualizar promedio por ID (solo activos)");
            System.out.println("4) Baja logica por ID");
            System.out.println("5) Listar activos");
            System.out.println("6) Reportes");
            System.out.println("0) Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1: alta(); break;
                case 2: buscar(); break;
                case 3: actualizarPromedio(); break;
                case 4: bajaLogica(); break;
                case 5: listarActivos(); break;
                case 6: reportes(); break;
                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opcion invalida");
            }

        } while (opcion != 0);
    }

    static void alta() {
        int pos = primeraLibre();
        if (pos == -1) {
            System.out.println("Arreglo lleno");
            return;
        }

        System.out.print("ID: ");
        int id = sc.nextInt();
        if (id <= 0 || existeId(id)) {
            System.out.println("ID invalido o repetido");
            return;
        }

        sc.nextLine(); // limpiar buffer
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        if (nombre.trim().isEmpty()) {
            System.out.println("Nombre vacio");
            return;
        }

        System.out.print("Promedio: ");
        double promedio = sc.nextDouble();
        if (promedio < 0 || promedio > 10) {
            System.out.println("Promedio fuera de rango");
            return;
        }

        alumnos[pos] = new Alumno(id, nombre, promedio);
        System.out.println("Alumno registrado");
    }

    static void buscar() {
        System.out.print("ID a buscar: ");
        int id = sc.nextInt();

        for (Alumno a : alumnos) {
            if (a != null && a.activo && a.id == id) {
                System.out.println("ID: " + a.id);
                System.out.println("Nombre: " + a.nombre);
                System.out.println("Promedio: " + a.promedio);
                return;
            }
        }
        System.out.println("Alumno activo no encontrado");
    }

    static void actualizarPromedio() {
        System.out.print("ID del alumno: ");
        int id = sc.nextInt();

        for (Alumno a : alumnos) {
            if (a != null && a.activo && a.id == id) {
                System.out.print("Nuevo promedio: ");
                double nuevo = sc.nextDouble();
                if (nuevo < 0 || nuevo > 10) {
                    System.out.println("Promedio invalido");
                    return;
                }
                a.promedio = nuevo;
                System.out.println("Promedio actualizado");
                return;
            }
        }
        System.out.println("Alumno activo no encontrado");
    }

    static void bajaLogica() {
        System.out.print("ID a dar de baja: ");
        int id = sc.nextInt();

        for (Alumno a : alumnos) {
            if (a != null && a.activo && a.id == id) {
                a.activo = false;
                System.out.println("Alumno dado de baja logica");
                return;
            }
        }
        System.out.println("Alumno activo no encontrado");
    }

    static void listarActivos() {
        boolean hay = false;
        for (Alumno a : alumnos) {
            if (a != null && a.activo) {
                System.out.println(a.id + " | " + a.nombre + " | " + a.promedio);
                hay = true;
            }
        }
        if (!hay) System.out.println("No hay alumnos activos");
    }

    static void reportes() {
        double suma = 0;
        int cont = 0;
        Alumno mayor = null;
        Alumno menor = null;
        int contMayor8 = 0;

        for (Alumno a : alumnos) {
            if (a != null && a.activo) {
                suma += a.promedio;
                cont++;

                if (mayor == null || a.promedio > mayor.promedio)
                    mayor = a;

                if (menor == null || a.promedio < menor.promedio)
                    menor = a;

                if (a.promedio >= 8.0)
                    contMayor8++;
            }
        }

        if (cont == 0) {
            System.out.println("No hay alumnos activos para reportes");
            return;
        }

        System.out.println("\n--- REPORTES ---");
        System.out.println("Promedio general: " + (suma / cont));
        System.out.println("Mayor promedio: " + mayor.id + " | " + mayor.nombre + " | " + mayor.promedio);
        System.out.println("Menor promedio: " + menor.id + " | " + menor.nombre + " | " + menor.promedio);
        System.out.println("Activos con promedio >= 8.0: " + contMayor8);
    }

    static int primeraLibre() {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) return i;
        }
        return -1;
    }

    static boolean existeId(int id) {
        for (Alumno a : alumnos) {
            if (a != null && a.id == id) return true;
        }
        return false;
    }
}