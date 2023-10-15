package my.cufee.partygame.Games.DigOrDie;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


import static my.cufee.partygame.Games.DigOrDie.DigOrDieLocation.locSpawnDigOrDie;
import static my.cufee.partygame.Games.PlayersArray.*;



public class DigOrDieGame {
    public static void startDigOrDie(){
        Bukkit.broadcastMessage(String.valueOf(playersOnGame.length));
        DigOrDieLocation.setLocation();
        for (int i = 0; i < playersOnGame.length; i++)
        {
            Player teleportedPlayer = playersOnGame[i];
            teleportedPlayer.teleport(locSpawnDigOrDie[i]);
        }
    }
}
