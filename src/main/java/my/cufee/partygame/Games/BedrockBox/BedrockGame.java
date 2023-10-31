package my.cufee.partygame.Games.BedrockBox;

import my.cufee.partygame.Games.Parkour.ParkourLocartion;
import my.cufee.partygame.MainLocation.SpawnLocation;
import my.cufee.partygame.Util.TeleportPlayers;
import my.cufee.partygame.Util.TimerUtil;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

import static my.cufee.partygame.Games.PlayersArray.playersOnGame;

public class BedrockGame {
    public static void startGame(){
        BedrockLocation.setSpawnLocation();
        BedrockLocation.setBedrockDoor();
        TimerUtil.timeInfoStartBRB();
        setDoor();
        for (Player player : playersOnGame) {
            givePoitonEffect(player);
            player.getInventory().addItem(createShovel());
            player.setGameMode(GameMode.SURVIVAL);
        }
        TeleportPlayers.teleportInMoreLoc(BedrockLocation.locSpawnBedrock);
        FillBox();
        spawnRandomDiamondBlock();
    }

    public static void givePoitonEffect(Player player){
        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 300*20, 10, false, false));
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 300*20, 10, false, false));
    }
    public static ItemStack createShovel() {
        ItemStack ironPickaxe = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta itemMeta = ironPickaxe.getItemMeta();
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addEnchant(Enchantment.DIG_SPEED, 5, true);
        ironPickaxe.setItemMeta(itemMeta);
        return ironPickaxe;
    }
    public static void FillBox(){
        for (int x = -220; x >= -270; x--) {
            for (int y = 30; y < 55; y++) {
                for (int z = -70; z >= -120; z--) {
                    Location location = new Location(SpawnLocation.world, x, y, z);
                    Block block = SpawnLocation.world.getBlockAt(location);
                    block.setType(Material.DIRT);
                }
            }
        }
    }
    public static void spawnRandomDiamondBlock() {
        Random random = new Random();
        int x = random.nextInt((-220 - (-270) + 1));
        x += -270;
        int y = random.nextInt((55 - 30 + 1));
        y += 30;
        int z = random.nextInt((-70 - (-120) + 1));
        z += -120;
        Location location = new Location(SpawnLocation.world, x, y, z);
        Block block = SpawnLocation.world.getBlockAt(location);
        block.setType(Material.DIAMOND_BLOCK);
    }
    public static void setDoor(){
        for(int i = 0; i < BedrockLocation.locBedrockDoor.length; i++){
            BedrockLocation.locBedrockDoor[i].getBlock().setType(Material.TINTED_GLASS);
        }
    }
    public static void removeDoor(){
        for(int i = 0; i < BedrockLocation.locBedrockDoor.length; i++){
            BedrockLocation.locBedrockDoor[i].getBlock().setType(Material.AIR);
        }
    }
}
