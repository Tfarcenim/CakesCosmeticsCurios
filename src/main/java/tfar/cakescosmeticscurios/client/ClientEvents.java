package tfar.cakescosmeticscurios.client;

import net.loworbitstation.cakescosmetics.item.VanityArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import tfar.cakescosmeticscurios.CakesCosmeticCurioRenderer;
import tfar.cakescosmeticscurios.CakesCosmeticsCurios;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import tfar.cakescosmeticscurios.CuriosItems;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

@Mod.EventBusSubscriber(modid = CakesCosmeticsCurios.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent evt) {

        for (VanityArmorItem vanityArmorItem : CuriosItems.HEAD_ITEMS) {
            CuriosRendererRegistry.register(vanityArmorItem, () -> new CakesCosmeticCurioRenderer(getGeoRenderer(vanityArmorItem)));
        }
    }

    public static GeoArmorRenderer<?> getGeoRenderer(Item item) {
        ItemStack stack = item.getDefaultInstance();
        if (IClientItemExtensions.of(stack).getHumanoidArmorModel(null, stack, null, null) instanceof GeoArmorRenderer<?> armorRenderer)
            return armorRenderer;
        return null;
    }
}
