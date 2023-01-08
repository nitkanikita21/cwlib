package me.cobweb.fabric.cwlib.client.gui.api;

import io.github.layout.LayoutContext;
import lombok.Getter;
import me.cobweb.fabric.cwlib.client.gui.api.utils.Flex;
import me.cobweb.fabric.cwlib.client.gui.utils.GuiContext;
import org.jetbrains.annotations.Nullable;

public abstract class BasePrefab<T extends BasePrefab<?, ?>, D> implements Prefab, Element{
    @Getter
    private D data;
    public T data(D data) {
        this.data = data;
        return (T) this;
    }

    @Override
    public abstract void build(Container<?> container, LayoutContext ctx);

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
        return false;
    }

    @Override
    public boolean mouseScrolled(GuiContext ctx) {
        return false;
    }

    @Override
    public boolean mouseReleased(GuiContext ctx) {
        return false;
    }

    @Override
    public boolean keyPressed(GuiContext ctx) {
        return false;
    }

    @Override
    public Flex getFlex() {
        return null;
    }

    @Override
    public void applyFlex(LayoutContext ctx) {

    }

    @Override
    public @Nullable Element getParent() {
        return null;
    }

    @Override
    public void setParent(Element parent) {

    }

    @Override
    public int getId() {
        return 0;
    }
}
