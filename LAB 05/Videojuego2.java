import java.util.*;

public class Videojuego2{
    public static void main (String [] args){
        int tamañoEjer = 10;
        //Tablero de soldados
        Soldado [][] ejer = new Soldado[10][10];
        generarEjercito(ejer, tamañoEjer);
        printTablero(ejer);
    }
    public static void generarEjercito(Soldado [][] ejer, int tamaño){
        int nroSoldados = 0;
        while (nroSoldados < tamaño){
            //Fila entre 0 y 9 (pasará entre 1 y 10)
            int fila = (int)(Math.random() * 10);
            //Columna entre 0 y 9 (pasará entre A y J por ASCII)
            int colum = (int)(Math.random() * 10);
            int vida = (int)(Math.random() * 5 + 1);
            String nombre = "Soldado" + nroSoldados;

            if(ejer[fila][colum] == null){
                ejer[fila][colum] = new Soldado(nombre, vida, fila, colum);
                nroSoldados++;
            }
        }
    }

    public static void printTablero(Soldado [][] ejer){
        for(int i = 0; i < ejer.length; i++){
            //Cada casillero será de 5 x 3
            for(int j = 1; j <= 3; j++){
                if(j == 2){
                    System.out.print(i);
                }
                System.out.print("\t");
                for(int k = 0; k < ejer[i].length; k++){
                    if(ejer[i][k] == null){
                        System.out.print("!!!!!" + " ");
                    }
                    else{
                        System.out.print("@@@@@" + " ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}