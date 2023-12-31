package dev.refactoring.bridge.core;

import dev.refactoring.bridge.client.MinecraftClientBridge;
import dev.refactoring.bridge.core.util.MinecraftVersion;
import lombok.Getter;
import lombok.Setter;

/**
 * This class has all the bridges, which are to be implemented in each version.
 *
 * @author refactoring
 */
@Getter @Setter
public class BridgeManager {
    public static BridgeManager INSTANCE = new BridgeManager();

    // Bridges
    public Bridge bridge;
    public MinecraftClientBridge minecraftClientBridge;

    // Other
    private String windowTitle = "Test Client | Initializing";
    private MinecraftVersion version;
}
