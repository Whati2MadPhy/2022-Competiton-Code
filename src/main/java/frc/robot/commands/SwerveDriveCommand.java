package frc.robot.commands;

//import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.SwerveDrivetrain;
import frc.robot.subsystems.SwerveModuleMK3;

import frc.robot.Constants;

public class SwerveDriveCommand extends CommandBase {

  private RobotContainer m_robotContainer; 
  private final SwerveDrivetrain drivetrain;
  private final XboxController controller;

  // Slew rate limiters to make joystick inputs more gentle; 1/3 sec from 0 to 1.
  private final SlewRateLimiter xspeedLimiter = new SlewRateLimiter(0.1);
  private final SlewRateLimiter yspeedLimiter = new SlewRateLimiter(0.1);
  private final SlewRateLimiter rotLimiter = new SlewRateLimiter(0.1);

  public SwerveDriveCommand(SwerveDrivetrain drivetrain, XboxController controller) {
    this.drivetrain = drivetrain;
    addRequirements(drivetrain);

    this.controller = controller;
  }

  @Override
  public void execute() {
    // Get the x speed. We are inverting this because Xbox controllers return
    // negative values when we push forward.
    /*
    final var xSpeed =
      -xspeedLimiter.calculate(m_robotContainer.getLeftXPower())
        * Constants.MAX_SPEED;
*/
      final var xSpeed =
      -xspeedLimiter.calculate(controller.getRawAxis(1))
        * SwerveDrivetrain.kMaxSpeed;


        //getLeftY returns drive power
        //use get drive powerr bbut for getLeftY instead of drive power 
        // test numbers 
        // same for x and rot 
    

    // Get the y speed or sideways/strafe speed. We are inverting this because
    // we want a positive value when we pull to the left. Xbox controllers
    // return positive values when you pull to the right by default.
    /*
    final var ySpeed =
      -yspeedLimiter.calculate(m_robotContainer.getLeftXPower())
        * Constants.MAX_SPEED;
    */
    final var ySpeed =
      -yspeedLimiter.calculate(controller.getRawAxis(0))
        * SwerveDrivetrain.kMaxSpeed;

    // Get the rate of angular rotation. We are inverting this because we want a
    // positive value when we pull to the left (remember, CCW is positive in
    // mathematics). Xbox controllers return positive values when you pull to
    // the right by default.
    final var rot =
      -rotLimiter.calculate(controller.getRawAxis(4))
        * Constants.MAX_ANGLE_SPEED;

    boolean calibrate = controller.getLeftBumper();

    drivetrain.drive(xSpeed, ySpeed, rot, false, calibrate);
    
  }

}
