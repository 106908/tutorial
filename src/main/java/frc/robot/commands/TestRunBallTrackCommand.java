package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.BallTrackSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TestRunBallTrackCommand extends CommandBase
{
    private BallTrackSubsystem balltracksub;
    
    public TestRunBallTrackCommand(BallTrackSubsystem balltracksub) {
        this.balltracksub = balltracksub;
        this.addRequirements(balltracksub);
    }
    
    public void initialize() {
        balltracksub.testing = true;
    }
    
    public void execute() {
        balltracksub.storeBall();
    }

    public void end() {
        balltracksub.enabled = false;
    }   
}