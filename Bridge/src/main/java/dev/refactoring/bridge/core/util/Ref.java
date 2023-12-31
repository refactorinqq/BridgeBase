package dev.refactoring.bridge.core.util;

import dev.refactoring.bridge.client.MinecraftClientBridge;
import dev.refactoring.bridge.core.BridgeManager;

/**
 * The Ref class has commonly used bridges to make code shorter and cleaner.
 *
 * @author refactoring
 */
public class Ref {
    public static MinecraftClientBridge minecraft() {
        return BridgeManager.INSTANCE.getMinecraftClientBridge();
    }

    /**
     * It can also be used to return commonly used values.
     * Here, I've used FPS. But again, the possibilities are endless.
     */
    public static int fps() {
        return minecraft().bridge$getCurrentFps();
    }
}
