package com.edinarobotics.VIIITankDrive.subsystems;

import com.edinarobotics.utils.subsystems.Subsystem1816;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Command;

public class Drivetrain extends Subsystem1816 {

    public RobotDrive robotDrive;
    private SpeedControllerWrapper rightSection, leftSection;
    private double rightValue, leftValue;

    public Drivetrain(int leftCANJag1, int leftCANJag2, int leftCANJag3,
            int rightCANJag1, int rightCANJag2, int rightCANJag3) {
        try {
            rightSection = new SpeedControllerWrapper(rightCANJag1, rightCANJag2, rightCANJag3);
            leftSection = new SpeedControllerWrapper(leftCANJag1, leftCANJag2, leftCANJag3);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
            System.out.println("CANJaguar assignment failed! lelelel");
        }
        
        this.robotDrive = new RobotDrive(rightSection, leftSection);
    }
    
    public void setValues(double rightValue, double leftValue) {
        this.rightValue = rightValue;
        this.leftValue = leftValue;
        update();
    }

    public void update() {
        this.robotDrive.tankDrive(leftValue, rightValue);
    }
    
    public void setDefaultCommand(Command command){
        if(getDefaultCommand() != null){
            super.getDefaultCommand().cancel();
        }
        super.setDefaultCommand(command);
    }

}
