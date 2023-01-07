package me.cobweb.fabric.cwlib.client.gui.api;

public interface Customizible<B extends Customizible<?>> {

    interface CustomizeCallback<T extends Customizible> {
        void customize(T callback);
    }
    B customize(CustomizeCallback<B> callback);
}
