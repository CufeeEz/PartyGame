package my.cufee.partygame.Games.Parkour;

import my.cufee.partygame.MainLocation.SpawnLocation;
import org.bukkit.Location;

public class ParkourLocartion {
    public static Location ParkourLocationSpawn = new Location(SpawnLocation.getWorld(), -105.5, 61.0, -37.5);
    public static Location[] ParkourLocationBlock = new Location[6];
    public static Location[] setParkourLocationBlock(){
        ParkourLocationBlock[0] = new Location(SpawnLocation.world, -107.0,62.0,-47.0);
        ParkourLocationBlock[1] = new Location(SpawnLocation.world, -106.0,62.0,-47.0);
        ParkourLocationBlock[2] = new Location(SpawnLocation.world, -105.0,62.0,-47.0);
        ParkourLocationBlock[3] = new Location(SpawnLocation.world, -105.0,61.0,-47.0);
        ParkourLocationBlock[4] = new Location(SpawnLocation.world, -106.0,61.0,-47.0);
        ParkourLocationBlock[5] = new Location(SpawnLocation.world, -107.0,61.0,-47.0);
        return ParkourLocationBlock;
    }
    public static Location ParkourLocationFinish = new Location(SpawnLocation.getWorld(), -133.5, 61.0, -44.5);
}
