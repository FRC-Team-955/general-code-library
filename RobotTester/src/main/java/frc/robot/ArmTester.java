package frc.robot;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxRelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;

public class ArmTester {
private CANSparkMax ArmMotor; 
private SparkMaxRelativeEncoder ArmEncoder; 

ArmTester(int ArmMotorID){
CANSparkMax ArmMotor = new CANSparkMax(ArmMotorID, MotorType.kBrushless);
SparkMaxRelativeEncoder ArmEncoder = new SparkMaxRelativeEncoder(); 
System.out.println(ArmEncoder); 
}

void ArmMove(Joystick joy0){
double joystick_position = joy0.getRawAxis(1);
ArmMotor.set(joystick_position); 
}

}
