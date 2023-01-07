package me.cobweb.fabric.cwlib.client.gui.elements;

import io.github.layout.LayoutContext;
import me.cobweb.fabric.cwlib.client.gui.api.Container;
import me.cobweb.fabric.cwlib.client.gui.api.Element;
import me.cobweb.fabric.cwlib.client.gui.api.Prefab;
import me.cobweb.fabric.cwlib.client.gui.api.utils.Flex;
import me.cobweb.fabric.cwlib.client.gui.utils.GuiContext;
import org.jetbrains.annotations.Nullable;

public class SimplePrefab implements Element, Prefab<SimplePrefab> {
    PrefabInitializer initializer;
    @Override
    public void putItems(Container<?> container, LayoutContext ctx) {
        if(initializer == null)return;
        initializer.build(container, ctx);
    }

    @Override
    public SimplePrefab initPrefab(PrefabInitializer initializer) {
        this.initializer = initializer;
        return this;
    }


    @Override
    public boolean isVisible(GuiContext ctx) {
        return true;
    }

    @Override
    public boolean isEnabled(GuiContext ctx) {
        return true;
    }

    @Override
    public boolean mouseClicked(GuiContext ctx) {
        return true;
    }

    @Override
    public boolean mouseScrolled(GuiContext ctx) {
        return true;
    }

    @Override
    public boolean mouseReleased(GuiContext ctx) {
        return true;
    }

    @Override
    public boolean keyPressed(GuiContext ctx) {
        return true;
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
