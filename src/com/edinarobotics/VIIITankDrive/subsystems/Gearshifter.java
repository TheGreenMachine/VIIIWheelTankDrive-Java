package com.edinarobotics.VIIITankDrive.subsystems;

import com.edinarobotics.utils.subsystems.Subsystem1816;

import edu.wpi.first.wpilibj.Relay;

public class Gearshifter extends Subsystem1816 {
    
    private Relay gearshifter;
    private Relay.Value value;
    
    public Gearshifter(int relay) {
        gearshifter = new Relay(relay);
        value = Relay.Value.kForward;
    }

    public void set(Relay.Value value) {
        this.value = value;
        update();
    }
    
    public void update() {
        gearshifter.set(value);
    }
    
}
