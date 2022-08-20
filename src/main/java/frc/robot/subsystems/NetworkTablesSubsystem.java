package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Subsystem;

public abstract class NetworkTablesSubsystem implements Subsystem {
    private NetworkTable table;
    private String name;
    public NetworkTablesSubsystem(String getname) {
        this.name = getname;

        NetworkTableInstance inst = NetworkTableInstance.getDefault();

        this.table = inst.getTable(name);
    }
    public NetworkTableEntry getEntries(String key){
        return table.getEntry(key);
    }
}
