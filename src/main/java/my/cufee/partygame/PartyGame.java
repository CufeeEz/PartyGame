package my.cufee.partygame;

import my.cufee.partygame.CMD.GameCreate;
import my.cufee.partygame.CMD.GameJoin;
import org.bukkit.plugin.java.JavaPlugin;

public final class PartyGame extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("pgjoin").setExecutor(new GameJoin());
        getCommand("pgcreate").setExecutor(new GameCreate());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
