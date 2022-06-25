package fr.canardnocturne.cnrpg.client.guis;

import fr.canardnocturne.cnrpg.client.CNRPGClient;
import fr.canardnocturne.cnrpg.client.guis.widget.RoleWidget;
import fr.canardnocturne.cnrpg.roles.Role;
import fr.canardnocturne.cnrpg.roles.Roles;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import org.lwjgl.glfw.GLFW;

public class ChooseRoleScreen extends Screen {

    public ChooseRoleScreen() {
        super(new LiteralText("Choose role"));
    }

    @Override
    protected void init() {
        int minX = 35 * Roles.getRoles().size();
        int i = 0;
        for (Role role : Roles.getRoles()) {
            this.addDrawableChild(new RoleWidget(this.width / 2 - minX + 70*i, this.height / 2 - 40, 70, 80, role));
            i++;
        }
    }

    @Override
    public void tick() {
        MinecraftClient.getInstance().player.age++;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackgroundTexture(0);
        matrices.push();
        matrices.scale(2.0f, 2.0f, 2.0f);
        ChooseRoleScreen.drawCenteredText(matrices, this.textRenderer, "Choose a role", this.width / 4, this.height / 4 - 30, 0xFFFFFFFF);
        matrices.pop();
        GLFW.glfwSetCursor(MinecraftClient.getInstance().getWindow().getHandle(), CNRPGClient.normalCursor);
        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return true;
    }
}
