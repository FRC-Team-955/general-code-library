package frc.robot;
import edu.wpi.first.wpilibj.Joystick;

public class IO {

public void SwerveMode(Joystick joy0)
{
boolean LeftBumper = joy0.getRawButton(5); 
int ModeCheck = 0; 

//Fastmode and Slowmode can be configured as needed through ModeCheck
if(LeftBumper == true)
{
ModeCheck ++; 
}

switch(ModeCheck)
{
case 1: System.out.println("Mode 1");

case 2: ModeCheck = 0; 

}

};

};