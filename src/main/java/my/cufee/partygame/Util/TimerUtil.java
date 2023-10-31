package my.cufee.partygame.Util;

import my.cufee.partygame.Games.BedrockBox.BedrockGame;
import my.cufee.partygame.Games.DigOrDie.DigOrDieGame;
import my.cufee.partygame.Games.DigOrDie.DigOrDieLocation;
import my.cufee.partygame.Games.GoldRush.GoldRushEvents;
import my.cufee.partygame.Games.GoldRush.GoldRushLocation;
import my.cufee.partygame.Games.GoldRush.GoldRushStartGame;
import my.cufee.partygame.Games.Parkour.ParkourGame;
import my.cufee.partygame.Games.Parkour.ParkourLocartion;
import my.cufee.partygame.Games.PlayersArray;
import my.cufee.partygame.Games.PlayersScore;
import my.cufee.partygame.MainLocation.SpawnLocation;
import my.cufee.partygame.PartyGame;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import static my.cufee.partygame.Games.DigOrDie.DigOrDieGame.*;
import static my.cufee.partygame.Games.DigOrDie.DigOrDieLocation.locSpawnDigOrDie;
import static my.cufee.partygame.Games.GoldRush.GoldRushStartGame.giveLeatherArmor;
import static my.cufee.partygame.Games.PlayersScore.*;
import static my.cufee.partygame.Util.PlayerUtil.clearPlayers;
import static my.cufee.partygame.Util.TeleportPlayers.teleportInMoreLoc;

public class TimerUtil {
    static int timerIdGameRule;
    static int timerStartGame;

