import java.util.ArrayList;
import java.util.List;

public class ShipmentManager {

    private static ShipmentManager instance;

    private List<Envio> envios;

    private ShipmentManager() {
        envios = new ArrayList<>();
    }

    public static ShipmentManager getInstance() {
        if (instance == null) {
            instance = new ShipmentManager();
        }
        return instance;
    }

    public void agregarEnvio(Envio envio) {
        envios.add(envio);
    }

    public Envio buscarEnvio(int id) {

        for (Envio envio : envios) {

            if (envio.getId() == id) {
                return envio;
            }

        }

        return null;
    }

    public List<Envio> listarEnvios() {
        return envios;
    }

    public ShipmentIterator crearIterador() {
        return new ShipmentIteratorImpl(envios);
    }
}