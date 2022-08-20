// 
// Decompiled by Procyon v0.5.36
// 

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ExampleCommand extends CommandBase
{
    private final ExampleSubsystem m_subsystem;
    
    public ExampleCommand(final ExampleSubsystem subsystem) {
        this.m_subsystem = subsystem;
        this.addRequirements(new Subsystem[] { (Subsystem)subsystem });
    }
    
    public void initialize() {
    }
    
    public void execute() {
    }
    
    public void end(final boolean interrupted) {
    }
    
    public boolean isFinished() {
        return false;
    }
}
