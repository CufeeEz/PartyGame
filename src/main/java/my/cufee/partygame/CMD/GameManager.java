package my.cufee.partygame.CMD;

import my.cufee.partygame.Games.PlayersArray;
import my.cufee.partygame.MainLocation.SpawnLocation;
import my.cufee.partygame.Util.TimerUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameManager implements CommandExecutor, TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 1) {
            return Arrays.asList("create", "join", "leave", "delete");
        } else if (args.length == 2 && args[0].equalsIgnoreCase("create")) {
            return Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8");
        }
        return Collections.emptyList();
    }
    public static int CreatePlayersCount;
    public static boolean GameStatus = false;
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            if (strings[0].equals("create")) {
                if(strings.length != 1){
                    Player gameCreator = (Player) commandSender;
                    if (gameCreator.isOp()) {
                        if (!GameStatus) {
                            int countPlayers = Integer.parseInt(strings[1]);
                            if (countPlayers >= 1 && countPlayers <= 8) {
                                CreatePlayersCount = Integer.parseInt(strings[1]);
                                Bukkit.broadcastMessage(ChatColor.GREEN + gameCreator.getName() + " создал игру!" +
                                        ChatColor.YELLOW + "\nДля подключения напишите /pg join");
                                GameStatus = true;
                                PlayersArray.createArrayPlayersOnGame(CreatePlayersCount);
                                return true;
                            } else {
                                commandSender.sendMessage(ChatColor.RED + "Количество игроков должно быть от 1 до 8!");
                                return false;
                            }
                        } else {
                            commandSender.sendMessage(ChatColor.RED + "Игра уже создана!");
                            return false;
                        }
                    }
                    else {
                        commandSender.sendMessage(ChatColor.RED + "Вы не оператор!");
                        return false;
                    }
                }
                else {
                    commandSender.sendMessage(ChatColor.RED + "Неправильное использование команды!\n/pg create <num>");
                    return false;
                }
            }
            else if (Objects.equals(strings[0], "join")) {
                Player GamePlayer = (Player) commandSender;
                if (GameStatus){
                    if (PlayersArray.count <= (int) CreatePlayersCount){
                        if (!Arrays.asList(PlayersArray.playersOnGame).contains(GamePlayer)) {
                            PlayersArray.addPlayer(GamePlayer, PlayersArray.count);
                            PlayersArray.count += 1;
                            Bukkit.broadcastMessage(ChatColor.GRAY + GamePlayer.getName() + ChatColor.GREEN +
                                    " подключился (" + PlayersArray.count + "/" + CreatePlayersCount + ")");
                            GamePlayer.teleport(SpawnLocation.getLocHub());
                            if (PlayersArray.count == (int) CreatePlayersCount) {
                                TimerUtil.timeStartGame();
                            }
                        }
                        else {
                            commandSender.sendMessage(ChatColor.DARK_RED + "Вы уже в игре!" + ChatColor.GRAY +
                                    "\nДля выхода из игры напишите /pg leave");
                            return false;
                        }
                    }
                    else {
                        commandSender.sendMessage(ChatColor.DARK_RED + "В игре максимальное количество игроков");
                        return false;
                    }
                }
                else {
                    commandSender.sendMessage(ChatColor.DARK_RED + "Игра не запущена, ожидайте запуск игры!");
                    return false;
                }
            }
            else if (Objects.equals(strings[0], "leave")) {
                Player gamePlayer = (Player) commandSender;
                if (GameStatus){
                    if (Arrays.asList(PlayersArray.playersOnGame).contains(gamePlayer)){
                        PlayersArray.count -= 1;
                        Bukkit.broadcastMessage(ChatColor.GRAY + gamePlayer.getName() + ChatColor.GREEN +
                                " вышел из игры (" + PlayersArray.count + "/" + CreatePlayersCount + ")");
                        for (int i = 0; i < PlayersArray.playersOnGame.length; i++) {
                            if (PlayersArray.playersOnGame[i].equals(gamePlayer)) {
                                PlayersArray.playersOnGame[i] = null;
                            }
                        }
                        gamePlayer.teleport(SpawnLocation.getLocLobby());
                    }
                    else {
                        commandSender.sendMessage(ChatColor.DARK_RED + "Вы не в игре!");
                        return false;
                    }
                }
                else {
                    commandSender.sendMessage(ChatColor.DARK_RED + "Игра не запущена!");
                    return false;
                }
            }
            else if (Objects.equals(strings[0], "delete")) {

                // метод не рабочий
                if (GameStatus){
                    Player deletingPlayer = (Player) commandSender;
                    if (deletingPlayer.isOp())
                    {
                        Bukkit.broadcastMessage(ChatColor.GREEN + deletingPlayer.getName() + " удалил игру!" +
                                ChatColor.YELLOW + "\nДля создания игры напишите /pg create");

                    }
                    else {
                        commandSender.sendMessage(ChatColor.DARK_RED + "Вы не оператор!");
                        return false;
                    }

                }
                else {
                    commandSender.sendMessage(ChatColor.DARK_RED + "Игра не создана!");
                    return false;
                }
            }
            else {
                commandSender.sendMessage(ChatColor.DARK_RED + "Неизвестная команда!\n" +
                        ChatColor.YELLOW + "Доступные команды - create, join, leave, delete");
            }
        }
        else {
            commandSender.sendMessage(ChatColor.DARK_RED + "Вы не игрок!");
            return false;
        }
        return false;
    }
}
