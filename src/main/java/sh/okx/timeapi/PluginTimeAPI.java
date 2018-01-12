package sh.okx.timeapi;

import org.bukkit.plugin.java.JavaPlugin;

public class PluginTimeAPI extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("timeapi").setExecutor(new CommandTimeAPI());
    }
}
