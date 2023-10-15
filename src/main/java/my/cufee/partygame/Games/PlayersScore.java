package my.cufee.partygame.Games;

import my.cufee.partygame.CMD.GameCreate;
import my.cufee.partygame.Util.ChatBroadcastMessege;
import org.bukkit.entity.Player;

import static my.cufee.partygame.Games.PlayersArray.playersOnGame;

public class PlayersScore {
    public static int[] Score = new int[GameCreate.CreatePlayersCount];
    static int CountPoint = 5;
    public static void setPoint(Player player){
        for(int i = 0; i <= playersOnGame.length; i++){
            if (player.equals(playersOnGame)){
                if (CountPoint == 5) {
                    Score[i] += 5;
                    ChatBroadcastMessege.PlayerSendMessages(player.getName() + " получил " + CountPoint);
                    CountPoint = -2;
                }
                if (CountPoint == 3){
                    Score[i] += 3;
                    ChatBroadcastMessege.PlayerSendMessages(player.getName() + " получил " + CountPoint);
                    CountPoint =-1;
                }
                if (CountPoint == 2){
                    Score[i] += 2;
                    ChatBroadcastMessege.PlayerSendMessages(player.getName() + " получил " + CountPoint);
                    CountPoint =-1;
                }
                else {
                    ChatBroadcastMessege.PlayerSendMessages(player.getName() + " получил " + CountPoint);
                    Score[i] += 1;
                }
            }
        }
    }
}
