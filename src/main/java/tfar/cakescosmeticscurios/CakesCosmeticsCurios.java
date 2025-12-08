package tfar.cakescosmeticscurios;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CakesCosmeticsCurios.MODID)
public class CakesCosmeticsCurios {

    public static final String MODID = "cakescosmeticscurios";
    private static final Logger LOGGER = LogUtils.getLogger();

    public CakesCosmeticsCurios() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        modEventBus.addListener(Datagen::gather);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

}
