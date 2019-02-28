package Cars;

import java.awt.*;

public class Volvo240 extends AbstractCar implements Movable {
    /***
     * Constant given be Cars.Volvo240's trim
     */
    private final static double trimFactor = 1.25;

    /***
     * Constructor for Cars.Volvo240
     * @param nrDoors see Cars.AbstractCar
     * @param enginePower see Cars.AbstractCar
     * @param currentSpeed see Cars.AbstractCar
     * @param color see Cars.AbstractCar
     * @param modelName see Cars.AbstractCar
     * @param x see Cars.AbstractCar
     * @param y see Cars.AbstractCar
     */
    public Volvo240(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double x, double y) {

        super(nrDoors, enginePower, currentSpeed, color, modelName, x, y);


    }


    /***
     * Method to calculate the factor of speed
     * @return Total velocity of the Cars.Volvo240
     */
    public double speedFactor() {

        return getEnginePower() * 0.01 * trimFactor;
    }


}
