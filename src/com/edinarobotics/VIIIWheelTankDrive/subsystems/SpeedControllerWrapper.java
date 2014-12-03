package com.edinarobotics.VIIIWheelTankDrive.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.can.CANTimeoutException;

public class SpeedControllerWrapper implements SpeedController {
    
    private CANJaguar canJag1, canJag2, canJag3;
    
    private boolean isPIDControlled;
    
    public SpeedControllerWrapper(int canJag1, int canJag2, int canJag3) throws CANTimeoutException {
        this.canJag1 = new CANJaguar(canJag1);
        this.canJag2 = new CANJaguar(canJag2);
        this.canJag3 = new CANJaguar(canJag3);        
        this.canJag1.setSafetyEnabled(false);
        
        this.canJag2.setSafetyEnabled(false);
        this.canJag3.setSafetyEnabled(false);
        this.canJag1.enableControl();
        this.canJag2.enableControl();
        this.canJag3.enableControl();
        isPIDControlled = false;
    }
    
    public SpeedControllerWrapper(int canJagEncoder, int canJag2, int canJag3,
            double p, double i, double d, int encoderTicksPerRev) throws CANTimeoutException {
        this.canJag1 = new CANJaguar(canJagEncoder, CANJaguar.ControlMode.kSpeed);
        this.canJag2 = new CANJaguar(canJag2, CANJaguar.ControlMode.kVoltage);
        this.canJag3 = new CANJaguar(canJag3, CANJaguar.ControlMode.kVoltage);
        this.canJag1.setPID(p, i, d);
        this.canJag1.configEncoderCodesPerRev(encoderTicksPerRev);
        this.canJag1.setSafetyEnabled(false);
        this.canJag2.setSafetyEnabled(false);
        this.canJag3.setSafetyEnabled(false);
        this.canJag1.enableControl();
        this.canJag2.enableControl();
        this.canJag3.enableControl();
        isPIDControlled = true;
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
            if(isPIDControlled) {
                canJag1.setX(d, b);
                double voltage = canJag1.getOutputVoltage();
                canJag2.setX(voltage, b);
                canJag3.setX(voltage, b);
            } else {
                canJag1.setX(d, b);
                canJag2.setX(d, b);
                canJag3.setX(d, b);
            }
        } catch (CANTimeoutException e) {
            System.err.println("CAN Timeout Exception");
        }
    }

    public void set(double d) {
        try {
            if(isPIDControlled) {
                canJag1.setX(d);
                double voltage = canJag1.getOutputVoltage();
                canJag2.setX(voltage);
                canJag3.setX(voltage);
            } else {
                canJag1.setX(d);
                canJag2.setX(d);
                canJag3.setX(d);
                System.out.println(canJag1.getX());
                //System.out.println(canJag2.getX());
                //System.out.println(canJag3.getX());
            }
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
        set(d);
    }
    
}
