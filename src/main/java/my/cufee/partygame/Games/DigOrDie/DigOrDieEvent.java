package my.cufee.partygame.Games.DigOrDie;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class DigOrDieEvent implements Listener {
    @EventHandler
    public void playerTouchBlock(PlayerInteractEvent event) {
        Player Player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if (event.getClickedBlock().getType().equals(Material.SCULK_SENSOR)){

            }
        }
    }
}

