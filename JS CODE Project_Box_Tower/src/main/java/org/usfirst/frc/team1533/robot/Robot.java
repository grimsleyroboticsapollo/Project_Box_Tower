
package org.usfirst.frc.team1533.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.Joystick.ButtonType;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team1533.robot.subsystems.AbsoluteEncoder;
import org.usfirst.frc.team1533.robot.subsystems.SwerveDrive;
import org.usfirst.frc.team1533.robot.subsystems.SwerveModule;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
    public static SwerveDrive swerve;
    public static RobotMap motor;
	
	Joystick joy1;

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		swerve = new SwerveDrive();
		joy1 = new Joystick(1);
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
        	//swerve.enable();
        	
        	
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        swerve.enable();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	swerve.disable();
    }
    
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();

        // Drive Code
        swerve.driveNormal(joy1.getX()/2, -joy1.getY()/2, joy1.getZ()/2);

        // Box Mechanism Code
        
        // Intake
        if (joy1.getRawButton(1)) {
            motor.INTAKE += 1;
        }

        // Lift
        if (joy1.getRawButton(7)) {
            motor.LIFT += 1;
        } else if (joy1.getRawButton(8)) {
            motor.LIFT -= 1;
        } else {
            motor.LIFT = 0;
        }

        // Rotation
        if (joy1.getRawButton(4)) {
            motor.ROTATE += 1;
        } else if (joy1.getRawButton(3)) {
            motor.ROTATE -= 1;
        } else {
            motor.ROTATE = 0;
        }


        // "Climbing"
        // #TODO Figure Out A Way To Switch From Teleop To Autonomous
    }
    
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}


