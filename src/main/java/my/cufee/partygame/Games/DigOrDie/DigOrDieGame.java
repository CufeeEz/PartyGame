package my.cufee.partygame.Games.DigOrDie;

import my.cufee.partygame.Games.PlayersArray;
import my.cufee.partygame.Util.TimerUtil;
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

import static my.cufee.partygame.Games.DigOrDie.DigOrDieLocation.locBedrockDigOrDie;
import static my.cufee.partygame.Games.PlayersArray.playersOnGame;


public class DigOrDieGame {
    public static void startDigOrDie() {
        DigOrDieLocation.setBedrockLocation();
        DigOrDieEvent.setBlocks();
        setBadrock();
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
        metaShears.setDisplayName("Ножницы маникюрные");

        pickaxe.setItemMeta(metaPickaxe);
        axe.setItemMeta(metaAxe);
        shovel.setItemMeta(metaShovel);
        shears.setItemMeta(metaShears);

        for (Player player : playersOnGame) {
            player.setGameMode(GameMode.SURVIVAL);
            player.getInventory().addItem(pickaxe);
            player.getInventory().addItem(axe);
            player.getInventory().addItem(shovel);
            player.getInventory().addItem(shears);
        }

    }
    public static void removeBadrock(){
        DigOrDieLocation.setBedrockLocation();
        for(int i = 0; i < locBedrockDigOrDie.length;i++){
            locBedrockDigOrDie[i].getBlock().setType(Material.AIR);
        }
    }
    public static void setBadrock(){
        DigOrDieLocation.setBedrockLocation();
        for(int i = 0; i < locBedrockDigOrDie.length;i++){
            locBedrockDigOrDie[i].getBlock().setType(Material.BEDROCK);
        }
    }
    public static void givePoitonEffectRegeneration(){
        for(Player player : PlayersArray.playersOnGame){
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 300*20, 10, false, false));
        }
    }

}
