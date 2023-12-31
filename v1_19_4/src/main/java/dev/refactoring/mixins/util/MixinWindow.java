package dev.refactoring.mixins.util;

import dev.refactoring.bridge.core.BridgeManager;
import net.minecraft.client.util.Window;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

/**
 * @author refactoring
 */
@Mixin(Window.class)
public class MixinWindow {
    @Shadow @Final private long handle;

    /**
     * @author Refactoring
     * @reason Uses the bridge title system instead of the default one.
     */
    @Overwrite
    public void setTitle(String title) {
        GLFW.glfwSetWindowTitle(this.handle, BridgeManager.INSTANCE.getWindowTitle());
    }
}
