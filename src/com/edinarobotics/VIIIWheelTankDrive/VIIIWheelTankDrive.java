/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.edinarobotics.VIIIWheelTankDrive;


import com.edinarobotics.VIIIWheelTankDrive.commands.GamepadDriveCommand;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Scheduler;

public class VIIIWheelTankDrive extends IterativeRobot {  
    
    public void robotInit() {        
    }

    public void autonomousPeriodic() {    
    }
    
    public void teleopPeriodic() {
        try {
            Scheduler.getInstance().run();
            DriverStation ds = DriverStation.getInstance();
            double p = ds.getAnalogIn(1);
            double i = ds.getAnalogIn(2);
            double d = ds.getAnalogIn(3);
            Components.getInstance().drivetrain.setPID(p, i, d);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    
    public void testPeriodic() {    
    }
    
    public void stop() throws CANTimeoutException {
        Components.getInstance().drivetrain.setValues(0.0, 0.0);
    }
    
    public void teleopInit() {
        try {
            Components.getInstance().drivetrain.setDefaultCommand(new GamepadDriveCommand(Controls.getInstance().gamepad));
        } catch (CANTimeoutException e) {
            System.err.println("CAN Timeout Exception");
        }
        System.out.println("It's alive...");
    }
    
    public void disabledInit() {        
    }
    
    public void disabledPeriodic() {        
    }
}
