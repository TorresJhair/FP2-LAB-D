import java.util.*;

public class Ejercicio02 {
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Soldado 1");
        String sol1 = sc.next();
        int hp1 = sc.nextInt();
        System.out.println("Soldado 2:");
        String sol2 = sc.next();
        int hp2 = sc.nextInt();
        System.out.println("Soldado 3:");
        String sol3 = sc.next();
        int hp3 = sc.nextInt();
        System.out.println("Soldado 4:");
        String sol4 = sc.next();
        int hp4 = sc.nextInt();
        System.out.println("Soldado 5:");
        String sol5 = sc.next();
        int hp5 = sc.nextInt();

        System.out.println("Ejército");
        showSold(sol1, hp1);
        showSold(sol2, hp2);
        showSold(sol3, hp3);
        showSold(sol4, hp4);
        showSold(sol5, hp5);
    }
   
    public static void showSold(String name, int hp){
        System.out.println("Nombre: " + name + " - Vida: " + hp);
    }
}
