package me.duncanruns.forceport.mixin;

import me.duncanruns.forceport.ForcePort;
import net.minecraft.util.HttpUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(HttpUtil.class)
public abstract class HttpUtilMixin {
    /**
     * @author DuncanRuns
     * @reason Replace port with 25565
     */
    @Overwrite
    public static int getAvailablePort() {
        return ForcePort.speedrunapi ? ForcePort.config.port : ForcePort.port;
    }
}
