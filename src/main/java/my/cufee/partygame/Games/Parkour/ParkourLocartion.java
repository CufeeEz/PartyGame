package my.cufee.partygame.Games.Parkour;

import my.cufee.partygame.MainLocation.SpawnLocation;
import org.bukkit.Location;

public class ParkourLocartion {
    public static Location ParkourLocationSpawn = new Location(SpawnLocation.getWorld(), -105.5, 61.0, -37.5);
    public static Location[] ParkourLocationBlock = new Location[9];
    public static Location[] setParkourLocationBlock(){
        ParkourLocationBlock[0] = new Location(SpawnLocation.world, -107.0,61.0,-44.0);
        ParkourLocationBlock[1] = new Location(SpawnLocation.world, -106.0,61.0,-44.0);
        ParkourLocationBlock[2] = new Location(SpawnLocation.world, -105.0,61.0,-44.0);
        ParkourLocationBlock[3] = new Location(SpawnLocation.world, -105.0,62.0,-44.0);
        ParkourLocationBlock[4] = new Location(SpawnLocation.world, -106.0,62.0,-44.0);
        ParkourLocationBlock[5] = new Location(SpawnLocation.world, -107.0,62.0,-44.0);
        ParkourLocationBlock[6] = new Location(SpawnLocation.world, -107.0,63.0,-44.0);
        ParkourLocationBlock[7] = new Location(SpawnLocation.world, -106.0,63.0,-44.0);
        ParkourLocationBlock[8] = new Location(SpawnLocation.world, -105.0,63.0,-44.0);
        return ParkourLocationBlock;
    }
    public static Location ParkourLocationFinish = new Location(SpawnLocation.getWorld(), -133.5, 61.0, -44.5);
}
