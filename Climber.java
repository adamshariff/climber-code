package com.team1241.frc2018.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.team1241.frc2018.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;



/**
 *
 */
public class Climber extends Subsystem {

    //Declares components
	WPI_TalonSRX climberArm,climberWinch;
	DoubleSolenoid piston;

	public Climber()
	{
		//Initializes objects used
		climberArm=new WPI_TalonSRX(RobotMap.CLIMBER_ARM);
		climberWinch=new WPI_TalonSRX(RobotMap.CLIMBER_WINCH);
		piston = new DoubleSolenoid(RobotMap.SOLENOID_A,RobotMap.SOLENOID_B);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    //method raises or lowers the climber arm
    public void runClimberArm(double pwmVal)
    {
    	climberArm.set(pwmVal);
    }
    
    //Extends or retracts pistons for detaching the arm
    public void extendPiston()
    {
    	piston.set(DoubleSolenoid.Value.kForward);
    }
    public void retractPiston()
    {
    	piston.set(DoubleSolenoid.Value.kReverse);
    }
    
    //Runs the winch to lift the robot
    public void runClimberWinch(double pwmVal)
    {
    	climberWinch.set(pwmVal);
    }
}

