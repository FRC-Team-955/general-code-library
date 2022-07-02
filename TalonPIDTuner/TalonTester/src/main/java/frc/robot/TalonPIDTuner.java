package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.math.controller.PIDController;

public class TalonPIDTuner {
    
    WPI_TalonSRX mTalon;
    public int talon_id;

    TalonPIDTuner(){
        this.talon_id = 0;
        mTalon = new WPI_TalonSRX(0);
    }
    TalonPIDTuner(int talon_id){
        this.talon_id = talon_id;
        mTalon = new WPI_TalonSRX(talon_id);
    }

    PIDController mPositionPID = new PIDController(0.04, 0, 0);
    PIDController mVelocityPID = new PIDController(0, 0, 0);

    SendableChooser mModeChooser = new SendableChooser<String>();
    
    public double target_position = 1000;
    public double target_velocity = 200;
    public double voltage_offset = 0.027;

    public void positionPID(){
        double current_position = mTalon.getSelectedSensorPosition();
        double position_pid = mPositionPID.calculate(current_position, target_position);
        mTalon.setVoltage(position_pid);
    }

    public void velocityPID(){
        double current_velocity = mTalon.getSelectedSensorVelocity();
        double velocity_pid = mVelocityPID.calculate(current_velocity, target_velocity);
        mTalon.setVoltage(velocity_pid + voltage_offset * target_velocity);
    }

    public void setSmartDashboard(){
        SmartDashboard.putNumber("Talon ID: ", talon_id);

        SmartDashboard.putNumber("Target Position: ", 1000);

        SmartDashboard.putNumber("Target Velocity: ", 200);

        SmartDashboard.putNumber("Voltage Offset: ", 0);

        mModeChooser.setDefaultOption("None", "None");
        mModeChooser.setDefaultOption("Reset", "Reset");
        mModeChooser.addOption("Position", "Position PID");
        mModeChooser.addOption("Velocity", "Velocity PID");
    }

    public void updateSmartDashboard(){
        int talon_id = (int) SmartDashboard.getNumber("Talon ID: ", this.talon_id);
        if(this.talon_id != talon_id){
            changeMotorID(talon_id);
        }

        SmartDashboard.putData("Position PID Controller", mPositionPID);
        SmartDashboard.putNumber("Current Position", mTalon.getSelectedSensorPosition());

        SmartDashboard.putData("Velocity PID Controller", mVelocityPID);
        SmartDashboard.putNumber("Current Velocity", mTalon.getSelectedSensorVelocity());

        target_position = SmartDashboard.getNumber("Target Position: ", target_position);
        target_velocity = SmartDashboard.getNumber("Target Velocity: ", target_velocity);
        voltage_offset = SmartDashboard.getNumber("Voltage Offset: ", voltage_offset);

        SmartDashboard.putData("PID Mode Chooser", mModeChooser);
    }
    public void runPIDTuner(){
        if(mModeChooser.getSelected() == "Position PID"){
            positionPID();
        }else if(mModeChooser.getSelected() == "Velocity PID"){
            velocityPID();
        }else if(mModeChooser.getSelected() == "Reset"){
            resetMotor();
        }else{
            stopMotor();
        }
    }

    public void stopMotor(){
        mTalon.set(ControlMode.PercentOutput, 0);
    }
    public void resetMotor(){
        mTalon.set(ControlMode.PercentOutput, 0);
        mTalon.setSelectedSensorPosition(0);
    }
    public void changeMotorID(int talon_id){
        mTalon.DestroyObject();
        this.talon_id = talon_id;
        mTalon = new WPI_TalonSRX(talon_id);
    }
    
}

