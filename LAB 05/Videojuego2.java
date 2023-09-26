public class Videojuego2{
    public static void main (String [] args){
        int tamañoEjer = (int)(Math.random() * 10 + 1);
        //Tablero de soldados
        Soldado [][] tablero= new Soldado[10][10];
        //Array auxiliar para almacenar los soldados creados
        Soldado [] ejerAux = new Soldado[tamañoEjer];
        
        generarEjercito(tablero, ejerAux, tamañoEjer);
        printTablero(tablero);
        System.out.println("Total del soldados: " + tamañoEjer);
        System.out.println("Máxima vida del ejército:\n" + maxVidaSoldado(ejerAux) + "\n");
        System.out.println("Promedio de vida:\n" + promedioVida(ejerAux) + "\n");
        System.out.println("Total de vida del ejército:\n" + totalVida(ejerAux) + "\n");
        System.out.println("Ejército original:");
        printEjercito(ejerAux);
        System.out.println("Ranking de vida:");
        printEjercito(rankingPorVidaSelection(ejerAux));
    }

    //Métodos de generación y gráfica
    public static void generarEjercito(Soldado [][] tablero, Soldado [] ejerAux, int tamaño){
        int nroSoldados = 0;
        while (nroSoldados < tamaño){
            //Fila entre 0 y 9 (pasará entre 1 y 10)
            int fila = (int)(Math.random() * 10);
            //Columna entre 0 y 9 (pasará entre A y J por ASCII)
            int colum = (int)(Math.random() * 10);
            int vida = (int)(Math.random() * 5 + 1);
            String nombre = "Soldado" + nroSoldados;

            if(tablero[fila][colum] == null){
                tablero[fila][colum] = new Soldado(nombre, vida, fila, colum);
                ejerAux[nroSoldados] = tablero[fila][colum];
                nroSoldados++;
            }
        }
    }
    public static void printTablero(Soldado [][] tablero){
        //Imprimir índices letra de columna
        System.out.print("\t");
        for(int i = 65; i <= 74; i++){
            System.out.print((char)(i) + "     ");
        }
        System.out.println();
        //Imprimir filas
        for(int i = 0; i < tablero.length; i++){
            //Cada casillero será de 5 x 3
            for(int j = 1; j <= 3; j++){
                if(j == 2){
                    System.out.print((i + 1));
                }
                System.out.print("\t");
                for(int k = 0; k < tablero[i].length; k++){
                    if(tablero[i][k] == null){
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

    //Métodos de rodenamiento y muestra
    public static Soldado maxVidaSoldado(Soldado [] ejerAux){
        Soldado [] ordenado = ordenadarPorVidaBubble(ejerAux);
        return ordenado[ordenado.length - 1];
    }
    public static Soldado [] ordenadarPorVidaBubble(Soldado [] ejerAux){
        Soldado aux;
        for(int i = 0; i < ejerAux.length; i++){
            for(int j = 0; j < ejerAux.length - i - 1; j++){
                if(ejerAux[j].getVida() > ejerAux [j + 1].getVida()){
                    aux = ejerAux[j + 1];
                    ejerAux[j + 1] = ejerAux[j];
                    ejerAux[j] = aux;
                }   
            }
        }
        return ejerAux;
    }
    public static Soldado [] rankingPorVidaSelection(Soldado [] ejerAux){
        int maxVidaIndex = 0;
        Soldado aux;
        for(int j = 0; j < ejerAux.length; j++){
            //Busca el mayor
            for(int i = j; i < ejerAux.length; i++){
                if(ejerAux[i].getVida() > ejerAux[maxVidaIndex].getVida()){
                    maxVidaIndex = i;
                }
            }
            //Reemplazar por el 1er
            aux = ejerAux[j];
            ejerAux[j] = ejerAux[maxVidaIndex];
            ejerAux[maxVidaIndex] = aux;
        }
        return ejerAux;
    }  
    public static double promedioVida(Soldado [] ejerAux){
        int suma = 0;
        for(int i = 0; i < ejerAux.length; i++){
            suma += ejerAux[i].getVida();
        }
        return (double) suma / ejerAux.length * 1.0;
    }
    public static int totalVida(Soldado [] ejerAux){
        int suma = 0;
        for(int i = 0; i < ejerAux.length; i++){
            suma += ejerAux[i].getVida();
        }
        return suma;    
    }
    public static void printEjercito(Soldado [] ejerAux){
        for(int i = 0; i < ejerAux.length; i++){
            System.out.println(ejerAux[i]);
        }
    }
}