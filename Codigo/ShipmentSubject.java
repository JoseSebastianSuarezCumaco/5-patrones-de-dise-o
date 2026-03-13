import java.util.ArrayList;
import java.util.List;

public class ShipmentSubject {

    private List<Observer> observers;

    public ShipmentSubject() {
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Envio envio) {
        for (Observer observer : observers) {
            observer.update(envio);
        }
    }
}