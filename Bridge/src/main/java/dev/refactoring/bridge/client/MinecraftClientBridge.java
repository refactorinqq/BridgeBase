package dev.refactoring.bridge.client;

/**
 * Bridge for the class MinecraftClient.
 * This is just an example and will definitely need to have changes.
 *
 * @author refactoring
 */
public interface MinecraftClientBridge {
    /**
     * Returns the current FPS.
     * Javadoc is not required for a bridge, but all bridge methods must start with "bridge$"
     * to avoid colliding with other methods during implementation.
     *
     * @return the current FPS
     */
    public int bridge$getCurrentFps();
}
