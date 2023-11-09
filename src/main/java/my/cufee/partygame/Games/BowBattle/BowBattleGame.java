package my.cufee.partygame.Games.BowBattle;

import my.cufee.partygame.CMD.GameManager;
import my.cufee.partygame.Games.PlayersArray;
import my.cufee.partygame.MainLocation.SpawnLocation;
import my.cufee.partygame.PartyGame;
import my.cufee.partygame.Util.AllEvent;
import my.cufee.partygame.Util.ChatBroadcastMessege;
import my.cufee.partygame.Util.TeleportPlayers;
import my.cufee.partygame.Util.TimerUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BowBattleGame {
    public static int[] countPlayersHeal;
    public static void bowBattleStart(){
        count = 1;
        createArrayPlayersHeal();
        for(Player player : PlayersArray.playersOnGame) {
            player.setGameMode(GameMode.SURVIVAL);
            getAmmunition(player);
        }
        closeSpawnBox();
        spawnPlayers();
        TimerUtil.timeInfoStartBowBattle();
    }
    public static void spawnPlayers(){
        BowBattleLocation.setLocationBB();
        TeleportPlayers.teleportInMoreLoc(BowBattleLocation.locSpawnBowBattle);
    }
    public static void getAmmunition(Player player){
        ItemStack stick = new ItemStack(Material.STICK);
        ItemStack arrow = new ItemStack(Material.ARROW);
        ItemMeta stickMeta = stick.getItemMeta();
        stickMeta.addEnchant(Enchantment.KNOCKBACK, 2, true);
        stick.setItemMeta(stickMeta);
        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        bowMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true);
        bowMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        bowMeta.setUnbreakable(true);
        bow.setItemMeta(bowMeta);

        player.getInventory().addItem(bow, stick, arrow);
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
            BowBattleLocation.locBoxSpawnBowBattle[i].getBlock().setType(Material.BARRIER);
        }
    }
    public static void countDeathPlayers(Player player){
        for(int i = 0; i < PlayersArray.playersOnGame.length; i++){
            if(player.equals(PlayersArray.playersOnGame[i])){
                countPlayersHeal[i] += 1;
                switch (countPlayersHeal[i]){
                    case 1: ChatBroadcastMessege.PlayerSendMessages(ChatColor.YELLOW + "У " + player.getName() + " осталось " + (countPlayersHeal[i]+1) + " жизни");break;
                    case 2: ChatBroadcastMessege.PlayerSendMessages(ChatColor.YELLOW + "У " + player.getName() + " осталось " + (countPlayersHeal[i]-1) + " жизнь");break;
                }
            }
            if(countPlayersHeal[i] == 3){
                countDeathAllPlayers();
                player.teleport(BowBattleLocation.locDieBowBattle);
                player.setGameMode(GameMode.SPECTATOR);
                ChatBroadcastMessege.PlayerSendMessages(ChatColor.RED + player.getName() + " выбыл!");
            }
        }
    }
    private static int count = 1;
    public static void countDeathAllPlayers(){
        count += 1;
        if(count == countPlayersHeal.length){
            endBowBattle();
        }
    }
    public static void endBowBattle(){
        AllEvent.bowBattleRespawn = false;
        AllEvent.deathEventBowBattle = false;
        AllEvent.bowBattleTuchEvent = false;
        TimerUtil.timerTimeOut();
        TeleportPlayers.teleportInOneLoc(SpawnLocation.getLocHub());
        Bukkit.getScheduler().cancelTask(TimerUtil.timerIdBowBattle);
    }

    public static int[] createArrayPlayersHeal(){
        return countPlayersHeal = new int[GameManager.CreatePlayersCount];
    }
    public static void respawnPlayer(Player player){
        for(int i = 0; i < PlayersArray.playersOnGame.length; i++) {
            if (player.equals(PlayersArray.playersOnGame[i])) {
                getAmmunition(player);
                int j = i;
                Bukkit.getScheduler().runTaskLater(PartyGame.getInstance(), () -> {
                    player.teleport(BowBattleLocation.locSpawnBowBattle[j]);
                }, 2);
            }
        }
    }
}
