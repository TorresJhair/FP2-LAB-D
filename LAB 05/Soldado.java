class Soldado{
    private String nombre;
    private int vida;
    private int fila;
    private int columna;
    private String figura;    

    //Constructor
    public Soldado(String name, int life, int fil, int colum) {
        nombre = name;
        vida = life;
        fila = fil;
        columna = colum;
    }

    //Figuras en Tablero
    public static String cuadroVacio(){
        return "|||||\n" + 
               "|||||\n" + 
               "|||||";
    }
    public static String cuadroLleno(){
        return "#####\n" + 
               "#####\n" + 
               "#####";
    }  
    //Setters
    public void setNombre(String n){
        nombre = n;
    }
    public void setVida(int v){
        vida = v;
    }
    public void setFila(int f) {
        fila = f;
    }
    public void setColumna(char c) {
        columna = c;
    }

    //Getters
    public String getNombre(){
        return nombre;
    }
    public int getVida(){
        return vida;
    }
    public int getFila() {
        return fila;
    }
    public int getColumna() {
        return columna;
    }
    public void setFigura(String fig) {
        figura = fig;
    }
    public String getFigura() {
        return figura;
    }
    public String toString(){
        return "Nombre: " + nombre + "\t - Vida: " + vida;
    }        
}