package frc.robot.commands;

import frc.robot.subsystems.Turret;
import frc.robot.subsystems.FlyWheel;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class Fire extends Command {
    private final Intake m_Intake;
    private final FlyWheel m_FlyWheel;
    private double m_vel;

    public Fire(Intake subsystem, FlyWheel subsystem2, double vel) {
        m_Intake = subsystem;
        m_FlyWheel = subsystem2;

        m_vel = vel;
        addRequirements(m_Intake);
    }

          // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Intake.Intake();
    m_FlyWheel.runIndexer();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Intake.StopIntake();
    m_FlyWheel.stopIndexer();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
