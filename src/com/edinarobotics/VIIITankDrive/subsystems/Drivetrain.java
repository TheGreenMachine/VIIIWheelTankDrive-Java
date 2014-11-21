package com.edinarobotics.VIIITankDrive.subsystems;

import com.edinarobotics.utils.subsystems.Subsystem1816;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;

public class Drivetrain extends Subsystem1816 {

    public RobotDrive robotDrive;
    private SpeedControllerWrapper rightSection, leftSection;
    private double rightValue, leftValue;

    public Drivetrain(SpeedControllerWrapper r, SpeedControllerWrapper l) {
        rightSection = r;
        leftSection = l;
        this.robotDrive = new RobotDrive(rightSection, leftSection);
    }
    
    public void setValues(double rightValue, double leftValue) {
        this.rightValue = rightValue;
        this.leftValue = leftValue;
        update();
    }

    public void update() {
        System.out.println("Point 5");
        this.robotDrive.tankDrive(leftValue, rightValue);
    }
    
    public void setDefaultCommand(Command command){
        if(getDefaultCommand() != null){
            super.getDefaultCommand().cancel();
        }
        super.setDefaultCommand(command);
    }

}
