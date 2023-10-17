package my.cufee.partygame.Games.GoldRush;


import my.cufee.partygame.Games.PlayersArray;
import my.cufee.partygame.Util.AllEvent;
import org.bukkit.Material;

import org.bukkit.entity.Player;

import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



    public class GoldRushStartGame {
    public static void grStart(){
        for(Player player: PlayersArray.playersOnGame){
            player.getInventory().addItem(createGoldenOrePickaxe());
        }

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
}


