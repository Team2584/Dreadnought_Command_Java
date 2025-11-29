// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants.IntakeConstants;


import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.*;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Intake extends SubsystemBase {

  private final VictorSPX m_Intake1 = new VictorSPX(IntakeConstants.kIntake1);
  private final VictorSPX m_Intake2 = new VictorSPX(IntakeConstants.kIntake2);

  /** Creates a new ExampleSubsystem. */
  public Intake() {
    m_Intake2.setInverted(true);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command Intake() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          m_Intake1.set(VictorSPXControlMode.PercentOutput, 0.80);
          m_Intake2.set(VictorSPXControlMode.PercentOutput, 0.60);
        });
  }

  public Command Outtake() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          m_Intake1.set(VictorSPXControlMode.PercentOutput, -0.80);
          m_Intake2.set(VictorSPXControlMode.PercentOutput, -0.80);
        });
  }

    public Command StopIntake() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          m_Intake1.set(VictorSPXControlMode.PercentOutput, 0);
          m_Intake2.set(VictorSPXControlMode.PercentOutput, 0);
        });
  }

  public void runIntake(double dir){
    m_Intake1.set(VictorSPXControlMode.PercentOutput, 0.80*dir);
    m_Intake2.set(VictorSPXControlMode.PercentOutput, 0.60*dir);
  }

  public void stop(){
    m_Intake1.set(VictorSPXControlMode.PercentOutput, 0);
    m_Intake2.set(VictorSPXControlMode.PercentOutput, 0);
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
