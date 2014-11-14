/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.edinarobotics.VIIIWheelTankDrive;


import com.edinarobotics.VIIITankDrive.commands.GamepadDriveCommand;
import com.edinarobotics.VIIITankDrive.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.IterativeRobot;

public class VIIIWheelTankDrive extends IterativeRobot {
    
    private Drivetrain drivetrain;
    
    
    
    public void robotInit() {
        drivetrain = Components.getInstance().drivetrain;
    }

    public void autonomousPeriodic() {

    }

    
    public void teleopPeriodic() {
        Components.getInstance().drivetrain.setDefaultCommand(new GamepadDriveCommand());
    }
    
    public void testPeriodic() {
    
    }
    
}
