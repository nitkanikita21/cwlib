package me.cobweb.fabric.cwlib.client.gui.api;

import io.github.layout.LayoutContext;

public interface Prefab {
    void build(Container<?> container, LayoutContext ctx);
}
