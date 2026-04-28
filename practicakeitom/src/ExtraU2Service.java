public class ExtraU2Service {

    public static boolean esIdValido(String id) {
        // TODO validar null, blank y longitud 4-8
        return false;
    }

    public static boolean esCategoriaValida(int cat) {
        // TODO 1..3
        return false;
    }

    public static boolean esUrgenciaValida(int urg) {
        // TODO 1..5
        return false;
    }

    public static boolean esHorasValida(double hrs) {
        // TODO 0.5..40
        return false;
    }

    public static String clasificarUrgencia(int urg) {
        // TODO U1, U2, U3
        return "";
    }

    public static String clasificarTiempo(double hrs) {
        // TODO BAJO, MEDIO, ALTO
        return "";
    }

    public static boolean esAlertaSistema(int cat, int urg, boolean esc) {
        // TODO condición crítica
        return false;
    }
}
