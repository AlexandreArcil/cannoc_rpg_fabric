package fr.canardnocturne.cnrpg.guis;

import fr.canardnocturne.cnrpg.guis.presentation.AssassinPresentation;
import fr.canardnocturne.cnrpg.guis.presentation.Presentations;
import fr.canardnocturne.cnrpg.guis.presentation.RolePresentation;
import fr.canardnocturne.cnrpg.guis.presentation.WizardPresentation;
import fr.canardnocturne.cnrpg.guis.widget.RoleWidget;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;

public class ChooseRoleScreen extends Screen {

    public ChooseRoleScreen() {
        super(new LiteralText("Choose role"));
    }

    @Override
    protected void init() {
        int minX = 35 * Presentations.ALL.size();
        for (int i = 0; i < Presentations.ALL.size(); i++) {
            RolePresentation rolePresentation = Presentations.ALL.get(i);
            this.addDrawable(new RoleWidget(this.width / 2 - minX + 70*i, this.height / 2 - 40, 70, 80, new LiteralText("Assassin"), rolePresentation));
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
        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public boolean isPauseScreen() {
        return super.isPauseScreen();
    }
}
