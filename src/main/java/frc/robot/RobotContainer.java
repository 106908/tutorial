// 
// Decompiled by Procyon v0.5.36
// 

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.RunBallTrackCommand;
import frc.robot.commands.TestRunBallTrackCommand;
import frc.robot.subsystems.BallTrackSubsystem;

public class RobotContainer
{
    private final BallTrackSubsystem m_BallTrackSubsystem;
    private final RunBallTrackCommand m_RunBallTrackCommand;
    private final TestRunBallTrackCommand m_TestRunBallTrackCommand;
    
    public RobotContainer() {
        this.m_BallTrackSubsystem = new BallTrackSubsystem();
        this.m_RunBallTrackCommand = new RunBallTrackCommand(this.m_BallTrackSubsystem);
        this.m_TestRunBallTrackCommand = new TestRunBallTrackCommand(this.m_BallTrackSubsystem);
        this.configureButtonBindings();
    }
    
    private void configureButtonBindings() {
        new JoystickButton((GenericHID)new Joystick(0), 3).whileHeld((Command)this.m_RunBallTrackCommand);
        new JoystickButton((GenericHID)new Joystick(0), 4).whileHeld((Command)this.m_TestRunBallTrackCommand);
    }
    
    public Command getAutonomousCommand() {
        return (Command)this.m_RunBallTrackCommand;
    }
}
