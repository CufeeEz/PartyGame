package my.cufee.partygame.Games;

import my.cufee.partygame.CMD.GameManager;
import my.cufee.partygame.Util.ChatBroadcastMessege;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Arrays;

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
                    break;
                }
            }
        }
    }

    public static void resetScoreGoldRush(){
        Arrays.fill(ScoreGoldRush, 0);
    }
    //регистрация очков за мини-игру
    public static int[] ScoreGoldRush = new int[GameManager.CreatePlayersCount];
    public static void setPointGoldRush(Player player){
        for(int i = 0; i < playersOnGame.length; i++) {
            if (player.equals(playersOnGame[i])) {
                ScoreGoldRush[i] += 1;
                Bukkit.broadcastMessage(player.getName()+ " "+ ScoreGoldRush[i]);
            }
        }
    }
    //сортировка очков
    public static void sortScoreGoldRush(){
        for (int i = 0; i < ScoreGoldRush.length - 1; i++) {
            for (int j = i + 1; j < ScoreGoldRush.length; j++) {
                if (ScoreGoldRush[j] > ScoreGoldRush[i]) {
                    int tempScore = ScoreGoldRush[i];
                    ScoreGoldRush[i] = ScoreGoldRush[j];
                    ScoreGoldRush[j] = tempScore;
                    Player tempPlayer = playersOnGame[i];
                    playersOnGame[i] = playersOnGame[j];
                    playersOnGame[j] = tempPlayer;
                }
            }
        }
        for (int i = 0; i < ScoreGoldRush.length; i++) {
            setScoreGoldRush(i, ScoreGoldRush[i]);
        }
    }
    //выдача очков за голдраш
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
        Bukkit.broadcastMessage(playersOnGame[i].getName() + " " +  Score[i]);
    }
}
