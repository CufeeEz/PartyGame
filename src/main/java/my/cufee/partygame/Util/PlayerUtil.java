package my.cufee.partygame.Util;

import my.cufee.partygame.Games.PlayersArray;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class PlayerUtil {
    public static void clearPlayers(){
        for(Player player: PlayersArray.playersOnGame){
            player.setHealth(20);
            player.setFoodLevel(20);
            for(PotionEffect e : player.getActivePotionEffects()){
                player.removePotionEffect(e.getType());
            }
            player.setGameMode(GameMode.ADVENTURE);
            player.getInventory().clear();
        }
    }
    public static void clearOnePlayer(Player player){
        player.setGameMode(GameMode.ADVENTURE);
        player.setHealth(20);
        player.getInventory().clear();
        player.setFoodLevel(20);
        for(PotionEffect e : player.getActivePotionEffects()){
            player.removePotionEffect(e.getType());

        }
    }
}
