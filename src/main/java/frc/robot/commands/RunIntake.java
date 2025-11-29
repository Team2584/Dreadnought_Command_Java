package frc.robot.commands;

import frc.robot.subsystems.Turret;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;

public class RunIntake extends Command {
    private final Intake m_Intake;

    private double m_dir;

    public RunIntake(Intake subsystem, double dir) {
        m_Intake = subsystem;
        m_dir = dir;
        addRequirements(m_Intake);
    }

          // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Intake.runIntake(m_dir);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Intake.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
