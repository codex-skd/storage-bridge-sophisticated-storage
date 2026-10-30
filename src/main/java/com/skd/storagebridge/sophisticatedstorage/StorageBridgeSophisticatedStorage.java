package com.skd.storagebridge.sophisticatedstorage;

import com.skd.storagebridge.sophisticatedstorage.compat.apotheosis.GemCaseDepositHandler;
import com.skd.storagebridge.sophisticatedstorage.compat.apothic.LibraryDepositHandler;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

@Mod(StorageBridgeSophisticatedStorage.MOD_ID)
public class StorageBridgeSophisticatedStorage {

    public static final String MOD_ID = "storage_bridge_sophisticated_storage";

    public StorageBridgeSophisticatedStorage(IEventBus modEventBus) {
        // Gameplay listeners live on the global game bus, not the mod lifecycle bus.
        NeoForge.EVENT_BUS.addListener(LibraryDepositHandler::onRightClickController);
        NeoForge.EVENT_BUS.addListener(GemCaseDepositHandler::onRightClickController);
    }
}
