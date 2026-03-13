public class CreateShipmentCommand implements Command {

    private ShipmentManager manager;
    private Envio envio;

    public CreateShipmentCommand(ShipmentManager manager, Envio envio) {
        this.manager = manager;
        this.envio = envio;
    }

    @Override
    public void ejecutar() {
        manager.agregarEnvio(envio);
    }
}