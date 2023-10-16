package my.cufee.partygame.MainLocation;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class SpawnLocation {
    // Y - 60 standart hight
    public static World world = Bukkit.getWorld("world");
    public static World getWorld(){
        return world;
    }
    public static Location getLocLobby() {
        return new Location(getWorld(), 0.5,61.0,0.5);
    }
    public static Location getLocHub() {
        return new Location(getWorld(), -112.5,61.0,1.5);
    }
}
