package my.cufee.partygame.Games.DigOrDie;

import my.cufee.partygame.MainLocation.SpawnLocation;
import org.bukkit.Location;

public class DigOrDieLocation {
    public static Location[] locSpawnDigOrDie = new Location[8];
    public static Location[] setLocation(){
        locSpawnDigOrDie[0] = new Location(SpawnLocation.getWorld(), -40.5, 62.5, 33.5);
        locSpawnDigOrDie[1] = new Location(SpawnLocation.getWorld(), -30.5, 62.5, 37.5);
        locSpawnDigOrDie[2] = new Location(SpawnLocation.getWorld(), -26.5, 62.5, 47.5);
        locSpawnDigOrDie[3] = new Location(SpawnLocation.getWorld(), -30.5, 62.5, 57.5);
        locSpawnDigOrDie[4] = new Location(SpawnLocation.getWorld(), -40.5, 62.5, 61.5);
        locSpawnDigOrDie[5] = new Location(SpawnLocation.getWorld(), -50.5, 62.5, 57.5);
        locSpawnDigOrDie[6] = new Location(SpawnLocation.getWorld(), -54.5, 62.5, 47.5);
        locSpawnDigOrDie[7] = new Location(SpawnLocation.getWorld(), -50.5, 62.5, 37.5);
        return locSpawnDigOrDie;
    }
    public static Location[] locBedrockDigOrDie = new Location[8];
    public static Location[] setBedrockLocation() {
        locBedrockDigOrDie[0] = new Location(SpawnLocation.getWorld(), -40.5, 61.5, 33.5);
        locBedrockDigOrDie[1] = new Location(SpawnLocation.getWorld(), -30.5, 61.5, 37.5);
        locBedrockDigOrDie[2] = new Location(SpawnLocation.getWorld(), -26.5, 61.5, 47.5);
        locBedrockDigOrDie[3] = new Location(SpawnLocation.getWorld(), -30.5, 61.5, 57.5);
        locBedrockDigOrDie[4] = new Location(SpawnLocation.getWorld(), -40.5, 61.5, 61.5);
        locBedrockDigOrDie[5] = new Location(SpawnLocation.getWorld(), -50.5, 61.5, 57.5);
        locBedrockDigOrDie[6] = new Location(SpawnLocation.getWorld(), -54.5, 61.5, 47.5);
        locBedrockDigOrDie[7] = new Location(SpawnLocation.getWorld(), -50.5, 61.5, 37.5);
        return locBedrockDigOrDie;

    }


    public static Location pasteSchem = new Location(SpawnLocation.world, -58, 17,64);
}