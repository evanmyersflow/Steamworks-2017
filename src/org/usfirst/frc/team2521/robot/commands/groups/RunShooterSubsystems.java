package org.usfirst.frc.team2521.robot.commands.groups;

import org.usfirst.frc.team2521.robot.Robot;
import org.usfirst.frc.team2521.robot.commands.base.RunAgitator;
import org.usfirst.frc.team2521.robot.commands.base.RunFeeder;
import org.usfirst.frc.team2521.robot.commands.base.RunShooter;
import org.usfirst.frc.team2521.robot.subsystems.Feeder;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * This command runs the agitator and the shooter immediately, then
 * starts the feeder once the shooter is up to speed.
 */
public class RunShooterSubsystems extends CommandGroup {
	private static final double SPEED_CUTOFF = -200;

	private boolean upToSpeed = false;

	public RunShooterSubsystems() {
		addParallel(new RunAgitator(true));
		addParallel(new RunShooter());
		addSequential(new RunFeeder() {
			@Override
			protected void execute() {
				if (Robot.shooter.getEncVelocity() < SPEED_CUTOFF || upToSpeed) {
					upToSpeed = true;
					Robot.feeder.setMotor(-Feeder.FEEDER_SPEED);
				}
			}
		});
	}
}
