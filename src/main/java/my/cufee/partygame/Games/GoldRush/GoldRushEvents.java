package my.cufee.partygame.Games.GoldRush;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class GoldRushEvents {
    public static void setblock(){
        GoldRushLocation.setLocGoldBlocks();
        for(int i = 0; i < GoldRushLocation.goldBlocks.length;i++){
            GoldRushLocation.goldBlocks[i].getBlock().setType(Material.GOLD_ORE);
        }
    }
}