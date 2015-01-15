package com.edinarobotics.VIIIWheelTankDrive.subsystems;

import com.edinarobotics.utils.subsystems.Subsystem1816;

import edu.wpi.first.wpilibj.Relay;

public class Gearshifter extends Subsystem1816 {
    
    private Relay gearshifter;
    private Relay.Value value;
    private Drivetrain drivetrain;
    
    public Gearshifter(int relay, Drivetrain drivetrain) {
        gearshifter = new Relay(relay);
        value = Relay.Value.kForward;
        this.drivetrain = drivetrain;
    }

    public void set(Relay.Value value) {
        this.value = value;
        drivetrain.setGearState(value == Relay.Value.kForward);
        update();
    }
    
    public Relay.Value getValue() {
        return value;
    }
    
    public void update() {
        gearshifter.set(value);
    }
    
}
