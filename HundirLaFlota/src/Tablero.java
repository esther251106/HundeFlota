public class Tablero {

    private char[][] tablero;
    private int tamaño = 5;
    private int numeroBarcos = 3;

    public Tablero() {
        tablero = new char[tamaño][tamaño];
        inicializarTablero();
        colocarBarcosAleatorios();
    }

    private void inicializarTablero() {
        for (int fila = 0; fila < tamaño; fila++) {
            for (int columna = 0; columna < tamaño; columna++) {
                tablero[fila][columna] = '~'; // Agua
            }
        }
    }

    private void colocarBarcosAleatorios() {
        int barcosColocados = 0;

        while (barcosColocados < numeroBarcos) {
            int fila = (int) (Math.random() * tamaño);
            int columna = (int) (Math.random() * tamaño);

            if (tablero[fila][columna] == '~') {
                tablero[fila][columna] = 'B'; // Barco
                barcosColocados++;
            }
        }
    }

    public boolean disparar(int fila, int columna) {
        if (tablero[fila][columna] == 'B') {
            tablero[fila][columna] = 'X'; // Tocado
            return true;
        } else if (tablero[fila][columna] == '~') {
            tablero[fila][columna] = 'O'; // Agua
            return false;
        }
        return false; // Ya disparado
    }

    public boolean todosLosBarcosHundidos() {
        for (int fila = 0; fila < tamaño; fila++) {
            for (int columna = 0; columna < tamaño; columna++) {
                if (tablero[fila][columna] == 'B') {
                    return false;
                }
            }
        }
        return true;
    }

    public char[][] obtenerTablero() {
        return tablero;
    }

    public int obtenerTamaño() {
        return tamaño;
    }
}