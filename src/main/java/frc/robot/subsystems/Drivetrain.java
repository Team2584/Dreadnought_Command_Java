package frc.robot.subsystems;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.util.function.DoubleSupplier;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.*;



public class Drivetrain extends SubsystemBase {
    private final CANSparkMax m_leftLeader = new CANSparkMax(DriveConstants.kLeftMotor1Port, MotorType.kBrushless);
    private final CANSparkMax m_leftFollower = new CANSparkMax(DriveConstants.kLeftMotor2Port, MotorType.kBrushless);

    private final CANSparkMax m_rightLeader = new CANSparkMax(DriveConstants.kRightMotor1Port, MotorType.kBrushless);
    private final CANSparkMax m_rightFollower = new CANSparkMax(DriveConstants.kRightMotor2Port, MotorType.kBrushless);

    private DifferentialDrive m_diffDrive = null;

    private final VictorSPX m_lowerIndex = new VictorSPX(2);

    public Drivetrain() {
        m_diffDrive = new DifferentialDrive(m_leftLeader::set, m_rightLeader::set);

        SendableRegistry.addChild(m_diffDrive, m_leftLeader);
        SendableRegistry.addChild(m_diffDrive, m_rightLeader);

        m_leftFollower.follow(m_leftLeader);
        m_rightFollower.follow(m_rightLeader);

        // We need to invert one side of the drivetrain so that positive voltages
        // result in both sides moving forward. Depending on how your robot's
        // gearbox is constructed, you might have to invert the left side instead.
        m_rightLeader.setInverted(true);

        /*
        // Sets the distance per pulse for the encoders
        m_leftEncoder.setDistancePerPulse(DriveConstants.kEncoderDistancePerPulse);
        m_rightEncoder.setDistancePerPulse(DriveConstants.kEncoderDistancePerPulse);
        */
    }

    /**
     * Returns a command that drives the robot with arcade controls.
     *
     * @param fwd the commanded forward movement
     * @param rot the commanded rotation
     */
    /* 
    public void arcadeDrive(double moveSpeed, double rotateSpeed) {
        m_diffDrive.arcadeDrive(moveSpeed, rotateSpeed);
      }
      */
      @Override
      public void periodic() {
        // This method will be called once per scheduler run
      }

      // Drive commands from RapidReact Example
    public Command arcadeDriveCommand(DoubleSupplier fwd, DoubleSupplier rot) {
        // A split-stick arcade command, with forward/backward controlled by the left
        // hand, and turning controlled by the right.
        return run(() ->  m_diffDrive.arcadeDrive(-fwd.getAsDouble() * 0.2, -rot.getAsDouble() * 0.2))
            .withName("arcadeDriveCommand");
           //m_leftLeader.set(fwd.getAsDouble()));//m_lowerIndex.set(VictorSPXControlMode.PercentOutput, fwd.getAsDouble()));
    }
    
    
}
