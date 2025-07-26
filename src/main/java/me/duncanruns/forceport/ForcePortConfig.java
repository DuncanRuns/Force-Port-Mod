package me.duncanruns.forceport;

import me.contaria.speedrunapi.config.api.SpeedrunConfig;
import me.contaria.speedrunapi.config.api.annotations.Config;

public class ForcePortConfig implements SpeedrunConfig {
    @Config.Numbers.Whole.Bounds(min = 1024, max = 65565)
    @Config.Numbers.TextField
    public int port = 25565;

    @Override
    public void finishLoading() {
        ForcePort.config = this;
    }

    @Override
    public String modID() {
        return "forceport";
    }
}
