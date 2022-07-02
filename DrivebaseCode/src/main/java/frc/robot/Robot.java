// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */

  WPI_TalonSRX m_left = new WPI_TalonSRX(1);
  WPI_TalonSRX m_right = new WPI_TalonSRX(3);
  WPI_TalonSRX m_rightFollow = new WPI_TalonSRX(4);
  WPI_TalonSRX m_leftFollow = new WPI_TalonSRX(2);

  MotorControllerGroup m_leftGroup = new MotorControllerGroup(m_left, m_leftFollow);
  MotorControllerGroup m_rightGroup = new MotorControllerGroup(m_right, m_rightFollow);
  
  DifferentialDrive m_drive = new DifferentialDrive(m_leftGroup, m_rightGroup);
  Joystick joy = new Joystick(0);
  final double mult = .6;

  @Override
  public void robotInit() {}

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    m_drive.arcadeDrive(joy.getRawAxis(4)*mult, joy.getRawAxis(1)*mult);
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
