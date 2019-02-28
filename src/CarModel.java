import Cars.AbstractCar;
import Cars.CarFactory;
import Cars.ITruckBed;
import Cars.ITurbo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarModel {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());
    private static final int X = 800;
    private static final int Y = 800;

    private ArrayList<AbstractCar> cars = new ArrayList<>();
    private ArrayList<ITurbo> saabs = new ArrayList<>();
    private ArrayList<ITruckBed> scanias = new ArrayList<>();

    private Point volvoPoint = new Point();
    private Point saabPoint = new Point();
    private Point scaniaPoint = new Point();





    public CarModel() {

    }

    void update() {

    }

    void init() {
        CarFactory carFactory = new CarFactory();
        AbstractCar saab = carFactory.createSaab95();
        AbstractCar scania = carFactory.createScania();
        //     Cars.Saab95 saab = new Cars.Saab95(4, 100, 0, Color.CYAN, "Cars.Saab95", 300, 300, false);
        //     Cars.Scania scania = new Cars.Scania(2, 100, 0, Color.BLUE, "Cars.Scania", 700, 500, 0);

        cars.add(carFactory.createVolvo240());
        cars.add(saab);
        cars.add(scania);
        saabs.add((ITurbo) saab);
        scanias.add((ITruckBed) scania);
        // Start the timer
        cM.timer.start();
    }

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

                //compares each car to lists of Cars.ITurbo and Cars.ITruckBed
                //to choose the correct image to move
                moveit(car, x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }
//void setAllDire
    // TODO: Make this general for all cars
String getModelName(int INDEX) {
return cars.get(INDEX).getModelName();
}
    void moveit(AbstractCar car, int x, int y) {
        if (scanias.contains(car)) {
            updateCarPoints(x, y, scaniaPoint);
        } else if (saabs.contains(car)) {
            updateCarPoints(x, y, saabPoint);
        } else {
            updateCarPoints(x, y, volvoPoint);
        }
    }

    private void updateCarPoints(int x, int y, Point carPoints) {
        carPoints.x = x;
        carPoints.y = y;
    }

    Point getCarPoint(AbstractCar car) {
        if (scanias.contains(car)) {
            return scaniaPoint;
        } else if (saabs.contains(car)) {
            return saabPoint;
        }
        return volvoPoint;
    }

    int getVolvoPointX() {
return volvoPoint.x;
    }


    private void changeDirectionIfCarHitsFrame(AbstractCar car) {
        if (car.getX() > X - 100) {
            car.setDirectionWest();
        } else if (car.getX() < 0) {
            car.setDirectionEast();
        } else if (car.getY() < 0) {
            car.setDirectionSouth();
        } else if (car.getY() > Y - 300) {
            car.setDirectionNorth();
        }
    }


    /**
     * Calls cas method for each car
     *
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
     *
     * @param amount
     */
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (AbstractCar car : cars) {
            car.brake(brake);
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
}

