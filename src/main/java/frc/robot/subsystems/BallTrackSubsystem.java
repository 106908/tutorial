// 
// Decompiled by Procyon v0.5.36
// 

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.ejml.ops.ConvertMatrixData;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BallTrackSubsystem extends NetworkTablesSubsystem
{
    private NetworkTableEntry conveyorStatus;
    private NetworkTableEntry chamberStatus;
    private NetworkTableEntry conveyorMotorSpeed;
    private NetworkTableEntry chamberMotorSpeed;
    private NetworkTableEntry ballTrackStatus;
    private AnalogInput conveyorSensor = new AnalogInput(0);
    private AnalogInput chamberSensor = new AnalogInput(1);
    private WPI_TalonSRX conveyorMotor = new WPI_TalonSRX(11);
    private WPI_TalonSRX chamberMotor = new WPI_TalonSRX(12);
    public boolean testing = false;   
    public boolean enabled = false;
    public BallTrackSubsystem() {
        super("balltrack");
//        conveyorStatus = getEntries("conveyor status");
//       chamberStatus = getEntries("chamber status");
        conveyorMotorSpeed = getEntries("conveyor motor speed");
        conveyorStatus.setNumber(conveyorSensor.getValue());
        chamberStatus.setNumber(chamberSensor.getValue());
        ballTrackStatus.setBoolean(enabled);
        chamberMotorSpeed = getEntries("chamber motor speed");
    }
    public void ballTrackStop(){
        conveyorMotor.stopMotor();
        chamberMotor.stopMotor();
    }
    public boolean conveyorFull(){
        return conveyorSensor.getValue() < 50;
    }
    public boolean chamberFull(){
        return chamberSensor.getValue() < 50;
    }
    public boolean robotFull(){
        return conveyorFull() && chamberFull();
    }
    public boolean seesBall() {
        if(conveyorSensor.getValue() < 50){
            return true;
        }
        else{
            return false;
        }
    } 
    public void moveConveyor(){
        if(!testing){
            conveyorMotor.set(Constants.motorspd);
        }
        else{
            conveyorMotor.set(conveyorMotorSpeed.getDouble(0));
        }
    }
    public void moveChamber(){
        if(!testing){
            chamberMotor.set(Constants.motorspd);
        }
        else{
            chamberMotor.set(chamberMotorSpeed.getDouble(0));
        }
    }
    public void moveAll(){
        moveConveyor();
        moveChamber();
    }
    
    public void storeBall() {
        if(enabled){
            if(robotFull()){
                ballTrackStop();
            }
            else if(chamberFull()){
                moveConveyor();
            }
            else{
                moveAll();
            }

        }
        else{
            ballTrackStop();
        }
    }
}
