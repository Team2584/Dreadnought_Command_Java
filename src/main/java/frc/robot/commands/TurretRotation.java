package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Turret;
import frc.robot.RobotContainer;

public class TurretRotation extends Command {
  private final Turret m_turret;
  private double m_vel;

  public TurretRotation(Turret subsystem, double vel){
    m_turret = subsystem;
    m_vel = vel;

    addRequirements(m_turret);

}


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_turret.setTurretRotation(m_vel);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_turret.setTurretRotation(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}