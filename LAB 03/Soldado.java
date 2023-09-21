class Soldado{
    String nombre;
    int vida;
    public Soldado(String name, int hp){
        setNombre(name);
        setVida(hp);
    }
    public void setNombre(String n){
        nombre = n;
    }
    public void setVida(int v){
        vida = v;
    }
    public String getNombre(){
        return nombre;
    }
    public int getVida(){
        return vida;
    }
    public String toString(){
        return "Nombre: " + nombre + "\t - Vida: " + vida;
    }
}