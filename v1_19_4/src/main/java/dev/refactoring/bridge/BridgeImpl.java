package dev.refactoring.bridge;

import dev.refactoring.bridge.client.input.KeyBindingBridge;
import dev.refactoring.bridge.core.Bridge;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;

/**
 * @author refactoring
 */
public class BridgeImpl implements Bridge {
    @Override
    public KeyBindingBridge initKeyBinding(String name, int keyCode, String cat) {
        return (KeyBindingBridge) KeyBindingHelper.registerKeyBinding(new KeyBinding(name, keyCode, cat));
    }
}
