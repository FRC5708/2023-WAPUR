package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.function.DoubleSupplier;

public class DefaultDrive extends CommandBase {
    private DriveTrain m_drive;
    private XboxController m_controller;
    private DoubleSupplier m_xSpeed;
    private DoubleSupplier m_ySpeed;
    private DoubleSupplier m_rotation;

    public DefaultDrive(DriveTrain drive,DoubleSupplier xSpeed,DoubleSupplier ySpeed,DoubleSupplier rotation) {
        m_drive = drive;
        m_xSpeed = xSpeed;
        m_ySpeed = ySpeed;
        m_rotation = rotation;
        addRequirements(m_drive);
    }

    public void execute() {

        //m_xSpeed = SmartDashboard.getNumber("X",0);
        //m_ySpeed = SmartDashboard.getNumber("Y",0);
        //m_rotation = SmartDashboard.getNumber("rotation",0);

        m_drive.drive(m_xSpeed.getAsDouble(),m_ySpeed.getAsDouble(),m_rotation.getAsDouble());
    }
}