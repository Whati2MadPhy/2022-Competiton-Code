// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LauncherSubsystem extends SubsystemBase {
  /** Creates a new LauncherSubsystem. */
  
  private final MotorController m_mainMotor = new WPI_TalonSRX(0);
  private final MotorController m_subMotor = new WPI_VictorSPX(0);
  
  
  public LauncherSubsystem() {}

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

  //trigger control motor
  public void spinSub(double speed){
    m_subMotor.set(-speed);
  }
  public void stopSub(){
    m_subMotor.set(0.0);
    m_subMotor.stopMotor(); // Still extra safe
  }

  // aiming posibly?? 

  // cameras/rrrelfective tape identifyer  
}
