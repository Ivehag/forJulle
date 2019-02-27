import java.awt.*;

public class Volvo240 extends AbstractCar implements Movable {
    /***
     * Constant given be Volvo240's trim
     */
    private final static double trimFactor = 1.25;

    /***
     * Constructor for Volvo240
     * @param nrDoors see AbstractCar
     * @param enginePower see AbstractCar
     * @param currentSpeed see AbstractCar
     * @param color see AbstractCar
     * @param modelName see AbstractCar
     * @param x see AbstractCar
     * @param y see AbstractCar
     */
    public Volvo240(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double x, double y) {

        super(nrDoors, enginePower, currentSpeed, color, modelName, x, y);


    }


    /***
     * Method to calculate the factor of speed
     * @return Total velocity of the Volvo240
     */
    public double speedFactor() {

        return getEnginePower() * 0.01 * trimFactor;
    }


}
