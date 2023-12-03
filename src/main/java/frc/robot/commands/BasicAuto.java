package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.subsystems.DriveTrain;

public class BasicAuto extends SequentialCommandGroup {
    DriveTrain m_drive;

    public BasicAuto(DriveTrain drive) {
        m_drive = drive;
        addCommands(
            
        );
    }
}
