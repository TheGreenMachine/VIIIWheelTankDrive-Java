package com.edinarobotics.VIIITankDrive.commands;

import com.edinarobotics.VIIITankDrive.subsystems.Drivetrain;
import com.edinarobotics.VIIIWheelTankDrive.Components;
import com.edinarobotics.VIIIWheelTankDrive.Controls;
import com.edinarobotics.utils.gamepad.Gamepad;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Command;

public class GamepadDriveCommand extends Command{
    
    private Gamepad gamepad;
    private Drivetrain drivetrain;

    protected void initialize() {
        
        
        try {
            drivetrain = Components.getInstance().drivetrain;
            requires(drivetrain);
            gamepad = Controls.getInstance().gamepad;
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    protected void execute() {
        double rightValue = gamepad.getRightJoystick().getY();
        double leftValue = gamepad.getRightJoystick().getY();
        drivetrain.setValues(rightValue, leftValue);
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
