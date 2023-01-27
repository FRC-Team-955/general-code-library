package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType; 
import com.revrobotics.CANSparkMax.IdleMode; 
import com.revrobotics.CANSparkMaxLowLevel.PeriodicStatus2; 

public class ElevatorTester {
private TalonFX ElevatorMotor; 
private CANSparkMax ElevatorMotorN;

ElevatorTester(int Elevator_MotorID)
{
TalonFX Elevator_Motor = new TalonFX(Elevator_MotorID);
ElevatorMotor = Elevator_Motor; 

ElevatorMotor.setNeutralMode(NeutralMode.Brake); 
ElevatorMotor.setSelectedSensorPosition(0); 

SupplyCurrentLimitConfiguration config = new SupplyCurrentLimitConfiguration(true, 40,40,0);
ElevatorMotor.configSupplyCurrentLimit(config, 100);

CANSparkMax Elevator_MotorN = new CANSparkMax(Elevator_MotorID, MotorType.kBrushless); 
ElevatorMotorN = Elevator_MotorN; 

ElevatorMotorN.setIdleMode(IdleMode.kBrake);
ElevatorMotorN.setSmartCurrentLimit(40); 

}

void ElevatorMove(Joystick joy0)
{
double joystick_position = joy0.getRawAxis(1);
joystick_position = -joystick_position;

ElevatorMotor.set(ControlMode.PercentOutput, joystick_position);
ElevatorMotorN.set(joystick_position);
};

};