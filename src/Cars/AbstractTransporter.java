package Cars;

import java.awt.*;

public abstract class AbstractTransporter<T extends AbstractCar> extends AbstractVehicle {
    private Ramp ramp;


    private double delta = 2;

    public enum Ramp {UP, DOWN}

    public AbstractTransporter(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double x, double y) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, x, y);
    }

    public void setRampUp() {
        if (getCurrentSpeed() == 0) {
            ramp = CarTransporter.Ramp.UP;
        }
    }

    /***
     * we want to throw a exception if getCurrentSpeed()!=0
     */
    public void setRampDown() {
        if (getCurrentSpeed() == 0) {
            ramp = CarTransporter.Ramp.DOWN;
        }
    }




    /***
     * get method
     * @return
     */
    public Ramp getRampStatus() {
        return ramp;
    }

}
