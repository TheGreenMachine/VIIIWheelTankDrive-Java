package com.edinarobotics.VIIIWheelTankDrive.commands;

import com.edinarobotics.VIIIWheelTankDrive.subsystems.Gearshifter;
import com.edinarobotics.VIIIWheelTankDrive.Components;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Command;

public class SetSolenoidCommand extends Command {

    private Value value;
    private Gearshifter gearshifter;
    
    public SetSolenoidCommand(Value value) throws CANTimeoutException {
        this.value = value;
        gearshifter = Components.getInstance().gearshifter;
        requires(gearshifter);
    }
    
    protected void initialize() {
        gearshifter.set(value);
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
