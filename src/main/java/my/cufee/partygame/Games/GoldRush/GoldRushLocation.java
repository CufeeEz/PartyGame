package my.cufee.partygame.Games.GoldRush;

import com.sk89q.worldedit.WorldEdit;
import my.cufee.partygame.MainLocation.SpawnLocation;
import org.bukkit.Location;

public class GoldRushLocation {
    static Location GRLocationSpawn = new Location(SpawnLocation.getWorld(), -53.5, 63.0, -55.5);
    static Location[] goldBlocks = new Location[50];
    public static Location[] setLocGoldBlocks(){
        goldBlocks[0] = new Location(SpawnLocation.world, 0.0,0.0,0.0);
        return goldBlocks;

    }
}
