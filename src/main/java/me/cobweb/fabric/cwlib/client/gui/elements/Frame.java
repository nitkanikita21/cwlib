package me.cobweb.fabric.cwlib.client.gui.elements;

import io.github.layout.LayoutBoxFlags;
import io.github.layout.LayoutContext;
import lombok.Data;
import me.cobweb.fabric.cwlib.client.gui.api.*;
import me.cobweb.fabric.cwlib.client.gui.utils.GuiContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Frame extends BaseElement<Frame> implements Drawable, Customizible<Frame>, Container<Frame> {
    final List<Element> children = new ArrayList<>();

    public Frame(LayoutContext ctx) {
        super(ctx);
        flex.mLeft(2.5f)
                .mRight(2.5f)
                .mTop(2.5f)
                .mBottom(2.5f)
                .contain(LayoutBoxFlags.LAY_JUSTIFY);
    }

    @Override
    public List<Element> children() {
        return children;
    }

    @Override
    public Frame addChildren(Element... child) {
        for (Element element : child) {
            if (element instanceof Prefab) {
                ((Prefab) element).build(this, layout);
            } else {
                element.setParent(this);
            }
        }
        children.addAll(Stream.of(child).filter(element -> !(element instanceof Prefab)).toList());
        return this;
    }

    @Override
    public void draw(GuiContext guiContext) {
        float[] rect = getRect();
        for (Element child : children) {
            ((Drawable) child).draw(guiContext);
        }
        Window window = MinecraftClient.getInstance().getWindow();
    }

    @Override
    public void applyFlex(LayoutContext ctx) {
        super.applyFlex(ctx);
        for (Element child : children) {
            child.applyFlex(ctx);
        }
    }

    @Override
    public Frame customize(Customizible.CustomizeCallback<Frame> callback) {
        callback.customize(this);
        return null;
    }

    @Data
    public static class FrameStyles {
        private int backgroundColor = 0x66000000;
    }

    @Override
    public boolean mouseClicked(GuiContext ctx) {
        children.forEach(element -> {element.mouseClicked(ctx);});
        return false;
    }

    @Override
    public boolean mouseReleased(GuiContext ctx) {
        children.forEach(element -> {element.mouseReleased(ctx);});
        return false;
    }

    @Override
    public boolean keyPressed(GuiContext ctx) {
        children.forEach(element -> {element.keyPressed(ctx);});
        return super.keyPressed(ctx);
    }
}
