package io.myzticbean.mcdevtools;

import io.myzticbean.mcdevtools.annotations.async.aspect.RunAsyncAspect;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.bukkit.plugin.java.JavaPlugin;

@UtilityClass
public class MCDevTools {

    @Getter
    private static JavaPlugin plugin;

    public static void initialize(JavaPlugin pluginInstance) {
        plugin = pluginInstance;
        new RunAsyncAspect(pluginInstance);
    }
}
