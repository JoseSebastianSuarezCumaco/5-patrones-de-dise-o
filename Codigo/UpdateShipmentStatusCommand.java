public class UpdateShipmentStatusCommand implements Command {

    private Envio envio;
    private EstadoEnvio estado;

    public UpdateShipmentStatusCommand(Envio envio, EstadoEnvio estado) {
        this.envio = envio;
        this.estado = estado;
    }

    @Override
    public void ejecutar() {
        envio.cambiarEstado(estado);
    }
}
