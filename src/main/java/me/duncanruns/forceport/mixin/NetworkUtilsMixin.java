package me.duncanruns.forceport.mixin;

import me.duncanruns.forceport.*;
import net.minecraft.client.util.NetworkUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(NetworkUtils.class)
public abstract class NetworkUtilsMixin {
    /**
     * @author DuncanRuns
     * @reason Replace port with 25565
     */
    @Overwrite
    public static int findLocalPort() {
        return ForcePort.speedrunapi ? ForcePort.config.port : ForcePort.port;
    }
}
