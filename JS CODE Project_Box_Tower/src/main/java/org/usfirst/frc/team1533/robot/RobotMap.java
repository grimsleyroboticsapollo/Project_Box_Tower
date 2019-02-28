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
	public static int FL_STEER = 8; //front left
	public static int FR_STEER = 9; //front right
	public static int BL_STEER = 10; //back left
	public static int BR_STEER = 11; //back right
	
	// Drive Motors
	public static int FL_DRIVE = 4; //front left
	public static int FR_DRIVE = 5; // front right
	public static int BL_DRIVE = 6; // back left
	public static int BR_DRIVE = 7; //back right

	// Encoders For Drive Motors
	public static int FL_ENCODER = 4; //front left
	public static int FR_ENCODER = 5; // front right
	public static int BL_ENCODER = 6; // back left
	public static int BR_ENCODER = 7; // back right

	// Intake Mechanism
	public static int INTAKE = 0; // Intake Belt Motor
	public static int CLIMBER = 1; // Climbing Motor
}