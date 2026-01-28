import java.util.*;

public class ConsolaUI {
    private Scanner entrada = new Scanner(System.in);

    public void mostrarTablero(Tablero tablero) {
        System.out.println("\nTABLERO:");
        char[][] casillas = tablero.obtenerCasillas();

        System.out.print("  ");
        for (int i = 0; i < tablero.obtenerTamaño(); i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int fila = 0; fila < tablero.obtenerTamaño(); fila++) {
            System.out.print(fila + " ");
            for (int columna = 0; columna < tablero.obtenerTamaño(); columna++) {
                char celda = casillas[fila][columna];
                if (celda == 'B') {
                    System.out.print("~ "); // No mostrar los barcos
                } else {
                    System.out.print(celda + " ");
                }
            }
            System.out.println();
        }
    }

    public int pedirCoordenada(String mensaje, int limite) {
        int valor = -1;
        do {
            System.out.print(mensaje);
            while (!entrada.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido.");
                entrada.next();
            }
            valor = entrada.nextInt();
            if (valor < 0 || valor >= limite) {
                System.out.println("Coordenada fuera de rango. Intenta de nuevo.");
            }
        } while (valor < 0 || valor >= limite);
        return valor;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
