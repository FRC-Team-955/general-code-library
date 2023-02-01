package frc.robot;
import edu.wpi.first.wpilibj.Joystick;

public class IO {

    Joystick joystick  = new joystick(0);
    
    boolean toggleOn = false;
    boolean togglePressed = false;

    public void teleopPeriodic(){
        updateToggle();

        //if button pressed then do this
        if (toggleOn){
            System.out.println("Slow");
        }

        //If pressed again do this
        else{
            System.out.println("Fast");
        }
    }

    public void updateToggle(){
        if(joystick.getRawButton(1)){
            if(!togglePressed){
                toggleOn = !toggleOn;
                togglePressed = true;
            }
            else{
                togglePressed = false;
            }
        }
    }



// public void SwerveMode(Joystick joy0)
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

public void PipelineSwitch(){ 
boolean XButton = new joy0.getRawButton(3); 
if (XButton = true)
{
    camera.setPipelineIndex(1);

}

}

};