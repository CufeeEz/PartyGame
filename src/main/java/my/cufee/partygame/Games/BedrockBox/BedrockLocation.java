package my.cufee.partygame.Games.BedrockBox;


import my.cufee.partygame.MainLocation.SpawnLocation;
import org.bukkit.Location;

public class BedrockLocation {

    public static Location[] locSpawnBedrock = new org.bukkit.Location[8];
    public static Location[] setSpawnLocation(){
        locSpawnBedrock[0] = new Location(SpawnLocation.getWorld(), -273.5, 31.5, -117.5);
        locSpawnBedrock[1] = new Location(SpawnLocation.getWorld(), -221.5, 52.5, -65.5);
        locSpawnBedrock[2] = new Location(SpawnLocation.getWorld(), -221.5, 31.5, -123.5);
        locSpawnBedrock[3] = new Location(SpawnLocation.getWorld(), -215.5, 31.5, -71.5);
        locSpawnBedrock[4] = new Location(SpawnLocation.getWorld(), -273.5, 52.5, -71.5);
        locSpawnBedrock[5] = new Location(SpawnLocation.getWorld(), -267.5, 52.5, -123.5);
        locSpawnBedrock[6] = new Location(SpawnLocation.getWorld(), -267.5, 31.5, -65.5);
        locSpawnBedrock[7] = new Location(SpawnLocation.getWorld(), -215.5, 52.5, -117.5);
        return locSpawnBedrock;
    }
    public static Location[] locBedrockDoor = new org.bukkit.Location[16];
    public static Location[] setBedrockDoor(){
        locBedrockDoor[0] = new Location(SpawnLocation.getWorld(), -222.0, 53.0, -69.0);
        locBedrockDoor[1] = new Location(SpawnLocation.getWorld(), -222.0, 52.0, -69.0);
        locBedrockDoor[2] = new Location(SpawnLocation.getWorld(), -268.0, 32.0, -69.0);
        locBedrockDoor[3] = new Location(SpawnLocation.getWorld(), -268.0, 31.0, -69.0);
        locBedrockDoor[4] = new Location(SpawnLocation.getWorld(), -271.0, 53.0, -72.0);
        locBedrockDoor[5] = new Location(SpawnLocation.getWorld(), -271.0, 52.0, -72.0);
        locBedrockDoor[6] = new Location(SpawnLocation.getWorld(), -271.0, 32.0, -118.0);
        locBedrockDoor[7] = new Location(SpawnLocation.getWorld(), -271.0, 31.0, -118.0);
        locBedrockDoor[8] = new Location(SpawnLocation.getWorld(), -268.0, 53.0, -121.0);
        locBedrockDoor[9] = new Location(SpawnLocation.getWorld(), -268.0, 52.0, -121.0);
        locBedrockDoor[10] = new Location(SpawnLocation.getWorld(), -222.0, 32.0, -121.0);
        locBedrockDoor[11] = new Location(SpawnLocation.getWorld(), -222.0, 31.0, -121.0);
        locBedrockDoor[12] = new Location(SpawnLocation.getWorld(), -219.0, 53.0, -118.0);
        locBedrockDoor[13] = new Location(SpawnLocation.getWorld(), -219.0, 52.0, -118.0);
        locBedrockDoor[14] = new Location(SpawnLocation.getWorld(), -219.0, 32.0, -72.0);
        locBedrockDoor[15] = new Location(SpawnLocation.getWorld(), -219.0, 31.0, -72.0);
        return locBedrockDoor;
    }
}
