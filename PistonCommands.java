package com.team1241.frc2018.commands;

import edu.wpi.first.wpilibj.command.Command;
import com.team1241.frc2018.Robot;

/**
 *
 */
public class PistonCommands extends Command {
	boolean state;
    public PistonCommands(boolean state) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.state=state;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//based on input it extends or retracts piston
    	if(state)
    	{
    		Robot.climb.extendPiston();
    	}
    	else
    	{
    		Robot.climb.retractPiston();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
