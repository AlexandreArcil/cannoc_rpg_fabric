package fr.canardnocturne.cnrpg.client.guis;

import com.mojang.blaze3d.systems.RenderSystem;
import fr.canardnocturne.cnrpg.client.CNRPGClient;
import fr.canardnocturne.cnrpg.network.CNRPGPackets;
import fr.canardnocturne.cnrpg.roles.Role;
import fr.canardnocturne.cnrpg.roles.RoleStat;
import fr.canardnocturne.cnrpg.roles.Roles;
import fr.canardnocturne.cnrpg.roles.component.CNRPGComponents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

/**
 * @author CanardNocturne
 */
public class RoleScreen extends Screen {

    private static final Text HEALTH = new LiteralText("Health");
    private static final Text ATTACK = new LiteralText("Attack");
    private static final Text DEFENSE = new LiteralText("Defense");
    private static final Text SPEED = new LiteralText("Speed");
    private static final Text RANGE = new LiteralText("Range");
    private static final Identifier TARGET_SIDE = new Identifier("textures/block/target_side.png");

    private final Role role;
    private final int playerX;
    private final int playerY;
    private final float animationMax = 20f;
    private int animation;

    public RoleScreen(Role role, int playerX, int playerY) {
        super(role.getPresentation().getName());
        this.role = role;
        this.playerX = playerX;
        this.playerY = playerY;
        this.animation = 1;
    }

