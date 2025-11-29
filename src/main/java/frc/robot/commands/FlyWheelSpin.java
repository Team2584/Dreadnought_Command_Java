package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Turret;
import frc.robot.subsystems.FlyWheel;
import frc.robot.RobotContainer;

public class FlyWheelSpin extends Command {
    private final FlyWheel m_flyWheel;
    private double m_vel;

    public FlyWheelSpin(FlyWheel subsystem, double vel){
        m_flyWheel = subsystem;
        m_vel = vel;
        addRequirements(m_flyWheel);
    }

      // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_flyWheel.setFly(m_vel);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //m_flyWheel.StopFly();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
    
}
