package me.cobweb.fabric.cwlib.client.gui.api;

import io.github.layout.LayoutContext;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import me.cobweb.fabric.cwlib.client.gui.utils.GuiContext;
import me.cobweb.fabric.cwlib.client.gui.utils.RectUtils;

import java.util.Objects;

@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseClickableElement<T extends BaseClickableElement> extends BaseElement<T> implements Drawable {

    @Getter
    MouseState state = MouseState.NONE;

    protected BaseClickableElement(LayoutContext ctx) {
        super(ctx);
    }

    @Override
    public boolean mouseClicked(GuiContext ctx) {
        if (!RectUtils.checkInRect(ctx.mouseX, ctx.mouseY, getRect())) return false;
        state = MouseState.PRESSED;
        return true;
    }

    @Override
    public boolean mouseReleased(GuiContext ctx) {
        if (!RectUtils.checkInRect(ctx.mouseX, ctx.mouseY, getRect())) return false;
        state = MouseState.NONE;
        return true;
    }

    @Override
    public void draw(GuiContext guiContext) {
        if (Objects.requireNonNull(state) == MouseState.PRESSED) {
            RectUtils.drawBorderRect(guiContext.matrices, getRect(), 0xffffffff);
        } else {
            RectUtils.drawBorderRect(guiContext.matrices, getRect(), 0xff00ffff);
        }
    }

    public enum MouseState {
        HOVERED, PRESSED, SELECTED, NONE
    }
}
