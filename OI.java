/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.team1241.frc2018;
import com.team1241.frc2018.commands.ClimberCommand;
import com.team1241.frc2018.commands.PistonCommands;
import com.team1241.frc2018.commands.WinchCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * Used with the Logitech F310.
 * 
 * @author Mahrus Kazi
 * @since 2015-09-13
 */
public class OI {
    //Controls for used for robot 
    Joystick drivePad;
    Joystick toolPad;
    JoystickButton bButton;
    JoystickButton aButton;
    JoystickButton xButton;
    JoystickButton yButton;
    JoystickButton rtButton;
    JoystickButton ltButton;
    /**
     * Initializes the joystick objects 
     */
    public OI()
    {
    	//initializes joystick objects
        drivePad = new Joystick (GamepadConstants.DRIVE_USB_PORT);
        toolPad = new Joystick (GamepadConstants.TOOL_USB_PORT);
        bButton=new JoystickButton(drivePad,GamepadConstants.B_BUTTON);
        aButton=new JoystickButton(drivePad,GamepadConstants.A_BUTTON);
        xButton=new JoystickButton(drivePad,GamepadConstants.X_BUTTON);
        yButton=new JoystickButton(drivePad,GamepadConstants.Y_BUTTON);
        rtButton=new JoystickButton(drivePad,GamepadConstants.RIGHT_TRIGGER);
        ltButton=new JoystickButton(drivePad,GamepadConstants.LEFT_TRIGGER); 
        
    }
    
    //Runs the climber command that moves the arm
    public void climberCommand()
    {
    	bButton.whenPressed(new ClimberCommand(0.5));
    	aButton.whenPressed(new ClimberCommand(-0.5));
    }
    
    //Runs the piston command that detaches the hook from the arm
    public void pistonCommand()
    {
    	xButton.whenPressed(new PistonCommands(false));
    	ltButton.whenPressed(new PistonCommands(true));
    }
    
    //Runs the winch command to climb
    public void winchCommand()
    {
    	yButton.whenPressed(new WinchCommand(0.5));
    	rtButton.whenPressed(new WinchCommand(-0.5));
    }
    /**
     * Used to return the drivePad's right joystick y-axis value 
     * 
     * @return Returns y-value from right joystick on the drivePad
     */
    public double getDriveRightY ()
    {
        double joy = drivePad.getRawAxis(GamepadConstants.RIGHT_ANALOG_Y);
        if(Math.abs(joy) < 0.05)
            return 0.0;
        else
            return joy;
    }
    
    /**
     * Used to return the toolPad's right joystick y-axis value 
     * 
     * @return Returns y-value from right joystick on the toolPad
     */
    public double getToolRightY ()
    {
        double joy = toolPad.getRawAxis(GamepadConstants.RIGHT_ANALOG_Y);
        if(Math.abs(joy) < 0.05)
            return 0.0;
        else
            return joy;
    }
    
    /**
     * Used to return the drivePad's left joystick y-axis value 
     * 
     * @return Returns y-value from left joystick on the drivePad
     */
    public double getDriveLeftY ()
    {
        double joy = drivePad.getRawAxis(GamepadConstants.LEFT_ANALOG_Y);
        if(Math.abs(joy) < 0.05)
            return 0.0;
        else
            return joy;
    }
    
    /**
     * Used to return the toolPad's left joystick y-axis value 
     * 
     * @return Returns y-value from left joystick on the toolPad
     */
    public double getToolLeftY ()
    {
        double joy = toolPad.getRawAxis(GamepadConstants.LEFT_ANALOG_Y);
        if(Math.abs(joy) < 0.05)
            return 0.0;
        else
            return joy;
    }
    
    /**
     * Used to return the drivePad's right joystick x-axis value 
     * 
     * @return Returns x-value from right joystick on the drivePad
     */
    public double getDriveRightX()
    {
        double joy = drivePad.getRawAxis(GamepadConstants.RIGHT_ANALOG_X);
        if(Math.abs(joy) < 0.05)
            return 0.0;
        else
            return joy;
    }
    
    /**
     * Used to return the toolPad's right joystick x-axis value 
     * 
     * @return Returns x-value from right joystick on the toolPad
     */
    public double getToolRightX()
    {
        double joy = toolPad.getRawAxis(GamepadConstants.RIGHT_ANALOG_X);
        if(Math.abs(joy) < 0.05)
            return 0.0;
        else
            return joy;
    }
    
    /**
     * Used to return the drivePad's left joystick x-axis value 
     * 
     * @return Returns x-value from left joystick on the drivePad
     */
    public double getDriveLeftX()
    {
        double joy = drivePad.getRawAxis(GamepadConstants.LEFT_ANALOG_X);
        if(Math.abs(joy) < 0.05)
            return 0.0;
        else
            return joy;
    }
    
    /**
     * Used to return the toolPad's left joystick x-axis value 
     * 
     * @return Returns x-value from left joystick on the toolPad
     */
    public double getToolLeftX()
    {
        double joy = toolPad.getRawAxis(GamepadConstants.LEFT_ANALOG_X);
        if(Math.abs(joy) < 0.05)
            return 0.0;
        else
            return joy;
    }

