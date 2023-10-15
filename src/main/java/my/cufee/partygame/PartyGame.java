package my.cufee.partygame;

import my.cufee.partygame.CMD.GameCreate;
import my.cufee.partygame.CMD.GameJoin;
import org.bukkit.plugin.java.JavaPlugin;

public final class PartyGame extends JavaPlugin {
    private static PartyGame instance;

    @Override
    public void onEnable() {
        instance = this;
        getCommand("pgjoin").setExecutor(new GameJoin());
        getCommand("pgcreate").setExecutor(new GameCreate());

    }
    public static PartyGame getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
