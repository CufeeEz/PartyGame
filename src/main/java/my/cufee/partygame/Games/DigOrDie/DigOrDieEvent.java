package my.cufee.partygame.Games.DigOrDie;

import org.bukkit.Material;
import org.bukkit.block.Block;

;import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static my.cufee.partygame.Games.DigOrDie.DigOrDieLocation.locBedrockDigOrDie;

public class DigOrDieEvent{
    public static void setBlocks(){
        for (int i = 0; i <= 7; i++) {
            fillColumn(i);
        }
    }
    private static List<Material> blockTypes = Arrays.asList(
            Material.STONE,
            Material.WHITE_WOOL,
            Material.OAK_LOG,
            Material.DIRT
    );
    private static void fillColumn(int columnNumber) {
        Material randomBlockType;
        for (int y = 17; y <= 60; y++) {
            randomBlockType = blockTypes.get(new Random().nextInt(blockTypes.size()));
            Block block = locBedrockDigOrDie[columnNumber].getBlock();
            block.setType(randomBlockType);
            locBedrockDigOrDie[columnNumber].subtract(0, 1, 0); // Перемещение вниз по координатам
        }
    }

}

