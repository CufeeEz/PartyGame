package my.cufee.partygame.Games.DigOrDie;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.function.pattern.Pattern;
import com.sk89q.worldedit.function.pattern.RandomPattern;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldedit.session.SessionManager;
import com.sk89q.worldedit.world.block.BaseBlock;
import com.sk89q.worldedit.world.block.BlockType;
import my.cufee.partygame.Games.PlayersScore;
import my.cufee.partygame.MainLocation.SpawnLocation;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.math.BlockVector3;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;


import java.util.Random;

import static my.cufee.partygame.Games.DigOrDie.DigOrDieLocation.locSpawnDigOrDie;
import static my.cufee.partygame.Games.PlayersArray.*;
import static my.cufee.partygame.Util.TeleportPlayers.teleportInMoreLoc;


public class DigOrDieGame {
    public static void startDigOrDie(){
        Bukkit.broadcastMessage(String.valueOf(playersOnGame.length));
        DigOrDieLocation.setLocation();
        teleportInMoreLoc(locSpawnDigOrDie);
    }
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
