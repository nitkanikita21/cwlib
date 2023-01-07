package me.cobweb.fabric.cwlib.client.gui.api;

import io.github.layout.LayoutContext;
import me.cobweb.fabric.cwlib.client.gui.api.utils.Flex;
import me.cobweb.fabric.cwlib.client.gui.utils.GuiContext;

public abstract class BaseElement<T extends BaseElement> implements Element{
    protected boolean visible = true;
    protected boolean enabled = true;
    protected Flex flex = new Flex();
    protected LayoutContext layout;
    protected int id = 0;
    protected Element parent;

    public BaseElement(LayoutContext ctx) {
        id = ctx.item();
        layout = ctx;
    }

    @Override
    public boolean isVisible(GuiContext ctx) {
        return visible;
    }

    @Override
    public boolean isEnabled(GuiContext ctx) {
        return enabled;
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


    public interface FlexChanger {
        void change(Flex flex);
    }
    public T flex(FlexChanger callback){
        callback.change(flex);
        return (T) this;
    }

    @Override
    public void applyFlex(LayoutContext ctx) {
        flex.apply(ctx, id);
    }


    @Override
    public void setParent(Element parent){
        layout.insert(parent.getId(), id);
        this.parent = parent;
    }
    public T parent(Element parent){
        setParent(parent);
        return (T)this;
    }

    public Element getParent(){
        return parent;
    }

    @Override
    public int getId() {
        return id;
    }


    public float[] getRect(){
        return layout.getRect(id, new float[4]);
    }
}
