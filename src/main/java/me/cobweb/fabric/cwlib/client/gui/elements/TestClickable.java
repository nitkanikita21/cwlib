package me.cobweb.fabric.cwlib.client.gui.elements;

import io.github.layout.LayoutContext;
import me.cobweb.fabric.cwlib.client.gui.api.BaseClickableElement;
import me.cobweb.fabric.cwlib.client.gui.utils.GuiContext;
import me.cobweb.fabric.cwlib.client.gui.utils.RectUtils;

import java.util.Objects;

public class TestClickable extends BaseClickableElement<TestClickable> {
    public TestClickable(LayoutContext ctx) {
        super(ctx);
    }

    @Override
    public void draw(GuiContext guiContext) {
        super.draw(guiContext);
        if (Objects.requireNonNull(getState()) == MouseState.PRESSED) {
            RectUtils.drawBorderRect(guiContext.matrices, getRect(), 0xffffffff);
        } else {
            RectUtils.drawBorderRect(guiContext.matrices, getRect(), 0xff00ffff);
        }
    }
}
