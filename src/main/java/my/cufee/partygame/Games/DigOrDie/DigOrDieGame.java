package my.cufee.partygame.Games.DigOrDie;

import my.cufee.partygame.Games.PlayersArray;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockSpreadEvent;

import javax.xml.stream.Location;

import static my.cufee.partygame.Games.DigOrDie.DigOrDieLocation.locSpawnDigOrDie;
import static my.cufee.partygame.Games.PlayersArray.*;

public class DigOrDieGame {
    public static void startDigOrDie(){
        for (int i = 0; i == playersOnGame.length; i++)
        {
            Player teleportedPlayer = playersOnGame[i];
            teleportedPlayer.teleport(locSpawnDigOrDie[i]);
        }
    }

}
