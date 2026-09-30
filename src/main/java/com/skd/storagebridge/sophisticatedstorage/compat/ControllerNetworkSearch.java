package com.skd.storagebridge.sophisticatedstorage.compat;

import java.util.LinkedHashSet;
import java.util.Set;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.p3pp3rf1y.sophisticatedstorage.block.ControllerBlockEntity;

/**
 * Shared helpers for every {@code compat.*} integration in this mod
 * (Apothic-Enchanting Library, Apotheosis Gem Case).
 *
 * <p>The trigger is the same right-click Sophisticated Storage already uses to
 * deposit the player's inventory into the Controller's storages: main hand, not
 * sneaking, any face (the Sophisticated Storage Controller has no front face).
 * Sophisticated Storage's own deposit still runs afterwards; this mod only adds
 * the targets it cannot reach.</p>
 *
 * <p>A target is "reachable" when it touches the Controller itself, any storage
 * the Controller has connected ({@link ControllerBlockEntity#getStoragePositions()},
 * bounded by Sophisticated Storage's own {@code controllerRange}), or any linked
 * block such as a Storage Link ({@link ControllerBlockEntity#getLinkedBlocks()}).</p>
 */
public final class ControllerNetworkSearch {

    private ControllerNetworkSearch() {
    }

    /**
     * Returns the Sophisticated Storage Controller targeted by this click if it
     * is a valid deposit gesture, or {@code null} otherwise (client side, other
     * block, off-hand or sneaking).
     */
    public static ControllerBlockEntity controllerFor(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        if (level.isClientSide()) {
            return null;
        }
        if (event.getHand() != InteractionHand.MAIN_HAND) {
            return null; // Sophisticated Storage only deposits from the main-hand click
        }
        if (event.getEntity().isShiftKeyDown()) {
            return null; // sneak-clicks are Sophisticated Storage's own upgrade interactions
        }
        if (!(level.getBlockEntity(event.getPos()) instanceof ControllerBlockEntity controller)) {
            return null; // not a Controller at all, stay silent to avoid acting on unrelated clicks
        }
        return controller;
    }

    public static <T extends BlockEntity> T findNetworked(Level level, ControllerBlockEntity controller, Class<T> targetType) {
        Set<BlockPos> members = new LinkedHashSet<>();
        members.add(controller.getBlockPos());
        members.addAll(controller.getStoragePositions());
        members.addAll(controller.getLinkedBlocks());

        for (BlockPos member : members) {
            for (Direction direction : Direction.values()) {
                BlockPos neighbor = member.relative(direction);
                if (!level.isLoaded(neighbor)) {
                    continue;
                }
                BlockEntity blockEntity = level.getBlockEntity(neighbor);
                if (targetType.isInstance(blockEntity)) {
                    return targetType.cast(blockEntity);
                }
            }
        }
        return null;
    }
}