    public boolean getDriveDPadX() 
    {
    	return drivePad.getRawButton(GamepadConstants.DPAD_X);
    }
    
    public boolean getToolDPadX() 
    {
    	return toolPad.getRawButton(GamepadConstants.DPAD_X);
    }
    
    public boolean getDriveDPadY() 
    {
    	return drivePad.getRawButton(GamepadConstants.DPAD_Y);
    }
    
    public boolean getToolDPadY() 
    {
    	return toolPad.getRawButton(GamepadConstants.DPAD_Y);
    }
    
    /** 
     * @return Returns corresponding value (true or false) when button is pressed
     */
    public boolean getDriveRightTrigger()
    {
        return drivePad.getRawButton(GamepadConstants.RIGHT_TRIGGER);
    }
    
    /** 
     * @return Returns corresponding value (true or false) when button is pressed
     */
    public boolean getToolRightTrigger()
    {
        return toolPad.getRawButton(GamepadConstants.RIGHT_TRIGGER);
    }
    
    /** 
     * @return Returns corresponding value (true or false) when button is pressed
     */
    public boolean getDriveLeftTrigger()
    {
        return drivePad.getRawButton(GamepadConstants.LEFT_TRIGGER);
    }
    
    /** 
     * @return Returns corresponding value (true or false) when button is pressed
     */
    public boolean getToolLeftTrigger()
    {
        return toolPad.getRawButton(GamepadConstants.LEFT_TRIGGER);
    }
    
    /** 
     * @return Returns corresponding value (true or false) when button is pressed
     */
    public boolean getDriveLeftBumper()
    {
        return drivePad.getRawButton(GamepadConstants.LEFT_BUMPER);
    }
    
    /** 
     * @return Returns corresponding value (true or false) when button is pressed
     */
    public boolean getToolLeftBumper()
    {
        return toolPad.getRawButton(GamepadConstants.LEFT_BUMPER);
    }
    
    /** 
     * @return Returns corresponding value (true or false) when button is pressed
     */
    public boolean getDriveRightBumper()
    {
        return drivePad.getRawButton(GamepadConstants.RIGHT_BUMPER);
    }
    
    /** 
     * @return Returns corresponding value (true or false) when button is pressed
     */
    public boolean getToolRightBumper()
    {
        return toolPad.getRawButton(GamepadConstants.RIGHT_BUMPER);
    }
    
    /** 
     * @return Returns corresponding value (true or false) when button is pressed
     */
    public boolean getToolXButton()
    {
        return toolPad.getRawButton(GamepadConstants.X_BUTTON);
    }
    
    /** 
     * @return Returns corresponding value (true or false) when button is pressed
     */
    public boolean getToolAButton()
    {
        return toolPad.getRawButton(GamepadConstants.A_BUTTON);
    }
    
    /** 
     * @return Returns corresponding value (true or false) when button is pressed
     */
    public boolean getToolBButton()
    {
        return toolPad.getRawButton(GamepadConstants.B_BUTTON);
    }
    
    /** 
     * @return Returns corresponding value (true or false) when button is pressed
     */
    public boolean getToolYButton()
    {
        return toolPad.getRawButton(GamepadConstants.Y_BUTTON);
    }

    /** 
     * @return Returns corresponding value (true or false) when button is pressed
     */
    public boolean getDriveXButton()
    {
        return drivePad.getRawButton(GamepadConstants.X_BUTTON);
    }
    
    /** 
     * @return Returns corresponding value (true or false) when button is pressed
     */
    public boolean getDriveAButton()
    {
        return drivePad.getRawButton(GamepadConstants.A_BUTTON);
    }
    
    /** 
     * @return Returns corresponding value (true or false) when button is pressed
     */
    public boolean getDriveBButton()
    {
        return drivePad.getRawButton(GamepadConstants.B_BUTTON);
    }
    
    /** 
     * @return Returns corresponding value (true or false) when button is pressed
     */
    public boolean getDriveYButton()
    {
        return drivePad.getRawButton(GamepadConstants.Y_BUTTON);
    }
    
    /** 
     * @return Returns corresponding value (true or false) when button is pressed
     */
    public boolean getToolStartButton()
    {
        return toolPad.getRawButton(GamepadConstants.START_BUTTON);
    }
    
    /** 
     * @return Returns corresponding value (true or false) when button is pressed
     */
    public boolean getToolBackButton()
    {
        return toolPad.getRawButton(GamepadConstants.BACK_BUTTON);
    }
    
    /** 
     * @return Returns corresponding value (true or false) when button is pressed
     */
    public boolean getToolLeftButton()
    {
        return toolPad.getRawButton(GamepadConstants.LEFT_ANALOG_BUTTON);
    }
    
    /** 
     * @return Returns corresponding value (true or false) when button is pressed
     */
    public boolean getToolRightButton()
    {
        return toolPad.getRawButton(GamepadConstants.RIGHT_ANALOG_BUTTON);
    }
}
