package my.cufee.partygame.Util;

import my.cufee.partygame.CMD.GameManager;
import my.cufee.partygame.Games.GoldRush.GoldRushEvents;
import my.cufee.partygame.Games.GoldRush.GoldRushLocation;
import my.cufee.partygame.Games.GoldRush.GoldRushStartGame;
import my.cufee.partygame.Games.PlayersArray;
import my.cufee.partygame.MainLocation.SpawnLocation;
import my.cufee.partygame.PartyGame;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import static my.cufee.partygame.Games.PlayersScore.calculatePointGoldRush;
import static my.cufee.partygame.Util.PlayerUtil.clearPlayers;

public class TimerUtil {
    static AllEvent event = new AllEvent();
    static int timerIdGameRule;
    static int timerStartGame = 5;
    public static void timeStartGame(){
        timerIdGameRule = Bukkit.getScheduler().runTaskTimer(PartyGame.getInstance(), () -> {
            if (timerStartGame > 0){
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "До начала игры: " + timerStartGame);
                timerStartGame--;
            }
            else{
                clearPlayers();
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
                timeStartgrGame();
                GoldRushStartGame.grStart();
                Bukkit.getScheduler().cancelTask(timerStartGR);
            }
            timerStartGR--;
        }, 0, 20).getTaskId();
    }
    static int timerIdGRgame;
    static int timerStartGRgame = 30; //310
    public static void timeStartgrGame(){
        timerIdGRgame = Bukkit.getScheduler().runTaskTimer(PartyGame.getInstance(), () -> {
            switch (timerStartGRgame){
                case 183:
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "До конца игры осталось "
                        + (int) (timerStartGRgame-3)/60 + " минуты");
                    break;
                case 123:
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "До конца игры осталось "
                            + (int) (timerStartGRgame-3)/60 + " минуты");
                    break;
                case 63:
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "До конца игры осталось 1 минута");
                    break;
                case 8:
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "До конца игры осталось "+ (timerStartGRgame-3) + " секунд");
                    break;
                case 6:
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "До конца игры осталось "+ (timerStartGRgame-3) + " секунды");
                    break;
                case 5:
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "До конца игры осталось "+ (timerStartGRgame-3) + " секунды");
                    break;
                case 4:
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "До конца игры осталось "+ (timerStartGRgame-3) + " секунда");
                    break;
                case 3:
                    clearPlayers();
                    calculatePointGoldRush();
                    Bukkit.broadcastMessage("вызов калькуляции");
                    for(int i = 0; i < PlayersArray.playersOnGame.length; i++){
                        calculatePointGoldRush();
                    }
                case 0:
                    for(Player player: PlayersArray.playersOnGame) {
                        player.teleport(SpawnLocation.getLocHub());
                    }

            }
            timerStartGRgame--;
        }, 0, 20).getTaskId();
    }
    static int timerIdTimeOut;
    static int timerTimeOut = 10;
    public static void timerTimeOut() {
        timerIdTimeOut = Bukkit.getScheduler().runTaskTimer(PartyGame.getInstance(), () -> {
            if (timerTimeOut==0){

            }
            timerTimeOut--;
        }, 0, 20).getTaskId();
    }
}