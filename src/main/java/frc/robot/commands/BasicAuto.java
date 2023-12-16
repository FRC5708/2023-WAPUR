package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class BasicAuto extends CommandBase {
    private DriveTrain m_drive;
    private double startTime;

    public BasicAuto(DriveTrain drive) {
        addRequirements(drive);
        m_drive = drive;
        startTime = 0;
        System.out.println("command born");
    }

    @Override
    public void initialize() {
        startTime = java.lang.System.currentTimeMillis();
        System.out.println("command initialized");
    }

    @Override
    public void execute() {
        m_drive.drive(0,.4,0);
        System.out.println("executing");
    }

    @Override
    public boolean isFinished() {
        double diff = Math.abs(startTime - java.lang.System.currentTimeMillis());
        if ( diff > 3000){
            System.out.println("command finished");
            m_drive.drive(0.0,0,0);
            return true;
        }
        else{
            return false;
        }
    }
}
