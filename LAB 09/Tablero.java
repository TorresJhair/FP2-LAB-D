class Tablero {
    private int fila;
    private int columna;
    private Soldado [][] tablero;

    public Tablero(){
        this.fila = 8;
        this.columna = 8;
        this.tablero = new Soldado [fila][columna];
    }

    //Getters y setters
    public int getFila(){
        return fila;
    }
    public void setFila(int fila){
        this.fila = fila;
    }
    public int getColumna(){
        return columna;
    }
    public void setColumna(int columna){
        this.columna = columna;
    }
    public Soldado[][] getTablero() {
        return tablero;
    }
    public void setTablero(Soldado[][] tablero) {
        this.tablero = tablero;
    }
    

    //Metodos de validacion 
    public boolean isEmptySquare(int fila, int columna){
        return this.tablero[fila][columna] == null;
    }

    //Metodos de graficacion
    public void printTablero(){
        prntColumnas();
        //Filas
        for(int i = 0; i < tablero.length; i++){
            //Cada cuadro sera de 3x5
            for(int k = 1; k <= 3; k++){
                //Imprime el indice de la fila
                if(k == 2){
                    System.out.print(i + 1);
                }
                System.out.print("\t");
                for(int j = 0; j < tablero[i].length; j++){
                    String espacio = "\t";
                    if(tablero[i][j] == null){
                        System.out.print("!!!!!" );
                    }
                    else{
                        int vidaActual = tablero[i][j].getVidaActual();
                        if(tablero[i][j].getEquipo().equals("A")){
                            if(k == 2)
                                System.out.print("@@" + vidaActual + "@@" );
                            else
                                System.out.print("@@@@@" );
                        }
                        if(tablero[i][j].getEquipo().equals("B")){
                            if(k == 2)
                                System.out.print("==" + vidaActual + "==" );
                            else
                                System.out.print("=====" );
                        }
                    }
                    //Imrpime espacio entre columnas
                    System.out.print(espacio);
                }
                System.out.println();
            }
            System.out.println("\t");
        }
    }
    public static void prntColumnas(){
        for(int i = 65; i <= 72; i++){
            System.out.print("\t  ");
            System.out.print((char)(i));
        }
        System.out.println();
    }
}
