//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.render.modules;

import java.awt.Color;

import keystrokesmod.module.ModuleSettings;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class ModuleSettingsStateRenderer extends ModuleDescRender
{
    private boolean h;
    private ModuleSettings cl1ckButton;
    private ModuleDescRenderer p;
    private int o;
    private int x;
    private int y;
    
    public ModuleSettingsStateRenderer(final ModuleSettings op, final ModuleDescRenderer b, final int o) {
        this.cl1ckButton = op;
        this.p = b;
        this.x = b.chromaManager.gx() + b.chromaManager.gw();
        this.y = b.chromaManager.gy() + b.o;
        this.o = o;
    }
    
    public static void e() {
        GL11.glDisable(2929);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glDepthMask(true);
        GL11.glEnable(2848);
        GL11.glHint(3154, 4354);
        GL11.glHint(3155, 4354);
    }
    
    public static void d() {
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDisable(2848);
        GL11.glHint(3154, 4352);
        GL11.glHint(3155, 4352);
    }
    
    public static void d(final float x, final float y, final float x1, final float y1, final int c) {
        e();
        b(c);
        d(x, y, x1, y1);
        d();
    }
    
    public static void d(final float x, final float y, final float x1, final float y1) {
        GL11.glBegin(7);
        GL11.glVertex2f(x, y1);
        GL11.glVertex2f(x1, y1);
        GL11.glVertex2f(x1, y);
        GL11.glVertex2f(x, y);
        GL11.glEnd();
    }
    
    public static void b(final int h) {
        final float a1pha = (h >> 24 & 0xFF) / 350.0f;
        GL11.glColor4f(0.0f, 0.0f, 0.0f, a1pha);
    }
    
    @Override
    public void render() {
        GL11.glPushMatrix();
        GL11.glScaled(0.5, 0.5, 0.5);
        Minecraft.getMinecraft().fontRendererObj.drawString(this.cl1ckButton.isToggled() ? ("> \u2714 <   " + this.cl1ckButton.get()) : ("> x <   " + this.cl1ckButton.get()), (float)((this.p.chromaManager.gx() + 4) * 2), (float)((this.p.chromaManager.gy() + this.o + 4) * 2), this.cl1ckButton.isToggled() ? new Color(20, 255, 0).getRGB() : -1, false);
        GL11.glPopMatrix();
    }
    
    @Override
    public void so(final int n) {
        this.o = n;
    }
    
    @Override
    public void uu(final int x, final int y) {
        this.h = this.i(x, y);
        this.y = this.p.chromaManager.gy() + this.o;
        this.x = this.p.chromaManager.gx();
    }
    
    @Override
    public void onCl1ck(final int x, final int y, final int b) {
        if (this.i(x, y) && b == 0 && this.p.po) {
            this.cl1ckButton.toggle();
        }
    }
    
    public boolean i(final int x, final int y) {
        return x > this.x && x < this.x + this.p.chromaManager.gw() && y > this.y && y < this.y + 11;
    }
}
