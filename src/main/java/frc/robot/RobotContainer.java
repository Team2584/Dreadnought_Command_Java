// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.wpilibj2.command.Commands.parallel;

import frc.robot.Constants.OperatorConstants;
// Import Commands
import frc.robot.commands.Autos;
import frc.robot.commands.DriveArcade;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.TurretRotation;
import frc.robot.commands.FlyWheelSpin;
import frc.robot.commands.Fire;
// Improt Subsystems
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.FlyWheel;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Turret;
import frc.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final FlyWheel m_flywheel = new FlyWheel();
  private final Intake m_intake = new Intake();
  private final Turret m_turret = new Turret();
  
  public static final Drivetrain m_drivetrain = new Drivetrain();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  public static final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();

    //m_drivetrain.setDefaultCommand(new DriveArcade());
    //Drive commands from RapidReact Example
    m_drivetrain.setDefaultCommand(
      m_drivetrain.arcadeDriveCommand(
        () -> m_driverController.getRightX(), () -> m_driverController.getLeftY()));
    
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));
    
    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.

    // Old Controls
    /* 
    m_driverController.x().whileTrue(m_flywheel.FlyWheelCommand());
    m_driverController.y().whileTrue(m_flywheel.FlyWheel50());
    m_driverController.b().whileTrue(m_flywheel.FlyWheel80());
    m_driverController.a().whileTrue(m_flywheel.StopFly());
    
    m_driverController.rightTrigger().whileTrue(m_intake.Intake());
    m_driverController.leftTrigger().whileTrue(m_intake.Outtake());
    m_driverController.rightTrigger().whileFalse(m_intake.StopIntake());
    m_driverController.leftTrigger().whileFalse(m_intake.StopIntake());
    */

    // Flywheel
    m_driverController.x().whileTrue(new FlyWheelSpin(m_flywheel, 0.2));
    m_driverController.y().whileTrue(new FlyWheelSpin(m_flywheel, 0.5));
    m_driverController.b().whileTrue(new FlyWheelSpin(m_flywheel, 0.8));
    m_driverController.a().whileTrue(m_flywheel.StopFly());

    // Intake
    m_driverController.leftTrigger().whileTrue(m_intake.Intake());
    m_driverController.leftTrigger().whileFalse(m_intake.StopIntake());

    // Outtake
    m_driverController.leftTrigger().and(m_driverController.leftBumper()).whileTrue(m_intake.Outtake());
    m_driverController.leftTrigger().and(m_driverController.leftBumper()).whileFalse(m_intake.StopIntake());

    // Fire
    m_driverController.rightTrigger().whileTrue(new Fire(m_intake, m_flywheel, 0.35));

    // Turret rotation
    m_driverController.rightBumper().whileTrue(new TurretRotation(m_turret, 0.2));
    m_driverController.leftBumper().whileTrue(new TurretRotation(m_turret, -0.2));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
