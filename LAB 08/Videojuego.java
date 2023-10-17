import java.util.*;

public class Videojuego {
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        String continuar = "Y";
        do{
            List<ArrayList<Soldado>> tablero = new ArrayList<ArrayList<Soldado>>();
            generarTablero(tablero);
            Map <Integer, Soldado> ejercitoA = new HashMap<>();
            Map <Integer, Soldado> ejercitoB = new HashMap<>();
            llenarEjercito(ejercitoA, tablero);
            llenarEjercito(ejercitoB, tablero);
            prntTablero(tablero, ejercitoA, ejercitoB);

            System.out.println("\n===Estadisticas: EjercitoA===");
            prntStats(ejercitoA);
            System.out.println("\n===Estadisticas: EjercitoB===");
            prntStats(ejercitoB);
            winner(ejercitoA, ejercitoB);
            
            System.out.println("Continuar? (Y/N)");
            continuar = sc.next().toUpperCase();
        } while(continuar.equals("Y"));
    }

    //Metodos estadísticos
    public static void winner(Map <Integer, Soldado> ejerA, Map <Integer, Soldado> ejerB){
        System.out.println("Resultado Final:");
        if(ejerA.size() == ejerB.size()){
            System.out.println("EMPATE");
        }
        else{
            if(ejerA.size() < ejerB.size()){
                System.out.println("GANO TEAM B");
            }
            if(ejerA.size() > ejerB.size()){
                System.out.println("GANO TEAM A");
            }
        }
    }
    public static void prntStats(Map <Integer, Soldado> ejer){
        Map <Integer, Soldado> ejerOrdenadoVida = sortByHp(ejer);
        System.out.println("\nSoldado TOP vida:");
        maxVida(ejerOrdenadoVida);
        System.out.println("\nPromedio vida:");
        promedVida(ejerOrdenadoVida);
        System.out.println("\nOrden de creacion:");
        prntEjer(ejer);
        System.out.println("\nRanking de poder:");
        prntEjer(ejerOrdenadoVida);
    }
    public static Map <Integer, Soldado> sortByHp(Map <Integer, Soldado> ejer){
        Map <Integer, Soldado> ejerAux = new HashMap<Integer, Soldado>(ejer);
        ejerAux.putAll(ejer);
        Soldado aux;
        for(int i = 0; i < ejerAux.size(); i++){
            for(int j = 0; j < ejerAux.size() - i - 1; j++){
                if(ejerAux.get(j).getVida() < ejerAux.get(j + 1).getVida()){
                    aux = ejerAux.get(j + 1);
                    ejerAux.replace(j + 1, ejerAux.get(j));
                    ejerAux.replace(j , aux);
                }
            } 
        }   
        return ejerAux;
    }
    public static void maxVida(Map <Integer, Soldado> ejer){
        System.out.println(ejer.get(0));
    }
    public static void promedVida(Map <Integer, Soldado> ejer){
        double sumaHp = 0;
        for(int i = 0; i < ejer.size(); i++){
            sumaHp += ejer.get(i).getVida();
        }
        System.out.print(sumaHp / (ejer.size()) * 1.0);
    }
    public static void prntEjer(Map <Integer, Soldado> ejer){
        for(int i = 0; i < ejer.size(); i++){
            System.out.println("\nPosicion " + (i + 1) + ":");
            System.out.println(ejer.get(i));
        }
    }

    //Metodo de graficacion y auxiliares
    public static void prntTablero(List <ArrayList<Soldado>> tablero,
                                    Map <Integer, Soldado>ejerA, 
                                    Map <Integer, Soldado> ejerB){
        System.out.print("\t ");
        //Imprimire las columnas
        for(int i = 65; i <= 74; i++){
            System.out.print((char)(i) + "     ");
        }
        System.out.println();
        //Filas
        for(int i = 0; i < tablero.size(); i++){
            //Cada posicion sera 3x5
            for(int k = 1; k <= 3; k++){
                //Imprime el indice de la fila
                if(k == 2){
                    System.out.print(i + 1);
                }
                System.out.print("\t");
                //Columnas
                for(int j = 0; j < tablero.get(i).size(); j++){
                    //Verifica si hay ficha en la posicion
                    if(tablero.get(i).get(j) != null){
                        //Verifica si pertenece al ejercitoA
                        if(isOnTeam(ejerA, i, j)){
                            //Imprimira su vida en el caracter central
                            if(k == 2)
                                System.out.print("@@" + tablero.get(i).get(j).getVida() + "@@" + "   ");
                            else 
                                System.out.print("@@@@@" + "   ");
                        }
                        //Verifica si pertenece al ejercitoB
                        else if(isOnTeam(ejerB, i, j)){
                            if(k == 2)
                                System.out.print("$$" + tablero.get(i).get(j).getVida() + "$$" + "   ");
                            else 
                                System.out.print("$$$$$" + "   ");
                       }
                    }
                    //Si no hay ficha
                    else{
                        System.out.print("!!!!!" + "   ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    public static boolean isOnTeam(Map <Integer, Soldado> ejer, int filaSoldado, int columnaSoldado){
        for(int i = 0; i < ejer.size(); i++){
            if(ejer.get(i).getFila() == filaSoldado &&
                ejer.get(i).getColumna() == columnaSoldado){
                    return true; 
                }
        }
        return false;
    }

    //Metodos de geracion
    public static void generarTablero(List<ArrayList<Soldado>> tablero){
        for(int i = 0; i < 8; i++){
            tablero.add(new ArrayList<Soldado>(8));
            for(int j = 0; j < 8; j++){
                tablero.get(i).add(null);
            }
        }
    }

    public static void llenarEjercito(Map <Integer, Soldado> ejer, 
                                      List<ArrayList<Soldado>> tablero){
        int size = (int)(Math.random() * 10 + 1);
        //Mientras el ultima elemento sea vacio
        int index = 0;
        while(index < size){
            int fila = (int)(Math.random() * 8);
            int columna = (int)(Math.random() * 8);
            int vida = (int)(Math.random() * 5 + 1);
            //Verifica si el espacio ya ha sido ocupado
            if(isEmptySpace(fila, columna, tablero)){
                Soldado sold = new Soldado();
                sold.setColumna(columna);
                sold.setFila(fila);
                sold.setVida(vida);
                sold.setNombre("Soldado" + fila + "x" + columna);

                ejer.put(index, sold);
                tablero.get(fila).set(columna, sold);
                index++;
            }
        }
    }
    public static boolean isEmptySpace(int fila, int columna, 
                                        List<ArrayList<Soldado>> tablero){
        return tablero.get(fila).get(columna) == null;
    }
}
