package Cars;

import java.awt.*;
import java.util.ArrayList;

public class CarFerrie<T extends AbstractVehicle> extends AbstractTransporter {
    private Ramp ramp;
    private int MAX_CARS = 50;
    private ArrayList<T> cars = new ArrayList<>(MAX_CARS);
    private double delta = 2;

    private enum Ramp {UP, DOWN}

    public CarFerrie(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double x, double y) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, x, y);
    }

    /***
     * Unload the car of class T on top of the Stack
     */
    public void unloadCar() {
        ArrayList<T> temp = new ArrayList<>(cars.size());
        for (T c : cars) {
         temp.add(c);
        }
        cars.removeAll(temp);
    }

    /***
     * Get method
     * @param i
     * @return
     */
    public T getCarAtIndex(int i) {
        return cars.get(i);
    }

    public void loadCar(T car) {
        boolean carCloseToTransporter = Math.abs(getX() - car.getX()) <= delta && Math.abs(getY() - car.getY()) <= delta;

        if (carCloseToTransporter && getRampStatus() == AbstractTransporter.Ramp.DOWN && car.getClass() != CarFerrie.class) {
            car.stopEngine();
            car.setY(getY());
            car.setX(getX());
            cars.add(car);
        }

    }

    /***
     * Set method
     */
    public void setCarPositionEqualsToCarTransporter() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).setX(getX());
            cars.get(i).setY(getY());
        }

    }


}
