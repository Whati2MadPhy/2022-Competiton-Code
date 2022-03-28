// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.SwerveDriveCommand;
import frc.robot.subsystems.SwerveDrivetrain;

// import controrller 
//import edu.wpi.first.wpilibj.GenericHID;

//import javax.print.attribute.standard.Finishings;

//import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


// import commands 

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
//import edu.wpi.first.wpilibj2.command.CommandScheduler;
//import edu.wpi.first.wpilibj2.command.InstantCommand;
//import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutoSwerveDrive;
import frc.robot.commands.AutoSwerveTurn;
import frc.robot.commands.Launch;
import frc.robot.commands.PullupOverhang;
import frc.robot.commands.ReleaseOverhang;
import frc.robot.commands.RunPickup;
import frc.robot.commands.SpinLauncher;
//import frc.robot.commands.SwerveDriveCommand;
import frc.robot.subsystems.FlyWheelSubsystem;
// import subsystems 
import frc.robot.subsystems.LauncherSubsystem;
import frc.robot.subsystems.PickupSubsystem;
//import frc.robot.subsystems.SwerveDrivetrain;

import frc.robot.Constants;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  //private Constants constants;


//crrerate subsysterms

  private final FlyWheelSubsystem m_flyWheelSubsystem = new FlyWheelSubsystem();
  private final LauncherSubsystem m_launcherSubsystem = new LauncherSubsystem();
  private final PickupSubsystem m_pickupSubsystem = new PickupSubsystem();
  private final SwerveDrivetrain drivetrain = new SwerveDrivetrain();


//create controllers 
  private final XboxController controller = new XboxController(0);
  private final XboxController secondary = new XboxController(1);
  
  //thoughts: a  drive controller is already set in drive command so i could just leave that alone and only use secondary here? 

// set default command 
/** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    configureButtonBindings();
  }

  // new buttons for commands  
  //TODO check button numbers for this 
  private void configureButtonBindings()
  {
    drivetrain.setDefaultCommand(new SwerveDriveCommand(drivetrain, controller));

    //Button.kRightBumper.value
    new JoystickButton(controller, 6).whileHeld(new RunPickup(m_pickupSubsystem));
    new JoystickButton(secondary, 4).whileHeld(new ReleaseOverhang(m_pickupSubsystem));
    new JoystickButton(secondary, 1).whileHeld(new PullupOverhang(m_pickupSubsystem, .4));
  
    new JoystickButton(secondary, 5).whileHeld(new Launch(m_launcherSubsystem));
    new JoystickButton(secondary, 2).whileHeld(new SpinLauncher(m_flyWheelSubsystem));
  }

//get autonomous 
/**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return new AutoVeloDrive(m_driveSubsystem).withTimeout(3.0);
    return testAuto();
  }
// test auto
  public Command testAuto() {
    return new AutoSwerveDrive(drivetrain, -.08).withTimeout(1.8)
    //.andThen(new AutoVeloTurn(m_driveSubsystem, -300.0, -900.0, 90f))
    //.andThen(new AutoVeloDrive(m_driveSubsystem, -1000.0).withTimeout(2.5))
    //.andThen(new AutoVeloTurn(m_driveSubsystem, -900.0, -300.0, 90f))
    //.andThen(new AutoSwerveDrive(drivetrain, -.1).withTimeout(.8)
    
    .andThen(new WaitCommand(.50))
    .andThen(new ParallelCommandGroup(new SpinLauncher(m_flyWheelSubsystem).withTimeout(4.0),
                                      new SequentialCommandGroup(new WaitCommand(1.0), new Launch(m_launcherSubsystem).withTimeout(.5)) ))
    //.andThen(new SequentialCommandGroup(new SpinLauncher(m_launcherSubsystem).withTimeout(.5), new Launch(m_launcherSubsystem)))
    .andThen(new WaitCommand(.5))
    .andThen(new AutoSwerveTurn(drivetrain, .2).withTimeout(1.0))
    .andThen(new PullupOverhang(m_pickupSubsystem, .4).withTimeout(2.0));
    
    //.andThen(new AutoVeloDrive(m_driveSubsystem, 1000.0).withTimeout(1.5))
    //.andThen(new AutoVeloTurn(m_driveSubsystem, 900.0, 300.0, 90f))
    //.andThen(new AutoVeloDrive(m_driveSubsystem, 1000.0).withTimeout(2.5))
    //.andThen(new AutoVeloTurn(m_driveSubsystem, 300.0, 900.0, 90f))
    //.andThen(new AutoVeloDrive(m_driveSubsystem, 1000.0).withTimeout(1.5));
  }


//get drive power

  /**
	 * @return the drive power using cubed inputs.
	 */
  public double getLeftYPower() {
    double drivePower = -controller.getLeftY();
    if (Math.abs(drivePower) < Constants.DEAD_ZONE) { 
      drivePower = 0.0;
    }
    //might change 
    //return Math.pow((drivePower * 0.95) , 3.0); // 0.75 works
    //might be able to take off this math and just return power
    return drivePower; 
  }


  public double getLeftXPower() {
    double drivePower = -controller.getLeftX();
    if (Math.abs(drivePower) < Constants.DEAD_ZONE) { 
      drivePower = 0.0;
    }
    //might change 
    //return Math.pow((drivePower * 0.95) , 3.0); // 0.75 works
    //might be able to take off this math and just return power
    return drivePower; 
  }


//get curve power 

/**
	 * @return the drive power using inputs to the third.
	 */
	public double getCurvePower() {
		double curvePower = controller.getRawAxis(2);
		if (Math.abs(curvePower) < Constants.DEAD_ZONE) {
			curvePower = 0.0;
		}
		//return Math.pow((curvePower * 0.85) , 3.0); 
    //might be able to take off this math and just return power
    return curvePower;  
  }



//get second controrlelr josticks  

//clear gyro 

// pneumatics 

}