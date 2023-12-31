package dev.refactoring;

import dev.refactoring.bridge.BridgeImpl;
import dev.refactoring.bridge.core.BridgeManager;
import dev.refactoring.bridge.core.util.MinecraftVersion;
import net.fabricmc.api.ClientModInitializer;

/**
 * @author refactoring
 */
public class ClientEntrypoint implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BridgeManager.INSTANCE.setVersion(MinecraftVersion.v1_19_4);
        BridgeManager.INSTANCE.setBridge(new BridgeImpl());
    }
}
