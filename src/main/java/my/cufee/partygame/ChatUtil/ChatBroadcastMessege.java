package my.cufee.partygame.ChatUtil;

public class ChatBroadcastMessege {
    public static void PlayerSendMessages(String message){
        for(org.bukkit.entity.Player Player : PlayersCount.playersOnGame) {
            if (Player != null) {
                Player.sendMessage(message);
            }
        }
    }
}
