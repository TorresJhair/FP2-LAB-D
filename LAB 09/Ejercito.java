import java.util.*;

class Ejercito {
    private int tamano;
    private List <Soldado> ejercito;

    //Constructores
    public Ejercito(Tablero tab, String equipo){
        this.tamano = (int)(Math.random() * 10 + 1);
        this.ejercito = new ArrayList<Soldado>(tamano);
        //Crea el ArrayList
        for(int i = 0; i < tamano; i++){
            ejercito.add(null);
        }
        //Llena todos los espacios con un objeto de la clase Soldado
        //No acaba hasta que se lene el ultimo espacio
        int index = 0;
        while(ejercito.get(tamano - 1) == null){
            int fila = (int)(Math.random() * 8);
            int columna = (int)(Math.random() * 8);
            if(tab.isEmptySquare(fila, columna)){
                Soldado sold = new Soldado(equipo);
                sold.setFila(fila);
                sold.setColumna(columna);
                sold.setEquipo(equipo);
                sold.setNombre("Soldado" + fila + "x" + columna);
                //Añade al ejercito y al tablero
                ejercito.set(index, sold);
                tab.getTablero()[fila][columna] = sold;
                index++;
            }
        }
    }

    //Getters y setters
    public List <Soldado> getEjercito(){
        return ejercito;
    }

    //Metodos de clase
    //Estadisticos
    public void prntStats(){
        System.out.println("EJERCITO " + ejercito.get(0).getEquipo());
        List<Soldado> ejerOrdenado = sortByHp(this.getEjercito());
        maxHp(ejerOrdenado);
        promedHp(ejerOrdenado);
        System.out.println("Ejercito original");
        prntEjercito(this.getEjercito());
        System.out.println();
        System.out.println("RANKING PODER");
        prntEjercito(ejerOrdenado);
        System.out.println();
    }
    public static void prntEjercito(List <Soldado> ejercito){
        for(int i = 0; i < ejercito.size(); i++){
            System.out.println("Posicion " + (i + 1));
            System.out.println(ejercito.get(i));
            System.out.println();
        }
    }
    public static void maxHp(List<Soldado> ejer){
        System.out.println("SOLDADO MAX HP");
        System.out.println(ejer.get(0));
        System.out.println();
    }
    public static void promedHp(List <Soldado> ejer){
        System.out.println("PROMEDIO DE HP");
        double sumaHp = 0;
        for(int i = 0; i < ejer.size(); i++){
            sumaHp += ejer.get(i).getVidaActual();
        }
        System.out.println(sumaHp / ejer.size());
        System.out.println();
    }

    public static List<Soldado> sortByHp(List <Soldado> ejer){
        List <Soldado> ejerOrdenado = clone(ejer);
        for(int i = 0; i < ejerOrdenado.size(); i++){
            for(int j = 0; j < ejerOrdenado.size() - i - 1; j++){
                if(ejerOrdenado.get(j).getVidaActual() < 
                   ejerOrdenado.get(j + 1).getVidaActual()){
                    Soldado aux = ejerOrdenado.get(j);
                    Soldado aux2 = ejerOrdenado.get(j + 1);
                    ejerOrdenado.set(j, aux2);
                    ejerOrdenado.set(j + 1, aux);
                }
            }
        }
        return ejerOrdenado;
    }
    public static List <Soldado> clone(List <Soldado> ejer){
        List<Soldado> clone = new ArrayList<>();
        for(int i = 0; i < ejer.size(); i++){
            clone.add(null);
            clone.set(i, ejer.get(i));     
        }       
        return clone;
    }
}
