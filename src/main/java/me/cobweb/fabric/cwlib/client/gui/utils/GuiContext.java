package me.cobweb.fabric.cwlib.client.gui.utils;

import io.github.layout.LayoutContext;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.Window;
import net.minecraft.client.util.math.MatrixStack;

@FieldDefaults(level = AccessLevel.PUBLIC)
public class GuiContext {
    MinecraftClient minecraft;
    TextRenderer textRenderer;
    Window window;
    MatrixStack matrices;


    /* Mouse states */
    double mouseX;
    double mouseY;
    double mouseWheel;
    int mouseButton;
    float delta;

    /* Keyboard states */
    int keyCode;
    int scanCode;
    int modifiers;
}
