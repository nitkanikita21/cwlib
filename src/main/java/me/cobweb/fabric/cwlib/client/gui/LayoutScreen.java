package me.cobweb.fabric.cwlib.client.gui;

import io.github.layout.LayoutBoxFlags;
import io.github.layout.LayoutContext;
import io.github.layout.LayoutFlags;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import me.cobweb.fabric.cwlib.client.gui.api.utils.Flex;
import me.cobweb.fabric.cwlib.client.gui.elements.*;
import me.cobweb.fabric.cwlib.client.gui.utils.GuiContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class LayoutScreen extends Screen {
    final LayoutContext ctx = new LayoutContext();
    final RootElement root = new RootElement(ctx,
            new Flex()
                    .behave(LayoutFlags.LAY_FILL)
                    .contain(LayoutBoxFlags.LAY_JUSTIFY | LayoutBoxFlags.LAY_ROW)
    );

    public LayoutScreen() {
        super(Text.empty());
    }


    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        GuiContext guiCtx = new GuiContext();
        guiCtx.matrices = matrices;
        guiCtx.mouseX = mouseX;
        guiCtx.mouseY = mouseY;
        guiCtx.delta = delta;

        guiCtx.minecraft = MinecraftClient.getInstance();
        guiCtx.window = guiCtx.minecraft.getWindow();
        guiCtx.textRenderer = guiCtx.minecraft.textRenderer;

        root.applyFlex(ctx);
        this.ctx.runContext();
        root.draw(guiCtx);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        GuiContext guiCtx = new GuiContext();
        guiCtx.mouseX = mouseX;
        guiCtx.mouseY = mouseY;
        guiCtx.mouseButton = button;
        root.mouseClicked(guiCtx);

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        GuiContext guiCtx = new GuiContext();
        guiCtx.mouseX = mouseX;
        guiCtx.mouseY = mouseY;
        guiCtx.mouseButton = button;
        root.mouseReleased(guiCtx);

        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double amount) {
        GuiContext guiCtx = new GuiContext();
        guiCtx.mouseX = mouseX;
        guiCtx.mouseY = mouseY;
        guiCtx.mouseWheel = amount;
        root.mouseReleased(guiCtx);

        return super.mouseScrolled(mouseX, mouseY, amount);
    }

    @Override
    public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
        GuiContext guiCtx = new GuiContext();
        guiCtx.keyCode = keyCode;
        guiCtx.scanCode = scanCode;
        guiCtx.modifiers = modifiers;

        root.keyPressed(guiCtx);
        return super.keyReleased(keyCode, scanCode, modifiers);
    }
}
