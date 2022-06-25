package fr.canardnocturne.cnrpg.mixin;

import fr.canardnocturne.cnrpg.roles.component.CNRPGComponents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

/**
 * @author CanardNocturne
 */
@Mixin(InGameHud.class)
@Debug(export = true)
public abstract class InGameHudMixin extends DrawableHelper {

    /**
     * Completely change how the health bar is rendered
     * @author CanardNocturne (16/04/2022)
     */
    @Overwrite
    private void renderHealthBar(MatrixStack matrices, PlayerEntity player, int x, int y, int lines,
                                 int regeneratingHeartIndex, float maxHealth, int lastHealth, int health,
                                 int absorption, boolean blinking) {
        /*int maxRoleHealth = CNRPGComponents.ROLE_STAT.get(player).getHealth();
        if(maxRoleHealth == 0) return;*/
        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
        //Pas de problème dû au position
        //TODO tester avec un draw simple ("a", 1, 2 par exemple)
        textRenderer.draw(matrices, String.valueOf(health),
                x - textRenderer.getWidth(String.valueOf(health)), y + 1, 0xFFFFFFFF);
    }

    /*DrawableHelper.fill(matrices, x, y + 1, x + (1 - (maxRoleHealth - health) / maxRoleHealth) * 80,
                y + 8, 0xFFFF0000);*/
        /*matrices.push();
        matrices.scale(0.5f, 0.5f, 1);
        String percentageHealth = 100 - ((maxRoleHealth - health) / maxRoleHealth) * 100 + "%";
        this.getTextRenderer().draw(matrices, percentageHealth,
                (x - this.getTextRenderer().getWidth(percentageHealth)) * 2 - 5,
                y * 2 + 5, 0xFF0000FF);
        matrices.pop();*/

    /*@Shadow
    public abstract TextRenderer getTextRenderer();*/

}
