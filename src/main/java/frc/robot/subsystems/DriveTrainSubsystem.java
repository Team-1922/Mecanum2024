// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix6.hardware.TalonFX;

//import com.ctre.phoenix.motorcontrol.can.TalonSRX;
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.SPI;
public class DriveTrainSubsystem extends SubsystemBase {
// MecanumDrive m_mecanumBase;

//private static final AHRS m_navX = new AHRS(SPI.Port.kMXP);

  WPI_TalonSRX m_frontLeft = new WPI_TalonSRX(3);
  WPI_TalonSRX m_frontRight = new WPI_TalonSRX(4);
  WPI_TalonSRX m_backRight = new WPI_TalonSRX(1);
  WPI_TalonSRX m_backLeft = new WPI_TalonSRX(2);
  
  MecanumDrive m_mecanumBase = new MecanumDrive(m_frontLeft, m_backLeft, m_frontRight, m_backRight);
  
//TalonSRX m_test = new TalonSRX(0);


CommandXboxController m_XboxController = new CommandXboxController(0);
// m_Gyro = new Pigeon2(0);
// remember to update the ids

 
 // put the motors in here 
  /** Creates a new DriveTrainSubsystem. */
  public DriveTrainSubsystem() {
    m_backLeft.setSafetyEnabled(false);
    m_backRight.setSafetyEnabled(false);
    m_frontLeft.setSafetyEnabled(false);
    m_frontRight.setSafetyEnabled(false);

    m_frontRight.setInverted(true);
    m_backRight.setInverted(true);
    m_frontLeft.setInverted(false);
    m_backLeft.setInverted(false);
/* 
    m_frontLeft.setSafetyEnabled(false);
    m_frontRight.setSafetyEnabled(false);
    m_backLeft.setSafetyEnabled(false);
    m_backRight.setSafetyEnabled(false);

    m_mecanumBase.setSafetyEnabled(false);
*/
  }

// range -360 to 360
public double gyroAngle(){
  return 0;
 // return m_navX.getAngleAdjustment();
}



 // public double doubleAngle = m_Gyro.getCompassHeading();
  //public Rotation2d gyroAngle = new Rotation2d(m_Gyro.getCompassHeading());


 
public void drive(double xSpeed,double ySpeed, double zRotation){
  
    m_mecanumBase.driveCartesian(xSpeed, ySpeed, zRotation);
    m_mecanumBase.setDeadband(.05);
  
  
};







public void FieldDrive(double xSpeed, double ySpeed, double zRotation){
  //m_mecanumBase.driveCartesian(xSpeed, ySpeed, zRotation
 // ,new Rotation2d(m_navX.getAngleAdjustment())
  //);
  //m_mecanumBase.setDeadband(.1);
}






  @Override
  public void periodic() {
    //SmartDashboard.putNumber("front left speed", m_frontLeft);
    // This method will be called once per scheduler run
  }
}
