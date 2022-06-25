package fr.canardnocturne.cnrpg.server;

import net.fabricmc.api.DedicatedServerModInitializer;

/**
 * @author CanardNocturne
 */
public class CNRPGServer implements DedicatedServerModInitializer {

    @Override
    public void onInitializeServer() {
        SetRolePacketReceiver.register();
    }
}
