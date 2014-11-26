package com.edinarobotics.VIIIWheelTankDrive.commands;

import com.edinarobotics.VIIIWheelTankDrive.subsystems.Drivetrain;
import com.edinarobotics.VIIIWheelTankDrive.Components;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Command;

public class SetDrivetrainCommand extends Command {
    
    private Drivetrain drivetrain;
    private double rightValue, leftValue;
    
    public SetDrivetrainCommand(double rightValue, double leftValue) throws CANTimeoutException {
        super("SetDrivetrain");
        drivetrain = Components.getInstance().drivetrain;
        requires(drivetrain);
        this.rightValue = rightValue;
        this.leftValue = leftValue;
    }

    protected void initialize() {
        drivetrain.setValues(rightValue, leftValue);
    }

    protected void execute() {        
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {        
    }

    protected void interrupted() {    
    }
    
}
