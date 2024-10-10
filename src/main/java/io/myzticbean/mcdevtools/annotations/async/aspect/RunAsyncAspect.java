package io.myzticbean.mcdevtools.annotations.async.aspect;

import io.myzticbean.mcdevtools.annotations.async.RunAsync;
import lombok.NoArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@Aspect
@NoArgsConstructor  // Default constructor required for AspectJ
public class RunAsyncAspect {

    private static JavaPlugin plugin;

    public RunAsyncAspect(JavaPlugin pluginInstance) {
        plugin = pluginInstance;
    }

    @Around("@annotation(async)")
    public Object executeAsynchronously(ProceedingJoinPoint joinPoint, RunAsync async) throws Throwable {
        if (plugin == null) throw new IllegalStateException("RunAsyncAspect not initialized with plugin instance");
        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            try {
                joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        return null;
    }

}
