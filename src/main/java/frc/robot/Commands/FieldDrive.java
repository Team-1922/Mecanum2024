// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrainSubsystem;

public class FieldDrive extends Command {
  DriveTrainSubsystem m_driveTrain;
  XboxController m_XboxController;
  double slowDownFactor = 0.5;

  /** Creates a new tankdrive. */
  public FieldDrive(DriveTrainSubsystem driveTrain, XboxController xboxController) {
   m_driveTrain = driveTrain;
   m_XboxController = xboxController;
addRequirements(m_driveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {



    m_driveTrain.FieldDrive(-m_XboxController.getRawAxis(1)*slowDownFactor,
      m_XboxController.getRawAxis(0) * slowDownFactor,
    m_XboxController.getRawAxis(4)*slowDownFactor);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
