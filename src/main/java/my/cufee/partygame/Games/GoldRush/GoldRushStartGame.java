package my.cufee.partygame.Games.GoldRush;

import my.cufee.partygame.Util.TeleportPlayers;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import static my.cufee.partygame.Games.PlayersArray.playersOnGame;

public class GoldRushStartGame {
    public static void grStart(){
        TeleportPlayers.teleportInOneLoc(GoldRushLocation.GRLocationSpawn);
    }
}
