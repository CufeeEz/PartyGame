package my.cufee.partygame.CMD;

import my.cufee.partygame.Games.DigOrDie.DigOrDieGame;
import my.cufee.partygame.Games.GoldRush.GoldRushStartGame;
import my.cufee.partygame.Games.PlayersArray;
import my.cufee.partygame.MainLocation.SpawnLocation;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;


public class GameJoin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player GamePlayer = (Player) commandSender;
            if (GameStatus){
                if (PlayersArray.count <= (int ) GameCreate.CreatePlayersCount){
                    if (!Arrays.asList(PlayersArray.playersOnGame).contains(GamePlayer)) {
                        PlayersArray.addPlayer(GamePlayer, PlayersArray.count);
                        PlayersArray.count += 1;
                        Bukkit.broadcastMessage(ChatColor.GRAY + GamePlayer.getName() + ChatColor.GREEN +
                                " подключился (" + PlayersArray.count + "/" + GameCreate.CreatePlayersCount + ")");
                        GamePlayer.teleport(SpawnLocation.getLocHub());
                        if (PlayersArray.count == (int) GameCreate.CreatePlayersCount) {
                            GoldRushStartGame.grStart();
                        }
                    }
                    else {
                        commandSender.sendMessage(ChatColor.RED + "Вы уже в игре!" + ChatColor.GRAY +
                                "\nДля выхода из игры напишите /BFleave");
                    }
                }
                else {
                    commandSender.sendMessage(ChatColor.RED + "В игре максимальное количество игроков");
                }
            }
            else {
                commandSender.sendMessage(ChatColor.RED + "Игра не запущена, ожидайте запуск игры!");
            }
        }
        else {
            commandSender.sendMessage(ChatColor.RED + "Вы не игрок!");
        }
        return false;
    }
    public static boolean GameStatus = false;
}