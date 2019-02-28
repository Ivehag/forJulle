package Cars;

import Cars.AbstractCar;
import Cars.AbstractPositionable;

import java.awt.*;
import java.util.ArrayList;

public class Garage<T extends AbstractCar> extends AbstractPositionable {
    private int MAX_CARS = 20;
    private ArrayList<T> cars = new ArrayList<>(MAX_CARS);
    private double delta = 1.5;

    public Garage(int x, int y, Color color) {
        super(x, y, color);
    }

    /***
     * Loads cars
     * @param car
     */
    public void loadCar(T car) {
        boolean carCloseToTransporter = Math.abs(getX() - car.getX()) <= delta && Math.abs(getY() - car.getY()) <= delta;

        if (carCloseToTransporter && cars.size() <= MAX_CARS) {
            car.stopEngine();
            car.setY(getY());
            car.setX(getX());
            cars.add(car);
        }

    }

    public void unloadCarAtIndex(int index) {
        cars.remove(index);
    }

    public T getCarAtIndex(int index) {
        return cars.get(index);
    }


}