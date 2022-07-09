package fr.canardnocturne.cnrpg.client.guis;

import com.mojang.blaze3d.systems.RenderSystem;
import fr.canardnocturne.cnrpg.CNRPG;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/**
 * @author CanardNocturne
 */
public class SkillsScreen extends Screen {

    private static final Identifier SKILLS_GUI = new Identifier(CNRPG.MOD_ID, "textures/gui/skills.png");
    public SkillsScreen() {
        super(Text.of("Skills"));
    }

    @Override
    protected void init() {

    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices); //TODO est-ce que je le mes ?
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, SKILLS_GUI);
        drawTexture(matrices, this.width / 2 - 121, this.height / 2 - 57, 0, 0, 243, 114);
        super.render(matrices, mouseX, mouseY, delta);
        matrices.push();
        matrices.scale(2.0f, 2.0f, 0);
        DrawableHelper.drawCenteredText(matrices, this.textRenderer, this.title, this.width / 4, this.height / 4 - 25, 0xFFFFFF);
        matrices.pop();
    }

}
