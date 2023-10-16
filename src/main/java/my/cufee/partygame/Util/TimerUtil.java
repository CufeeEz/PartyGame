package my.cufee.partygame.Util;

import my.cufee.partygame.Games.DigOrDie.DigOrDieGame;
import my.cufee.partygame.PartyGame;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class TimerUtil {
    static int timerIdGameRule;
    static int timerStartGame = 5;
    public static void timeStartGame(){
        timerIdGameRule = Bukkit.getScheduler().runTaskTimer(PartyGame.getInstance(), () -> {
            if (timerStartGame > 0){
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "До начала игры: " + timerStartGame);
                timerStartGame--;
            }
            else{
                Bukkit.getScheduler().cancelTask(timerIdGameRule);
                DigOrDieGame.startDigOrDie();
            }
        }, 0, 20).getTaskId();
    }

}