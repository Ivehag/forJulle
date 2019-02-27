import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:
    private final int X = 800;
    private final int Y = 800;

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<AbstractCar> cars = new ArrayList<>();
    ArrayList<ITurbo> saabs = new ArrayList<>();
    ArrayList<ITruckBed> scanias = new ArrayList<>();


    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        CarFactory carFactory = new CarFactory();
        AbstractCar saab = carFactory.createSaab95();
        AbstractCar scania = carFactory.createScania();
        //     Saab95 saab = new Saab95(4, 100, 0, Color.CYAN, "Saab95", 300, 300, false);
        //     Scania scania = new Scania(2, 100, 0, Color.BLUE, "Scania", 700, 500, 0);

        cc.cars.add(carFactory.createVolvo240());
        cc.cars.add(saab);
        cc.cars.add(scania);
        cc.saabs.add((ITurbo) saab);
        cc.scanias.add((ITruckBed) scania);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (AbstractCar car : cars) {
                //          System.out.println(car.direction);
                //  changeDirectionBasedOnKeyHit();
                changeDirectionIfCarHitsFrame(car);
                //     System.out.println(car.direction);
                //   System.out.println(car.getY());
                //    System.out.println(saabs.get(0).getTurboStatus());
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());

                //compares each car to lists of ITurbo and ITruckBed
                //to choose the correct image to move
                if (saabs.contains(car)) {
                    frame.drawPanel.moveit((ITurbo) car, x, y);
                } else if (scanias.contains(car)) {
                    frame.drawPanel.moveit((ITruckBed) car, x, y);
                } else {
                    frame.drawPanel.moveit(car, x, y);
                }
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }

       /*public void changeDirectionBasedOnKeyHit(KeyEvent e) {
            for (AbstractCar car : cars) {
                if (e.equals(KeyEvent.VK_RIGHT)) {
                    car.direction = AbstractCar.Direction.EAST;
                } else if (e.equals(KeyEvent.VK_DOWN)) {
                    car.direction = AbstractCar.Direction.SOUTH;
                } else if (e.equals(KeyEvent.VK_LEFT)) {
                    car.direction = AbstractCar.Direction.WEST;
                } else if (e.equals(KeyEvent.VK_UP)) {
                    car.direction = AbstractCar.Direction.NORTH;
                }
            }
        }*/

        private void changeDirectionIfCarHitsFrame(AbstractCar car) {
            if (car.getX() > X - 100) {
                car.direction = AbstractCar.Direction.WEST;
            } else if (car.getX() < 0) {
                car.direction = AbstractCar.Direction.EAST;
            } else if (car.getY() < 0) {
                car.direction = AbstractCar.Direction.SOUTH;
            } else if (car.getY() > Y - 300) {
                car.direction = AbstractCar.Direction.NORTH;
            }
        }
    }

    /**
     * Calls cas method for each car
     * @param amount
     */
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (AbstractCar car : cars) {
            car.gas(gas);
        }
    }

    /**
     * Starts engine based on which car
     */
    void startAllEngines() {
        for (AbstractCar c : cars) {
            if (scanias.contains(c)) {
                ((ITruckBed) c).startEngine();
            } else {
                c.startEngine();
            }
        }

    }

    /**
     * Turns off all engines
     */
    void turnOffAllEngines() {
        for (AbstractCar c : cars) {
            c.stopEngine();
        }
    }

    /**
     * Uses brake on all cars
     * @param amount
     */
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (AbstractCar car : cars) {
            car.brake(brake);
        }
    }

    /**
     * Sets all directions
     * @param dir
     */
    void setAllDirections(AbstractCar.Direction dir) {
        for (AbstractCar car : cars) {
            car.direction = dir;
        }
    }

    /**
     *
     */
    void turboOn() {
        for (ITurbo saab : saabs) {

            saab.setTurboOn();

        }
    }

    void turboOff() {
        for (ITurbo saab : saabs) {

            saab.setTurboOff();

        }
    }

    void lowerTruckBed() {
        for (ITruckBed sc : scanias) {
            sc.tipTruckBed(70);
        }
    }

    void liftTruckBed() {
        for (ITruckBed sc : scanias) {
            sc.liftTruckBed(70);
        }
    }
}
