package my.cufee.partygame.Games;

import my.cufee.partygame.CMD.GameManager;
import my.cufee.partygame.Util.ChatBroadcastMessege;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import static my.cufee.partygame.Games.PlayersArray.playersOnGame;

public class PlayersScore {
    public static int[] Score = new int[GameManager.CreatePlayersCount];
    static int CountPoint = 5;
    public static void setPoint(Player player){
        for(int i = 0; i <= playersOnGame.length; i++){
            if (player.equals(playersOnGame[i])){
                if (CountPoint == 5) {
                    Score[i] += 5;
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GRAY + player.getName() + ChatColor.DARK_GREEN
                            + " получил " + CountPoint + " очков!");
                    CountPoint -= 2;
                    break;
                }
                if (CountPoint == 3){
                    Score[i] += 3;
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GRAY + player.getName() + ChatColor.GREEN
                            + " получил " + CountPoint + " очка!");
                    CountPoint -= 1;
                    break;
                }
                if (CountPoint == 2){
                    Score[i] += 2;
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GRAY + player.getName() + ChatColor.YELLOW
                            + " получил " + CountPoint+ " очка!");
                    CountPoint -= 1;
                    break;
                }
                else {
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GRAY + player.getName() + ChatColor.RED
                            + " получил " + CountPoint + " очко!");
                    Score[i] += 1;
                }
            }
        }
    }
}
