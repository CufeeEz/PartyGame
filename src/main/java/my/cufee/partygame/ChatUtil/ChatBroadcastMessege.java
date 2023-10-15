package my.cufee.partygame.ChatUtil;

import my.cufee.partygame.Games.PlayersArray;

public class ChatBroadcastMessege {
    public static void PlayerSendMessages(String message){
        for(org.bukkit.entity.Player Player : PlayersArray.playersOnGame) {
            if (Player != null) {
                Player.sendMessage(message);
            }
        }
    }
}
