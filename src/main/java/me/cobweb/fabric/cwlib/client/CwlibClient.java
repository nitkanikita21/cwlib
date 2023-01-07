package me.cobweb.fabric.cwlib.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class CwlibClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        /*KeyBinding editorKeybind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.itemeditor.openmenu", // The translation key of the keybinding's name
                InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
                GLFW.GLFW_KEY_R, // The keycode of the key
                "category.itemeditor.itemeditor" // The translation key of the keybinding's category.
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (editorKeybind.wasPressed()) {
                if(client.player != null){
                    client.setScreen(new LayoutScreen());
                }
            }
        });*/
    }
}
