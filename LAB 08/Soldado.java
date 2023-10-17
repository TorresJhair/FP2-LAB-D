class Soldado{
    private String nombre;
    private int vida;
    private int fila; //Del 1 al 10
    private int columna; //De la A a  la J

    public Soldado(String nombre, int vida, int fila, int columna){
        this.nombre = nombre;
        this.vida = vida;
        this.fila = fila;
        this.columna = columna;
    }
    public Soldado(){
    }

    public String toString(){
        return "Nombre: " + nombre + "\n" + 
                "Vida: " + vida + "\n" + 
                "Fila : " + (fila + 1) + " Columa: " + (columna + 1);
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public int getFila() {
        return fila;
    }
    public void setFila(int fila) {
        this.fila = fila;
    }
    public int getColumna() {
        return columna;
    }
    public void setColumna(int columna) {
        this.columna = columna;
    }
}
