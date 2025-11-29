// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants.FlyConstants;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.*;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class FlyWheel extends SubsystemBase {
  private final CANSparkMax m_fly1 = new CANSparkMax(FlyConstants.kUpperFly, MotorType.kBrushless);
  private final CANSparkMax m_fly2 = new CANSparkMax(FlyConstants.kLowerFly, MotorType.kBrushless);
  private final VictorSPX m_upperIndex = new VictorSPX(FlyConstants.kUpperIndex);

  /** Creates a new ExampleSubsystem. */
  public FlyWheel() {

    m_fly1.setInverted(true);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command FlyWheelCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
          m_fly1.set(0.2);
          m_fly2.set(0.2);
          m_upperIndex.set(VictorSPXControlMode.PercentOutput, 0.35);
        });
  }

  public Command FlyWheel50() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
          m_fly1.set(0.5);
          m_fly2.set(0.5);
          m_upperIndex.set(VictorSPXControlMode.PercentOutput, 0.35);
        });
  }

    public Command FlyWheel80() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
          m_fly1.set(0.8);
          m_fly2.set(0.8);
          m_upperIndex.set(VictorSPXControlMode.PercentOutput, 0.35);
        });
  }

  public void setFly(double vel){
    m_fly1.set(vel);
    m_fly2.set(vel);
  }

  public void runIndexer(){
    m_upperIndex.set(VictorSPXControlMode.PercentOutput,0.35);
  }

  public void stopIndexer(){
    m_upperIndex.set(VictorSPXControlMode.PercentOutput, 0);
  }

  public Command StopFly(){
    return runOnce(()-> {m_fly1.set(0); m_fly2.set(0); m_upperIndex.set(VictorSPXControlMode.PercentOutput, 0.0);} );
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean FlyWheelCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
