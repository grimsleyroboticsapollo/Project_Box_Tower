package org.usfirst.frc.team1533.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.Joystick.ButtonType;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1533.robot.subsystems.AbsoluteEncoder;
import org.usfirst.frc.team1533.robot.subsystems.SwerveDrive;
import org.usfirst.frc.team1533.robot.subsystems.SwerveModule;
import org.usfirst.frc.team1533.robot.RobotMap;
import edu.wpi.first.wpilibj.VictorSP;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import org.usfirst.frc.team1533.robot.OI;

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
    public static RobotMap device;
    public static UsbCamera mrSandCam;
    VictorSPX INTAKE = new VictorSPX(8);
    VictorSPX LIFT = new VictorSPX(9);
    VictorSPX ROTATE = new VictorSPX(10);

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // Init. All Devices
		    oi = new OI();
            swerve = new SwerveDrive();
            device = new RobotMap();
            mrSandCam = CameraServer.getInstance().startAutomaticCapture(0);
            mrSandCam.setResolution(520, 360);
            mrSandCam.setFPS(30);
            INTAKE.set(ControlMode.PercentOutput, 0);
            LIFT.set(ControlMode.PercentOutput, 0);
            ROTATE.set(ControlMode.PercentOutput, 0);
    }

    public void robotPeriodic() {
        // Dashboard/Debug Stuff
            SmartDashboard.putNumber("FL", Math.toDegrees(swerve.modules[0].steerEncoder.getAngle()));
            SmartDashboard.putNumber("FR", Math.toDegrees(swerve.modules[1].steerEncoder.getAngle()));
            SmartDashboard.putNumber("BL", Math.toDegrees(swerve.modules[2].steerEncoder.getAngle()));
            SmartDashboard.putNumber("BR", Math.toDegrees(swerve.modules[3].steerEncoder.getAngle()));
            //SmartDashboard.putNumber("FL", swerve.modules[0].steerEncoder.getAverageVoltage());
            //SmartDashboard.putNumber("FR", swerve.modules[1].steerEncoder.getAverageVoltage());
            //SmartDashboard.putNumber("BL", swerve.modules[2].steerEncoder.getAverageVoltage());
            //SmartDashboard.putNumber("BR", swerve.modules[3].steerEncoder.getAverageVoltage());
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
        swerve.enable();
        	
        	
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();

        // Set Camera Quality To Normal Conditions
        mrSandCam.setResolution(520, 360);
        mrSandCam.setFPS(30);

        // Drive Code
            swerve.driveNormal(OI.getGamepad().getX()/2, -OI.getGamepad().getY()/2, OI.getGamepad().getZ()/2);            
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
        
        // Lower Camera Quality Once Teleop Starts
            mrSandCam.setResolution(1, 1);
            mrSandCam.setFPS(1);

        // Drive Code
            swerve.driveNormal(OI.getGamepad().getX(), -OI.getGamepad().getY(), OI.getGamepad().getZ());
            //swerve.driveNormal(OI.getGamepad().getX()/2, -OI.getGamepad().getY()/2, OI.getGamepad().getZ()/2);

        // Box Mechanism Code
    
            // Intake
            if (OI.getGamepad().getRawButton(1)) {
                INTAKE.set(ControlMode.PercentOutput, 1);
            } else if (OI.getGamepad().getRawButton(2)){
                INTAKE.set(ControlMode.PercentOutput, -1);
            } else {
                INTAKE.set(ControlMode.PercentOutput, 0);
            }

            // Lift
            if (OI.getGamepad().getRawButton(5)) {
                LIFT.set(ControlMode.PercentOutput, 1);
                OI.getGamepad().setRumble(RumbleType.kLeftRumble, 1);
            } else if (OI.getGamepad().getRawButton(6)) {
                LIFT.set(ControlMode.PercentOutput, -1);
                OI.getGamepad().setRumble(RumbleType.kRightRumble, 1);
            } else {
                LIFT.set(ControlMode.PercentOutput, 0);
            }

            // Rotate
            if (OI.getGamepad().getRawButton(3)) {
                ROTATE.set(ControlMode.PercentOutput, 1);
            } else if (OI.getGamepad().getRawButton(4)) {
                ROTATE.set(ControlMode.PercentOutput, -1);
            } else {
                ROTATE.set(ControlMode.PercentOutput, 0);
            }
                     
    }
    
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}


