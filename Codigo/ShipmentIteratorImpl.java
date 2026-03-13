import java.util.List;

public class ShipmentIteratorImpl implements ShipmentIterator {

    private List<Envio> envios;
    private int posicion = 0;

    public ShipmentIteratorImpl(List<Envio> envios) {
        this.envios = envios;
    }

    @Override
    public boolean hasNext() {
        return posicion < envios.size();
    }

    @Override
    public Envio next() {
        if (!hasNext()) {
            return null;
        }

        Envio envio = envios.get(posicion);
        posicion++;
        return envio;
    }
}