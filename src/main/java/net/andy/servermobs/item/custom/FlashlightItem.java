package net.andy.servermobs.item.custom;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.world.ServerWorld;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FlashlightItem extends Item {
    private static final long TORCH_LIFETIME = 10;
    private final Map<Long, Long> torchTimers = new HashMap<Long, Long>();

    public FlashlightItem(Settings settings) {
        super(settings);
        ServerTickEvents.END_WORLD_TICK.register(this::onWorldTick);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.playSound(SoundEvents.BLOCK_LEVER_CLICK, 1.0F, 1.0F);

        return super.use(world, user, hand);
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos().offset(context.getSide());
        Block block = Blocks.TORCH;

        if (!world.isClient) {
            world.setBlockState(pos, block.getDefaultState());
            torchTimers.put(pos.asLong(), world.getTime() + TORCH_LIFETIME);
        }

        return ActionResult.SUCCESS;
    }

    private void onWorldTick(ServerWorld world) {
        Iterator<Map.Entry<Long, Long>> iterator = torchTimers.entrySet().iterator();
        long currentTime = world.getTime();

        while (iterator.hasNext()) {
            Map.Entry<Long, Long> entry = iterator.next();
            BlockPos pos = BlockPos.fromLong(entry.getKey());
            long despawnTime = entry.getValue();

            if (currentTime >= despawnTime) {
                if (world.getBlockState(pos).getBlock() == Blocks.TORCH) {
                    world.setBlockState(pos, Blocks.AIR.getDefaultState());
                }
                iterator.remove();
            }
        }
    }
}

    /*
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos().offset(context.getSide());

        if (!world.isClient) {
            world.setBlockState(pos, Blocks.TORCH.getDefaultState());
        }

        return ActionResult.SUCCESS;
    }
    }
     */

