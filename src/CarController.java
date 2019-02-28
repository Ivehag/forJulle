import Cars.AbstractCar;
import Cars.CarFactory;
import Cars.ITruckBed;
import Cars.ITurbo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:
    private final int X = 800;
    private final int Y = 800;



    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    CarModel carMod;
    // A list of cars, modify if needed


    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);


    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
// TODO: Create more for each component as necessary
        frame.startButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carMod.startAllEngines();
        }
    });

        frame.stopButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carMod.turnOffAllEngines();
        }
    });

        frame.gasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carMod.gas(gasAmount);
        }
    });

        frame.turboOnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carMod.turboOn();
        }
    });

        frame.liftBedButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carMod.liftTruckBed();
        }
    });

        frame.brakeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carMod.brake(gasAmount);
        }
    });

        frame.turboOffButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carMod.turboOff();
        }
    });

        frame.lowerBedButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carMod.lowerTruckBed();
        }
    });

       /*public void changeDirectionBasedOnKeyHit(KeyEvent e) {
            for (Cars.AbstractCar car : cars) {
                if (e.equals(KeyEvent.VK_RIGHT)) {
                    car.direction = Cars.AbstractCar.Direction.EAST;
                } else if (e.equals(KeyEvent.VK_DOWN)) {
                    car.direction = Cars.AbstractCar.Direction.SOUTH;
                } else if (e.equals(KeyEvent.VK_LEFT)) {
                    car.direction = Cars.AbstractCar.Direction.WEST;
                } else if (e.equals(KeyEvent.VK_UP)) {
                    car.direction = Cars.AbstractCar.Direction.NORTH;
                }
            }
        }*/

}
