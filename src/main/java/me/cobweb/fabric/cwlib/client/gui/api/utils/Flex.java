package me.cobweb.fabric.cwlib.client.gui.api.utils;

import io.github.layout.LayoutBoxFlags;
import io.github.layout.LayoutContext;
import io.github.layout.LayoutFlags;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.intellij.lang.annotations.MagicConstant;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Flex {
    @MagicConstant(flagsFromClass = LayoutBoxFlags.class)
    int contain = LayoutBoxFlags.LAY_START | LayoutBoxFlags.LAY_JUSTIFY;
    @MagicConstant(flagsFromClass = LayoutFlags.class)
    int behave = LayoutFlags.LAY_HFILL | LayoutFlags.LAY_VFILL;

    float marginLeft = 0;
    float marginTop = 0;
    float marginRight = 0;
    float marginBottom = 0;

    public Flex mLeft(float v) {
        this.marginLeft = v;
        return this;
    }

    public Flex mTop(float v) {
        this.marginTop = v;
        return this;
    }

    public Flex mRight(float v) {
        this.marginRight = v;
        return this;
    }

    public Flex mBottom(float v) {
        this.marginBottom = v;
        return this;
    }
    public Flex m(float l, float t, float r, float b){
        mLeft(l); mTop(t); mRight(r); mBottom(b);
        return this;
    }

    int width = 0;
    int height = 0;

    public int getContain() {
        return contain;
    }

    public Flex contain(@MagicConstant(flagsFromClass = LayoutBoxFlags.class) int contain) {
        this.contain = contain;
        return this;
    }

    public int getBehave() {
        return behave;
    }

    public Flex behave(@MagicConstant(flagsFromClass = LayoutFlags.class) int behave) {
        this.behave = behave;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public Flex w(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public Flex h(int height) {
        this.height = height;
        return this;
    }

    public Flex wh(int width, int height){
        this.width = width;
        this.height = height;
        return this;
    }

    public void apply(LayoutContext ctx, int id){
        ctx.setContain(id, contain);
        ctx.setBehave(id, behave);
        ctx.setSize(id, width, height);
        ctx.setMargins(id, marginLeft, marginTop, marginRight, marginBottom);
    }
}
