class Soldado {
    private String nombre;
    private int nivelAtaque;
    private int nivelDefensa;
    private int nivelVida;
    private int vidaActual;
    private int velocidad;
    private String actitud;
        //Ofensiva, defensiva, fuga de acuerdo a si
        //ataca, defende o huye, respectivamente
    private boolean vive;
    private int fila;
    private int columna;
    private String equipo;

    public Soldado(String nombre, int nivelAtaque, int nivelDefensa, int nivelVida, 
                    int vidaActual, int velocidad, String actitud, boolean vive,
                    int fila, int columna) {
        this.nombre = nombre;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.nivelVida = nivelVida;
        this.vidaActual = vidaActual;
        this.velocidad = velocidad;
        this.actitud = actitud;
        this.vive = vive;
        this.fila = fila;
        this.columna = columna;
    }
    public Soldado(String nombre, int vida){
        this(nombre, 1, 1, vida, vida, 1, "Defensiva", true, 0, 0);
    }
    public Soldado(String equipo){
        this("Soldado", randomStat(), randomStat(), 0, 
        0, 0, "Defensiva", true, 0, 0);
        this.nivelVida = randomStat();
        this.vidaActual = this.nivelVida;
        //El valor de la fila y comlumna seran generados dentro del juego
    }
    public static int randomStat(){
        return (int)(Math.random() * 5 + 1);
    }
    public String toString (){
        return "Nombre: " + nombre + "\n" + 
                "Vida: " + vidaActual + "\n" + 
                "Fila : " + (fila + 1) + " Columa: " + (columna + 1);
    }
    
    //Setters y Getters
    public int getVidaActual() {
        return vidaActual;
    }
    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
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
    public String getEquipo() {
        return equipo;
    }
    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    //Metodos de clase


    //Metodos de instancia
    //Acciones activas
    public void atacar(){
        this.actitud = "Ofensiva";
        avanzar();
    }

    public void defender(){
        this.actitud = "Defensiva";
        this.velocidad = 0;
    }
    public void huir(){
        this.velocidad += 2;
    }

    //Movimientos
    public void avanzar(){
        this.velocidad++;
    }
    public void retroceder(){
        if(this.velocidad > 0){
            defender();
        }
        else if(this.velocidad == 0){
            this.velocidad--;
        }
    }
    
    //Acciones pasivas
    public void serAtacado(){
        this.vidaActual--;  
        morir();
    }
    public void morir(){
        if(this.vidaActual <= 0){
            this.vive = false;
        }
        else{
            this.vive = true;
        }
    }

    //Metodos adicionales
}
