package io.myzticbean.mcdevtools;

import io.myzticbean.mcdevtools.annotations.async.aspect.RunAsyncAspect;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class MCDevTools extends JavaPlugin {

    @Getter
    private static JavaPlugin plugin = new MCDevTools();

    @Override
    public void onEnable() {
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static void setup(JavaPlugin pluginInstance) {
        plugin = pluginInstance;
        new RunAsyncAspect(plugin);
    }
}
