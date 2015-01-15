package com.edinarobotics.VIIIWheelTankDrive.subsystems;

import com.edinarobotics.utils.subsystems.Subsystem1816;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Command;

public class Drivetrain extends Subsystem1816 {

    public RobotDrive robotDrive;
    private SpeedControllerWrapper rightSection, leftSection;
    private double rightValue, leftValue, moveValue, rotateValue;
    private boolean isHighGear, isArcade;
    
    public DriverStationEnhancedIO driverStation = DriverStation.getInstance().getEnhancedIO();
    
    public Drivetrain(SpeedControllerWrapper right, SpeedControllerWrapper left) {
        rightSection = right;
        leftSection = left;
        isHighGear = true;
        robotDrive = new RobotDrive(rightSection, leftSection);
        robotDrive.setSafetyEnabled(false);
        isArcade = false;
    }
    
    public void setValues(double rightValue, double leftValue) {
        this.rightValue = -rightValue;
        this.leftValue = -leftValue;
        isArcade = false;
        update();
    }
    
    public void setValuesArcade(double moveValue, double rotateValue)
    {
        this.moveValue = moveValue;
        this.rotateValue = rotateValue;
        isArcade = true;
        update();
    }
    
    public void setGearState(boolean isHighGear) {
        this.isHighGear = isHighGear;
        leftSection.setGearState(isHighGear);
        rightSection.setGearState(isHighGear);
        update();
    }
    
    public void setPID(double p, double i, double d) throws CANTimeoutException {
        leftSection.setPID(p, i, d);
        rightSection.setPID(p, i, d);
    }

    public void update() {
        /*try {
            //System.out.println("3     " + rightSection.getRPM());
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }*/
        if(isArcade){
            robotDrive.arcadeDrive(moveValue, rotateValue);
        }
        else{
            robotDrive.tankDrive(leftValue, rightValue);
        }
    }
    
    public void setDefaultCommand(Command command){
        if(getDefaultCommand() != null){
            super.getDefaultCommand().cancel();
        }
        super.setDefaultCommand(command);
    }

}
