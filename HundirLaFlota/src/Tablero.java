public class Tablero {
    private char[][] casillas;
    private int tamano = 5;
    private int barcos = 3;

    public Tablero() {
        casillas = new char[tamano][tamano];
        inicializarTablero();
        colocarBarcosAleatoriamente();
    }

    private void inicializarTablero() {
        for (int fila = 0; fila < tamano; fila++) {
            for (int columna = 0; columna < tamano; columna++) {
                casillas[fila][columna] = '~'; // Agua
            }
        }
    }

    private void colocarBarcosAleatoriamente() {
        int colocados = 0;
        while (colocados < barcos) {
            int fila = (int) (Math.random() * tamano);
            int columna = (int) (Math.random() * tamano);

            if (casillas[fila][columna] == '~') {
                casillas[fila][columna] = 'B'; // Barco
                colocados++;
            }
        }
    }

    public boolean disparar(int fila, int columna) {
        if (casillas[fila][columna] == 'B') {
            casillas[fila][columna] = 'X'; // Tocado
            return true;
        } else if (casillas[fila][columna] == '~') {
            casillas[fila][columna] = 'O'; // Agua (disparo fallido)
            return false;
        } else {
            return false; // Ya se disparo aqui (X u O)
        }
    }

    public boolean todosHundidos() {
        for (int fila = 0; fila < tamano; fila++) {
            for (int columna = 0; columna < tamano; columna++) {
                if (casillas[fila][columna] == 'B') {
                    return false;
                }
            }
        }
        return true;
    }

    // Métodos accesores
    public char[][] obtenerCasillas() {
        return casillas;
    }

    public int obtenerTamano() {
        return tamano;
    }
}
