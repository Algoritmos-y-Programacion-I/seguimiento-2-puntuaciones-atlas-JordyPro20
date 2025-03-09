// Análisis:
// Descripción del programa: Este programa permite registrar las puntuaciones obtenidas por varios jugadores en un torneo de múltiples rondas, calculando el total y el promedio de cada jugador, así como identificando al ganador con mayor puntaje.
//
// Entradas:
// - Cantidad de jugadores (máx. 10)
// - Cantidad de rondas (máx. 5)
// - Puntajes de cada jugador en cada ronda (0 a 100)
//
// Salidas:
// - Puntaje total por jugador
// - Promedio por jugador
// - Jugador con mayor puntaje
//
// Ejemplo:
//------->>>>>>RESULTADOS DEL TORNEO<<<<<<------

//>> ElJugador1 - Tiene un Puntaje Total De: 330/ Su Promedio es: 82.5
//>> ElJugador2 - Tiene un Puntaje Total De: 250/ Su Promedio es: 62.5
//>> ElJugador3 - Tiene un Puntaje Total De: 350/ Su Promedio es: 87.5
//------------(El Ganador de Torneo)-----------

//Con la puntuación más alta es el: Jugador3

package ui; // No olvidar especificar el paquete / carpeta de nuestro programa
import java.util.Scanner; // Para poder usar Scanner, debemos importarlo

public class AtlasPuntuaciones {
    private Scanner escaner;

    public AtlasPuntuaciones() {
        escaner = new Scanner(System.in);
    }

//  Solicita datos, calcula resultados y los muestra.
    public void run() {
        System.out.println("");
        System.out.println("<----Bienvenido a la Puntuación Atlas de ICESI----->");
        int cantidadJugadores = cantidadJugadores();
        int cantidadRondas = cantidadRondas();
        String[] jugadores = numJugador(cantidadJugadores);
        int[] puntajes = numPuntaje(cantidadJugadores, cantidadRondas, jugadores);
        mostrarResultados(jugadores, puntajes, cantidadRondas);
    }
    
    public static void main(String[] args) {
        AtlasPuntuaciones mainApp = new AtlasPuntuaciones();
        mainApp.run();
    }

// Solicita al usuario la cantidad de jugadores,estos no pueden pasar de 10
    public int cantidadJugadores() {
        System.out.println("<<<Para comenzar cuál es la cantidad de jugadores>>>");
		System.out.println("--------------(Maximo 10 jugadores)----------------");
        int cantidad = escaner.nextInt();
        while (cantidad < 1 || cantidad > 10) {
            System.out.println(">El numero de jugadores es invalido, Vueleve a escribirlo: ");
            cantidad = escaner.nextInt();
        }
        return cantidad;
    }

// Le pide al usuario la cantidad de rondas dell torneo y Comprueba que esté entre 1 y 5.
    public int cantidadRondas() {
        System.out.println("<<<<<<<<<Cauntas rondas se van a hacer>>>>>>>>>>");
		System.out.println("---------------(Maximo 5 rondas)----------------");
        int rondas = escaner.nextInt();
        while (rondas < 1 || rondas > 5) {
            System.out.println(">El numero de rondas es invalido, Vueleve a escribirlo: ");
            rondas = escaner.nextInt();
        }
        return rondas;
    }

// Crea un arreglo de nombres de jugadores con el formato "Jugador1"
    public String[] numJugador(int cantidad) {
        String[] jugador = new String[cantidad];
        for (int x = 0; x < cantidad; x++) {
            jugador[x] = "Jugador" + (x + 1);
        }
        return jugador;
    }

// Pide los puntajes de cada jugador en cada ronda, despues Suma el total de puntos por jugador.
    public int[] numPuntaje(int cantidadJugadores, int cantidadRondas, String[] jugador) {
		System.out.println("------------AHORA VAMOS A CALCULAR LOS PUNTOS DE CADA JUGADOR---------" );
		System.out.println("--------------.(Mínimo de puntos 0, Máximo de puntos 100)-------------");
        int[] puntajes = new int[cantidadJugadores];
        for (int x = 0; x < cantidadJugadores; x++) {
            int totalPuntaje = 0;
            for (int i = 0; i < cantidadRondas; i++) {
                System.out.println(">>"+ jugador[x] + " en la ronda " + (i + 1) + ":");
                
                int puntaje = escaner.nextInt();
                while (puntaje < 0 || puntaje > 100) {
                    System.out.println(">El numero es invalido (Vueleve a escribirlo)");
                    puntaje = escaner.nextInt();
                }
                totalPuntaje += puntaje;
            }
            puntajes[x] = totalPuntaje;
        }
        return puntajes;
    }

 // Muestra el puntaje total y promedio de cada jugador, e identifica al jugador con mayor puntaje.
    public void mostrarResultados(String[] jugadores, int[] puntajes, int cantidadRondas) {
        System.out.println("------->>>>>>RESULTADOS DEL TORNEO<<<<<<------");
        System.out.println("");
        int mayorPuntaje = -1;
        String jugadorConMayorPuntaje = "";

        for (int i = 0; i < jugadores.length; i++) {
            double promedio = (double) puntajes[i] / cantidadRondas;
            System.out.println(">> El"+jugadores[i]+" - Tiene un Puntaje Total De: "+puntajes[i]+" , Su Promedio es: " + promedio);

            if (puntajes[i] > mayorPuntaje) {
                mayorPuntaje = puntajes[i];
                jugadorConMayorPuntaje = jugadores[i];
            }
        }
        System.out.println("------------(El Ganador de Torneo)-----------");
        System.out.println("");
        System.out.println("Con la puntuación más alta es el: " + jugadorConMayorPuntaje);
        System.out.println("");
    }
}