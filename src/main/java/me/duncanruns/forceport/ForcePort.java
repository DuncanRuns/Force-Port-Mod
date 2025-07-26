package me.duncanruns.forceport;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ForcePort implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger(ForcePort.class);

    public static ForcePortConfig config;
    public static int port = 25565;
    public static Path configFile = FabricLoader.getInstance().getConfigDir().resolve("forceport.txt");
    public static final boolean speedrunapi = FabricLoader.getInstance().isModLoaded("speedrunapi");

    @Override
    public void onInitialize() {
        if (speedrunapi) return;
        try {
            if (Files.notExists(configFile)) {
                Files.createFile(configFile);
                Files.write(configFile, Integer.toString(port).getBytes(StandardCharsets.UTF_8));
            } else if (Files.exists(configFile)) {
                port = Math.max(1024, Math.min(65565, Integer.parseInt(new String(Files.readAllBytes(configFile), StandardCharsets.UTF_8))));
            } else {
                LOGGER.error("config file is in superposition");
            }
        } catch (IOException | NumberFormatException e) {
            LOGGER.error("could not read or create config");
        }
    }
}
