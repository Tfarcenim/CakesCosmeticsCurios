package tfar.cakescosmeticscurios;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.loworbitstation.cakescosmetics.entity.armor.ChristmasHatRenderer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class CakesCosmeticCurioRenderer implements ICurioRenderer {
    private GeoArmorRenderer<?> renderer;
    ResourceLocation texture;

    public CakesCosmeticCurioRenderer(GeoArmorRenderer<?> renderer) {
        this.renderer = renderer;
        texture = renderer.getGeoModel().getTextureResource(null);
    }

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack matrixStack,
                                                                          RenderLayerParent<T, M> renderLayerParent, MultiBufferSource renderTypeBuffer,
                                                                          int light, float limbSwing, float limbSwingAmount, float partialTicks,
                                                                          float ageInTicks, float netHeadYaw, float headPitch) {

        M model = renderLayerParent.getModel();
        if (model instanceof HumanoidModel<?> humanoidModel) {
            VertexConsumer vertexconsumer = renderTypeBuffer.getBuffer(RenderType.armorCutoutNoCull(texture));
            this.renderer.prepForRender(slotContext.entity(), stack, EquipmentSlot.HEAD, humanoidModel);
            renderer.renderToBuffer(matrixStack, vertexconsumer, light, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        }
    }
}
