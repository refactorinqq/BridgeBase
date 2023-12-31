package dev.refactoring.mixins.input;

import dev.refactoring.bridge.client.input.KeyBindingBridge;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.util.InputUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import java.util.ArrayList;
import java.util.List;

/**
 * @author refactoring
 */
@Mixin(KeyBinding.class)
public abstract class MixinKeyBinding implements KeyBindingBridge {
    @Unique
    public final List<String> clashesWith = new ArrayList<>();
    @Shadow public abstract boolean isPressed();
    @Shadow public abstract String getTranslationKey();
    @Shadow public abstract String getCategory();

    @Shadow private InputUtil.Key boundKey;

    @Shadow public abstract void setBoundKey(InputUtil.Key par1);

    @Override
    public int bridge$getKey() {
        return this.boundKey.getCode();
    }

    @Override
    public void bridge$setKey(Integer var1) {
        this.setBoundKey(InputUtil.fromKeyCode(var1, 0));
    }

    @Override
    public boolean bridge$isKeyDown() {
        return this.isPressed();
    }

    @Override
    public String bridge$getKeyName() {
        return I18n.translate(this.getTranslationKey());
    }

    @Override
    public String bridge$getKeyDescription() {
        return I18n.translate(this.getTranslationKey());
    }

    @Override
    public void bridge$setKeyBindState(boolean var1) {
        KeyBinding.setKeyPressed(this.boundKey, var1);
    }

    @Override
    public List<String> bridge$getClashesWith() {
        return this.clashesWith;
    }

    @Override
    public String bridge$getCategory() {
        return this.getCategory();
    }
    // I decided to be nice and include a KeyBinding bridge :)
}
