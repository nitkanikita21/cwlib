package me.cobweb.fabric.cwlib.client.gui.api;

import io.github.layout.LayoutContext;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import me.cobweb.fabric.cwlib.client.gui.utils.GuiContext;
import me.cobweb.fabric.cwlib.client.gui.utils.RectUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.sound.SoundEvents;

import java.util.Objects;

@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseClickableElement<T extends BaseClickableElement<?>> extends BaseElement<T> implements Drawable {

    @Setter
    @Getter
    MouseState state = MouseState.NONE;

    protected BaseClickableElement(LayoutContext ctx) {
        super(ctx);
    }

    @Override
    public boolean mouseClicked(GuiContext ctx) {
        if (!RectUtils.checkInRect(ctx.mouseX, ctx.mouseY, getRect())) return false;
        state = MouseState.PRESSED;

        MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_BUTTON_CLICK, 1.0F));

        return true;
    }

    @Override
    public boolean mouseReleased(GuiContext ctx) {
        state = MouseState.NONE;
        return true;
    }

    @Override
    public void draw(GuiContext guiContext) {

    }

    public enum MouseState {
        HOVERED, PRESSED, SELECTED, NONE
    }
}
