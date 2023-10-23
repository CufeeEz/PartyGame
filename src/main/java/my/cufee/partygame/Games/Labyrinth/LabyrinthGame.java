package my.cufee.partygame.Games.Labyrinth;

import my.cufee.partygame.Games.PlayersArray;
import my.cufee.partygame.Util.AllEvent;
import my.cufee.partygame.Util.ChatBroadcastMessege;
import my.cufee.partygame.Util.PlayerUtil;
import my.cufee.partygame.Util.TimerUtil;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class LabyrinthGame {

    public static void startLabyrinth(){
        spectator = null;
        setSpectator();
        AllEvent.labyrinthTuchEvent = true;
        AllEvent.breakBlocksEnabled = true;
        PlayerUtil.clearPlayers();
        LabyrinthLocation.setlabyrinthSpawnLocation();
        Location spawnLocation = LabyrinthLocation.getRandomSpawnLocationIndex();
        ChatBroadcastMessege.PlayerSendMessages(ChatColor.DARK_GREEN + "Спектатором стал - " + spectator.getName());
        for(Player player : PlayersArray.playersOnGame){
            player.teleport(spawnLocation);
            if(spectator.equals(player)){
                setParameterSpectator(player);
            }
            else {
                setParameterRunner(player);
            }
        }
        TimerUtil.timerLabyrinthGame();
    }
    public static int setRoleLabyrinth() {
        Random random = new Random();
        int randomIndex = random.nextInt(PlayersArray.playersOnGame.length);
        return randomIndex;
    }
    public static void setParameterRunner(Player player){
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 420*20, 1, false, false));

    }
    public static void setParameterSpectator(Player player){
        player.setGameMode(GameMode.SPECTATOR);
    }

    public static Player spectator;

    public static Player setSpectator() {
        int indexSpectator = setRoleLabyrinth();
        spectator = PlayersArray.playersOnGame[indexSpectator];
        return spectator;
    }
}
