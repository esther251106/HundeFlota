public class Principal {
    public static void main(String[] args) {
        Juego juego = new Juego();
        ConsolaUI consola = new ConsolaUI();

        consola.mostrarMensaje("🎯 ¡Bienvenido al juego Hundir la Flota!");

        while (!juego.juegoTerminado()) {
            consola.mostrarTablero(juego.obtenerTablero());

            int fila = consola.pedirCoordenada("Introduce la fila: ", juego.obtenerTablero().obtenerTamano());
            int columna = consola.pedirCoordenada("Introduce la columna: ", juego.obtenerTablero().obtenerTamano());

            boolean acierto = juego.realizarDisparo(fila, columna);

            if (acierto) {
                consola.mostrarMensaje("💥 ¡Tocado!");
            } else {
                consola.mostrarMensaje("🌊 Agua...");
            }

            consola.mostrarMensaje("Intentos restantes: " + juego.intentosRestantes());
        }

        if (juego.victoria()) {
            consola.mostrarMensaje("🏆 ¡Has hundido todos los barcos!");
        } else {
            consola.mostrarMensaje("💀 Fin del juego. Te has quedado sin intentos.");
        }
    }
}