    @Override
    protected void init() {
        LiteralText chooseThisRole = new LiteralText("Choose this role");
        chooseThisRole.setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xFFFF00)));
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 105, this.height - 50, 100, 20, new LiteralText("Return"), button -> MinecraftClient.getInstance().setScreen(new ChooseRoleScreen())));
        this.addDrawableChild(new ButtonWidget(this.width / 2 + 5, this.height - 50, 100, 20, chooseThisRole, button -> {
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeString(role.getIdentifier().getPath());
            ClientPlayNetworking.send(CNRPGPackets.SET_ROLE, buf);
            this.close();
        }));

        GLFW.glfwSetCursor(MinecraftClient.getInstance().getWindow().getHandle(), CNRPGClient.normalCursor);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        if(this.animation < this.animationMax) {
            this.animation++;
        }

        this.renderBackgroundTexture(0);

        this.drawPlayer(mouseX, mouseY);

        /*RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.clearColor(1f,  1f,  1f, 0.5f);*/
        matrices.push();
        matrices.scale(1.7f, 1.7f, 1f);
        DrawableHelper.drawCenteredText(matrices, this.textRenderer, this.title, (int) ((this.width / 2) / 1.7) + 4, (int) ((this.height / 6f) / 1.7), 0xFFFFFF);
        matrices.pop();

        this.drawStat(matrices);

        this.drawDescription(matrices);

        super.render(matrices, mouseX, mouseY, delta);
    }

    public void drawStat(MatrixStack matrices) {
//        this.itemRenderer.renderGuiItemIcon(new ItemStack(Items.DIAMOND_SWORD), 50, 50);
        RoleStat stat = this.role.getStat();

        Sprite sprite = this.client.getStatusEffectSpriteManager().getSprite(StatusEffects.REGENERATION);
        RenderSystem.setShaderTexture(0, sprite.getAtlas().getId());
        AbstractInventoryScreen.drawSprite(matrices, this.width / 2 - 105, this.height / 2 - 55, this.getZOffset(), 18, 18, sprite);
//        this.drawTexture(matrices, this.width / 2 - 105, this.height / 2 - 50, 16 + 4 * 9, 0, 9, 9);
        this.textRenderer.draw(matrices, HEALTH, this.width / 2f - 85f, this.height / 2f - 49f, 0xFFFFFF);
        this.textRenderer.draw(matrices, String.valueOf(stat.getHealth()), this.width / 2f + 105f - this.textRenderer.getWidth(String.valueOf(stat.getHealth())), this.height / 2f - 49f, 0xFFFFFF);

        sprite = this.client.getStatusEffectSpriteManager().getSprite(StatusEffects.STRENGTH);
        RenderSystem.setShaderTexture(0, sprite.getAtlas().getId());
        AbstractInventoryScreen.drawSprite(matrices, this.width / 2 - 105, this.height / 2 - 35, this.getZOffset(), 18, 18, sprite);
        this.textRenderer.draw(matrices, ATTACK, this.width / 2f - 85f, this.height / 2f - 29f, 0xFFFFFF);
        this.textRenderer.draw(matrices, String.valueOf(stat.getAttack()), this.width / 2f + 105f - this.textRenderer.getWidth(String.valueOf(stat.getAttack())), this.height / 2f - 29f, 0xFFFFFF);

        sprite = this.client.getStatusEffectSpriteManager().getSprite(StatusEffects.ABSORPTION);
        RenderSystem.setShaderTexture(0, sprite.getAtlas().getId());
        AbstractInventoryScreen.drawSprite(matrices, this.width / 2 - 105, this.height / 2 - 15, this.getZOffset(), 18, 18, sprite);
        this.textRenderer.draw(matrices, DEFENSE, this.width / 2f - 85f, this.height / 2f - 9f, 0xFFFFFF);
        this.textRenderer.draw(matrices, String.valueOf(stat.getDefense()), this.width / 2f + 105f - this.textRenderer.getWidth(String.valueOf(stat.getDefense())), this.height / 2f - 9f, 0xFFFFFF);

        sprite = this.client.getStatusEffectSpriteManager().getSprite(StatusEffects.SPEED);
        RenderSystem.setShaderTexture(0, sprite.getAtlas().getId());
        AbstractInventoryScreen.drawSprite(matrices, this.width / 2 - 105, this.height / 2 + 5, this.getZOffset(), 18, 18, sprite);
        this.textRenderer.draw(matrices, SPEED, this.width / 2f - 85f, this.height / 2f + 11f, 0xFFFFFF);
        this.textRenderer.draw(matrices, String.valueOf(stat.getSpeed()), this.width / 2f + 105f - this.textRenderer.getWidth(String.valueOf(stat.getSpeed())), this.height / 2f + 11f, 0xFFFFFF);

        RenderSystem.setShaderTexture(0, TARGET_SIDE);
        drawTexture(matrices, this.width / 2 - 105, this.height / 2 + 27, 0, 0, 16, 16, 16, 16);
        this.textRenderer.draw(matrices, RANGE, this.width / 2f - 85f, this.height / 2f + 31f, 0xFFFFFF);
        this.textRenderer.draw(matrices, String.valueOf(stat.getRange()), this.width / 2f + 105f - this.textRenderer.getWidth(String.valueOf(stat.getRange())), this.height / 2f + 31f, 0xFFFFFF);
    }

    public void drawDescription(MatrixStack matrixStack) {
        DrawableHelper.fill(matrixStack, 3 * this.width / 4 - 1, this.height / 4 - 1, 3 * this.width / 4 + 141, 3 * this.height / 4 + 1, 0xFF999999);
        DrawableHelper.fill(matrixStack, 3 * this.width / 4, this.height / 4, 3 * this.width / 4 + 140, 3 * this.height / 4, 0xFF000000);
        this.textRenderer.draw(matrixStack, "Lorem ipsum dolor sit amet", 3 * this.width / 4f + 2f, this.height / 4f + 2f, 0xFFFFFFFF);
    }

    public void drawPlayer(int mouseX, int mouseY) {
        int size = (int) (30 + (this.height / 4.8f - 30) * this.animation / this.animationMax);
        int x = (int) (this.playerX + (this.width / 6f - this.playerX) * this.animation / this.animationMax);
        int y = (int) (this.playerY + (this.height / 2f + size - this.playerY) * this.animation / this.animationMax);
        this.role.getPresentation().dressPlayer();
        InventoryScreen.drawEntity(x, y, size, x - mouseX, (y - 117) - mouseY, MinecraftClient.getInstance().player);
        this.client.player.getInventory().clear();
    }

    @Override
    public boolean shouldPause() {
        return true;
    }

}
