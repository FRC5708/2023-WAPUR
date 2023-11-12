package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DefaultDrive extends CommandBase {
    private DriveTrain m_drive;;
    private double m_xSpeed;
    private double m_ySpeed;
    private double m_zRot;

    public DefaultDrive(DriveTrain drive, double x, double y, double z) {
        m_xSpeed = x;
        m_ySpeed = y;
        m_zRot = z;
        m_drive = drive;
        addRequirements(m_drive);
    }

    public void execute() {
        m_drive.drive(m_xSpeed,m_ySpeed,m_zRot);
    }
}