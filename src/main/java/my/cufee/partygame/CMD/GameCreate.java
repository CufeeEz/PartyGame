package my.cufee.partygame.CMD;

import my.cufee.partygame.Games.PlayersArray;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameCreate implements CommandExecutor {
    public static int CreatePlayersCount;


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player gameCreator = (Player) commandSender;
            if (!GameJoin.GameStatus){
                if (gameCreator.isOp()) {
                    CreatePlayersCount = Integer.parseInt(args[0]);
                    Bukkit.broadcastMessage(ChatColor.GREEN + gameCreator.getName() + " создал игру!" +
                            ChatColor.YELLOW + "\nДля подключения напишите /BFjoin");
                    GameJoin.GameStatus = true;
                    PlayersArray.createArrayPlayersOnGame(CreatePlayersCount);
                }
                else {
                    commandSender.sendMessage(ChatColor.RED + "Вы не оператор!");
                }
            }
            else {
                commandSender.sendMessage(ChatColor.RED + "Игра уже создана!");
            }
        }
        else {
            commandSender.sendMessage(ChatColor.RED + "Вы не игрок!");
        }
        return false;
    }
}