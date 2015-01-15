
package com.edinarobotics.VIIIWheelTankDrive;

import com.edinarobotics.VIIIWheelTankDrive.subsystems.Drivetrain;
import com.edinarobotics.VIIIWheelTankDrive.subsystems.Gearshifter;
import com.edinarobotics.VIIIWheelTankDrive.subsystems.SpeedControllerWrapper;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.can.CANTimeoutException;

public class Components {
    private static Components instance;
    
    public Drivetrain drivetrain;
    public SpeedControllerWrapper left, right;
    public Gearshifter gearshifter;
    
    
    //Compressor Switch
    private static final int COMPRESSOR_PRESSURE_SWITCH = 1;
    
    //DOI Constants
        //Compressors
        private final Compressor compressor;
    //End DOI Constants
    
    // Relay constats
        // Compressor
        private static final int COMPRESSOR_RELAY = 1;
        // Solenoid
        private static final int GEARSHIFTER_RELAY = 2;
    // END Relay constants
    
    //PWM Constants        
        // Drivetrain Constants
        private static final int LEFT_CAN_JAG1 = 11;
        private static final int LEFT_CAN_JAG2 = 12;
        private static final int LEFT_CAN_JAG3 = 13;
        private static final int RIGHT_CAN_JAG1 = 14;
        private static final int RIGHT_CAN_JAG2 = 15;
        private static final int RIGHT_CAN_JAG3 = 16; //This Jaguar has an Encoder equipped
        //End Drivetrain Constants
        
    //End PWM Constants
        
    //PID CONSTANTS
        
        private static final boolean IS_PID_CONTROLLED = false;
        //Left Wheels
        private static final double P_LEFT = 1;
        private static final double I_LEFT = 0;
        private static final double D_LEFT = 0;
        //End Left Wheels
        
        //Right Wheels
        private static final double P_RIGHT = 1;
        private static final double I_RIGHT = 0;
        private static final double D_RIGHT = 0;
        //End Right Wheels
    //End PID CONSTANTS
        
    //RPM Constants
    private static final double HIGH_GEAR_MAX_RPM = 5000.0;
    private static final double LOW_GEAR_MAX_RPM = 2000.0;
    //End RPM Constants
    
    
    //Encoder Constants
        //Encoder Ticks per Rev Constant
    //1382
    
        private static final int TICKS_PER_REV = 256;
        //End Encoder Ticks per Rev Constant
        
        //Distance Per Pulse
        private static final double DISTANCE_PER_PULSE = 0.00909;
        //End Distance Per Pulse
    //End Encoder Constant
    
    private Components() throws CANTimeoutException {
        if(IS_PID_CONTROLLED) {
            right = new SpeedControllerWrapper(RIGHT_CAN_JAG3, RIGHT_CAN_JAG2, RIGHT_CAN_JAG1, 
                P_RIGHT, I_RIGHT, D_RIGHT, TICKS_PER_REV, HIGH_GEAR_MAX_RPM, LOW_GEAR_MAX_RPM);
            left = new SpeedControllerWrapper(LEFT_CAN_JAG1, LEFT_CAN_JAG2, LEFT_CAN_JAG3, 
                P_LEFT, I_LEFT, D_LEFT, TICKS_PER_REV, HIGH_GEAR_MAX_RPM, LOW_GEAR_MAX_RPM);
        } else {
            right = new SpeedControllerWrapper(RIGHT_CAN_JAG1, RIGHT_CAN_JAG2, RIGHT_CAN_JAG3);
            left = new SpeedControllerWrapper(LEFT_CAN_JAG1, LEFT_CAN_JAG2, LEFT_CAN_JAG3);
        }
        
        this.drivetrain = new Drivetrain(right, left);
        this.gearshifter = new Gearshifter(GEARSHIFTER_RELAY, drivetrain);
        this.compressor = new Compressor(COMPRESSOR_PRESSURE_SWITCH, COMPRESSOR_RELAY);
        compressor.start(); 
    }
    
    /**
     * Returns a new instance of {@link Components}, creating one if null.
     * @return {@link Components}
     */
    public static Components getInstance() throws CANTimeoutException {
        if(instance == null){
            instance = new Components();
        }
        return instance;
    }

}
