package my.cufee.partygame.Games.BedrockBox;

import my.cufee.partygame.MainLocation.SpawnLocation;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class BedrockGame {
    public static void FillBox(){
        for (int x = -220; x >= -270; x--) {
            for (int y = 30; y < 55; y++) {
                for (int z = -70; z >= -120; z--) {
                    Location location = new Location(SpawnLocation.world, x, y, z);
                    Block block = SpawnLocation.world.getBlockAt(location);
                    block.setType(Material.DIRT); // Или используйте другой тип блока земли
                }
            }
        }
    }
}
