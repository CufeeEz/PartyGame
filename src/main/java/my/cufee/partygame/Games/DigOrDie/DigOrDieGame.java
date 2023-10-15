package my.cufee.partygame.Games.DigOrDie;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.function.pattern.Pattern;
import com.sk89q.worldedit.function.pattern.RandomPattern;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldedit.session.SessionManager;
import com.sk89q.worldedit.world.block.BaseBlock;
import com.sk89q.worldedit.world.block.BlockType;
import my.cufee.partygame.MainLocation.SpawnLocation;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.math.BlockVector3;


import java.util.Random;

import static my.cufee.partygame.Games.DigOrDie.DigOrDieLocation.locSpawnDigOrDie;
import static my.cufee.partygame.Games.PlayersArray.*;



public class DigOrDieGame {
    public static void startDigOrDie(){
        Bukkit.broadcastMessage(String.valueOf(playersOnGame.length));
        DigOrDieLocation.setLocation();
        for (int i = 0; i < playersOnGame.length; i++)
        {
            Player teleportedPlayer = playersOnGame[i];
            teleportedPlayer.teleport(locSpawnDigOrDie[i]);
        }
    }
    public void setRandomBlocks(SessionManager sessionManager) {
        EditSession.Builder editSessionBuilder = WorldEdit.getInstance().newEditSessionBuilder().session(sessionManager);
        EditSession editSession = editSessionBuilder.build();
        Random random = new Random();

        // Границы области, в которой вы хотите установить случайные блоки
        BlockVector3 minPoint = BlockVector3.at(-40, 62, 33);
        BlockVector3 maxPoint = BlockVector3.at(-40, 30, 33);

        try {
            for (int x = minPoint.getX(); x <= maxPoint.getX(); x++) {
                for (int y = minPoint.getY(); y <= maxPoint.getY(); y++) {
                    for (int z = minPoint.getZ(); z <= maxPoint.getZ(); z++) {
                        Material randomBlockType = getRandomBlockType(random);
                        BlockType block = BukkitAdapter.asBlockType(randomBlockType);
                        editSession.setBlock(BlockVector3.at(x, y, z), (Pattern) block);
                    }
                }
            }
            editSession.flushSession();
            editSession.close();
        } catch (WorldEditException e) {
            e.printStackTrace();
        }
    }

    public Material getRandomBlockType(Random random) {
        // Создайте список всех доступных блоков, из которых вы хотите случайным образом выбирать
        Material[] blockTypes = {Material.GRASS_BLOCK, Material.STONE};

        // Выберите случайный индекс из массива блоков
        int randomIndex = random.nextInt(blockTypes.length);

        // Верните выбранный случайный блок
        return blockTypes[randomIndex];
    }

}
