package my.cufee.partygame.Games.DigOrDie;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import com.sk89q.worldedit.session.ClipboardHolder;
import com.sk89q.worldedit.world.World;
import my.cufee.partygame.MainLocation.SpawnLocation;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.math.BlockVector3;
import my.cufee.partygame.Util.AllEvent;
import org.bukkit.Bukkit;
import org.bukkit.util.Vector;


import java.awt.datatransfer.Clipboard;
import java.io.File;
import java.io.FileInputStream;

import static my.cufee.partygame.Games.DigOrDie.DigOrDieLocation.locSpawnDigOrDie;
import static my.cufee.partygame.Util.TeleportPlayers.teleportInMoreLoc;


public class DigOrDieGame {
    public static void startDigOrDie(){
        DigOrDieLocation.setLocation();
        teleportInMoreLoc(locSpawnDigOrDie);
        AllEvent.digEnable = true;
    }

}
