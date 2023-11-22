package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;

public class DefaultDrive extends CommandBase {
    private DriveTrain m_drive;
    private XboxController m_controller;

    public DefaultDrive(DriveTrain drive,XboxController controller) {
        m_drive = drive;
        m_controller = controller;
        addRequirements(m_drive);
    }

    public void execute() {
        m_drive.drive(m_controller.getLeftX(),m_controller.getLeftY(),m_controller.getRightX());
    }
}