//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.render.modules;

import keystrokesmod.module.*;
import keystrokesmod.render.ChromaManager;
import keystrokesmod.module.modules.client.Gui;
import net.minecraft.client.Minecraft;
import java.awt.Color;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

public class ModuleDescRenderer extends ModuleDescRender
{
    public Module mod;
    public ChromaManager chromaManager;
    public int o;
    private boolean ih;
    private ArrayList<ModuleDescRender> sn;
    public boolean po;
    private int h;

    public ModuleDescRenderer(final Module mod, final ChromaManager chromaManager, final int o) {
        this.mod = mod;
        this.chromaManager = chromaManager;
        this.o = o;
        this.sn = new ArrayList<ModuleDescRender>();
        this.po = false;
        this.h = 12;
        int y = o + 12;
        if (!mod.v().isEmpty()) {
            for (final ModuleSettingsList v : mod.v()) {
                if (v instanceof ModuleSettings2) {
                    final ModuleSettings2 n = (ModuleSettings2)v;
                    final ModuleSettingNameRenderer s = new ModuleSettingNameRenderer(n, this, y);
                    this.sn.add(s);
                    y += 12;
                }
                if (v instanceof ModuleSettings) {
                    final ModuleSettings b = (ModuleSettings)v;
                    final ModuleSettingsStateRenderer c = new ModuleSettingsStateRenderer(b, this, y);
                    this.sn.add(c);
                    y += 12;
                }
                if (v instanceof ModuleDesc) {
                    final ModuleDesc d = (ModuleDesc)v;
                    final ModuleDescRenderer2 m = new ModuleDescRenderer2(d, this, y);
                    this.sn.add(m);
                    y += 12;
                }
            }
        }
        this.sn.add(new AutoConfigDescRender(this, y));
    }
    
    @Override
    public void so(final int n) {
        this.o = n;
        int y = this.o + 16;
        for (final ModuleDescRender co : this.sn) {
            co.so(y);
            if (co instanceof ModuleSettingNameRenderer) {
                y += 16;
            }
            if (co instanceof ModuleSettingsStateRenderer || co instanceof AutoConfigDescRender || co instanceof ModuleDescRenderer2) {
                y += 12;
            }
        }
    }
    
    public static void e() {
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glDepthMask(true);
        GL11.glEnable(2848);
        GL11.glHint(3154, 4354);
        GL11.glHint(3155, 4354);
    }
    
    public static void f() {
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glEnable(2929);
        GL11.glDisable(2848);
        GL11.glHint(3154, 4352);
        GL11.glHint(3155, 4352);
        GL11.glEdgeFlag(true);
    }
    
    public static void g(final int h) {
        float a = 0.0f;
        float r = 0.0f;
        float g = 0.0f;
        float b = 0.0f;
        if (Gui.a.getInput() == 1.0) {
            a = (h >> 14 & 0xFF) / 255.0f;
            r = (h >> 5 & 0xFF) / 2155.0f;
            g = (h >> 5 & 0xFF) / 255.0f;
            b = (float)(h & 0xFF);
        }
        if (Gui.a.getInput() == 2.0) {
            a = (h >> 14 & 0xFF) / 255.0f;
            r = (h >> 5 & 0xFF) / 255.0f;
            g = (h >> 5 & 0xFF) / 2155.0f;
            b = (float)(h & 0xFF);
        }
        if (Gui.a.getInput() == 3.0) {}
        GL11.glColor4f(r, g, b, a);
    }
    
    public static void v(final float x, final float y, final float x1, final float y1, final int t, final int b) {
        e();
        GL11.glShadeModel(7425);
        GL11.glBegin(7);
        g(t);
        GL11.glVertex2f(x, y1);
        GL11.glVertex2f(x1, y1);
        g(b);
        GL11.glVertex2f(x1, y);
        GL11.glVertex2f(x, y);
        GL11.glEnd();
        GL11.glShadeModel(7424);
        f();
    }
    
    @Override
    public void render() {
        v((float)this.chromaManager.gx(), (float)(this.chromaManager.gy() + this.o), (float)(this.chromaManager.gx() + this.chromaManager.gw()), (float)(this.chromaManager.gy() + 15 + this.o), this.mod.isEnabled() ? new Color(154, 2, 255).getRGB() : -12829381, this.mod.isEnabled() ? new Color(154, 2, 255).getRGB() : -12302777);
        GL11.glPushMatrix();
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(this.mod.g3tN4m3(), (float)(this.chromaManager.gx() + this.chromaManager.gw() / 2 - Minecraft.getMinecraft().fontRendererObj.getStringWidth(this.mod.g3tN4m3()) / 2), (float)(this.chromaManager.gy() + this.o + 4), this.mod.isEnabled() ? ((Gui.a.getInput() == 3.0) ? new Color(0, 85, 255).getRGB() : new Color(250, 250, 250).getRGB()) : new Color(200, 200, 200).getRGB());
        GL11.glPopMatrix();
        if (this.po && !this.sn.isEmpty()) {
            for (final ModuleDescRender c : this.sn) {
                c.render();
            }
        }
    }
    
    @Override
    public int gh() {
        if (this.po) {
            int h = 16;
            for (final ModuleDescRender c : this.sn) {
                if (c instanceof ModuleSettingNameRenderer) {
                    h += 16;
                }
                if (c instanceof ModuleSettingsStateRenderer || c instanceof AutoConfigDescRender || c instanceof ModuleDescRenderer2) {
                    h += 12;
                }
            }
            return h;
        }
        return 16;
    }
    
    @Override
    public void uu(final int x, final int y) {
        this.ih = this.ii(x, y);
        if (!this.sn.isEmpty()) {
            for (final ModuleDescRender c : this.sn) {
                c.uu(x, y);
            }
        }
    }
    
    @Override
    public void onCl1ck(final int x, final int y, final int z) {
        if (this.ii(x, y) && z == 0) {
            this.mod.toggle();
        }
        if (this.ii(x, y) && z == 1) {
            this.po = !this.po;
            this.chromaManager.r3nd3r();
        }
        for (final ModuleDescRender moduleDescRender : this.sn) {
            moduleDescRender.onCl1ck(x, y, z);
        }
    }
    
    @Override
    public void mr(final int x, final int y, final int m) {
        for (final ModuleDescRender c : this.sn) {
            c.mr(x, y, m);
        }
    }
    
    @Override
    public void ky(final char t, final int k) {
        for (final ModuleDescRender c : this.sn) {
            c.ky(t, k);
        }
    }
    
    public boolean ii(final int x, final int y) {
        return x > this.chromaManager.gx() && x < this.chromaManager.gx() + this.chromaManager.gw() && y > this.chromaManager.gy() + this.o && y < this.chromaManager.gy() + 16 + this.o;
    }
}
