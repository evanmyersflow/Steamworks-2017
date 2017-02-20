package org.usfirst.frc.team2521.robot.commands.groups;

import org.usfirst.frc.team2521.robot.commands.automation.DriveToBoiler;
import org.usfirst.frc.team2521.robot.commands.automation.TurnToBoiler;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * This command turns until the boiler is centered for the camera,
 * drives to a specified distance, and then runs the shooter.
 */
public class AlignShooter extends CommandGroup {
	public AlignShooter() {
		addSequential(new DriveToBoiler(false));
		addSequential(new TurnToBoiler());
		addSequential(new RunShooterSubsystems());
	}
}
