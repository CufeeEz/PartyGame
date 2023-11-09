package my.cufee.partygame.Games.BowBattle;

import my.cufee.partygame.MainLocation.SpawnLocation;
import org.bukkit.Location;

public class BowBattleLocation {
    public static Location[] locSpawnBowBattle = new Location[8];
    public static Location locDieBowBattle = new Location(SpawnLocation.world,40.5,64.0,71.5);
    public static Location[] setLocationBB(){
        locSpawnBowBattle[0] = new Location(SpawnLocation.getWorld(), 40.5, 67.5, 31.5);
        locSpawnBowBattle[1] = new Location(SpawnLocation.getWorld(), 40.5, 67.5, 111.5);
        locSpawnBowBattle[2] = new Location(SpawnLocation.getWorld(), 0.5, 67.5, 71.5);
        locSpawnBowBattle[3] = new Location(SpawnLocation.getWorld(), 80.5, 67.5, 71.5);
        locSpawnBowBattle[4] = new Location(SpawnLocation.getWorld(), 12.5, 67.5, 99.5);
        locSpawnBowBattle[5] = new Location(SpawnLocation.getWorld(), 68.5, 67.5, 43.5);
        locSpawnBowBattle[6] = new Location(SpawnLocation.getWorld(), 68.5, 67.5, 99.5);
        locSpawnBowBattle[7] = new Location(SpawnLocation.getWorld(), 12.5, 67.5, 43.5);
        return locSpawnBowBattle;
    }
    public static Location[] locBoxSpawnBowBattle = new Location[8];
    public static Location[] setLocationBoxBB(){
        locBoxSpawnBowBattle[0] = new Location(SpawnLocation.getWorld(), 40.5, 65.5, 31.5);
        locBoxSpawnBowBattle[1] = new Location(SpawnLocation.getWorld(), 40.5, 65.5, 111.5);
        locBoxSpawnBowBattle[2] = new Location(SpawnLocation.getWorld(), 0.5, 65.5, 71.5);
        locBoxSpawnBowBattle[3] = new Location(SpawnLocation.getWorld(), 80.5, 65.5, 71.5);
        locBoxSpawnBowBattle[4] = new Location(SpawnLocation.getWorld(), 12.5, 65.5, 99.5);
        locBoxSpawnBowBattle[5] = new Location(SpawnLocation.getWorld(), 68.5, 65.5, 43.5);
        locBoxSpawnBowBattle[6] = new Location(SpawnLocation.getWorld(), 68.5, 65.5, 99.5);
        locBoxSpawnBowBattle[7] = new Location(SpawnLocation.getWorld(), 12.5, 65.5, 43.5);
        return locBoxSpawnBowBattle;
    }
}
