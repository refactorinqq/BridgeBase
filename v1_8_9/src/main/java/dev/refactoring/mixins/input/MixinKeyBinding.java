package dev.refactoring.mixins.input;

import dev.refactoring.bridge.client.input.KeyBindingBridge;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.resource.language.I18n;
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
    @Shadow public abstract int getCode();
    @Unique
    public final List<String> clashesWith = new ArrayList<>();
    @Shadow public abstract void setCode(int code);

    @Shadow public abstract boolean isPressed();

    @Shadow public abstract String getTranslationKey();

    @Shadow public abstract String getCategory();

    @Override
    public int bridge$getKey() {
        return this.getCode();
    }

    @Override
    public void bridge$setKey(Integer var1) {
        this.setCode(var1);
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
        KeyBinding.setKeyPressed(this.getCode(), var1);
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
