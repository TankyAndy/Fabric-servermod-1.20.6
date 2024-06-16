package net.andy.servermobs.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;


public class ExplosiveArrowEntity extends ArrowEntity {
    private final float explosionPower; // Set this value as needed

    public ExplosiveArrowEntity(EntityType<? extends ArrowEntity> entityType, World world, float explosionPower) {
        super(entityType, world);
        this.explosionPower = explosionPower;
    }


    /*
    public static DefaultAttributeContainer.Builder createrocketattributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1000)
                .add(EntityAttributes.GENERIC_GRAVITY, 0);
    }
     */

    @Override
    protected void onHit(LivingEntity target) {
        World world = target.getEntityWorld(); // Access the attacker's world

        super.onHit(target);

        if (!world.isClient) {
            // Create an explosion at the arrow's position
            world.createExplosion(this, getX(), getY(), getZ(), explosionPower, World.ExplosionSourceType.BLOCK);
            discard(); // Remove the arrow
        }
    }
}
