package com.edinarobotics.VIIITankDrive.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.can.CANTimeoutException;

public class SpeedControllerWrapper implements SpeedController {
    
    private CANJaguar canJag1, canJag2, canJag3;
    
    public SpeedControllerWrapper(int canJag1, int canJag2, int canJag3) throws CANTimeoutException {
        this.canJag1 = new CANJaguar(canJag1);
        this.canJag2 = new CANJaguar(canJag2);
        this.canJag3 = new CANJaguar(canJag3);
    }

    public double get() {
        try {
            return canJag1.getX();
        } catch(CANTimeoutException e) {
            System.err.println("CAN Timeout Exception");
            return 0.0;
        }
    }
    
    public void set(double d, byte b) {
        try {
            canJag1.setX(d, b);
            canJag2.setX(d, b);
            canJag3.setX(d, b);
        } catch (CANTimeoutException e) {
            System.err.println("CAN Timeout Exception");
        }
    }

    public void set(double d) {
        try {
            canJag1.setX(d);
            canJag2.setX(d);
            canJag3.setX(d);
        } catch (CANTimeoutException e) {
            System.err.println("CAN Timeout Exception");
        }
    }

    public void disable() {
        try {
             canJag1.disableControl();
             canJag2.disableControl();
             canJag3.disableControl();
        } catch (CANTimeoutException e) {
            System.err.println("CAN Timeout Exception");
        }
    }

    public void pidWrite(double d) {
        
    }
    
}
