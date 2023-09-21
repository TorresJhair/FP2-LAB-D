public class Ejercicio03_LAB03{
    public static void main(String [] args){
        Soldado [] ejerA = new Soldado [numRandom()];
        Soldado [] ejerB = new Soldado [numRandom()];
        llenarEjer(ejerA);
        llenarEjer(ejerB);
        System.out.println("Batallon A:");
        mostrarEjer(ejerA);
        System.out.println("Batallon B");
        mostrarEjer(ejerB);
        System.out.println();
        System.out.println(mostrarGanador(ejerA, ejerB));
    }
    public static int numRandom(){
        return (int)(Math.random() * 5 + 1);
    }
    public static void llenarEjer(Soldado [] ejercito){
        for(int i = 0; i < ejercito.length; i++){
            ejercito[i] = new Soldado("Soldado" + i + " ", 0);
        }
    }
    public static void mostrarEjer(Soldado [] ejercito){
        for(int i = 0; i < ejercito.length; i++){
            System.out.println(ejercito[i]);
        }
    }
    public static String mostrarGanador(Soldado[] ejerA, Soldado[] ejerB){
        System.out.println("Resultado final:");
        if(ejerA.length == ejerB.length){
            return "Empate";
        }
        System.out.print("Ganador: ");
        if(ejerA.length < ejerB.length){
            return "Ejército B";
        }
        return "Ejército A";
    }
}