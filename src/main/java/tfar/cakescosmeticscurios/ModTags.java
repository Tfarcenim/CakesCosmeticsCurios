package tfar.cakescosmeticscurios;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

/**
 * @see
 * top.theillusivec4.curios.api.SlotTypePreset
 */
public class ModTags {

    public static final TagKey<Item> HEAD = curios("head");
    public static final TagKey<Item> BACK = curios("back");
    public static final TagKey<Item> BELT = curios("belt");
    public static final TagKey<Item> FEET = curios("feet");

    public static TagKey<Item> curios(String s) {
        return TagKey.create(Registries.ITEM,new ResourceLocation("curios",s));
    }

}
