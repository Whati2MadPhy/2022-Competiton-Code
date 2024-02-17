// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.math.util.Units;

//exqmple comment

/** Add your docs here. */
public final class Constants {
    //swerve can ids 
    public static final int frontLeftDriveId = 8; 
    public static final int frontLeftCANCoderId = 6; 
    public static final int frontLeftSteerId = 7;
  
    public static final int frontRightDriveId = 14; 
    public static final int frontRightCANCoderId = 3; 
    public static final int frontRightSteerId = 13; 
 
    public static final int backLeftDriveId = 10; 
    public static final int backLeftCANCoderId = 5; 
    public static final int backLeftSteerId = 9;    

    public static final int backRightDriveId = 12; 
    public static final int backRightCANCoderId = 4; 
    public static final int backRightSteerId = 11;   
    
    //other motor ids 
    public static final int launchSubMotorId = 15;   
    public static final int pickupMotorId = 16;   
    public static final int releaseMotorId = 17;   
    public static final int launchMainMotorId = 18;   
    
    //offsets 
    public static double frontLeftOffset = 225.0;
    public static double frontRightOffset = 320.0;
    public static double backLeftOffset = 320.0;
    public static double backRightOffset = 255.0;

    //controllers nums
    public static final int driveControllerId = 0;   
    public static final int secondaryControllerId = 1;
    
    //button nums 
        //TODO find these 
    //dead zone 
    public static final double DEAD_ZONE = 0.054321; 

    //max speeds
    public static final double DEFAULT_SPEED = 1000.0;
    public static final double MAX_SPEED = Units.feetToMeters(3.6); // 1 feet per second
    public static final double MAX_ANGLE_SPEED = Math.PI; // 1/2 rotation per second
    public static double FEILD_CALIBRATION = 0;
 
    //tics per rotation 
    //private static double CANcoderTicksPerRotation = 4096;

}
