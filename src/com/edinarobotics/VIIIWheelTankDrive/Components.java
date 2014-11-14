package com.edinarobotics.VIIIWheelTankDrive;

import com.edinarobotics.VIIITankDrive.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Compressor;

public class Components {
    private static Components instance;
    
    public Drivetrain drivetrain;
    
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
    
    
    private Components() {
        this.drivetrain = new Drivetrain(LEFT_CAN_JAG1, LEFT_CAN_JAG2, LEFT_CAN_JAG3, 
                RIGHT_CAN_JAG1, RIGHT_CAN_JAG2, RIGHT_CAN_JAG3);
        
        this.compressor = new Compressor(COMPRESSOR_PRESSURE_SWITCH, COMPRESSOR_RELAY);
        compressor.start();
        
        
    }
    
    /**
     * Returns a new instance of {@link Components}, creating one if null.
     * @return {@link Components}
     */
    public static Components getInstance() {
        if(instance == null){
            instance = new Components();
        }
        return instance;
    }
}
