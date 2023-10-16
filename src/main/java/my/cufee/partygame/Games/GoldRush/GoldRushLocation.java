package my.cufee.partygame.Games.GoldRush;

import com.sk89q.worldedit.WorldEdit;
import my.cufee.partygame.MainLocation.SpawnLocation;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class GoldRushLocation {
    public static Location GRLocationSpawn = new Location(SpawnLocation.getWorld(), -53.5, 63.0, -55.5);
    public static Location[] goldBlocks = new Location[45];
    public static Location[] setLocGoldBlocks(){
        goldBlocks[0] = new Location(SpawnLocation.world, -63.0,63.0,-64.0);
        goldBlocks[1] = new Location(SpawnLocation.world, -66.0,62.0,-62.0);
        goldBlocks[2] = new Location(SpawnLocation.world, -65.0,63.0,-63.0);
        goldBlocks[3] = new Location(SpawnLocation.world, -66.0,65.0,-65.0);
        goldBlocks[4] = new Location(SpawnLocation.world, -66.0,63.0,-63.0);
        goldBlocks[5] = new Location(SpawnLocation.world, -63.0,63.0,-64.0);
        goldBlocks[6] = new Location(SpawnLocation.world, -64.0,64.0,-66.0);
        goldBlocks[7] = new Location(SpawnLocation.world, -66.0,64.0,-68.0);
        goldBlocks[8] = new Location(SpawnLocation.world, -61.0,61.0,-67.0);
        goldBlocks[9] = new Location(SpawnLocation.world, -58.0,63.0,-67.0);
        goldBlocks[10] = new Location(SpawnLocation.world, -52.0,63.0,-68.0);
        goldBlocks[11] = new Location(SpawnLocation.world, -50.0,62.0,-67.0);
        goldBlocks[12] = new Location(SpawnLocation.world, -54.0,62.0,-68.0);
        goldBlocks[13] = new Location(SpawnLocation.world, -44.0,64.0,-67.0);
        goldBlocks[14] = new Location(SpawnLocation.world, -42.0,65.0,-68.0);
        goldBlocks[15] = new Location(SpawnLocation.world, -42.0,63.0,-62.0);
        goldBlocks[16] = new Location(SpawnLocation.world, -44.0,62.0,-61.0);
        goldBlocks[17] = new Location(SpawnLocation.world, -43.0,62.0,-60.0);
        goldBlocks[18] = new Location(SpawnLocation.world, -42.0,63.0,-60.0);
        goldBlocks[19] = new Location(SpawnLocation.world, -47.0,62.0,-52.0);
        goldBlocks[20] = new Location(SpawnLocation.world, -48.0,62.0,-51.0);
        goldBlocks[21] = new Location(SpawnLocation.world, -46.0,63.0,-49.0);
        goldBlocks[22] = new Location(SpawnLocation.world, -45.0,64.0,-47.0);
        goldBlocks[23] = new Location(SpawnLocation.world, -45.0,62.0,-45.0);
        goldBlocks[24] = new Location(SpawnLocation.world, -44.0,63.0,-45.0);
        goldBlocks[25] = new Location(SpawnLocation.world, -47.0,62.0,-45.0);
        goldBlocks[26] = new Location(SpawnLocation.world, -42.0,65.0,-45.0);
        goldBlocks[27] = new Location(SpawnLocation.world, -42.0,67.0,-48.0);
        goldBlocks[28] = new Location(SpawnLocation.world, -42.0,69.0,-49.0);
        goldBlocks[29] = new Location(SpawnLocation.world, -55.0,62.0,-47.0);
        goldBlocks[30] = new Location(SpawnLocation.world, -54.0,63.0,-46.0);
        goldBlocks[31] = new Location(SpawnLocation.world, -55.0,64.0,-45.0);
        goldBlocks[32] = new Location(SpawnLocation.world, -54.0,66.0,-44.0);
        goldBlocks[33] = new Location(SpawnLocation.world, -58.0,62.0,-45.0);
        goldBlocks[34] = new Location(SpawnLocation.world, -59.0,62.0,-44.0);
        goldBlocks[35] = new Location(SpawnLocation.world, -62.0,62.0,-45.0);
        goldBlocks[36] = new Location(SpawnLocation.world, -64.0,63.0,-44.0);
        goldBlocks[37] = new Location(SpawnLocation.world, -64.0,63.0,-46.0);
        goldBlocks[38] = new Location(SpawnLocation.world, -66.0,66.0,-44.0);
        goldBlocks[39] = new Location(SpawnLocation.world, -65.0,62.0,-48.0);
        goldBlocks[40] = new Location(SpawnLocation.world, -64.0,62.0,-55.0);
        goldBlocks[41] = new Location(SpawnLocation.world, -63.0,62.0,-56.0);
        goldBlocks[42] = new Location(SpawnLocation.world, -53.0,62.0,-62.0);
        goldBlocks[43] = new Location(SpawnLocation.world, -49.0,62.0,-57.0);
        goldBlocks[44] = new Location(SpawnLocation.world, -42.0,67.0,-50.0);
        return goldBlocks;

    }
}
