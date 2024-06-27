// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrainSubsystem;

public class Aim extends Command {
  DriveTrainSubsystem m_driveTrain;
  Timer m_Timer = new Timer();
  Timer m_Timer2 = new Timer();
  double m_tx;
  NetworkTable table= NetworkTableInstance.getDefault().getTable("limelight");// limelights name goes in quotation marks
  NetworkTableEntry tx = table.getEntry("tx");
  /** Creates a new Aim. */
  public Aim(DriveTrainSubsystem drivetrain) {
    m_driveTrain = drivetrain;

    addRequirements(m_driveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Timer.reset();
    m_Timer.start();
    m_Timer2.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
m_driveTrain.FieldDrive(m_tx*.01, 0, 0);

if(Math.abs(m_tx) <= 4){m_Timer2.start();}
if(Math.abs(m_tx)>= 4) {m_Timer2.reset();}
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Timer.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
     if( m_Timer2.get() >.2) {return true;}
     if( m_Timer.get()>.4){return true;}
  return false;
  }
}
