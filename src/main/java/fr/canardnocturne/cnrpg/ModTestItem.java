package fr.canardnocturne.cnrpg;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ModTestItem extends Item {

    public ModTestItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        player.addVelocity(0, 5D, 0);
        return TypedActionResult.success(player.getStackInHand(hand));
    }
}
