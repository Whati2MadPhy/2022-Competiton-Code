// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.SwerveDriveCommand;
import frc.robot.subsystems.SwerveDrivetrain;

// import controrller 
import edu.wpi.first.wpilibj.GenericHID;

import javax.print.attribute.standard.Finishings;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


// import commands 

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.commands.Launch;
import frc.robot.commands.PullupOverhang;
import frc.robot.commands.ReleaseOverhang;
import frc.robot.commands.RunPickup;
import frc.robot.commands.SpinLauncher;
import frc.robot.commands.SwerveDriveCommand;

// import subsystems 
import frc.robot.subsystems.LauncherSubsystem;
import frc.robot.subsystems.PickupSubsystem;
import frc.robot.subsystems.SwerveDrivetrain;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
//deadzone 
  public static final double DEAD_ZONE = 0.054321; // used to be 0.1

//crrerate subsysterms
  private final LauncherSubsystem m_launcherSubsystem = new LauncherSubsystem();
  private final PickupSubsystem m_pickupSubsystem = new PickupSubsystem();
  private final SwerveDrivetrain drivetrain = new SwerveDrivetrain();


//create controllers 
  private final XboxController controller = new XboxController(0);
  
  //thoughts: a  drive controller is already set in drive command so i could just leave that alone and only use secondary here? 

// set default command 
/** The container for the robot. Contains subsystems, OI devices, and commands. */
public RobotContainer() {
}

// new buttons for commands  
private void configureButtonBindings()
{
  drivetrain.setDefaultCommand(new SwerveDriveCommand(drivetrain, controller));

  new JoystickButton(controller, Button.kA.value).whileHeld(new RunPickup(m_pickupSubsystem));
  new JoystickButton(controller, Button.kY.value).whileHeld(new Launch(m_launcherSubsystem));
  new JoystickButton(controller, Button.kX.value).toggleWhenActive(new SpinLauncher(m_launcherSubsystem));
}

//get autonomous 
// test auto

//get drive power
//get curve power 
//get second controrlelr josticks  

//clear gyro 

// pneumatics 

}
