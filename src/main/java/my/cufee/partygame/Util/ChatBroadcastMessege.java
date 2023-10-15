package my.cufee.partygame.Util;

import my.cufee.partygame.Games.PlayersArray;
import org.bukkit.entity.Player;

public class ChatBroadcastMessege {
    public static void PlayerSendMessages(String message){
        for(Player Player : PlayersArray.playersOnGame) {
            if (Player != null) {
                Player.sendMessage(message);
            }
        }
    }
}
