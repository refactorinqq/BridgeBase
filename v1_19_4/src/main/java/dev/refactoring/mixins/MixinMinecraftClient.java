package dev.refactoring.mixins;

import dev.refactoring.bridge.client.MinecraftClientBridge;
import dev.refactoring.bridge.core.BridgeManager;
import dev.refactoring.testclient.TestClient;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * This is how you implement a bridge.
 *
 * @author refactoring
 */
@Mixin(MinecraftClient.class)
public class MixinMinecraftClient implements MinecraftClientBridge {
    @Shadow private static int currentFps;

    // we initialize differently in modern versions
    // respectfully, fuck you mojang studios
    @Inject(method = "<init>", at = @At(target = "Lnet/minecraft/client/MinecraftClient;inGameHud:Lnet/minecraft/client/gui/hud/InGameHud;", value = "FIELD", shift = At.Shift.AFTER))
    private void aetherium$init(CallbackInfo ci) {
        BridgeManager.INSTANCE.setMinecraftClientBridge(this); // You want to do this for everything except things like keybindings, which are initialized by the user.
    }

    @Override
    public int bridge$getCurrentFps() {
        return currentFps;
    }

    @Inject(method = "tick", at = @At("HEAD"))
    public void mixin$tick(CallbackInfo ci) {
        TestClient.INSTANCE.printFps();
    }
}
