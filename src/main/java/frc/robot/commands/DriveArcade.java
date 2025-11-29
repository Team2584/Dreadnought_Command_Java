// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.Constants;
import frc.robot.Robot;


/** An example DriveArcade that uses the Drivetrain subsystem. */
public class DriveArcade extends Command {

    /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */

  public DriveArcade() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double moveSpeed = -RobotContainer.m_driverController.getLeftY();
    double rotateSpeed = RobotContainer.m_driverController.getRightX();
    //RobotContainer.m_drivetrain.arcadeDrive(moveSpeed, rotateSpeed);
  }

  @Override
  public void end(boolean interrupted){
    //RobotContainer.m_drivetrain.arcadeDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  
}
