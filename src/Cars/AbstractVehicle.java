package Cars;

import Cars.AbstractPositionable;
import Cars.Movable;

import java.awt.*;

public abstract class AbstractVehicle extends AbstractPositionable implements Movable {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    // Color of the car
    private String modelName; // The car model name
    protected Direction direction;

    public AbstractVehicle(Color color, double x, double y) {
        super(x, y, color);
    }

    protected enum Direction {NORTH, EAST, SOUTH, WEST}


    /***
     *
     * @param nrDoors Number of doors on the car
     * @param enginePower Engine power of the car
     * @param currentSpeed The current speed of the car
     * @param color Color of the car
     * @param modelName The model's name
     * @param x The x-coordinate of the car
     * @param y The y-coordinate of the car
     */

    public AbstractVehicle(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double x, double y) {
        super(x, y, color);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.modelName = modelName;

    }

    /***
     * Implemented method for moving car
     */
    public void move() {
        if (direction == Direction.EAST) {
            setX(getX() + currentSpeed);
        } else if (direction == Direction.SOUTH) {
            setY(getY() + currentSpeed);
        } else if (direction == Direction.WEST) {
            setX(getX() - currentSpeed);
        } else if (direction == Direction.NORTH) {
            setY(getY() - currentSpeed);
        }

    }

    /***
     * Method if turning car right
     */

    public void turnRight() {

        if (direction == Direction.NORTH) {
            direction = Direction.EAST;
        } else if (direction == Direction.EAST) {
            direction = Direction.SOUTH;
        } else if (direction == Direction.SOUTH) {
            direction = Direction.WEST;
        } else if (direction == Direction.WEST) {
            direction = Direction.NORTH;
        }

    }

    /***
     * Method for turning car left
     */
    public void turnLeft() {


        if (direction == Direction.NORTH) {
            direction = Direction.WEST;
        } else if (direction == Direction.WEST) {
            direction = Direction.SOUTH;
        } else if (direction == Direction.SOUTH) {
            direction = Direction.EAST;
        } else if (direction == Direction.EAST) {
            direction = Direction.NORTH;
        }
    }

    /***
     * Gets car model's name
     * @return String modelName
     */
    public String getModelName() {
        return modelName;
    }


    /***
     * Method to get the number of doors
     * @return Number of doors
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /***
     * Sets nr of doors
     * @param nr Parameter for number of doors for a car
     */
    public void setNrDoors(int nr) {
        this.nrDoors = nr;
    }


    /***
     * Gets the current engine power
     * @return Engine power
     */
    public double getEnginePower() {
        return enginePower;
    }

    /***
     * Gets the current speed
     * @return Current speed
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /***
     * Sets current speed
     * @param speed speed set
     */
    public void setCurrentSpeed(double speed) {
        this.currentSpeed = speed;
    }


    /***
     * Sets current speed to 0.1 when starting the engine
     */
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /***
     * Sets current speed to 0 when stopping the engine
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

    public double speedFactor() {

        return getEnginePower() * 0.01;
    }

    /***
     * Increases the total speed of the Cars.Volvo240
     * @param amount amount of speed increment
     */


    public void incrementSpeed(double amount) {

        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));

    }

    /***
     * Decrement of speed of the Cars.Volvo240
     * @param amount amount of speed decrement
     */
    public void decrementSpeed(double amount) {

        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));

    }

    /***
     * Gives gas to the Cars.Volvo240
     * @param amount amount of gas (speed increment) to the Cars.Volvo240
     */
    // TODO fix this method according to lab pm
    public void gas(double amount) {
        boolean isIncrementSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()) > getCurrentSpeed();
        boolean isInCurrentSpeedInterval = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()) >= 0 && Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()) <= getEnginePower();
        if (amount >= 0 && amount <= 1 && isIncrementSpeed && isInCurrentSpeedInterval) {
            incrementSpeed(amount);
        }
    }

    /***
     * Uses breaks of the Cars.Volvo240
     * @param amount amount of break (speed decrement) of the Cars.Volvo240
     */

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        boolean isDecrementSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0) < getCurrentSpeed();
        boolean isInCurrentSpeedInterval = Math.max(getCurrentSpeed() - speedFactor() * amount, 0) >= 0 && Math.max(getCurrentSpeed() - speedFactor() * amount, 0) <= getEnginePower();
        if (amount >= 0 && amount <= 1 && isDecrementSpeed && isInCurrentSpeedInterval) {
            decrementSpeed(amount);
        }
    }
}


