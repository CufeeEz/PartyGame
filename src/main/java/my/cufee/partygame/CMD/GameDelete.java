package my.cufee.partygame.CMD;


import my.cufee.partygame.Games.PlayersArray;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameDelete implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            if (GameJoin.GameStatus){
                Player deletingPlayer = (Player) commandSender;
                if (deletingPlayer.isOp())
                {
                    Bukkit.broadcastMessage(ChatColor.GREEN + deletingPlayer.getName() + " удалил игру!" +
                            ChatColor.YELLOW + "\nДля создания игры напишите /BFcreate");

                }
                else {
                    commandSender.sendMessage(ChatColor.RED + "Вы не оператор!");
                }

            }
            else {
                commandSender.sendMessage(ChatColor.RED + "Игра не создана!");
            }
        }
        else {
            commandSender.sendMessage(ChatColor.RED + "Вы не игрок!");
        }
        return false;
    }
}