package my.cufee.partygame.Games.DigOrDie;

import my.cufee.partygame.Games.PlayersScore;
import my.cufee.partygame.MainLocation.SpawnLocation;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;



import static my.cufee.partygame.Games.DigOrDie.DigOrDieLocation.locSpawnDigOrDie;
import static my.cufee.partygame.Games.PlayersArray.*;
import static my.cufee.partygame.Util.TeleportPlayers.teleportInMoreLoc;


public class DigOrDieGame {
    public static void startDigOrDie(){
        DigOrDieLocation.setLocation();
        teleportInMoreLoc(locSpawnDigOrDie);
    }


}
