import java.util.*;

public class Ejercicio04 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        String [][] soldiers = new String [5][2];
        System.out.println("Ingrese nombres:");
        enterData(soldiers);
        System.out.println("Ejército");
        prntSolds(soldiers);
    }
    public static void enterData(String [][] sold){
        Scanner sc = new Scanner (System.in);

        for (int i = 0; i < sold.length; i++){
            System.out.println("Soldado " + (i + 1));
            System.out.println("Nombre:");
            sold[i][0] = sc.next();
            System.out.println("Vida:");
            sold[i][1] = sc.next();
        }
    }
    public static void prntSolds(String [][] solds){
        System.out.println("\tNombre \t\tVida");
        for(int i = 0; i < solds.length; i++){
            System.out.println((i + 1) + ")\t" + solds[i][0] + "\t\t" + solds[i][1]);
        }
    }
}
