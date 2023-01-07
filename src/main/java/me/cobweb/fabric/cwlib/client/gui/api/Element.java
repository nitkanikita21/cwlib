package me.cobweb.fabric.cwlib.client.gui.api;

import io.github.layout.LayoutContext;
import me.cobweb.fabric.cwlib.client.gui.api.utils.Flex;
import me.cobweb.fabric.cwlib.client.gui.utils.GuiContext;
import org.jetbrains.annotations.Nullable;

public interface Element {
    boolean isVisible(GuiContext ctx);
    boolean isEnabled(GuiContext ctx);
    boolean mouseClicked(GuiContext ctx);
    boolean mouseScrolled(GuiContext ctx);
    boolean mouseReleased(GuiContext ctx);
    boolean keyPressed(GuiContext ctx);

    Flex getFlex();
    void applyFlex(LayoutContext ctx);

    @Nullable Element getParent();
    void setParent(Element parent);

    int getId();
}
