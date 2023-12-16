// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ElevatorConstants;
import frc.robot.subsystems.Elevator;

public class BangBangCommand extends CommandBase {
  /** Creates a new BangBangCommand. */
  private Elevator m_elevator;
  private double m_setPoint = 0;

  public BangBangCommand(Elevator elevator) {
    m_elevator = elevator;
    addRequirements(elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_setPoint = m_elevator.getPoint();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double motorPower = m_setPoint > m_elevator.getDistance() ? -ElevatorConstants.kBangBangSpeed : ElevatorConstants.kBangBangSpeed;
    m_elevator.lift(motorPower);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(m_setPoint - m_elevator.getDistance()) < 0.1;
  }
}
