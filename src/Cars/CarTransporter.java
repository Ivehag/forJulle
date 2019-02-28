package Cars;

import java.awt.*;
import java.util.Stack;

public class CarTransporter<T extends AbstractCar> extends AbstractTransporter {

    private Stack<T> cars = new Stack<>();
    private double delta = 2;


    public CarTransporter(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double x, double y) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, x, y);

    }/***
     * Unload the car of class T on top of the Stack
     */
    public void unloadCar() {
        cars.pop();
    }
    /***
     * Get method
     * @param i
     * @return
     */

    public T getCarAtIndex(int i) {
        return cars.elementAt(i);
    }

    public void loadCar(T car) {
        boolean carCloseToTransporter = Math.abs(getX() - car.getX()) <= delta && Math.abs(getY() - car.getY()) <= delta;

        if (carCloseToTransporter && getRampStatus() == Ramp.DOWN /*&& car.getClass() != Cars.CarTransporter*/) {
            car.stopEngine();
            car.setY(getY());
            car.setX(getX());
            cars.push(car);
        }

    }
    /***
     * Set method
     */
    public void setCarPositionEqualsToCarTransporter() {
        for (int i = 0; i < cars.size(); i++) {
            cars.elementAt(i).setX(getX());
            cars.elementAt(i).setY(getY());
        }

    }

    /***
     * Speed factor
     * @return
     */
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }


}
