package net.andy.servermobs.mixin;

import net.andy.servermobs.ServerMobs;
import net.andy.servermobs.item.ModItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useRubyStaffModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.isOf(ModItems.FAULTYROCKETLAUNCHER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(ServerMobs.MOD_ID, "faulty_rocket_launcher_3d", "inventory"));
        }
        if (stack.isOf(ModItems.FAULTYROCKETLAUNCHER_WORLD_ENDER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(ServerMobs.MOD_ID, "faulty_rocket_launcher_wd_3d", "inventory"));
        }
        if (stack.isOf(ModItems.FAULTYGRENADELAUNCHER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(ServerMobs.MOD_ID, "faulty_grenade_launcher_3d", "inventory"));
        }
        if (stack.isOf(ModItems.FAULTYROCKETLAUNCHER_NUCLEAR) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(ServerMobs.MOD_ID, "faulty_rocket_launcher_nuclear_3d", "inventory"));
        }
        return value;
    }
}