package me.cobweb.fabric.cwlib.client.gui.elements;

import io.github.layout.LayoutContext;
import io.github.layout.LayoutFlags;
import me.cobweb.fabric.cwlib.client.gui.api.BaseElement;
import me.cobweb.fabric.cwlib.client.gui.api.Drawable;
import me.cobweb.fabric.cwlib.client.gui.utils.GuiContext;
import me.cobweb.fabric.cwlib.client.gui.utils.RectUtils;

public class Test extends BaseElement<Test> implements Drawable {
    public Test(LayoutContext ctx) {
        super(ctx);
        flex
                .m(15, 15, 15, 15)
                .behave(LayoutFlags.LAY_HFILL | LayoutFlags.LAY_VFILL)
            ;
    }


    @Override
    public void draw(GuiContext guiContext) {
        RectUtils.drawFillRect(guiContext.matrices, getRect(), 0x3300ff00);
    }
}
