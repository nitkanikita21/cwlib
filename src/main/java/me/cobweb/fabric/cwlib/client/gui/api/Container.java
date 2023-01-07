package me.cobweb.fabric.cwlib.client.gui.api;

import me.cobweb.fabric.cwlib.client.gui.utils.GuiContext;

import java.util.List;

public interface Container<B extends Container<?>> {
    List<Element> children();
    B addChildren(Element ...child);

    default void drawChildren(GuiContext ctx) {
        for (Element child : children()) {
            if(child instanceof Drawable)((Drawable) child).draw(ctx);
        }
    }
}
