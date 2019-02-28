package Cars;

import java.awt.*;

public class AbstractTruck extends  AbstractVehicle {
    public AbstractTruck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double x, double y){
        super(nrDoors, enginePower, currentSpeed, color, modelName, x, y);
    }
}
