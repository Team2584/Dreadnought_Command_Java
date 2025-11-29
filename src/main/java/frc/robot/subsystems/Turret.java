package frc.robot.subsystems;

import static edu.wpi.first.wpilibj2.command.Commands.runOnce;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.*;

import frc.robot.Constants.TurretConstants;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Turret extends SubsystemBase {
    private final TalonSRX m_Turret;

    public Turret() {
      m_Turret = new TalonSRX(TurretConstants.kTurretPort);
    }

    public void setTurretRotation(double rotVel){
      m_Turret.set(TalonSRXControlMode.PercentOutput, rotVel);
    }

    public Command stopRotation() {
        return runOnce(() -> m_Turret.set(TalonSRXControlMode.PercentOutput, 0));
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
