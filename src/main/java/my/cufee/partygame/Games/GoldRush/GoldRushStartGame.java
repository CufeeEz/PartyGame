package my.cufee.partygame.Games.GoldRush;

import my.cufee.partygame.Util.TeleportPlayers;

public class GoldRushStartGame {
    public static void grStart(){
        TeleportPlayers.teleportInOneLoc(GoldRushLocation.GRLocationSpawn);
    }
}
