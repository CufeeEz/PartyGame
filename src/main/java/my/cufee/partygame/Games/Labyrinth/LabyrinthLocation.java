package my.cufee.partygame.Games.Labyrinth;

import my.cufee.partygame.Games.PlayersArray;
import my.cufee.partygame.MainLocation.SpawnLocation;
import org.bukkit.Location;

import java.util.Random;

public class LabyrinthLocation {
    public static Location[] labyrinthSpawnLocation = new Location[8];
    public static void setlabyrinthSpawnLocation(){
        labyrinthSpawnLocation[0] = new Location(SpawnLocation.world, -197.5, 61.0, 79.5);
        labyrinthSpawnLocation[1] = new Location(SpawnLocation.world, -197.5, 61.0, 127.5);
        labyrinthSpawnLocation[2] = new Location(SpawnLocation.world, -197.5, 61.0, 175.5);
        labyrinthSpawnLocation[3] = new Location(SpawnLocation.world, -245.5, 61.0, 175.5);
        labyrinthSpawnLocation[4] = new Location(SpawnLocation.world, -293.5, 61.0, 175.5);
        labyrinthSpawnLocation[5] = new Location(SpawnLocation.world, -293.5, 61.0, 127.5);
        labyrinthSpawnLocation[6] = new Location(SpawnLocation.world, -293.5, 61.0, 79.5);
        labyrinthSpawnLocation[7] = new Location(SpawnLocation.world, -245.5, 61.0, 79.5);
    }
    public static Location labyrinthFinishLocation = new Location(SpawnLocation.world, -246.0, 62.0, 127.0);
    public static Location getRandomSpawnLocationIndex(){
        Random random = new Random();
        int randomindex = random.nextInt(8);
        return labyrinthSpawnLocation[randomindex];
    }
}
