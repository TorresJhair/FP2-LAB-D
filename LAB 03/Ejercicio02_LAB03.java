import java.util.*;

public class Ejercicio02_LAB03{
    public static void main (String [] args){
        Soldado [] ejercito = new Soldado[5];
        ingresarSoldados(ejercito);
        for(int i = 0; i < ejercito.length; i++){
            System.out.println(ejercito[i]);
        }
        mostrarEjercito(ejercito);
    }
    public static void ingresarSoldados(Soldado [] ejercito){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < ejercito.length; i++){
            System.out.println("Soldado " + (i + 1));
            System.out.println("Nombre:");
            String name = sc.next();
            System.out.println("Vida:");
            int vida = sc.nextInt();
            ejercito[i] = new Soldado(name, vida);
        }
    }
    public static void mostrarEjercito(Soldado [] ejercito){
        System.out.println("Ejército:");
        for(int i = 0; i < ejercito.length; i++){
            System.out.println(ejercito[i]);
        }
    }
}