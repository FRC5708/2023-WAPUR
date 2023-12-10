// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  //all units should be SI (cm) and use radians. Coords using NWU.
  public static final class DriveConstants {
    public static final int kFrontLeftMotorID = 5;
    public static final int kFrontRightMotorID = 6;
    public static final int kRearLeftMotorID = 7;
    public static final int kRearRightMotorID = 8;
    //public static final int kLiftMotorID = 1;
    //public static final int kRightArmMotorID = 2;
    //public static final int kLeftArmMotorID = 3;


    public static final double driveSpeed = 0.5;
    public static final double xSlewRate = 0.9;
    public static final double ySlewRate = 0.9;
    public static final double rotSlewRate = 0.9;



    public static final int kEncoderCPR = 1024;
    public static final double kWheelDiameterInches = 6;
    public static final double kEncoderDistancePerPulse =
        // Assumes the encoders are directly mounted on the wheel shafts
        (kWheelDiameterInches * Math.PI) / (double) kEncoderCPR;
  }

  public static final class ElevatorConstants {
    public static final int kRightPokeyMotorID = 2;
    public static final int kLeftPokeyMotorID = 3;
    public static final int kPulleyMotorID = 1;
    public static final int kLaserEyePort = 0;
  }

  public static final class AutoConstants {
    public static final double kAutoDriveDistanceInches = 60;
    public static final double kAutoBackupDistanceInches = 20;
    public static final double kAutoDriveSpeed = 0.5;
  }

  public static final class OIConstants {
    public static final int kDriverControllerPortDrive = 0;
  }
}