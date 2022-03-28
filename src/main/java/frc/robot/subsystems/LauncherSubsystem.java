// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


//import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

//import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;
//Camera IMport
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;

public class LauncherSubsystem extends SubsystemBase {
  /** Creates a new LauncherSubsystem. */
  
  //private final MotorController m_subMotor = new WPI_VictorSPX(15);
  private final WPI_TalonSRX m_subMotor = new WPI_TalonSRX(Constants.launchSubMotorId);
  
  public LauncherSubsystem() {
  //HighCamera
  final UsbCamera visionCamera = CameraServer.startAutomaticCapture(1);
    visionCamera.setFPS(15);
    visionCamera.setResolution(300,220);
    visionCamera.setBrightness(50);
    CvSink cvSink = CameraServer.getVideo();
    CvSource outputStream = CameraServer.putVideo("HighCamera", 640, 480);
  }
    @Override

  public void periodic() {
    // This method will be called once per scheduler run
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
