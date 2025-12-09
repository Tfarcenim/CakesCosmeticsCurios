package tfar.cakescosmeticscurios;

import net.loworbitstation.cakescosmetics.item.ModItems;
import net.loworbitstation.cakescosmetics.item.VanityArmorItem;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CuriosItems {

    public static final List<VanityArmorItem> HEAD_ITEMS = List.of(
            (VanityArmorItem) ModItems.CHRISTMAS_HAT.get(),
            (VanityArmorItem) ModItems.CAPTAINS_HAT.get(),
            (VanityArmorItem) ModItems.COWBOY_HAT.get(),ModItems.PIRATE_HAT.get(),ModItems.CAKEMAN_PLUSHIE.get(),
            ModItems.DRAGON_SKULL.get(),ModItems.HORNS.get(),ModItems.SKULL.get(),ModItems.SOMBRERO.get(),ModItems.TOP_HAT.get(),
            ModItems.STRAW_HAT.get(),ModItems.WIZARDS_HAT.get(),ModItems.KASA_HAT.get(),ModItems.TOP_HAT_HAT.get(),
            ModItems.PUMPKIN_HAT.get(),ModItems.PICKELHAUBE.get(),ModItems.CROWN.get()
            );

    public static final List<VanityArmorItem> BACK_ITEMS = List.of(ModItems.ARROW_QUIVER.get(),ModItems.BANDOLIER.get(),ModItems.WINGS.get()
            ,ModItems.SHEATHED_KATANA.get());
    public static final List<VanityArmorItem> BELT_ITEMS = List.of(ModItems.HOLSTERED_BELT.get());
    public static final List<VanityArmorItem> FEET_ITEMS = List.of(ModItems.HERMES_BOOTS.get());

    public static final List<VanityArmorItem> ALL_ITEMS = Stream.of(HEAD_ITEMS,BACK_ITEMS,BELT_ITEMS,FEET_ITEMS).flatMap(Collection::stream).toList();

}
