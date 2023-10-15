package my.cufee.partygame.CMD;

import my.cufee.partygame.MainLocation.SpawnLocation;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class GameLeave implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player gamePlayer = (Player) commandSender;
            if (GameJoin.GameStatus){
                if (Arrays.asList(PlayersCount.playersOnGame).contains(gamePlayer)){
                    PlayersCount.count -= 1;
                    Bukkit.broadcastMessage(ChatColor.GRAY + gamePlayer.getName() + ChatColor.GREEN +
                            " вышел из игры (" + PlayersCount.count + "/" + GameCreate.CreatePlayersCount + ")");
                    for (int i = 0; i < PlayersCount.playersOnGame.length; i++) {
                        if (PlayersCount.playersOnGame[i].equals(gamePlayer)) {
                            PlayersCount.playersOnGame[i] = null;
                        }
                    }
                    gamePlayer.teleport(SpawnLocation.getLocLobby());
                }
                else {
                    commandSender.sendMessage(ChatColor.RED + "Вы не в игре!");
                }
            }
            else {
                commandSender.sendMessage(ChatColor.RED + "Игра не запущена!");
            }

        }
        else {
            commandSender.sendMessage(ChatColor.RED + "Вы не игрок!");
        }
        return false;
    }
}