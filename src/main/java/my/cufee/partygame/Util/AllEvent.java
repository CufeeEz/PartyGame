package my.cufee.partygame.Util;

import my.cufee.partygame.CMD.GameManager;
import my.cufee.partygame.Games.Labyrinth.LabyrinthGame;
import my.cufee.partygame.Games.PlayersScore;
import my.cufee.partygame.MainLocation.SpawnLocation;
import my.cufee.partygame.PartyGame;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import static my.cufee.partygame.Games.Parkour.ParkourGame.countFinisedParkour;
import static my.cufee.partygame.Games.PlayersArray.playersOnGame;
import static my.cufee.partygame.Util.TimerUtil.timerLabyrinth;

public class AllEvent implements Listener {
    // MAIN EVENTS
    public static boolean hungerChangeEnabled = true;
    @EventHandler
    public void onPlayerHungerChange(FoodLevelChangeEvent event) {
        if(hungerChangeEnabled){
            event.setCancelled(true);
        }
    }
    public static boolean breakBlocksEnabled = true;
    @EventHandler
    public void disableBreakBlocks(BlockBreakEvent event){
        if(breakBlocksEnabled){
            event.setCancelled(true);
        }
    }
    // EVENTS GOLD RUSH
    public static boolean grenabled;
    @EventHandler
    public void GRbreakOnlyGold(BlockBreakEvent event) {
        if(grenabled){
            Player player = event.getPlayer();
            for(int i = 0; i < playersOnGame.length; i++) {
                if (player.equals(playersOnGame[i])) {
                    if (event.getBlock().getType() == Material.GOLD_ORE) {
                        PlayersScore.setPointGoldRush(player);
                        return;
                    }
                    event.setCancelled(true);
                }
            }
        }
    }
    // ---------- EVENTS GOLD RUSH
    public static boolean grReplaceenabled;
    @EventHandler
    public void grReplaceBlock(BlockBreakEvent event) {
        if(grReplaceenabled){
            Block block = event.getBlock();
            if (block.getType() == Material.GOLD_ORE) {
                replaceBlock(block.getLocation());
            }
        }
    }
    public void replaceBlock(Location location) {
        Block block = location.getBlock();
        Bukkit.getScheduler().runTaskLater(PartyGame.getInstance(), () -> {
            Particle particle = Particle.FLAME;
            location.setY(location.getY()+1);
            SpawnLocation.world.spawnParticle(particle, location, 10);
            block.setType(Material.GOLD_ORE);
        }, 20 * 20);
    }
    // END EVENTS GOLD RUSH

    // EVENTS DIG OR DIE
    public static boolean digEnable;
    @EventHandler
    public void breakDigOrDie(BlockBreakEvent event) {
        if (digEnable) {
            Player player = event.getPlayer();
            for (int i = 0; i < playersOnGame.length; i++) {
                if (player.equals(playersOnGame[i])) {
                    if (event.getBlock().getType() == Material.WHITE_WOOL | event.getBlock().getType() == Material.DIRT |
                            event.getBlock().getType() == Material.STONE | event.getBlock().getType() == Material.OAK_LOG) {
                        return;
                    }
                    event.setCancelled(true);
                }
            }
        }
    }

