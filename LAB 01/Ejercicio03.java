import java.util.*;

public class Ejercicio03 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        String [] names = new String [5];
        System.out.println("Ingrese nombres:");
        toName(names);
        System.out.println("Ejército");
        prntNanmes(names);
    }
    public static void toName(String [] names){
        Scanner sc = new Scanner (System.in);

        for (int i = 0; i < names.length; i++){
            names[i] = sc.next();
        }
    }
    public static void prntNanmes(String [] names){
        for(int i = 0; i < names.length; i++){
            System.out.println((i + 1) + ")" + names[i]);
        }
    }
}