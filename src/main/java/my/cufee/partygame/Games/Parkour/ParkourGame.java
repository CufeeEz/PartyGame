package my.cufee.partygame.Games.Parkour;

import my.cufee.partygame.Games.PlayersArray;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ParkourGame {
    public static void setBlock(){
        ParkourLocartion.setParkourLocationBlock();
        for(int i = 0; i < ParkourLocartion.ParkourLocationBlock.length;i++){
            ParkourLocartion.ParkourLocationBlock[i].getBlock().setType(Material.RED_STAINED_GLASS);
        }
    }
    public static void removeBlock(){
        ParkourLocartion.setParkourLocationBlock();
        for(int i = 0; i < ParkourLocartion.ParkourLocationBlock.length;i++){
            ParkourLocartion.ParkourLocationBlock[i].getBlock().setType(Material.AIR);
        }
    }
    public static void givePoitonEffectRegeneration(){
        for(Player player : PlayersArray.playersOnGame){
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 300*20, 10, false, false));
        }
    }
}
