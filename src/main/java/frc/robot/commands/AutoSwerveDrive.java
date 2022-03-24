// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

//import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SwerveDrivetrain;

import frc.robot.Constants;


public class AutoSwerveDrive extends CommandBase {
  /** Creates a new AutoServeDrive. */
  

  private final SwerveDrivetrain m_swerveDrivetrain;
  private final double m_speed;

  public AutoSwerveDrive(final SwerveDrivetrain swerveDrivetrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    this(swerveDrivetrain, Constants.DEFAULT_SPEED);
  }

  /**
     * Must always be composed into a parallel race group with a timeout.
     * 
     * @param driveSubsystem the required DriveSubsystem
     * @param speed the speed in clicks per second (?)
     */
  public AutoSwerveDrive(final SwerveDrivetrain swerveDrivetrain, final double speed) {
      this.m_swerveDrivetrain = swerveDrivetrain;
      this.m_speed = speed;
      addRequirements(this.m_swerveDrivetrain);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_swerveDrivetrain.drive(0, m_speed, 0, false, false);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_swerveDrivetrain.drive(0, 0, 0, false, false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
