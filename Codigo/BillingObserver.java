public class BillingObserver implements Observer {

    @Override
    public void update(Envio envio) {
        System.out.println("Facturación notificada: estado del envío actualizado");
    }
}