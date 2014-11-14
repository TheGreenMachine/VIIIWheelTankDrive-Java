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
        return canJag1.get();
    }

    public void set(double d, byte b) {
        
    }

    public void set(double d) {
        
    }

    public void disable() {
        
    }

    public void pidWrite(double d) {
        
    }
    
}
