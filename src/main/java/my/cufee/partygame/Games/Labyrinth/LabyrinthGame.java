package my.cufee.partygame.Games.Labyrinth;

import my.cufee.partygame.Games.PlayersArray;
import my.cufee.partygame.Util.PlayerUtil;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class LabyrinthGame {
    static Location spawnLocation = LabyrinthLocation.getRandomSpawnLocationIndex();
    public static void startLabyrinth(){
        PlayerUtil.clearPlayers();

        int indexSpectator = setRoleLabyrinth();
        Player spectator = PlayersArray.playersOnGame[indexSpectator];
        for(Player player : PlayersArray.playersOnGame){
            player.teleport(spawnLocation);
            if(spectator.equals(player)){
                setParameterSpectator(player);
            }
            else {
                setParameterRunner(player);
            }
        }
    }
    public static int setRoleLabyrinth(){
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
}
