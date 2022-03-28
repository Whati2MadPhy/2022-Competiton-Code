// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PickupSubsystem;

public class RunPickup extends CommandBase {
  final PickupSubsystem m_pickupSubsystem;
  /** Creates a new DropOverhang. */
  public RunPickup(PickupSubsystem pickupSubsystem) {
    m_pickupSubsystem = pickupSubsystem;
    addRequirements(pickupSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_pickupSubsystem.spinPickup(.70);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_pickupSubsystem.stopPickup();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
