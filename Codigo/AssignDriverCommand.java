public class AssignDriverCommand implements Command {

    private Envio envio;
    private Repartidor repartidor;

    public AssignDriverCommand(Envio envio, Repartidor repartidor) {
        this.envio = envio;
        this.repartidor = repartidor;
    }

    @Override
    public void ejecutar() {
        envio.asignarRepartidor(repartidor);
    }
}