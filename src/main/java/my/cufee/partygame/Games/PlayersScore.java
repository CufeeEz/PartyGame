package my.cufee.partygame.Games;

import my.cufee.partygame.CMD.GameManager;
import my.cufee.partygame.Util.ChatBroadcastMessege;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import static my.cufee.partygame.Games.PlayersArray.playersOnGame;

public class PlayersScore {
    public static int[] Score = new int[GameManager.CreatePlayersCount];
    static int CountPoint = 5;
    public static void setPoint(Player player){
        for(int i = 0; i < playersOnGame.length; i++){
            if (player.equals(playersOnGame[i])){
                if (CountPoint == 5) {
                    Score[i] += 5;
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GRAY + player.getName() + ChatColor.DARK_GREEN
                            + " получил " + CountPoint + " очков!");
                    CountPoint -= 2;
                    break;
                }
                else if (CountPoint == 3){
                    Score[i] += 3;
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GRAY + player.getName() + ChatColor.GREEN
                            + " получил " + CountPoint + " очка!");
                    CountPoint -= 1;
                    break;
                }
                else if (CountPoint == 2){
                    Score[i] += 2;
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GRAY + player.getName() + ChatColor.YELLOW
                            + " получил " + CountPoint+ " очка!");
                    CountPoint -= 1;
                    break;
                }
                else if (CountPoint == 1) {
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GRAY + player.getName() + ChatColor.RED
                            + " получил " + CountPoint + " очко!");
                    Score[i] += 1;
                    Bukkit.broadcastMessage(player.getName() + " имеет " + Score[i] + " очков");
                    break;
                }
            }
        }
    }
    public static int[] ScoreGoldRush = new int[GameManager.CreatePlayersCount];
    public static void setPointGoldRush(Player player){
        for(int i = 0; i < playersOnGame.length; i++) {
            if (player.equals(playersOnGame[i])) {
                ScoreGoldRush[i] += 1;
                Bukkit.broadcastMessage(player.getName()+ " "+ ScoreGoldRush[i]);
            }
        }
    }
    static int max = 0;
    static int maxindex = 0;
    public static void calculatePointGoldRush() {
        for (int i = 0; i < ScoreGoldRush.length; i++) {
            if (ScoreGoldRush[i] > max) {
                max = ScoreGoldRush[i];
                ScoreGoldRush[i] = 0;
                maxindex = i;
            }
        }
        setScoreGoldRush(maxindex,max);
    }
        public static int setPointGR = 5;
    public static void setScoreGoldRush(int i, int count){
        if (setPointGR == 5) {
            Score[i] += 5;
            ChatBroadcastMessege.PlayerSendMessages(ChatColor.GRAY + playersOnGame[i].getName() + ChatColor.DARK_GREEN
                    + " получил " + setPointGR + " очков и добыл " + count + " золота!");
            setPointGR -= 2;
        }
        else if (setPointGR == 3){
            Score[i] += 3;
            ChatBroadcastMessege.PlayerSendMessages(ChatColor.GRAY + playersOnGame[i].getName() + ChatColor.GREEN
                    + " получил " + setPointGR + " очка и добыл " + count + " золота!");
            setPointGR -= 1;
        }
        else if (setPointGR == 2){
            Score[i] += 2;
            ChatBroadcastMessege.PlayerSendMessages(ChatColor.GRAY + playersOnGame[i].getName() + ChatColor.YELLOW
                    + " получил " + setPointGR+ " очка и добыл " + count + " золота!");
            setPointGR -= 1;
        }
        else if (setPointGR == 1) {
            ChatBroadcastMessege.PlayerSendMessages(ChatColor.GRAY + playersOnGame[i].getName() + ChatColor.RED
                    + " получил " + setPointGR + " очко и добыл " + count + " золота!");
            Score[i] += 1;
        }
        for(int ii = 0; i < playersOnGame.length; i++){
            Bukkit.broadcastMessage(playersOnGame[i].getName() + " " + Score[i]);
        }
    }
}
