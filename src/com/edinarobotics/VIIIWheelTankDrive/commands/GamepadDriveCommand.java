package com.edinarobotics.VIIIWheelTankDrive.commands;

import com.edinarobotics.VIIIWheelTankDrive.subsystems.Drivetrain;
import com.edinarobotics.VIIIWheelTankDrive.Components;
import com.edinarobotics.VIIIWheelTankDrive.Controls;
import com.edinarobotics.utils.gamepad.Gamepad;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Command;

public class GamepadDriveCommand extends Command{
    
    private Gamepad gamepad;
    private Drivetrain drivetrain;

    public GamepadDriveCommand(Gamepad gamepad) throws CANTimeoutException {
        this.gamepad = gamepad;
        this.drivetrain = Components.getInstance().drivetrain;
        requires(drivetrain);
    }
    
    protected void initialize() {
        double rightValue = gamepad.getRightJoystick().getY();
        double leftValue = gamepad.getLeftJoystick().getY();
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
        end();
    }
    
}
