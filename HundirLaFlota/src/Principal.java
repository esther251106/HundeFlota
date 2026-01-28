public class Principal {
    public static void main(String[] args) {
        Juego juego = new Juego();
        ConsolaUI consola = new ConsolaUI();

        consola.mostrarMensaje("🎯 ¡Bienvenido al juego Hundir la Flota!");

        while (!juego.juegoTerminado()) {
            consola.mostrarTablero(juego.obtenerTablero());

            int fila = consola.pedirCoordenada("Introduce la fila: ", juego.obtenerTablero().obtenerTamaño());
            int columna = consola.pedirCoordenada("Introduce la columna: ", juego.obtenerTablero().obtenerTamaño());

            boolean acierto = juego.realizarDisparo(fila, columna);

            if (acierto) {
                consola.mostrarMensaje("💥 ¡Tocado!");
            } else {
                consola.mostrarMensaje("🌊 Agua...");
            }

            consola.mostrarMensaje("Intentos restantes: " + juego.obtenerIntentosRestantes());
        }

        if (juego.esVictoria()) {
            consola.mostrarMensaje("🏆 ¡Has hundido todos los barcos!");
        } else {
            consola.mostrarMensaje("💀 Fin del juego. Te has quedado sin intentos.");
        }
    }
}