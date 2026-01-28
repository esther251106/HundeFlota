public class Juego {

    private Tablero tablero;
    private int intentos;
    private int maxIntentos = 10;

    public Juego() {
        tablero = new Tablero();
        intentos = 0;
    }

    public boolean realizarDisparo(int fila, int columna) {
        intentos++;
        return tablero.disparar(fila, columna);
    }

    public boolean juegoTerminado() {
        return tablero.todosLosBarcosHundidos() || intentos >= maxIntentos;
    }

    public boolean victoria() {
        return tablero.todosLosBarcosHundidos();
    }

    public Tablero obtenerTablero() {
        return tablero;
    }

    public int intentosRestantes() {
        return maxIntentos - intentos;
    }
}
