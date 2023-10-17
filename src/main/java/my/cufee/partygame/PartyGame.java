package my.cufee.partygame;

import my.cufee.partygame.CMD.GameManager;
import my.cufee.partygame.Games.DigOrDie.DigOrDieEvent;
import my.cufee.partygame.Games.GoldRush.GoldRushReplaceBlock;
import org.bukkit.plugin.java.JavaPlugin;

public final class PartyGame extends JavaPlugin {
    private static PartyGame instance;

    @Override
    public void onEnable() {
        instance = this;
        getCommand("pg").setExecutor(new GameManager());
        getCommand("pg").setTabCompleter(new GameManager());
        getServer().getPluginManager().registerEvents(new DigOrDieEvent(), this);
        getServer().getPluginManager().registerEvents(new GoldRushReplaceBlock(), this);
    }
    public static PartyGame getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
