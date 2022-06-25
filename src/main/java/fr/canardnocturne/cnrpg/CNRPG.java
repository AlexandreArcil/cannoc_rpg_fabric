package fr.canardnocturne.cnrpg;

import fr.canardnocturne.cnrpg.client.guis.ChooseRoleScreen;
import fr.canardnocturne.cnrpg.items.CNRPGItems;
import fr.canardnocturne.cnrpg.server.SetRolePacketReceiver;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CNRPG implements ModInitializer {

	public static final String MOD_ID = "cnrpg";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "knife"), CNRPGItems.KNIFE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "long_sword"), CNRPGItems.LONG_SWORD);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "assassin_boots"), CNRPGItems.ASSASSIN_BOOTS);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "assassin_leggings"), CNRPGItems.ASSASSIN_LEGS);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "assassin_chestplate"), CNRPGItems.ASSASSIN_CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "assassin_helmet"), CNRPGItems.ASSASSIN_HELMET);

		SetRolePacketReceiver.register();

		ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
			client.execute(() -> client.setScreen(new ChooseRoleScreen()));
		});

		ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
//			LOGGER.info(screen.getClass());
			if(screen.getClass() == GameMenuScreen.class) {
				Screens.getButtons(screen).add(new ButtonWidget(0, 0, 100, 20, new LiteralText("ChooseRole"), new ButtonWidget.PressAction() {
					@Override
					public void onPress(ButtonWidget button) {
						client.setScreen(new ChooseRoleScreen());
					}
				}));
			}
		});


		/*PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
			ItemStack is = player.getStackInHand(player.getActiveHand());
			if(state.getMaterial() == Material.WOOD && is.getItem() instanceof AxeItem) {
				List<BlockPos> woods = new ArrayList<>();
				if (player.isSneaking() && world.getBlockState(pos.up()).getMaterial() == Material.WOOD)
					woods.add(pos.up());
				else {
					for (int x = -1; x <= 1; x++) {
						for (int y = -1; y <= 1; y++) {
							for (int z = -1; z <= 1; z++) {
								if (!(x == 0 && y == 0 && z == 0) && world.getBlockState(pos.add(x, y, z)).getMaterial() == Material.WOOD)
									woods.add(pos.add(x, y, z));
							}
						}
					}
				}
				for (BlockPos wood : woods) {
					if(is.isEmpty())
						break;
					is.postMine(world, state, pos, player); //FIXME: 6 blocks -> 11 damage
					((ServerPlayerEntity) player).interactionManager.tryBreakBlock(wood);
				}

				*//*List<BlockPos> woodsToBreak = Lists.newArrayList(pos);
				List<BlockPos> woods = new ArrayList<>();
				while (!woodsToBreak.isEmpty()) {
					for (BlockPos wood : woodsToBreak) {
						((ServerPlayerEntity) player).interactionManager.tryBreakBlock(wood);
						if(is.isEmpty()) {
							woods.clear();
							break;
						}
						if(player.isSneaking() && world.getBlockState(wood.up()).getMaterial() == Material.WOOD)
							woods.add(wood.up());
						else {
							for (int x = -1; x <= 1; x++) {
								for (int y = -1; y <= 1; y++) {
									for (int z = -1; z <= 1; z++) {
										if(!(x == 0 && y == 0 && z == 0) && world.getBlockState(wood.add(x, y, z)).getMaterial() == Material.WOOD)
											woods.add(wood.add(x, y, z));
									}
								}
							}
						}
					}
					woodsToBreak.clear();
					woodsToBreak.addAll(woods);
					woods.clear();
				}*//*
			}

		});*/
	}



}
