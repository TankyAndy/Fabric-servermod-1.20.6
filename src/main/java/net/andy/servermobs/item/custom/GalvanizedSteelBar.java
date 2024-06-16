
package net.andy.servermobs.item.custom;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class GalvanizedSteelBar extends SwordItem {
    private final float knockbackStrength;
    private final float explosionPower;

    public GalvanizedSteelBar(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, float knockbackStrength, float explosionPower, Settings settings) {
        super(toolMaterial, settings);
        this.knockbackStrength = knockbackStrength;
        this.explosionPower = explosionPower;
    }



    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = attacker.getEntityWorld(); // Access the attacker's world

        if (attacker instanceof PlayerEntity) {
            Vec3d direction = target.getPos().subtract(attacker.getPos()).normalize();
            target.addVelocity(direction.x * knockbackStrength, 1, direction.z * knockbackStrength);
        }

        world.playSound(null, target.getX(), target.getY(), target.getZ(), SoundEvents.BLOCK_ANVIL_LAND, SoundCategory.PLAYERS, 1.0F, 1.0F);

        /*
        world.createExplosion(attacker, target.getX(), target.getBodyY(0.0625), target.getZ(), explosionPower, World.ExplosionSourceType.BLOCK);
         */
        return super.postHit(stack, target, attacker);
    }
}
