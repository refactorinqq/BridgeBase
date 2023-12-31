package dev.refactoring.testclient;

import dev.refactoring.bridge.core.BridgeManager;
import dev.refactoring.bridge.core.util.Ref;

/**
 * @author refactoring
 */
public class TestClient {
    public static TestClient INSTANCE = new TestClient();

    public static TestClient get() {
        return INSTANCE;
    }

    public void printFps() {
        BridgeManager.INSTANCE.setWindowTitle("Test Client 1.0.0 | " + BridgeManager.INSTANCE.getVersion().getName());
        System.out.println(Ref.fps()); // This is how you use the methods.
    }
}
