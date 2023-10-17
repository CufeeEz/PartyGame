package my.cufee.partygame.Games;

import my.cufee.partygame.CMD.GameManager;
import org.bukkit.entity.Player;

public class PlayersArray {
    public static int count = 0;
    public static void addPlayer(Player player, int id) {
        playersOnGame[id] = (player);
    }
    public static Player[] createArrayPlayersOnGame(int count){
        return playersOnGame = new Player[GameManager.CreatePlayersCount];
    }
    public static Player[] playersOnGame;


}
