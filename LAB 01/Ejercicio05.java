import java.util.*;

public class Ejercicio01 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        String [] armyA = createArmy(randomSize());
        String [] armyB = createArmy(randomSize());

        System.out.println("Ejército A");
        prntArmy(armyA);
        System.out.println("Ejército B");
        prntArmy(armyB);
        System.out.println(winner(armyA, armyB));
    }
    public static int randomSize(){
        return (int)(Math.random() * 4 + 1);
    }  
    public static String [] createArmy(int size){
        String [] solds =  new String [size];
        for(int i = 0; i < solds.length; i++){
            solds[i] = "Soldado" + i;
        }
        return solds;
    }
    public static void prntArmy(String [] solds){
        for(int i = 0; i < solds.length; i++){
            System.out.println(solds[i]);
        }
    }
    public static String winner(String [] army1, String [] army2){
        System.out.println("\nResultado");
        if(army1.length == army2.length){
            return "Empate";
        }
        if(army1.length > army2.length){
            return "Ganó Ejército A";
        }
        return "Ganó Ejército B";
    }
}
