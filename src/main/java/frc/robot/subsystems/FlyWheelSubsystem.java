// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FlyWheelSubsystem extends SubsystemBase {
  
  private final WPI_TalonSRX m_mainMotor = new WPI_TalonSRX(Constants.launchMainMotorId);
  
  /** Creates a new FlyWheelSubsystem. */
  public FlyWheelSubsystem() {
    m_mainMotor.configFactoryDefault();
    m_mainMotor.configPeakCurrentLimit(10);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }




  //toggle main wheel
  public void spinMain(double speed){
    m_mainMotor.set(-speed);
  }
  public void stopMain(){
    m_mainMotor.set(0.0);
    m_mainMotor.stopMotor(); // Extra safe
  }

}
