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
        }
            System.out.println("\nNaves creadas:");
            mostrarNaves(misNaves);
            mostrarPorNombre(misNaves);
            mostrarPorPuntos(misNaves);
            System.out.println("\nNave con mayor número de puntos: " + mostrarMayorPuntos(misNaves));

            //leer un nombre
            //mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en caso contrario
            System.out.println("Nombre a buscar:");
            String nombre = sc.next();
            int pos = busquedaLinealNombre(misNaves,nombre);
            printLinealNombre(misNaves, pos);
            
            //Burbuja
            ordenarPorPuntosBurbuja(misNaves);
            mostrarNaves(misNaves);
            ordenarPorNombreBurbuja(misNaves);
            mostrarNaves(misNaves);

            //mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en caso contrario
            pos = busquedaBinariaNombre(misNaves,nombre);
            printBinariaNombre(misNaves, pos);

            //Puntos
            ordenarPorPuntosSeleccion(misNaves);
            mostrarNaves(misNaves);
            ordenarPorPuntosInsercion(misNaves);
            mostrarNaves(misNaves);

            //Nombres
            ordenarPorNombreSeleccion(misNaves);
            mostrarNaves(misNaves);
            ordenarPorNombreInsercion(misNaves);
            mostrarNaves(misNaves);
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
    //Método para buscar la primera nave con un nombre que se pidió por teclado
    public static int busquedaLinealNombre(Nave[] flota, String s){
        for(int i = 0; i < flota.length; i++){
            if(flota[i].getNombre().equals(s)){
                return i;
            }
        }
        return -1;
    }
    public static void printLinealNombre(Nave [] flota, int pos){
        if(pos < 0){
            System.out.println("No encontrado");
        }
        else{
            System.out.println("Datos:");
            System.out.println(flota[pos]);
        }
    }
    //Método que ordena por número de puntos de menor a mayor
    public static void ordenarPorPuntosBurbuja(Nave[] flota){
        for(int i = 0; i < flota.length; i++){
            for(int j = 0; j < flota.length - i -1; j++){
                if (flota[j].getPuntos() >= flota[j + 1].getPuntos()){
                    Nave aux = flota[j];
                    flota[j] = flota[j + 1];
                    flota[j + 1] = aux;
                }
            }
        }
    }
    public static void ordenarPorNombreBurbuja(Nave [] flota){
        for(int i = 0; i < flota.length; i++){
            for(int j = 0; j < flota.length - i - 1; j++){
                if(flota[j].getNombre().charAt(0) > 
                   flota[j + 1].getNombre().charAt(0)){
                    Nave aux = flota[j];
                    flota[j] = flota[j + 1];
                    flota[j + 1] = aux;
                   }
            }
        }
    }
    public static int busquedaBinariaNombre(Nave [] flota, String nombre){
        int bajo = 0, alto = flota.length -1;
        int medio;
        do{
            medio = (int)((bajo + alto) / 2);
            if(flota[medio].getNombre().equals(nombre)){
                return medio;
            }
            else{
                if(nombre.charAt(0) < flota[medio].getNombre().charAt(0)){
                    alto = medio - 1;
                }
                else{
                    bajo = medio + 1;
                }
            }
        }while(bajo <= alto);
        return -1;
    }
    public static void printBinariaNombre(Nave [] flota, int pos){
        if (pos < 0){
            System.out.println("No encontrado");
        }
        else{
            System.out.println("Datos:");
            System.out.println(flota[pos]);
        }
    }
    public static void ordenarPorPuntosSeleccion(Nave [] flota){
        int minIndex = 0;
        Nave aux;
        for(int j = 0; j < flota.length; j++){
            //Menor indice
            for(int i = j; i < flota.length; i++){
                if (flota[i].getPuntos() < flota[minIndex].getPuntos()){
                    minIndex = i;
                }
            }
            //Intercambio
            aux = flota[j];
            flota[j] = flota[minIndex];
            flota[minIndex] = aux;
        }
    }
    public static void ordenarPorNombreSeleccion(Nave [] flota){
        int minIndex = 0;
        Nave aux;
        for(int j = 0; j < flota.length; j++){
            //Min indice
            for(int i = j; i < flota.length; i++){
                if (flota[i].getNombre().charAt(0) < 
                    flota[minIndex].getNombre().charAt(0)){
                    minIndex = i;
                }
            }
            //Intercambio
            aux = flota[j];
            flota[j] = flota[minIndex];
            flota[minIndex] = aux;
        }
    }

}
