package com.edinarobotics.VIIIWheelTankDrive;

import com.edinarobotics.VIIIWheelTankDrive.commands.SetSolenoidCommand;
import com.edinarobotics.utils.gamepad.FilteredGamepad;
import com.edinarobotics.utils.gamepad.Gamepad;
import com.edinarobotics.utils.gamepad.gamepadfilters.DeadzoneFilter;
import com.edinarobotics.utils.gamepad.gamepadfilters.GamepadFilterSet;
import com.edinarobotics.utils.gamepad.gamepadfilters.PowerFilter;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import java.util.Vector;

public class Controls {
    private static Controls instance;
    
    public final Gamepad gamepad;
    
    private Controls() throws CANTimeoutException {        
        Vector gamepadFilters = new Vector();
        gamepadFilters.addElement(new DeadzoneFilter(0.1));
        gamepadFilters.addElement(new PowerFilter(2));
        GamepadFilterSet shootGamepadFilterSet = new GamepadFilterSet(gamepadFilters);
        gamepad = new FilteredGamepad(3, shootGamepadFilterSet);
        
        gamepad.leftBumper().whenPressed(new SetSolenoidCommand(Relay.Value.kForward));
        gamepad.rightBumper().whenPressed(new SetSolenoidCommand(Relay.Value.kReverse));
    }
    
    /**
     * Returns the proper instance of Controls. This method creates a new
     * Controls object the first time it is called and returns that object for
     * each subsequent call.
     *
     * @return The current instance of Controls.
     */
    public static Controls getInstance() throws CANTimeoutException {
        if (instance == null) {
            instance = new Controls();
        }
        return instance;
    }
}
