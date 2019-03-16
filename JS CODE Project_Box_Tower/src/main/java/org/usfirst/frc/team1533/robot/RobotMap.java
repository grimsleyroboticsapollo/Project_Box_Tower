package org.usfirst.frc.team1533.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;

	// Steering/"Swerve" Motors
	public static int FL_STEER = 2; // Front Left Steer Motor
	public static int FR_STEER = 5; // Front Right Steer Motor
	public static int BL_STEER = 0; // Back Left Steer Motor
	public static int BR_STEER = 3; // Back Right Steer Motor
	
	// Drive Motors
	public static int FL_DRIVE = 6; // Front Left Motor
	public static int FR_DRIVE = 1; // Front Right Motor
	public static int BL_DRIVE = 7; // Back Left Motor
	public static int BR_DRIVE = 4; // Back Right Motor

	// Encoders For Drive Motors
	public static int FL_ENCODER = 6; // Front Left Encoder
	public static int FR_ENCODER = 1; // Front Right Encoder
	public static int BL_ENCODER = 7; // Back Left Encoder
	public static int BR_ENCODER = 4; // Back Right Encoder

	// Intake Mechanism
	//public static int INTAKE = ;  Intake Belt Motor
	//public static int ROTATE = ;  Box Rotation Motor
	//public static int LIFT = ;  Box Lift Motor

	// Climbing Mechanism
	//public static int CLIMBER = 11;  "Climbing" Motor

}