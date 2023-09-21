import java.util.Scanner;

public class AhoracadoJuego {
    public static void main(String []args){
        String ahor1 =  " +---+ \n"+
                        " |   | \n" +
                        "     | \n" +
                        "     | \n" +
                        "     | \n" +
                        "     | \n" +
                        "========= ";
        String ahor2 =  " +---+ \n"+
                        " |   | \n"+
                        " O   | \n"+
                        "     | \n"+
                        "     | \n"+
                        "     | \n"+
                        "=========";
        String ahor3 =  " +---+ \n"+
                        " |   | \n"+
                        " O   | \n"+
                        " |   | \n"+
                        "     | \n"+
                        "     | \n"+
                        "=========";
        String ahor4 =  " +---+ \n"+
                        " |   | \n"+
                        " O   | \n"+
                        "/|   | \n"+
                        "     | \n"+
                        "     | \n"+
                        "=========";
        String ahor5 =  " +---+ \n"+
                        " |   | \n"+
                        " O   | \n"+
                        "/|\\  | \n"+
                        "     | \n"+
                        "     | \n"+
        "=========";
        String ahor6 =  " +---+ \n"+
                        " |   | \n"+
                        " O   | \n"+
                        "/|\\  | \n"+
                        "/    | \n"+
                        "     | \n"+
                        "=========";
        String ahor7 =  " +---+ \n"+
                        " |   | \n"+
                        " O   | \n"+
                        "/|\\  | \n"+
                        "/ \\  | \n"+
                        "     | \n"+
                        "=========";
        String [] figuras = {ahor1, ahor2, ahor3,ahor4,ahor5,ahor6,ahor7};
        int contador = 1;
        String letra;
        String [] palabras = {"programacion", "java", "identacion", "clases",
        "objetos", "desarrollador", "pruebas"};

        String palSecreta = getPalabraSecreta(palabras);
        System.out.println(figuras[0]);
        mostrarBlancos(palSecreta);
        System.out.println(palSecreta);
        System.out.println("\n");
        String [] arrayPalabraBlanco = arrayEnBlanco(palSecreta);
        while(contador <= 6){
            if(isArrayBlancoLleno(arrayPalabraBlanco)){
                break;
            }
            letra = ingreseLetra();
            if (letraEnPalabraSecreta(letra, palSecreta)){
                mostrarBlancosActualizados(letra, palSecreta, arrayPalabraBlanco);
            }
            else{
                System.out.println(figuras[contador]);
                contador = contador +1;
            }
        }
        //COMPLETAR PARA INDICAR SI GANÓ, PERDIÓ Y CUÁNTOS TURNOS NECESITÓ
        System.out.println("\n");
        imprimirResultados(contador);
    }
    public static String getPalabraSecreta(String [] lasPalabras){
        int ind;
        int indiceMayor = lasPalabras.length -1;
        int indiceMenor =0;
        ind = (int) ((Math.random() * (indiceMayor - indiceMenor + 1) + indiceMenor));
        return lasPalabras[ind];
    }
    public static void mostrarBlancos(String palabra){
        for(int i=0; i< palabra.length(); i++)
            System.out.print("_ " );
    }
    public static String ingreseLetra(){
        String laLetra;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese letra: ");
        laLetra = sc.next().toLowerCase();
        while((laLetra.length()!= 1) || 
              (laLetra.charAt(0) <= 96 || 
               laLetra.charAt(0) >= 123)){
            System.out.println("ERROR\nVerifique su elección\n");
            System.out.println("Ingrese letra: "); //COMPLETAR PARA VALIDAR CARACTERES PERMITIDOS
            laLetra = sc.next();
        }
        return laLetra;
    }
    public static boolean letraEnPalabraSecreta(String letra, String palSecreta ){
        for(int i = 0; i < palSecreta.length(); i++){
            String letraSecreta;
            letraSecreta = palSecreta.substring(i, i + 1);
            if(letra.equals(letraSecreta)){
                return true;
            }
        }
        return false;
    }
    public static void mostrarBlancosActualizados(String letra, String palSecreta, String [] arrayBlanco){
        System.out.println("PROCESANDO.....");
        String [] arraySecreto = separarArraySecreto(palSecreta);
        for(int i = 0; i < arraySecreto.length; i++){
            if(letra.equals(arraySecreto[i])){
                arrayBlanco[i] = letra;
            }
            System.out.print(arrayBlanco[i]);

        }
        System.out.println();
    }
    public static String [] separarArraySecreto(String palSecreta){
        String [] arraySecreto = new String [palSecreta.length()];
        for(int i = 0; i < palSecreta.length(); i++){
            arraySecreto[i] = palSecreta.substring(i, i + 1);
        }
        return arraySecreto;
    } 
    public static String [] arrayEnBlanco(String palSecreta){
        String [] arrayBlanco = separarArraySecreto(palSecreta);
        for(int i = 0; i < arrayBlanco.length; i++){
            arrayBlanco[i] = "_";
        }
        return arrayBlanco;
    }
    public static boolean isArrayBlancoLleno(String [] arrayBlanco){
        for(int i = 0; i < arrayBlanco.length; i++){
            if (arrayBlanco[i] == "_")
                return false;
        }
        return true;
    }
    public static void imprimirResultados(int contador){
        if(contador <= 6){
            System.out.println("Ganaste! en " + contador + " intentos");
        }
        else{
            System.out.println("Perdiste! en " + (contador - 1) + " turnos");
        }
    }
}