    public static boolean DODTuch;
    static int playerFinishedDOD;
    @EventHandler
    public void playerTouchBlockDOD(PlayerInteractEvent event){

        Player player = event.getPlayer();
        if(DODTuch){
            if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (event.getClickedBlock().getType().equals(Material.SCULK_SENSOR)){
                    playerFinishedDOD +=1;
                    PlayersScore.setPoint(player);
                    player.teleport(SpawnLocation.getLocHub());
                    PlayerUtil.clearOnePlayer(player);
                    if(playerFinishedDOD == GameManager.CreatePlayersCount){
                        Bukkit.getScheduler().cancelTask(TimerUtil.timerIDStartDigOrDie);
                        TimerUtil.timerTimeOut();
                        ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "Все игроки добрались до финиша!");
                        AllEvent.digEnable = false;
                        AllEvent.DODTuch = false;
                        AllEvent.DODBlockPlace = false;
                        AllEvent.breakBlocksEnabled = true;
                    }
                }
            }
        }
    }
    public static boolean DODBlockPlace;
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if(DODBlockPlace){
            Player player = event.getPlayer();
            for (int i = 0; i < playersOnGame.length; i++) {
                if (player.equals(playersOnGame[i])) {
                    event.setCancelled(true);
                }
            }
        }
    }

    // EVENTS PARKOUR
    public static boolean ParkourTuchEvent;
    @EventHandler
    public void playerTouchBlockParkour(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(ParkourTuchEvent){
            if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (event.getClickedBlock().getType().equals(Material.SEA_LANTERN)){
                    PlayersScore.setPoint(player);
                    countFinisedParkour();
                    player.teleport(SpawnLocation.getLocHub());
                }
            }
        }
    }
    // EVENTS LABYRINTH
    public static boolean labyrinthTuchEvent;
    int playerFinished;
    @EventHandler
    public void playerTouchBlockLabyrinth(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(labyrinthTuchEvent){
            if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (LabyrinthGame.spectator.equals(player)){
                    player.sendMessage("Самый умный???");
                }
                else {
                    if (event.getClickedBlock().getType().equals(Material.SEA_LANTERN)){
                        PlayersScore.setPoint(player);
                        player.teleport(SpawnLocation.getLocHub());
                        playerFinished +=1;
                        if(playerFinished == GameManager.CreatePlayersCount){
                            Bukkit.getScheduler().cancelTask(timerLabyrinth);
                            TeleportPlayers.teleportInOneLoc(SpawnLocation.getLocHub());
                            PlayerUtil.clearPlayers();
                            ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "Все игроки добрались до финиша, "
                                    + LabyrinthGame.spectator.getName() + " получает " + playerFinished + " очков!");
                            playerFinished = 0;
                            TimerUtil.timerTimeOut();
                        }
                    }
                }
            }
        }
    }
    // EVENT BEDROCK BOX
    public static boolean bedrockTuchEvent;
    static int playerFinishedBDB;
    @EventHandler
    public void playerTouchBlockBedrockBox(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(bedrockTuchEvent){
            if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (event.getClickedBlock().getType().equals(Material.DIAMOND_BLOCK)){
                    if(player.getGameMode() == GameMode.SURVIVAL){
                        playerFinishedBDB +=1;
                        PlayersScore.setPoint(player);
                        player.setGameMode(GameMode.SPECTATOR);
                        if(playerFinishedBDB == GameManager.CreatePlayersCount){
                            AllEvent.playerFinishedBDB = 0;
                            Bukkit.getScheduler().cancelTask(TimerUtil.timerIdBRB);
                            PlayerUtil.clearPlayers();
                            AllEvent.breakBlocksEnabled = true;
                            AllEvent.bedrockTuchEvent = false;
                            AllEvent.breakEnableBedrockBox = false;
                            TeleportPlayers.teleportInOneLoc(SpawnLocation.getLocHub());
                            ChatBroadcastMessege.PlayerSendMessages(ChatColor.GREEN + "Молодцы, все справились!");
                            TimerUtil.timerTimeOut();
                            Bukkit.getScheduler().cancelTask(TimerUtil.timerIdBRB);
                        }
                    }
                }
            }
        }
    }
    public static boolean breakEnableBedrockBox;
    @EventHandler
    public void breakBedrockBox(BlockBreakEvent event) {
        if (breakEnableBedrockBox) {
            Player player = event.getPlayer();
            for (int i = 0; i < playersOnGame.length; i++) {
                if (player.equals(playersOnGame[i])) {
                    if (event.getBlock().getType() == Material.DIRT) {
                        return;
                    }
                    event.setCancelled(true);
                }
            }
        }
    }
    // EVENT BOWBATTLE BOX
    public static boolean deathEventBowBattle;
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (deathEventBowBattle) {
            Player player = event.getEntity();
            for (int i = 0; i < playersOnGame.length; i++) {
                if (player.equals(playersOnGame[i])) {
                    if(player.getGameMode() == GameMode.SURVIVAL){

                    }
                }
            }
        }
    }
}