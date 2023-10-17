package my.cufee.partygame.Games.GoldRush;


import my.cufee.partygame.Games.PlayersArray;
import my.cufee.partygame.Games.PlayersScore;
import my.cufee.partygame.Util.AllEvent;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Material;

import org.bukkit.entity.Player;

import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static my.cufee.partygame.Games.PlayersArray.*;


public class GoldRushStartGame {
    public static void grStart(){
        for (Player player : playersOnGame) {
            player.getInventory().addItem(createGoldenOrePickaxe());
            giveLeatherArmor(player);
            givePoitonEffect(player);
            player.setGameMode(GameMode.SURVIVAL);
        }
        AllEvent.grenabled = true;
        AllEvent.grReplaceenabled = true;
        PlayersScore.setPointGR = 5;
    }
    public static ItemStack createGoldenOrePickaxe() {
        ItemStack pickaxe = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta meta = pickaxe.getItemMeta();
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("Алмазный бур");
        pickaxe.setItemMeta(meta);
        return pickaxe;
    }

    public static void giveLeatherArmor(Player player) {
        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);

        LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
        LeatherArmorMeta leggingsMeta = (LeatherArmorMeta) leggings.getItemMeta();
        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();

        helmetMeta.setColor(Color.YELLOW);
        chestplateMeta.setColor(Color.ORANGE);
        leggingsMeta.setColor(Color.YELLOW);
        bootsMeta.setColor(Color.ORANGE);

        helmetMeta.setUnbreakable(true);
        chestplateMeta.setUnbreakable(true);
        leggingsMeta.setUnbreakable(true);
        bootsMeta.setUnbreakable(true);

        helmet.setItemMeta(helmetMeta);
        chestplate.setItemMeta(chestplateMeta);
        leggings.setItemMeta(leggingsMeta);
        boots.setItemMeta(bootsMeta);

        player.getInventory().setHelmet(helmet);
        player.getInventory().setChestplate(chestplate);
        player.getInventory().setLeggings(leggings);
        player.getInventory().setBoots(boots);
    }
    public static void givePoitonEffect(Player player){
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 300*20, 10, false, false));
    }
}


