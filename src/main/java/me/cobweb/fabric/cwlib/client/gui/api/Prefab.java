package me.cobweb.fabric.cwlib.client.gui.api;

import io.github.layout.LayoutContext;

public interface Prefab<T extends Prefab> {
    interface PrefabInitializer {
        void build(Container<?> container, LayoutContext context);
    }

    void putItems(Container<?> container, LayoutContext ctx);

    T initPrefab(PrefabInitializer initializer);
}
