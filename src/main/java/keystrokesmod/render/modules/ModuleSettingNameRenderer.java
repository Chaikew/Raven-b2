//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.render.modules;

import java.math.RoundingMode;
import java.math.BigDecimal;

import keystrokesmod.module.ModuleSettings2;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;
import java.awt.Color;
import net.minecraft.client.gui.Gui;

public class ModuleSettingNameRenderer extends ModuleDescRender
{
    private boolean h;
    private ModuleSettings2 v;
    private ModuleDescRenderer p;
    private int o;
    private int x;
    private int y;
    private boolean d;
    private double w;
    
    public ModuleSettingNameRenderer(final ModuleSettings2 v, final ModuleDescRenderer b, final int o) {
        this.d = false;
        this.v = v;
        this.p = b;
        this.x = b.category.gx() + b.category.gw();
        this.y = b.category.gy() + b.o;
        this.o = o;
    }
    
    @Override
    public void render() {
        Gui.drawRect(this.p.category.gx() + 4, this.p.category.gy() + this.o + 11, this.p.category.gx() + 4 + this.p.category.gw() - 8, this.p.category.gy() + this.o + 15, -12302777);
        Gui.drawRect(this.p.category.gx() + 4, this.p.category.gy() + this.o + 11, this.p.category.gx() + 4 + (int)this.w, this.p.category.gy() + this.o + 15, Color.getHSBColor(System.currentTimeMillis() % 11000L / 11000.0f, 0.75f, 0.9f).getRGB());
        GL11.glPushMatrix();
        GL11.glScaled(0.5, 0.5, 0.5);
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(String.valueOf(this.v.get()) + ": " + this.v.getInput(), (float)(int)((this.p.category.gx() + 4) * 2.0f), (float)(int)((this.p.category.gy() + this.o + 3) * 2.0f), -1);
        GL11.glPopMatrix();
    }
    
    @Override
    public void so(final int n) {
        this.o = n;
    }
    
    @Override
    public void uu(final int x, final int y) {
        this.h = (this.u(x, y) || this.i(x, y));
        this.y = this.p.category.gy() + this.o;
        this.x = this.p.category.gx();
        final double d = Math.min(this.p.category.gw() - 8, Math.max(0, x - this.x));
        this.w = (this.p.category.gw() - 8) * (this.v.getInput() - this.v.geti()) / (this.v.geta() - this.v.geti());
        if (this.d) {
            if (d == 0.0) {
                this.v.setValue(this.v.geti());
            }
            else {
                final double n = r(d / (this.p.category.gw() - 8) * (this.v.geta() - this.v.geti()) + this.v.geti(), 2);
                this.v.setValue(n);
            }
        }
    }
    
    private static double r(final double v, final int p) {
        if (p < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bd = new BigDecimal(v);
        bd = bd.setScale(p, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    
    @Override
    public void onCl1ck(final int x, final int y, final int b) {
        if (this.u(x, y) && b == 0 && this.p.po) {
            this.d = true;
        }
        if (this.i(x, y) && b == 0 && this.p.po) {
            this.d = true;
        }
    }
    
    @Override
    public void mr(final int x, final int y, final int m) {
        this.d = false;
    }
    
    public boolean u(final int x, final int y) {
        return x > this.x && x < this.x + (this.p.category.gw() / 2 + 1) && y > this.y && y < this.y + 16;
    }
    
    public boolean i(final int x, final int y) {
        return x > this.x + this.p.category.gw() / 2 && x < this.x + this.p.category.gw() && y > this.y && y < this.y + 16;
    }
}
