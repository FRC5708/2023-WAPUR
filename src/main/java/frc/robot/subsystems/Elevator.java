package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;

import frc.robot.Constants.ElevatorConstants;


public class Elevator extends SubsystemBase {
    private VictorSPX rightPokey = new VictorSPX(ElevatorConstants.kRightPokeyMotorID);
    private VictorSPX leftPokey = new VictorSPX(ElevatorConstants.kLeftPokeyMotorID);
    private VictorSPX pulley = new VictorSPX(ElevatorConstants.kPulleyMotorID);

    private DigitalInput laserEye = new DigitalInput(ElevatorConstants.kLaserEyePort);

    public Elevator() {

    }
}
