// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.DriveTrainSubsystem;

public class Drive extends Command {
  DriveTrainSubsystem m_driveTrain;
  CommandXboxController m_XboxController;
 
  /** Creates a new tankdrive. */
  public Drive(DriveTrainSubsystem driveTrain, CommandXboxController xboxController) {
   m_driveTrain = driveTrain;
   m_XboxController = xboxController;
   addRequirements(driveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
     m_driveTrain.drive(
      -MathUtil.applyDeadband(m_XboxController.getRawAxis(1),.1),
      MathUtil.applyDeadband( m_XboxController.getRawAxis(0),.1),
      MathUtil.applyDeadband(m_XboxController.getRawAxis(4),.1));
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

