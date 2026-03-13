public class CancelShipmentCommand implements Command {

    private Envio envio;

    public CancelShipmentCommand(Envio envio) {
        this.envio = envio;
    }

    @Override
    public void ejecutar() {
        envio.cambiarEstado(EstadoEnvio.cancelado);
    }
}
