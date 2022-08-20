// 
// Decompiled by Procyon v0.5.36
// 

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.BallTrackSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunBallTrackCommand extends CommandBase
{
    private BallTrackSubsystem balltracksub;
    
    public RunBallTrackCommand(BallTrackSubsystem balltracksub) {
        balltracksub = balltracksub;
        this.addRequirements(balltracksub);
    }
    
    public void initialize() {
        balltracksub.testing = false;
    }
    
    public void execute() {
        balltracksub.storeBall();
    }

    public void end(){
        balltracksub.enabled = false;
    }
}
