public class Envio {
private int id;
private String cliente;
private String direccion;
private EstadoEnvio estado;
private Repartidor repartidor;
private ShippingStrategy estrategia;

public Envio(int id, String cliente, String direccion, EstadoEnvio estado, Repartidor repartidor, ShippingStrategy estrategia) {
    this.id = id;
    this.cliente = cliente;
    this.direccion = direccion;
    this.estado = estado.creado;
    this.repartidor = repartidor;
    this.estrategia = estrategia;
}

public void asignarRepartidor(Repartidor repartidor) {
    this.repartidor = repartidor;
    this.estado = EstadoEnvio.asignado;

}
public void cambiarEstado(EstadoEnvio estado) {
    this.estado = estado;
}
public double calcularCosto() {
    if (estrategia == null) {
        return 0;
    }
    return estrategia.calcularCosto(this);
}
    public void setStrategy(ShippingStrategy s){
        this.estrategia = s;
    }

    public ShippingStrategy getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(ShippingStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }

    public EstadoEnvio getEstado() {
        return estado;
    }

    public void setEstado(EstadoEnvio estado) {
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}