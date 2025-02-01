package vowxky.rotnputrid.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import vowxky.rotnputrid.event.ClientJoinRot;

public class RotnputridClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientLifecycleEvents.CLIENT_STARTED.register(new ClientJoinRot());
    }
}
