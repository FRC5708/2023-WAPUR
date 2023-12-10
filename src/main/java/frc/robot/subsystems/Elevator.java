package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalOutput;

import frc.robot.Constants.ElevatorConstants;


public class Elevator extends SubsystemBase {
    private VictorSPX rightPokeyMotor = new VictorSPX(ElevatorConstants.kRightPokeyMotorID);
    private VictorSPX leftPokeyMotor = new VictorSPX(ElevatorConstants.kLeftPokeyMotorID);
    private VictorSPX pulley = new VictorSPX(ElevatorConstants.kPulleyMotorID);

    private AnalogInput distanceSensor = new AnalogInput(ElevatorConstants.kDistanceSensorPort);

    boolean leftPokey = false;
    boolean rightPokey = false;

    int setpointPos = 0;



    public Elevator() {
        SmartDashboard.putNumber("distance sensor", getDistance());
    }

    public void lift(double liftSpeed) {
        SmartDashboard.putNumber("distance sensor", getDistance());
        pulley.set(VictorSPXControlMode.PercentOutput,liftSpeed);
    }

    public StartEndCommand leftOut() {
        
        return new StartEndCommand(
            () -> leftPokeyMotor.set(VictorSPXControlMode.PercentOutput, -ElevatorConstants.kPokeySpeed),
            () -> leftPokeyMotor.set(VictorSPXControlMode.PercentOutput, 0),
            this);
    }

    public StartEndCommand leftIn() {
        
        return new StartEndCommand(
            () -> leftPokeyMotor.set(VictorSPXControlMode.PercentOutput, ElevatorConstants.kPokeySpeed),
            () -> leftPokeyMotor.set(VictorSPXControlMode.PercentOutput, 0),
            this);
    }

    public StartEndCommand rightOut() {
        
        return new StartEndCommand(
            () -> rightPokeyMotor.set(VictorSPXControlMode.PercentOutput, -ElevatorConstants.kPokeySpeed),
            () -> rightPokeyMotor.set(VictorSPXControlMode.PercentOutput, 0),
            this);
    }

    public StartEndCommand rightIn() {
        
        return new StartEndCommand(
            () -> rightPokeyMotor.set(VictorSPXControlMode.PercentOutput, ElevatorConstants.kPokeySpeed),
            () -> rightPokeyMotor.set(VictorSPXControlMode.PercentOutput, 0),
            this);
    }

    public double getPoint() {
        return ElevatorConstants.setPoints[setpointPos];
    }

    public void increasePoint() {
        if(setpointPos + 1 < ElevatorConstants.setPoints.length) {
        setpointPos++;
        }
    }

    public void decreasePoint() {
        if(setpointPos > 0) {
        setpointPos--;
        }
    }

    public double getDistance() {
        return distanceSensor.getVoltage();
    }

}
