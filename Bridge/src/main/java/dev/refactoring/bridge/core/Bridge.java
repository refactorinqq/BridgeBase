package dev.refactoring.bridge.core;


import dev.refactoring.bridge.client.input.KeyBindingBridge;

/**
 * Has helper methods.
 * Ex. Initializing a KeyBinding, ResourceLocation, the possibilities are endless.
 *
 * @author refactoring
 */
public interface Bridge {
    public KeyBindingBridge initKeyBinding(String name, int keyCode, String cat);
}