    public static void timeStartGame() {
        timerStartGame = 5;
        timerIdGameRule = Bukkit.getScheduler().runTaskTimer(PartyGame.getInstance(), () -> {
            if (timerStartGame > 0) {
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "До начала игры: " + timerStartGame);
                timerStartGame--;
            } else {
                GameRoll.beginGame();
                Bukkit.getScheduler().cancelTask(timerIdGameRule);
            }
        }, 0, 20).getTaskId();
    }

    // таймеры голдраша
    static int timerIdGR;
    static int timerStartGR;

    public static void timeStartgr() {
        timerStartGR = 6;
        timerIdGR = Bukkit.getScheduler().runTaskTimer(PartyGame.getInstance(), () -> {
            if (timerStartGR == 6) {
                AllEvent.breakBlocksEnabled = true;
                giveLeatherArmor();
                GoldRushEvents.setblock();
                TeleportPlayers.teleportInOneLoc(GoldRushLocation.GRLocationSpawn);
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.GOLD + "[=---Gold" + ChatColor.DARK_RED + "Rush---=]");
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.YELLOW + "В этой игре вам предстоит добывать" +
                        ChatColor.GREEN + " золотую " + ChatColor.YELLOW + "руду");
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.YELLOW + "Сломанная руда появляется каждые 20 секунд");
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.YELLOW + "Побеждает тот, кто добудет больше всего руд");
            } else if (timerStartGR > 0 && timerStartGR < 6) {
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "Начинайте копать через: " + timerStartGR);
            } else if (timerStartGR == 0) {
                AllEvent.breakBlocksEnabled = false;
                timeStartgrGame();
                GoldRushStartGame.grStart();
                Bukkit.getScheduler().cancelTask(timerIdGR);
            }
            timerStartGR--;
        }, 0, 20).getTaskId();
    }

    static int timerIdGRgame;
    static int timerStartGRgame;

    public static void timeStartgrGame() {
        timerStartGRgame = 23; // 183
        timerIdGRgame = Bukkit.getScheduler().runTaskTimer(PartyGame.getInstance(), () -> {
            switch (timerStartGRgame) {
                case 183, 123:
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "До конца игры осталось "
                            + (int) (timerStartGRgame - 3) / 60 + " минуты");
                    break;
                case 63:
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "До конца игры осталось 1 минута");
                    break;
                case 8:
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "До конца игры осталось " + (timerStartGRgame - 3) + " секунд");
                    break;
                case 6, 5:
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "До конца игры осталось " + (timerStartGRgame - 3) + " секунды");
                    break;
                case 4:
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "До конца игры осталось " + (timerStartGRgame - 3) + " секунда");
                    break;
                case 3:
                    clearPlayers();
                    sortScoreGoldRush();
                    break;
                case 0:
                    for (int i = 0; i < PlayersArray.playersOnGame.length; i++) {
                        PlayersArray.playersOnGame[i].teleport(SpawnLocation.getLocHub());
                    }
                    AllEvent.breakBlocksEnabled = true;
                    AllEvent.grenabled = false;
                    AllEvent.grReplaceenabled = false;
                    timerTimeOut();
                    PlayersScore.resetScoreGoldRush();
                    Bukkit.getScheduler().cancelTask(timerIdGRgame);
                    break;
            }
            timerStartGRgame--;
        }, 0, 20).getTaskId();
    }

    static int timerIdTimeOut;
    static int timerTimeOut;

    public static void timerTimeOut() {
        timerTimeOut = 10;
        TeleportPlayers.teleportInOneLoc(SpawnLocation.getLocHub());
        PlayerUtil.clearPlayers();
        timerIdTimeOut = Bukkit.getScheduler().runTaskTimer(PartyGame.getInstance(), () -> {
            switch (timerTimeOut) {
                case 10:
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.YELLOW + "Идет подбор следующей игры");
                    break;
                case 0:
                    GameRoll.beginGame();
                    Bukkit.getScheduler().cancelTask(timerIdTimeOut);
                    break;
            }
            timerTimeOut--;
        }, 0, 20).getTaskId();
    }

    // ------------TIMERS PARKOUR
    static int timerIdStartParkour;
    static int timerStartParkour;

    public static void timeStartParkour() {
        timerStartParkour = 6;
        timerIdStartParkour = Bukkit.getScheduler().runTaskTimer(PartyGame.getInstance(), () -> {
            if (timerStartParkour == 6) {
                if (!AllEvent.breakBlocksEnabled) {
                    AllEvent.breakBlocksEnabled = true;
                }
                TeleportPlayers.teleportInOneLoc(ParkourLocartion.ParkourLocationSpawn);
                ParkourGame.setBlock();
                PlayerUtil.clearPlayers();
                ParkourGame.givePoitonEffectRegeneration();
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.LIGHT_PURPLE + "[=---Parkour---=]");
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.YELLOW + "В этой игре вам предстоит пройти весь паркур.");
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.YELLOW + "Побеждают те, кто доберется быстрее всех до конца карты");
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.YELLOW + "В конце карты вас ждет морской фонарь");
            } else if (timerStartParkour > 0 && timerStartParkour < 6) {
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "Забег начнется через: " + timerStartParkour);
            } else if (timerStartParkour == 0) {
                ParkourGame.removeBlock();
                timerParkour();
                Bukkit.getScheduler().cancelTask(timerIdStartParkour);
            }
            timerStartParkour--;
        }, 0, 20).getTaskId();
    }

    public static int timerIdParkour;
    static int timerParkour;

    public static void timerParkour() {
        timerParkour = 300;
        timerIdParkour = Bukkit.getScheduler().runTaskTimer(PartyGame.getInstance(), () -> {
            switch (timerParkour) {
                case 300:
                    AllEvent.ParkourTuchEvent = true;
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "До конца игры осталось " + timerParkour / 60 + " минут");
                    break;
                case 240, 120, 180:
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "До конца игры осталось " + timerParkour / 60 + " минуты");
                    break;
                case 60:
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "До конца игры осталось " + timerParkour / 60 + " минута");
                    break;
            }
            if (timerParkour >= 1 && timerParkour <= 5) {
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "Игра закончится через " + timerParkour);
            } else if (timerParkour == 0) {
                AllEvent.ParkourTuchEvent = false;
                TeleportPlayers.teleportInOneLoc(SpawnLocation.getLocHub());
                PlayerUtil.clearPlayers();
                Bukkit.getScheduler().cancelTask(timerIdParkour);
            }
            timerParkour--;
        }, 0, 20).getTaskId();
    }

    // --- таймеры лабиринта
    static int timerIdLabyrinth;
    static int timerLabyrinth;

    public static void timerLabyrinthGame() {
        timerLabyrinth = 300;
        timerIdLabyrinth = Bukkit.getScheduler().runTaskTimer(PartyGame.getInstance(), () -> {
            switch (timerLabyrinth) {
                case 300:
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "До конца игры осталось " + timerLabyrinth / 60 + " минут");
                    break;
                case 240, 180, 120:
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "До конца игры осталось " + timerLabyrinth / 60 + " минуты");
                    break;
                case 60:
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "До конца игры осталось " + timerLabyrinth / 60 + " минута");
                    break;
            }
            if (timerLabyrinth >= 1 && timerLabyrinth <= 5) {
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "Игра закончится через " + timerParkour);
            } else if (timerLabyrinth == 0) {
                GameRoll.beginGame();
                TeleportPlayers.teleportInOneLoc(SpawnLocation.getLocHub());
                PlayerUtil.clearPlayers();
                Bukkit.getScheduler().cancelTask(timerLabyrinth);
            }
            timerLabyrinth--;
        }, 0, 20).getTaskId();
    }

    static int timerIDStartDigOrDie;
    static int timerStartDigOrDieGame;

    public static void timerStartDigOrDie() {
        timerStartDigOrDieGame = 60;
        timerIDStartDigOrDie = Bukkit.getScheduler().runTaskTimer(PartyGame.getInstance(), () -> {
            switch (timerStartDigOrDieGame) {
                case 30, 20, 10:
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "До конца игры осталось " + timerStartDigOrDieGame + " секунд");
                    break;
            }
            if (timerStartDigOrDieGame >= 1 && timerStartDigOrDieGame <= 5) {
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "Игра закончится через " + timerStartDigOrDieGame);
            } else if (timerStartDigOrDieGame == 0) {
                GameRoll.beginGame();
                TeleportPlayers.teleportInOneLoc(SpawnLocation.getLocHub());
                PlayerUtil.clearPlayers();
                AllEvent.DODTuch = false;
                AllEvent.DODBlockPlace = false;
                AllEvent.breakBlocksEnabled = true;
                Bukkit.getScheduler().cancelTask(timerIDStartDigOrDie);
            }
            timerStartDigOrDieGame--;
        }, 0, 20).getTaskId();
    }
    static int timerStartDOD;
    static int timerIdDOD;
    public static void timeStartDOD() {
        timerStartDOD = 10;
        timerIdDOD = Bukkit.getScheduler().runTaskTimer(PartyGame.getInstance(), () -> {
            if (timerStartDOD == 10) {
                DigOrDieLocation.setLocation();
                teleportInMoreLoc(locSpawnDigOrDie);
                AllEvent.digEnable = true;
                giveArmor();
                giveItemsDigOrDie();
                givePoitonEffectRegeneration();
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.DARK_GRAY + "[=---Dig" + ChatColor.WHITE + " or "+ChatColor.DARK_RED + "Die---=]");
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.WHITE + "В этой игре вам предстоит докопаться до низу");
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.WHITE + "Побеждает тот, кто нажмет на скалк сенсор первый");
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.RED + "УДАЧИ!");
            } else if (timerStartDOD > 0 && timerStartDOD < 6) {
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "Начинайте копать через: " + timerStartDOD);
            } else if (timerStartDOD == 0) {
                AllEvent.breakBlocksEnabled = false;
                DigOrDieGame.removeBadrock();
                timerStartDigOrDie();
                AllEvent.DODTuch = true;
                AllEvent.DODBlockPlace = true;
                Bukkit.getScheduler().cancelTask(timerIdDOD);
            }
            timerStartDOD--;
        }, 0, 20).getTaskId();
    }
    // BEDROCK BOX
    static int timerInfoStartBRB;
    static int timerInfoIdBRB;
    public static void timeInfoStartBRB() {
        timerInfoStartBRB = 10;
        timerInfoIdBRB = Bukkit.getScheduler().runTaskTimer(PartyGame.getInstance(), () -> {
            if (timerInfoStartBRB == 10) {
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.DARK_GRAY + "[=---Bedrock" + ChatColor.WHITE + "Box---=]");
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.YELLOW + "В этой игре вам предстоит найти среди грязи алмаз");
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.YELLOW + "Побеждает тот, кто первый найдем алмазный блок");
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "удачи!");
            } else if (timerInfoStartBRB > 0 && timerInfoStartBRB < 6) {
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.DARK_GREEN + "Начинайте копать через: " + timerInfoStartBRB);
            } else if (timerInfoStartBRB == 0) {
                timeStartBRB();
                AllEvent.breakBlocksEnabled = false;
                AllEvent.bedrockTuchEvent = true;
                AllEvent.breakEnableBedrockBox = true;
                BedrockGame.removeDoor();
                Bukkit.getScheduler().cancelTask(timerInfoIdBRB);
            }
            timerInfoStartBRB--;
        }, 0, 20).getTaskId();
    }
    static int timerStartBRB;
    static int timerIdBRB;
    public static void timeStartBRB() {
        timerStartBRB = 300;
        timerIdBRB = Bukkit.getScheduler().runTaskTimer(PartyGame.getInstance(), () -> {
            switch (timerStartBRB) {
                case 300:
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "До конца игры осталось " + timerStartBRB / 60 + " минут");
                    break;
                case 240, 120, 180:
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "До конца игры осталось " + timerStartBRB / 60 + " минуты");
                    break;
                case 60:
                    ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "До конца игры осталось " + timerStartBRB / 60 + " минута");
                    break;
            }
            if (timerStartBRB > 0 && timerStartBRB < 6) {
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "До конца игры " + timerStartDOD);
            }
            else if(timerStartBRB == 0){
                PlayerUtil.clearPlayers();
                AllEvent.breakBlocksEnabled = true;
                AllEvent.bedrockTuchEvent = false;
                AllEvent.breakEnableBedrockBox = false;
                TeleportPlayers.teleportInOneLoc(SpawnLocation.getLocHub());
                GameRoll.rollGame();
                Bukkit.getScheduler().cancelTask(timerIdBRB);
            }
            timerStartBRB--;
        }, 0, 20).getTaskId();
    }
}