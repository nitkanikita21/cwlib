package me.cobweb.fabric.cwlib.client.gui.utils;

import com.mojang.blaze3d.systems.RenderSystem;
import lombok.experimental.UtilityClass;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix4f;

@UtilityClass
public class RectUtils {
    public void drawFillRect(MatrixStack matricies, float[] rect, int color) {
        DrawableHelper.fill(matricies, (int) rect[0], (int) rect[1], (int) (rect[0]+rect[2]), (int) (rect[1] + rect[3]), color);
    }
    public void drawBorderRect(MatrixStack matricies, float[] rect, int color) {
        //|-
        DrawableHelper.fill(matricies, (int) rect[0], (int) rect[1], (int) (rect[0]+rect[2]), (int) rect[0], color);
        DrawableHelper.fill(matricies, (int) rect[0], (int) rect[1], (int) rect[0], (int) (rect[1] + rect[3]), color);

        //_|
        DrawableHelper.fill(matricies, (int) rect[0], (int) rect[3], (int) rect[0], (int) (rect[1] + rect[3]), color);
        DrawableHelper.fill(matricies, (int) (rect[0]+rect[2]), (int) rect[3], (int) (rect[0]+rect[2]), (int) (rect[1] + rect[3]), color);
    }

    public void drawLine(MatrixStack matricies, int x1, int y1, int x2, int y2, float width, int color){
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder builder = tessellator.getBuffer();
        Matrix4f mm = matricies.peek().getPositionMatrix();


        RenderSystem.disableTexture();
        RenderSystem.lineWidth(width);

        builder.begin(VertexFormat.DrawMode.LINES, VertexFormats.POSITION_COLOR);
        builder.vertex(mm, x1, y1, 20).color(color).next();
        builder.vertex(mm, x2, y2, 20).color(color).next();
        tessellator.draw();

        RenderSystem.enableTexture();
        RenderSystem.lineWidth(1f);
    }

    public boolean checkInRect(double x, double y, float[] rect){
        return (x > rect[0] && x < rect[0] + rect[2]) &&
                (y > rect[1] && y < rect[1] + rect[3]);
    }
}
