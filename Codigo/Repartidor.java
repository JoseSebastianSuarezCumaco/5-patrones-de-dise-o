public class Repartidor {
    private String nombre;
    private int id;

    public Repartidor(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
}

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

   public String toString() { return "Repartidor{id =" + id + ", nombre ='" + nombre + "'}";
}

}
