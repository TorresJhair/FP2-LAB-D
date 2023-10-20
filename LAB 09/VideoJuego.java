import java.util.*;

public class VideoJuego {
    public static void main (String [] args){
        Tablero tablero = new Tablero();
        Ejercito ejercitoA = new Ejercito(tablero, "A");
        Ejercito ejercitoB = new Ejercito(tablero, "B");

        tablero.printTablero();
        ejercitoA.prntStats();
        ejercitoB.prntStats();
    }
}
