package org.usfirst.frc.team2521.robot.commands.base;

import org.usfirst.frc.team2521.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command displays sensor information on the SmartDashboard.
 */
public class DisplaySensors extends Command {
	public DisplaySensors() {
		requires(Robot.sensors);
	}

	@Override
	protected void execute() {
		Robot.sensors.display();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
