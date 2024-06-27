// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants;
import frc.robot.Commands.Aim;
import frc.robot.Commands.Autos;
import frc.robot.Commands.ExampleCommand;
import frc.robot.Commands.FieldDrive;
import frc.robot.Commands.Drive;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
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
  private final DriveTrainSubsystem m_driveTrain = new DriveTrainSubsystem();
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController = 
  // devices/controllers  
  new CommandXboxController(OperatorConstants.kDriverControllerPort);
  private  XboxController m_XboxController = new XboxController(0);
// commands
  private final Drive m_drive = new Drive(m_driveTrain, m_driverController);
  private final FieldDrive m_fieldDrive = new FieldDrive(m_driveTrain, m_XboxController);
  private final Aim m_Aim = new Aim(m_driveTrain);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_driveTrain.setDefaultCommand(m_drive);
    initNetworkTable();
    // Configure the trigger bindings
    configureBindings();
  }
private void initNetworkTable(){
  NetworkTable table = NetworkTableInstance.getDefault().getTable("Ozram");
 // NetworkTableEntry Angle = table.getEntry("Gyro Angle"); 
  //Angle.setNumber(m_driveTrain.doubleAngle);
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
    //m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());

  // buttons
  
   // new JoystickButton(m_XboxController, 3)
    //  .onTrue(m_Aim);
    
  }
  

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
    // An example command will be run in autonomous
  //  return Autos.exampleAuto(m_exampleSubsystem);
  }
}
