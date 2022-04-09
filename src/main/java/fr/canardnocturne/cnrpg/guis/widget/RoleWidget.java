package fr.canardnocturne.cnrpg.guis.widget;

import fr.canardnocturne.cnrpg.CNRPG;
import fr.canardnocturne.cnrpg.CNRPGClient;
import fr.canardnocturne.cnrpg.guis.presentation.RolePresentation;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.PressableWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.glfw.GLFW;

public class RoleWidget extends PressableWidget {

    private final RolePresentation rolePresentation;
    private boolean lastHoverState;

    public RoleWidget(int x, int y, int width, int height, Text text, RolePresentation role) {
        super(x, y, width, height, text);
        rolePresentation = role;
    }

    @Override
    public void onPress() {
        CNRPG.LOGGER.info("PRESS");
    }

    @Override
    public void renderButton(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        MinecraftClient client = MinecraftClient.getInstance();
        TextRenderer textRenderer = client.textRenderer;
        RoleWidget.fill(matrices, this.x - 1, this.y - 1, this.x + this.width + 1, this.y + this.height + 1, 0xFFAAAAAA);
        RoleWidget.fill(matrices, this.x, this.y, this.x + this.width, this.y + this.height, 0xFF000000);
        RoleWidget.drawCenteredText(matrices, textRenderer, this.getMessage(), this.x + this.width / 2, this.y + 2, 0xFFFFFF | MathHelper.ceil(this.alpha * 255.0f) << 24);
        this.rolePresentation.dressPlayer();
        this.drawPlayer();
        client.player.getInventory().armor.clear();
        client.player.getInventory().main.clear();
        client.player.getInventory().offHand.clear();
        if (this.hovered) {
            RoleWidget.fill(matrices, this.x, this.y, this.x + this.width, this.y + this.height, 0x55999999);
            if (!this.lastHoverState) {
                GLFW.glfwSetCursor(MinecraftClient.getInstance().getWindow().getHandle(), CNRPGClient.pointerCursor);
                this.lastHoverState = true;
                new ItemStack(Items.ACACIA_BOAT);
            }
        } else if (this.lastHoverState) {
            GLFW.glfwSetCursor(MinecraftClient.getInstance().getWindow().getHandle(), CNRPGClient.normalCursor);
            this.lastHoverState = false;
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
