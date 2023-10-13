package my.cufee.partygame.Locations;

import org.bukkit.Bukkit;
import org.bukkit.World;

public class Location {
    // Y - 60 standart hight
    public static World world = Bukkit.getWorld("world");
    public static World getWorld(){
        return world;
    }
    public static org.bukkit.Location getLocLobby() {
        return new org.bukkit.Location(getWorld(), 0.0,61.0,0.0);
    }
    public static org.bukkit.Location getLocHub() {
        return new org.bukkit.Location(getWorld(), -40.0,61.0,0.0);
    }

}
