import java.util.Random;

// Interface for defining a generic robot
interface Robot {
    void move(double distance);
    void turn(double angle);
}

// Abstract class representing a generic drone
abstract class Drone implements Robot {
    private double batteryLevel;

    public Drone() {
        this.batteryLevel = 100.0; // Initialize battery level to 100%
    }

    public void checkBatteryLevel() {
        System.out.println("Battery level: " + batteryLevel + "%");
    }

    public void chargeBattery() {
        System.out.println("Charging battery...");
        // Simulate charging time
        try {
            Thread.sleep(3000); // Charging time in milliseconds
            batteryLevel = 100.0;
            System.out.println("Battery fully charged.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void move(double distance) {
        if (batteryLevel > 0) {
            System.out.println("Moving forward by " + distance + " meters.");
            batteryLevel -= distance * 0.1; // Consume battery
        } else {
            System.out.println("Battery depleted. Please recharge.");
        }
    }

    @Override
    public void turn(double angle) {
        if (batteryLevel > 0) {
            System.out.println("Turning by " + angle + " degrees.");
            batteryLevel -= angle * 0.05; // Consume battery
        } else {
            System.out.println("Battery depleted. Please recharge.");
        }
    }

    abstract void takeOff();
    abstract void land();
}

// Concrete implementation of a drone
class Quadcopter extends Drone {
    @Override
    void takeOff() {
        System.out.println("Quadcopter taking off...");
        // Simulate takeoff time
        try {
            Thread.sleep(2000); // Takeoff time in milliseconds
            System.out.println("Quadcopter airborne.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    void land() {
        System.out.println("Quadcopter landing...");
        // Simulate landing time
        try {
            Thread.sleep(1500); // Landing time in milliseconds
            System.out.println("Quadcopter landed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class AutonomousRoboticsSystem {
    public static void main(String[] args) {
        // Create a quadcopter drone
        Drone quadcopter = new Quadcopter();

        // Perform operations
        quadcopter.takeOff();
        quadcopter.move(10);
        quadcopter.turn(90);
        quadcopter.move(5);
        quadcopter.checkBatteryLevel();
        quadcopter.land();
        quadcopter.chargeBattery();
    }
}
