package fr.canardnocturne.cnrpg;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class CNRPGItems {

    public static final Item TEST_ITEM = new ModTestItem(new FabricItemSettings().maxCount(5).group(ItemGroup.MISC));

}
