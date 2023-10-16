package my.cufee.partygame.Util;

import my.cufee.partygame.Games.DigOrDie.DigOrDieGame;
import my.cufee.partygame.Games.GoldRush.GoldRushEvents;
import my.cufee.partygame.Games.GoldRush.GoldRushLocation;
import my.cufee.partygame.Games.GoldRush.GoldRushStartGame;
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
                timeStartgr();
            }
        }, 0, 20).getTaskId();
    }

    // таймеры голдраша
    static int timerIdGR;
    static int timerStartGR = 6;
    public static void timeStartgr(){
        timerIdGR = Bukkit.getScheduler().runTaskTimer(PartyGame.getInstance(), () -> {
            if(timerStartGR == 6){
                GoldRushEvents.setblock();
                TeleportPlayers.teleportInOneLoc(GoldRushLocation.GRLocationSpawn);
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.GOLD + "[=---Gold" + ChatColor.DARK_RED + "Rush---=]");
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.GOLD + "В этой игре вам предстоит добывать" +
                        ChatColor.GREEN + " золотую " + ChatColor.GOLD + "руду");
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.GOLD + "Сломанная руда появляется каждые 20 секунд");
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.GOLD + "Побеждает тот, кто добудет больше всего руд");
            }
            else if(timerStartGR > 0 && timerStartGR < 6){
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "Начинайте копать через: " + timerStartGR);
            }
            else if(timerStartGR == 0){
                GoldRushStartGame.grStart();
                Bukkit.getScheduler().cancelTask(timerStartGR);
            }
            timerStartGR--;
        }, 0, 20).getTaskId();
    }

}