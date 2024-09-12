package net.polenthor.fun.item.coustom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;
import java.util.Objects;

public class FunItem extends Item {

     private static final Map<Block, Block> FUN_MAP =
             Map.of(
                     Blocks.STONE, Blocks.CHISELED_SANDSTONE,
                     Blocks.BEDROCK, Blocks.SAND,
                     Blocks.DEEPSLATE, Blocks.ACACIA_FENCE,
                     Blocks.DIRT, Blocks.DIAMOND_BLOCK



                     );
    public FunItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();
if(FUN_MAP.containsKey(clickedBlock)) {
    if (level.isClientSide()) {
        level.setBlockAndUpdate(pContext.getClickedPos(),FUN_MAP.get(clickedBlock).defaultBlockState());

        pContext.getItemInHand().hurtAndBreak(1,((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null,pContext.getClickedPos(), SoundEvents.ANVIL_USE, SoundSource.BLOCKS);
    }
}



        return InteractionResult.SUCCESS;
    }
}
