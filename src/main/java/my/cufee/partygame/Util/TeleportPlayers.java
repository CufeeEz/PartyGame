package my.cufee.partygame.Util;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import static my.cufee.partygame.Games.PlayersArray.playersOnGame;

public class TeleportPlayers {
    public static void teleportInOneLoc(Location teleportLoc){
        for (Player teleportPlayer : playersOnGame) {
            teleportPlayer.teleport(teleportLoc);
        }
    }
    public static void teleportInMoreLoc(Location[] arrayLoc){
        for (int i = 0; i < playersOnGame.length; i++)
        {
            Player teleportedPlayer = playersOnGame[i];
            teleportedPlayer.teleport(arrayLoc[i]);
        }
    }
}
