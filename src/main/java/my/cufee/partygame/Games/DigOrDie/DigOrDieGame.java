package my.cufee.partygame.Games.DigOrDie;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import com.sk89q.worldedit.session.ClipboardHolder;
import com.sk89q.worldedit.world.World;
import my.cufee.partygame.Games.Parkour.ParkourLocartion;
import my.cufee.partygame.Games.PlayersArray;
import my.cufee.partygame.MainLocation.SpawnLocation;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.math.BlockVector3;
import my.cufee.partygame.Util.AllEvent;
import my.cufee.partygame.Util.TimerUtil;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;


import java.awt.datatransfer.Clipboard;
import java.io.File;
import java.sql.Time;

import static my.cufee.partygame.Games.DigOrDie.DigOrDieLocation.locSpawnDigOrDie;
import static my.cufee.partygame.Games.PlayersArray.playersOnGame;
import static my.cufee.partygame.Util.TeleportPlayers.teleportInMoreLoc;


public class DigOrDieGame {
    public static void startDigOrDie() {
        TimerUtil.timeStartDOD();
    }

    public static void giveArmor() {
        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
        helmetMeta.setColor(Color.YELLOW);
        helmetMeta.setUnbreakable(true);
        helmet.setItemMeta(helmetMeta);
        for (Player player : playersOnGame) {
            player.getInventory().setHelmet(helmet);

        }
    }
    public static  void giveItemsDigOrDie() {
        ItemStack pickaxe = new ItemStack(Material.IRON_PICKAXE);
        ItemStack axe = new ItemStack(Material.IRON_AXE);
        ItemStack shovel = new ItemStack(Material.IRON_SHOVEL);
        ItemStack shears = new ItemStack(Material.SHEARS);

        ItemMeta metaPickaxe = pickaxe.getItemMeta();
        ItemMeta metaAxe = axe.getItemMeta();
        ItemMeta metaShovel = shovel.getItemMeta();
        ItemMeta metaShears = shears.getItemMeta();

        metaPickaxe.setUnbreakable(true);
        metaAxe.setUnbreakable(true);
        metaShovel.setUnbreakable(true);
        metaShears.setUnbreakable(true);

        metaPickaxe.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        metaAxe.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        metaShovel.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        metaShears.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        metaPickaxe.setDisplayName("Железная камнерезка");
        metaAxe.setDisplayName("Железная дубоснеоска");
        metaShovel.setDisplayName("Железная землеройка");
        metaShovel.setDisplayName("Ножницы маникюрные");

        pickaxe.setItemMeta(metaPickaxe);
        axe.setItemMeta(metaAxe);
        shovel.setItemMeta(metaShovel);
        shears.setItemMeta(metaShears);

        for (Player player : playersOnGame) {
            player.getInventory().addItem(pickaxe);
            player.getInventory().addItem(axe);
            player.getInventory().addItem(shovel);
            player.getInventory().addItem(shears);
        }

    }
    public static void removeBlock(){
        ParkourLocartion.setParkourLocationBlock();
        for(int i = 0; i < DigOrDieLocation.locBedrockDigOrDie.length;i++){
            DigOrDieLocation.locBedrockDigOrDie[i].getBlock().setType(Material.AIR);
        }
    }
    public static void givePoitonEffectRegeneration(){
        for(Player player : PlayersArray.playersOnGame){
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 300*20, 10, false, false));
        }
    }
}
