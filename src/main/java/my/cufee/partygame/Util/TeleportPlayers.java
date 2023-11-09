package my.cufee.partygame.Util;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static my.cufee.partygame.Games.PlayersArray.playersOnGame;

public class TeleportPlayers {
    public static void teleportInOneLoc(Location teleportLoc){
        for (Player teleportPlayer : playersOnGame) {
            teleportPlayer.teleport(teleportLoc);
        }
    }
    public static void teleportInMoreLoc(Location[] arrayLoc){
        Location[] randomLocations = Arrays.copyOf(arrayLoc, arrayLoc.length);
        List<Location> randomLocationList = Arrays.asList(randomLocations);
        Collections.shuffle(randomLocationList);
        for (int i = 0; i < playersOnGame.length; i++) {
            playersOnGame[i].teleport(randomLocationList.get(i));
        }
    }
}
