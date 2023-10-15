package my.cufee.partygame.Games.DigOrDie;

import my.cufee.partygame.Games.PlayersScore;
import my.cufee.partygame.MainLocation.SpawnLocation;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class DigOrDieEvent implements Listener {
    @EventHandler
    public static void playerTouchBlock(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getClickedBlock().getType().equals(Material.SCULK_SENSOR)){
                PlayersScore.setPoint(player);
                player.teleport(SpawnLocation.getLocHub());
            }
        }

    }
}

