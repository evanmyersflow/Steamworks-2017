package org.usfirst.frc.team2521.robot.commands.base;

import org.usfirst.frc.team2521.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This command spins up the flywheel and attempts to maintain a constant speed.
 */
public class RunShooter extends PIDCommand {
	private static final double P = 0.007;
	private static final double I = 0;
	private static final double D = 0;

	private static final int SETPOINT = -290;

	public RunShooter() {
		super(P, I, D);

		requires(Robot.shooter);
	}

	@Override
	public void initialize() {
		setSetpoint(SETPOINT);
	}

	@Override
	public void execute() {
		if (Robot.DEBUG) {
			SmartDashboard.putNumber("Encoder velocity", Robot.shooter.getEncVelocity());
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.shooter.setMotor(0);
	}

	@Override
	protected double returnPIDInput() {
		return Robot.shooter.getEncVelocity();
	}

	@Override
	protected void usePIDOutput(double output) {
		Robot.shooter.setMotor(-output);
	}
}
