package com.team1241.frc2018.commands;
import com.team1241.frc2018.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WinchCommand extends Command {
	double direction;
    public WinchCommand(double direction) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	//gets the direction of power
    	this.direction=direction;
    	requires(Robot.climb);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//runs winch based on direction variable
    	Robot.climb.runClimberWinch(direction);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//when ends stops the winch climb method
    	Robot.climb.runClimberWinch(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//when interrupted stops the winch climb method
    	Robot.climb.runClimberWinch(0);
    }
}
