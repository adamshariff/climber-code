package com.team1241.frc2018.commands;
import com.team1241.frc2018.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class ClimberCommand extends Command {
	double direction;
    public ClimberCommand(double direction) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//initializes direction
    	this.direction=direction;
    	requires(Robot.climb);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.climb.runClimberArm(direction);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Stops the motor in the end
    	Robot.climb.runClimberArm(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//if interrupted stops the climber arm
    	Robot.climb.runClimberArm(0);
    }
}
