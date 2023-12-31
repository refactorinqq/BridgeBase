package dev.refactoring.bridge.core.util;

import lombok.Getter;

/**
 * @author refactoring
 */
@Getter
public enum MinecraftVersion {
    v1_8_9("1.8.9"),
    v1_19_4("1.19.4");

    MinecraftVersion(String name) {
        this.name = name;
    }

    private String name;
}
