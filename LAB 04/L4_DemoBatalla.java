import java.util.Scanner;

public class L4_DemoBatalla {
    public static void main(String [] args){
        Nave [] misNaves = new Nave[10];
        Scanner sc = new Scanner(System.in);
        String nomb, col;
        int fil, punt;
        boolean est;
        for (int i = 0; i < misNaves.length; i++) {
            System.out.println("Nave " + (i + 1));
            System.out.print("Nombre: ");
            nomb = sc.next();
            System.out.println("Fila ");
            fil = sc.nextInt();
            System.out.print("Columna: ");
            col = sc.next();
            System.out.print("Estado: ");
            est = sc.nextBoolean();
            System.out.print("Puntos: ");
            punt = sc.nextInt();
            misNaves[i] = new Nave(nomb, fil, col, est, punt); 
            System.out.println("\nNaves creadas:");
            mostrarNaves(misNaves);
            mostrarPorNombre(misNaves);
            mostrarPorPuntos(misNaves);
            System.out.println("\nNave con mayor número de puntos: " + mostrarMayorPuntos(misNaves));
        }
    }
    //Método para mostrar todas las naves
    public static void mostrarNaves(Nave [] flota){
        for(int i = 0; i < flota.length; i++){
            System.out.println(flota[i]);
        }
    }
    //Método para mostrar todas las naves de un nombre que se pide por teclado
    public static void mostrarPorNombre(Nave [] flota){
        Scanner sc = new Scanner (System.in);
        System.out.println("Nombre a buscar:");
        String nombr = sc.next();
        for(int i = 0; i < flota.length; i++){
            if(flota[i].getNombre().equals(nombr)){
                System.out.println(flota[i]);
            }
        }
    }
    //Método para mostrar todas las naves con un número de puntos inferior o igual
    //al número de puntos que se pide por teclado
    public static void mostrarPorPuntos(Nave [] flota){
        Scanner sc = new Scanner(System.in);
        System.out.println("Cantidad de puntos:");
        int puntos = sc.nextInt();
        for(int i = 0; i < flota.length; i++){
            if(flota[i].getPuntos() <= puntos){
                System.out.println(flota[i]);
            }
        }
    }
    //Método que devuelve la Nave con mayor número de Puntos
    public static Nave mostrarMayorPuntos(Nave [] flota){
        int max = flota[0].getPuntos();
        for(int i = 0; i < flota.length; i++){
            max = Math.max(max, flota[i].getPuntos());
        }
        for(int i = 0; i < flota.length; i++){
            if(flota[i].getPuntos() == max){
                return flota[i];
            }
        }
        return flota[0];
    }
}
