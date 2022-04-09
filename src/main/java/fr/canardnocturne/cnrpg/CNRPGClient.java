package fr.canardnocturne.cnrpg;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;

public class CNRPGClient implements ClientModInitializer {

    public static long pointerCursor;
    public static long normalCursor;

    @Override
    public void onInitializeClient() {
        MinecraftClient.getInstance().execute(() -> {
            pointerCursor = GLFW.glfwCreateStandardCursor(GLFW.GLFW_HAND_CURSOR);
            normalCursor = GLFW.glfwCreateStandardCursor(GLFW.GLFW_ARROW_CURSOR);
        });
    }
}
