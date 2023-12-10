// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.TestMotor;

import static edu.wpi.first.wpilibj.XboxController.Button;
import static edu.wpi.first.wpilibj.Joystick.ButtonType;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.BangBangCommand;
import frc.robot.commands.DefaultDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.WPILibVersion;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import java.util.function.DoubleSupplier;

import frc.robot.Constants.OIConstants;

import java.util.function.DoubleSupplier;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain m_drive = new DriveTrain();
  private final ExampleCommand m_autoCommand = new ExampleCommand();
  private final CommandXboxController m_controller;
  private final Elevator m_elevator = new Elevator();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_controller =  new CommandXboxController(OIConstants.kDriverControllerPortDrive);
  
    configureButtonBindings();

    m_drive.setDefaultCommand(new DefaultDrive(m_drive,
    () -> m_controller.getLeftX(),
    () -> m_controller.getLeftY(),
    () -> m_controller.getRightX()));
    //m_drive.setDefaultCommand(new TestMotor(m_drive));
    
    m_elevator.setDefaultCommand(new RunCommand(
    () -> {
      m_elevator.lift(m_controller.getRightTriggerAxis() - m_controller.getLeftTriggerAxis());
      
    }, 
    m_elevator));

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

   public void drive() {
    m_drive.drive(m_controller.getLeftX(),-m_controller.getLeftY(),m_controller.getRightX());
  } 

  private void configureButtonBindings() {
    
    m_controller.povLeft().whileTrue(m_elevator.leftIn());
    m_controller.povRight().whileTrue(m_elevator.leftOut());
    m_controller.x().whileTrue(m_elevator.rightIn());
    m_controller.b().whileTrue(m_elevator.rightOut());

    m_controller.y().onTrue(new InstantCommand(
      () -> m_elevator.increasePoint()
    ).andThen(
      new BangBangCommand(m_elevator)
    ));

    m_controller.a().onTrue(new InstantCommand(
      () -> m_elevator.decreasePoint()
    ).andThen(
      new BangBangCommand(m_elevator)
    ));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
