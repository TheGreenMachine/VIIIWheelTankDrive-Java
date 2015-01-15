package com.edinarobotics.VIIIWheelTankDrive.gamepad.filters;

import com.edinarobotics.utils.gamepad.gamepadfilters.SimpleGamepadFilter;
import com.sun.squawk.util.MathUtils;

public class GamepadFilter extends SimpleGamepadFilter {

    protected double applyFilter(double value) {
        if(Math.abs(value) <= 0.05){
            return 0;
        }
        return ((MathUtils.pow(Math.abs(value), 3) + 0.3)/1.3) * (value < 0 ? -1 : 1);
    }

}
