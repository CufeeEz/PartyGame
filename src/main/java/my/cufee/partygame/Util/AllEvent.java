package my.cufee.partygame.Util;

import my.cufee.partygame.Games.PlayersScore;
import my.cufee.partygame.MainLocation.SpawnLocation;
import my.cufee.partygame.PartyGame;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class AllEvent implements Listener {
    // MAIN EVENTS
    @EventHandler
    public void onPlayerHungerChange(FoodLevelChangeEvent event) {
        event.setCancelled(true);
    }

    // EVENTS GOLD RUSH
    public static boolean grenabled;
    @EventHandler
    public void GRbreakOnlyGold(BlockBreakEvent event) {
        if(grenabled){
            if (event.getBlock().getType() == Material.GOLD_ORE) {
                Player player = event.getPlayer();
                PlayersScore.setPointGoldRush(player);
                return;
            }
            event.setCancelled(true);
            event.getPlayer().sendMessage("Вы можете ломать только золотую руду.");
        }
    }
    // ----------
    public static boolean grReplaceenabled;
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
            Particle particle = Particle.FLAME;
            location.setY(location.getY()+1);
            SpawnLocation.world.spawnParticle(particle, location, 10);
            block.setType(Material.GOLD_ORE);
        }, 20 * 20);
    }
    // END EVENTS GOLD RUSH

    // EVENTS DIG OR DIE

    public static boolean DODTuch;
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