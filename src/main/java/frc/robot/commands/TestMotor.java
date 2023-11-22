package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TestMotor extends CommandBase {
    private DriveTrain m_drive;

    public TestMotor(DriveTrain drive) {
        m_drive = drive;
        addRequirements(m_drive);
    }

    public void execute() {
        double speed = SmartDashboard.getNumber("motor speed", 0);
        int motor = (int)SmartDashboard.getNumber("motor number", 0);
        m_drive.oneMotor(speed,motor);
    }
}