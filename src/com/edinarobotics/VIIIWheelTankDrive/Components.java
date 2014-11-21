package com.edinarobotics.VIIIWheelTankDrive;

import com.edinarobotics.VIIITankDrive.subsystems.Drivetrain;
import com.edinarobotics.VIIITankDrive.subsystems.Gearshifter;
import com.edinarobotics.VIIITankDrive.subsystems.SpeedControllerWrapper;
import edu.wpi.first.wpilibj.Compressor;
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
        private static final int RIGHT_CAN_JAG3 = 16;
        //End Drivetrain Constants
    //End PWM Constants
    
    
    private Components() throws CANTimeoutException {
        right = new SpeedControllerWrapper(RIGHT_CAN_JAG1, RIGHT_CAN_JAG2, RIGHT_CAN_JAG3);
        left = new SpeedControllerWrapper(LEFT_CAN_JAG1, LEFT_CAN_JAG2, LEFT_CAN_JAG3);
        this.drivetrain = new Drivetrain(right, left);
        this.gearshifter = new Gearshifter(GEARSHIFTER_RELAY);
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
