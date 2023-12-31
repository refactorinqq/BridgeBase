package dev.refactoring.bridge.client.input;

import java.util.List;

/**
 * @author refactoring
 */
public interface KeyBindingBridge {
    int bridge$getKey();
    void bridge$setKey(Integer var1);
    boolean bridge$isKeyDown();
    String bridge$getKeyName();
    String bridge$getKeyDescription();
    void bridge$setKeyBindState(boolean var1);
    List<String> bridge$getClashesWith();
    String bridge$getCategory();
}
