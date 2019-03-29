package org.usfirst.frc.team1533.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team1533.robot.subsystems.AbsoluteEncoder;
import org.usfirst.frc.team1533.robot.subsystems.SwerveDrive;
import org.usfirst.frc.team1533.robot.subsystems.SwerveModule;

import edu.wpi.first.wpilibj.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
        public static Joystick Gamepad_1 = new Joystick(0);
        
        public static Joystick getGamepad() {
            return Gamepad_1;
        }

        Button intake = new JoystickButton(Gamepad_1, 1); // Intake Button (X)
        Button outtake = new JoystickButton(Gamepad_1, 2); // Outtake Button (A)
        Button lift_Down = new JoystickButton(Gamepad_1, 3); // Lower Box Button (Y)
        Button lift_Up = new JoystickButton(Gamepad_1, 4); // Lift Box Up Button (B)
        Button rotate_Foward = new JoystickButton(Gamepad_1, 5); // Rotate Box Foward Button (LB)
        Button rotate_Backward = new JoystickButton(Gamepad_1, 6); // Rotate Box Backward Button (RB)
        //Button slow = new JoystickButton(Gamepad_1, 9); // Go Slower Button (BACK)
        //Button fast = new JoystickButton(Gamepad_1, 10); // Go Faster "Ludicrous Speed" Button (START)
        
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    


    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
}

