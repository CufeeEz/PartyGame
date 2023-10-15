package my.cufee.partygame.Games.DigOrDie;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


import static my.cufee.partygame.Games.DigOrDie.DigOrDieLocation.locSpawnDigOrDie;
import static my.cufee.partygame.Games.PlayersArray.*;
import static my.cufee.partygame.Util.TeleportPlayers.teleportInMoreLoc;


public class DigOrDieGame {
    public static void startDigOrDie(){
        Bukkit.broadcastMessage(String.valueOf(playersOnGame.length));
        DigOrDieLocation.setLocation();
        teleportInMoreLoc(locSpawnDigOrDie);
    }
}
