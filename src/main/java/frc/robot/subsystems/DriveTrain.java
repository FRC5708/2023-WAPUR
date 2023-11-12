package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.*;

import frc.robot.Constants.DriveConstants;
import frc.robot.RobotContainer;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.MecanumDriveOdometry;
import edu.wpi.first.wpilibj.SPI;
import com.kauailabs.navx.frc.AHRS;


import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.MecanumDriveKinematics;
import edu.wpi.first.math.kinematics.MecanumDriveOdometry;
//import edu.wpi.first.math.kinematics.MecanumDriveWheelPositions;
import edu.wpi.first.math.kinematics.MecanumDriveWheelSpeeds;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;




public class DriveTrain extends SubsystemBase {
    //Left side motors
    private TalonFX m_frontLeftMotor = new TalonFX(DriveConstants.kLeftMotor1Port);
    private TalonFX m_rearLeftMotor = new TalonFX(DriveConstants.kLeftMotor2Port);

    // Right side motors
    private TalonFX m_frontRightMotor = new TalonFX(DriveConstants.kRightMotor1Port);
    private TalonFX m_rearRightMotor = new TalonFX(DriveConstants.kRightMotor2Port);

    private final MecanumDrive m_drive = new MecanumDrive(m_frontLeftMotor,m_rearLeftMotor,m_frontRightMotor,m_rearRightMotor);
    
    private final Translation2d m_frontLeftLocation = new Translation2d(DriveConstants.frontLeftLocation[0],DriveConstants.frontLeftLocation[1]);
    private final Translation2d m_frontRightLocation = new Translation2d(DriveConstants.frontRightLocation[0],DriveConstants.frontRightLocation[1]);
    private final Translation2d m_rearLeftLocation = new Translation2d(DriveConstants.rearLeftLocation[0],DriveConstants.rearLeftLocation[1]);
    private final Translation2d m_rearRightLocation = new Translation2d(DriveConstants.rearRightLocation[0],DriveConstants.rearRightLocation[1]);

    private final Encoder m_frontLeftEncoder = new Encoder(DriveConstants.frontLeftEncoderChannels[0],DriveConstants.frontLeftEncoderChannels[1]);
    private final Encoder m_frontRightEncoder = new Encoder(DriveConstants.frontRightEncoderChannels[0], DriveConstants.frontRightEncoderChannels[1]);
    private final Encoder m_rearLeftEncoder = new Encoder(DriveConstants.rearLeftEncoderChannels[0], DriveConstants.rearLeftEncoderChannels[1]);
    private final Encoder m_rearRightEncoder = new Encoder(DriveConstants.rearRightEncoderChannels[0], DriveConstants.rearRightEncoderChannels[1]);

    private final AnalogGyro m_gyro = new AnalogGyro(0);

    public DriveTrain() {
        m_gyro.reset();

        m_frontRightMotor.setInverted(true);
        m_rearRightMotor.setInverted(true);

        m_drive.setMaxOutput(DriveConstants.driveSpeed);
      }

    public void drive(double xSpeed, double ySpeed, double zRot) {
        m_drive.driveCartesian(ySpeed,xSpeed,zRot);
    }
/* 
    private final MecanumDriveKinematics m_kinematics =
      new MecanumDriveKinematics(
          m_frontLeftLocation, m_frontRightLocation, m_rearLeftLocation, m_rearRightLocation);

    private MecanumDriveOdometry m_odometry = new MecanumDriveOdometry(m_kinematics, m_gyro.getRotation2d(), getCurrentDistances());

    public MecanumDriveWheelPositions getCurrentDistances() {
        return new MecanumDriveWheelPositions(
            m_frontLeftEncoder.getDistance(),
            m_frontRightEncoder.getDistance(),
            m_rearLeftEncoder.getDistance(),
            m_rearRightEncoder.getDistance());
      }
*/
}
