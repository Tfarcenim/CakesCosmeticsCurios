package tfar.cakescosmeticscurios;

import net.loworbitstation.cakescosmetics.item.ModItems;
import net.loworbitstation.cakescosmetics.item.VanityArmorItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.CuriosDataProvider;

import java.util.concurrent.CompletableFuture;

public class Datagen {
    static void gather(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        BlockTagP blockTagP = new BlockTagP(output, lookupProvider, existingFileHelper);
        generator.addProvider(true, blockTagP);
        generator.addProvider(true, new ItemTagP(output, lookupProvider, blockTagP.contentsGetter(), existingFileHelper));
        generator.addProvider(true, new ModCuriosDataProvider(event));
        generator.addProvider(true, new Lang(output));
        generator.addProvider(true,new ItemModels(output,existingFileHelper));
    }

    static class ItemTagP extends ItemTagsProvider {
        public ItemTagP(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
            super(p_275343_, p_275729_, p_275322_, CakesCosmeticsCurios.MODID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(ModTags.HEAD).add(CuriosItems.HEAD_ITEMS.toArray(new VanityArmorItem[0]));
            tag(ModTags.BACK).add(CuriosItems.BACK_ITEMS.toArray(new VanityArmorItem[0]));
            tag(ModTags.BELT).add(CuriosItems.BELT_ITEMS.toArray(new VanityArmorItem[0]));
            tag(ModTags.FEET).add(CuriosItems.FEET_ITEMS.toArray(new VanityArmorItem[0]));
        }
    }

    static class BlockTagP extends BlockTagsProvider {
        public BlockTagP(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, CakesCosmeticsCurios.MODID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {

        }
    }

    static class ItemModels extends ItemModelProvider{

        public ItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
            super(output, CakesCosmeticsCurios.MODID, existingFileHelper);
        }

        @Override
        protected void registerModels() {
        }

        protected String name(Item item) {
            return BuiltInRegistries.ITEM.getKey(item).getPath();
        }

        private void generatedItem(Item item, ResourceLocation texture) {
            String path = name(item);
            singleTexture(path, mcLoc("item/generated"),
                    "layer0", texture);
        }

        private void generatedItem(Item item) {
            generatedItem(item, modLoc("item/" + name(item)));
        }

    }

    static class Lang extends LanguageProvider {
        public Lang(PackOutput output) {
            super(output, CakesCosmeticsCurios.MODID, "en_us");
        }

        @Override
        protected void addTranslations() {
            add("curios.identifier.feet","Feet");
        }
    }

    static class ModCuriosDataProvider extends CuriosDataProvider {

        public ModCuriosDataProvider(GatherDataEvent event) {
            super(CakesCosmeticsCurios.MODID, event.getGenerator().getPackOutput(), event.getExistingFileHelper(), event.getLookupProvider());
        }

        @Override
        public void generate(HolderLookup.Provider registries, ExistingFileHelper fileHelper) {
            createSlot("feet");
            this.createEntities("entity_slots")
                    .addPlayer()
                    .addSlots("head","back","belt","feet");

        }
    }
}
