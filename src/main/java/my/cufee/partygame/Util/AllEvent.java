package my.cufee.partygame.Util;

import my.cufee.partygame.Games.PlayersScore;
import my.cufee.partygame.MainLocation.SpawnLocation;
import my.cufee.partygame.PartyGame;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class AllEvent implements Listener {
    // EVENTS GOLD RUSH
    private boolean grenabled = false;
    public void setEnabledbreakOnlyGold(boolean enabled) {
        this.grenabled = enabled;
    }
    @EventHandler
    public void GRbreakOnlyGold(BlockBreakEvent event) {
        if(grenabled){
            if (event.getBlock().getType() == Material.GOLD_ORE) {
                return;
            }
            event.setCancelled(true);
            event.getPlayer().sendMessage("Вы можете ломать только золотую руду.");
        }
    }
    // ----------
    private boolean grReplaceenabled = false;
    public void setEnabledGRReplace(boolean enabled) {
        this.grReplaceenabled = enabled;
    }
    @EventHandler
    public void grReplaceBlock(BlockBreakEvent event) {
        if(grReplaceenabled){
            Block block = event.getBlock();
            if (block.getType() == Material.GOLD_ORE) {
                replaceBlock(block.getLocation());
            }
        }
    }
    public void replaceBlock(Location location) {
        Block block = location.getBlock();
        Bukkit.getScheduler().runTaskLater(PartyGame.getInstance(), () -> {
            block.setType(Material.GOLD_ORE);
        }, 20 * 20);
    }
    // END EVENTS GOLD RUSH

    // EVENTS DIG OR DIE

    private boolean DODTuch = false;
    public void setEnabledDODTuch(boolean enabled) {
        this.DODTuch = enabled;
    }
    @EventHandler
    public void playerTouchBlock(PlayerInteractEvent event){

        Player player = event.getPlayer();
        if(DODTuch){
            if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (event.getClickedBlock().getType().equals(Material.SCULK_SENSOR)){
                    PlayersScore.setPoint(player);
                    player.teleport(SpawnLocation.getLocHub());
                }
            }
        }
    }
}