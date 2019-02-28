package Cars;

import java.awt.*;

public class Scania extends AbstractCar implements ITruckBed {
    private double currentTruckBedGradient;

    public Scania(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double x, double y, double currentTruckBedGradient) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, x, y);
        this.currentTruckBedGradient = currentTruckBedGradient;
    }

    /***
     * Get method
     * @return
     */
    public double getCurrentTruckBedGradient() {
        return currentTruckBedGradient;
    }



    /***
     * Set method
     * @param gradient
     */
     public void setTruckBedGradient(double gradient) {
        this.currentTruckBedGradient = gradient;
    }

    /***
     * Tips the truck bed
     * @param gradients Amount of gradients we would like to tip the truck bed
     */
    public void tipTruckBed(double gradients) {
        double maxTruckBedGradient = 70.0;
        if (getCurrentTruckBedGradient() + gradients <= maxTruckBedGradient && getCurrentSpeed() == 0) {
            setTruckBedGradient(getCurrentTruckBedGradient() + gradients);
        }
    }

    /***
     * Lifts the truck bed
     * @param gradients Amount of gradients we would like to tip the truck bed
     */
    public void liftTruckBed(double gradients) {
        setCurrentSpeed(0);
        double minTruckBedGradient = 0.0;
        if (getCurrentTruckBedGradient() - gradients >= minTruckBedGradient /*&& getCurrentSpeed() == 0*/) {
            setTruckBedGradient(getCurrentTruckBedGradient() - gradients);
        }
    }



    public void startEngine() {
        if (Math.abs(currentTruckBedGradient - 0) <= 1) {
            setCurrentSpeed(0.1);
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
