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
public class ShippingCalculator {

    public double calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean zonaRemota) {
        double subtotal = 0;

        if (tipoServicio == 1) {
            subtotal = subtotal + 50;
        } else {
            subtotal = subtotal + 90;
        }

        subtotal = subtotal + (pesoKg * 12);

        if (distanciaKm <= 50) {
            subtotal = subtotal + 20;
        } else if (distanciaKm <= 200) {
            subtotal = subtotal + 60;
        } else {
            subtotal = subtotal + 120;
        }

        if (zonaRemota == true) {
            subtotal = subtotal + (subtotal * 0.10);
        }

        return subtotal;
    }

    public double calcularIVA(double subtotal) {
        return subtotal * 0.16;
    }

    public double calcularTotal(double subtotal, double iva) {
        return subtotal + iva;
    }
}