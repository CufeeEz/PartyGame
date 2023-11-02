package my.cufee.partygame.Games.BowBattle;

import my.cufee.partygame.Games.PlayersArray;
import my.cufee.partygame.Util.TeleportPlayers;
import my.cufee.partygame.Util.TimerUtil;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class BowBattleGame {
    public static void bowBattleStart(){
        deathPlayer();
        closeSpawnBox();
        spawnPlayers();
        getAmmunition();
        TimerUtil.timeInfoStartBowBattle();
    }
    public static void spawnPlayers(){
        BowBattleLocation.setLocationBB();
        TeleportPlayers.teleportInMoreLoc(BowBattleLocation.locSpawnBowBattle);
    }
    public static void getAmmunition(){
        ItemStack stick = new ItemStack(Material.BOW);
        ItemMeta stickMeta = stick.getItemMeta();
        stickMeta.addEnchant(Enchantment.KNOCKBACK, 2, true);
        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        bowMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true);
        bowMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        bowMeta.setUnbreakable(true);
        bow.setItemMeta(bowMeta);
        for(Player player : PlayersArray.playersOnGame){
            player.getInventory().addItem(bow, stick);
        }
    }
    public static void openSpawnBox(){
        BowBattleLocation.setLocationBoxBB();
        for(int i = 0; i < BowBattleLocation.locBoxSpawnBowBattle.length;i++){
            BowBattleLocation.locBoxSpawnBowBattle[i].getBlock().setType(Material.AIR);
        }
    }
    public static void closeSpawnBox(){
        BowBattleLocation.setLocationBoxBB();
        for(int i = 0; i < BowBattleLocation.locBoxSpawnBowBattle.length;i++){
            BowBattleLocation.locBoxSpawnBowBattle[i].getBlock().setType(Material.AIR);
        }
    }


    public static boolean[] arrayDeathPlayers = new boolean[PlayersArray.playersOnGame.length];
    public static void deathPlayer(){
        Arrays.fill(arrayDeathPlayers, false);
    }
    public static void setDeathPlayer(Player player){
        for(int i = 0; i < PlayersArray.playersOnGame.length; i++){
            if(player.equals(PlayersArray.playersOnGame[i])){
                //arrayDeathPlayers[i] = true;
            }
        }
    }
}
