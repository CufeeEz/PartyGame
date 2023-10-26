package my.cufee.partygame.Games.Parkour;

import my.cufee.partygame.CMD.GameManager;
import my.cufee.partygame.Games.PlayersArray;
import my.cufee.partygame.MainLocation.SpawnLocation;
import my.cufee.partygame.Util.AllEvent;
import my.cufee.partygame.Util.PlayerUtil;
import my.cufee.partygame.Util.TeleportPlayers;
import my.cufee.partygame.Util.TimerUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ParkourGame {
    public static void startParkour(){
        countFinished = 0;
        TimerUtil.timeStartParkour();
        AllEvent.breakBlocksEnabled = true;
    }
    static int countFinished = 0;
    public static void endGame(){
        AllEvent.ParkourTuchEvent = false;
        TimerUtil.timerTimeOut();
        Bukkit.getScheduler().cancelTask(TimerUtil.timerIdParkour);
    }
    public static void countFinisedParkour(){
        countFinished += 1;
        if(countFinished == GameManager.CreatePlayersCount){
            endGame();
        }
    }
    public static void setBlock(){
        ParkourLocartion.setParkourLocationBlock();
        for(int i = 0; i < ParkourLocartion.ParkourLocationBlock.length;i++){
            ParkourLocartion.ParkourLocationBlock[i].getBlock().setType(Material.RED_STAINED_GLASS);
        }
    }
    public static void removeBlock(){
        ParkourLocartion.setParkourLocationBlock();
        for(int i = 0; i < ParkourLocartion.ParkourLocationBlock.length;i++){
            ParkourLocartion.ParkourLocationBlock[i].getBlock().setType(Material.AIR);
        }
    }
    public static void givePoitonEffectRegeneration(){
        for(Player player : PlayersArray.playersOnGame){
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 300*20, 10, false, false));
        }
    }
}
