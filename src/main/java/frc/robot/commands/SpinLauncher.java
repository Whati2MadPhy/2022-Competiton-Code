// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlyWheelSubsystem;

public class SpinLauncher extends CommandBase {
  final FlyWheelSubsystem m_flyWheelSubsystem;
  /** Creates a new SpinLauncher. */
  public SpinLauncher(FlyWheelSubsystem flyWheelSubsystem  ) {
    m_flyWheelSubsystem = flyWheelSubsystem;
    addRequirements(flyWheelSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //m_launcherSubsystem.spinMain(-1.0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_flyWheelSubsystem.spinMain(1.0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_flyWheelSubsystem.stopMain();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
