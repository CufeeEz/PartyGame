package my.cufee.partygame.Games.GoldRush;


import my.cufee.partygame.Games.PlayersArray;
import my.cufee.partygame.MainLocation.SpawnLocation;
import my.cufee.partygame.PartyGame;
import my.cufee.partygame.Util.TeleportPlayers;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;


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
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.getBlock().getType() == Material.GOLD_ORE) {
            // Разрешить ломать золотую руду
            return;
        }
        event.setCancelled(true);
        event.getPlayer().sendMessage("Вы можете ломать только золотую руду.");
    }
}


