package com.edinarobotics.VIIIWheelTankDrive.commands;

import com.edinarobotics.VIIIWheelTankDrive.subsystems.Drivetrain;
import com.edinarobotics.VIIIWheelTankDrive.Components;
import com.edinarobotics.VIIIWheelTankDrive.Controls;
import com.edinarobotics.utils.gamepad.Gamepad;
import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Command;

public class GamepadDriveCommand extends Command {
    
    private Gamepad gamepad;
    private Drivetrain drivetrain;

    public GamepadDriveCommand(Gamepad gamepad) throws CANTimeoutException {
        this.gamepad = gamepad;
        this.drivetrain = Components.getInstance().drivetrain;
        requires(drivetrain);
    }
    
    protected void initialize() {
    }

    protected void execute() {
        double moveValue = gamepad.getLeftJoystick().getY();
        double rotateValue = gamepad.getRightJoystick().getX();        
        drivetrain.setValuesArcade(moveValue, rotateValue);
        System.out.println("Right: " + moveValue + "         Left: " + rotateValue);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {        
    }

    protected void interrupted() {
        end();
    }
    
}
