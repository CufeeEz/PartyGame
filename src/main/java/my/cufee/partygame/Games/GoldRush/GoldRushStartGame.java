package my.cufee.partygame.Games.GoldRush;


import my.cufee.partygame.MainLocation.SpawnLocation;
import my.cufee.partygame.Util.TeleportPlayers;
import org.bukkit.Location;


public class GoldRushStartGame {
    static Location l1 = new Location(SpawnLocation.world, -41, 73,-42);
    static Location l2 = new Location(SpawnLocation.world, -59, 80,-28);
    public static void grStart(){
        TeleportPlayers.teleportInOneLoc(GoldRushLocation.GRLocationSpawn);

    }
}


