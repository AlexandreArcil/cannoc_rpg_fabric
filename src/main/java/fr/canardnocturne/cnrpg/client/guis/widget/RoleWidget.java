package fr.canardnocturne.cnrpg.client.guis.widget;

import fr.canardnocturne.cnrpg.client.CNRPGClient;
import fr.canardnocturne.cnrpg.client.guis.RoleScreen;
import fr.canardnocturne.cnrpg.roles.Role;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.PressableWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.glfw.GLFW;

public class RoleWidget extends PressableWidget {

    private final Role role;

    public RoleWidget(int x, int y, int width, int height, Role role) {
        super(x, y, width, height, role.getPresentation().getName());
        this.role = role;
    }

    @Override
    public void onPress() {
        MinecraftClient.getInstance().setScreen(new RoleScreen(this.role, this.x + (this.width / 2), this.y + 70));
    }

    @Override
    public void renderButton(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        MinecraftClient client = MinecraftClient.getInstance();
        TextRenderer textRenderer = client.textRenderer;
        RoleWidget.fill(matrices, this.x - 1, this.y - 1, this.x + this.width + 1, this.y + this.height + 1, 0xFFAAAAAA);
        RoleWidget.fill(matrices, this.x, this.y, this.x + this.width, this.y + this.height, 0xFF000000);
        RoleWidget.drawCenteredText(matrices, textRenderer, this.getMessage(), this.x + this.width / 2, this.y + 2, 0xFFFFFF | MathHelper.ceil(this.alpha * 255.0f) << 24);
        this.role.getPresentation().dressPlayer();
        this.drawPlayer();
        client.player.getInventory().clear();
        if (this.hovered) {
            RoleWidget.fill(matrices, this.x, this.y, this.x + this.width, this.y + this.height, 0x55999999);
            GLFW.glfwSetCursor(MinecraftClient.getInstance().getWindow().getHandle(), CNRPGClient.pointerCursor);
        }
    }

    public void drawPlayer() {
        InventoryScreen.drawEntity(this.x + (this.width / 2), this.y + 70, 30, 0f, 0f, MinecraftClient.getInstance().player);
    }

    @Override
    public void appendNarrations(NarrationMessageBuilder builder) {
        this.appendDefaultNarrations(builder);
    }
}
