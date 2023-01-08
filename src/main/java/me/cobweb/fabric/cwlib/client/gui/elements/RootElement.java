package me.cobweb.fabric.cwlib.client.gui.elements;

import io.github.layout.LayoutContext;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import me.cobweb.fabric.cwlib.client.gui.api.*;
import me.cobweb.fabric.cwlib.client.gui.api.utils.Flex;
import me.cobweb.fabric.cwlib.client.gui.utils.GuiContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class RootElement implements Element, Drawable, Container<RootElement>, Customizible<RootElement> {
    final List<Element> children = new ArrayList<>();
    final LayoutContext ctx;
    int id = 0;
    @Getter
    Flex flex;

    public RootElement(LayoutContext ctx, Flex flex) {
        id = ctx.item();
        this.flex = flex;
        this.ctx = ctx;
    }

    @Override
    public List<Element> children() {
        return children;
    }

    @Override
    public RootElement addChildren(Element... child) {
        for (Element element : child) {
            if (element instanceof Prefab) {
                ((Prefab) element).build(this, ctx);
            } else {
                element.setParent(this);
            }
        }
        children.addAll(Stream.of(child).filter(element -> !(element instanceof Prefab)).toList());
        return this;
    }

    @Override
    public void draw(GuiContext guiContext) {
        drawChildren(guiContext);
    }

    @Override
    public boolean isVisible(GuiContext ctx) {
        return false;
    }

    @Override
    public boolean isEnabled(GuiContext ctx) {
        return false;
    }

    @Override
    public boolean mouseClicked(GuiContext ctx) {
        System.out.println("Test");
        children.forEach(element -> {element.mouseClicked(ctx);});
        return false;
    }

    @Override
    public boolean mouseScrolled(GuiContext ctx) {
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
        return false;
    }

    @Override
    public void applyFlex(LayoutContext ctx) {
        Window window = MinecraftClient.getInstance().getWindow();
        flex.wh(window.getScaledWidth(), window.getScaledHeight());
        flex.apply(ctx, id);
        for (Element child : children) {
            child.applyFlex(ctx);
        }
    }

    @Override
    public @Nullable Element getParent() {
        return null;
    }

    @Override
    public void setParent(Element parent) {
        throw new UnsupportedOperationException("This is the root element");
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public RootElement customize(CustomizeCallback<RootElement> callback) {
        callback.customize(this);
        return null;
    }
}
