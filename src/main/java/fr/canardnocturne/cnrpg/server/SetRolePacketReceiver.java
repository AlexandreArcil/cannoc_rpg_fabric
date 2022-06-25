package fr.canardnocturne.cnrpg.server;

import fr.canardnocturne.cnrpg.network.CNRPGPackets;
import fr.canardnocturne.cnrpg.roles.Roles;
import fr.canardnocturne.cnrpg.roles.component.CNRPGComponents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

/**
 * @author CanardNocturne
 */
public class SetRolePacketReceiver {

    public static void register() {
        ServerPlayNetworking.registerGlobalReceiver(CNRPGPackets.SET_ROLE, (server, player, handler, buf, responseSender) -> {
            String role = buf.readString();
            CNRPGComponents.ROLE.get(player).setRole(Roles.getById(role));
        });
    }

}
