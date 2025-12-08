package tfar.cakescosmeticscurios.client;

import net.loworbitstation.cakescosmetics.item.ModItems;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import tfar.cakescosmeticscurios.CakesCosmeticCurioRenderer;
import tfar.cakescosmeticscurios.CakesCosmeticsCurios;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

@Mod.EventBusSubscriber(modid = CakesCosmeticsCurios.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent evt) {
        CuriosRendererRegistry.register(ModItems.CHRISTMAS_HAT.get(), () -> new CakesCosmeticCurioRenderer());
    }
}
