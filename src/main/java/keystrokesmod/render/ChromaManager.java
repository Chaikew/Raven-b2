//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.render;

import keystrokesmod.main.Ravenb2;
import keystrokesmod.module.Module;
import keystrokesmod.render.modules.ModuleDescRender;
import keystrokesmod.render.modules.ModuleDescRenderer;
import keystrokesmod.render.modules.ModuleSettingsStateRenderer;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.gui.Gui;
import java.awt.Color;
import net.minecraft.client.gui.FontRenderer;

import java.util.ArrayList;

public class ChromaManager
{
    public ArrayList<ModuleDescRender> c;
    public Module.category categoryName;
    private boolean categoryOpened;
    private int k;
    private int y;
    private int x;
    private int bh;
    private boolean id;
    public int xx;
    public int yy;
    public boolean n4m;
    public String pvp;
    public boolean pin;
    private int chromaSpeed;
    
    public ChromaManager(final Module.category category) {
        this.n4m = false;
        this.pin = false;
        this.c = new ArrayList<ModuleDescRender>();
        this.categoryName = category;
        this.k = 92;
        this.x = 5;
        this.y = 5;
        this.bh = 13;
        this.xx = 0;
        this.categoryOpened = false;
        this.id = false;
        this.chromaSpeed = 3;
        int tY = this.bh + 3;
        for (final Module mod : Ravenb2.c.getModuleManager().inCategory(this.categoryName)) {
            final ModuleDescRenderer b = new ModuleDescRenderer(mod, this, tY);
            this.c.add(b);
            tY += 16;
        }
    }
    
    public ChromaManager(final String d) {
        this.n4m = false;
        this.pin = false;
        this.c = new ArrayList<ModuleDescRender>();
        this.k = 92;
        this.x = 5;
        this.y = 5;
        this.bh = 13;
        this.xx = 0;
        this.categoryOpened = false;
        this.id = false;
        final int tY = this.bh;
        this.pvp = d;
        this.n4m = true;
    }
    
    public ArrayList<ModuleDescRender> gc() {
        return this.c;
    }
    
    public void x(final int n) {
        this.x = n;
    }
    
    public void y(final int y) {
        this.y = y;
    }
    
    public void d(final boolean d) {
        this.id = d;
    }
    
    public boolean p() {
        return this.pin;
    }
    
    public void cv(final boolean on) {
        this.pin = on;
    }
    
    public boolean fv() {
        return this.categoryOpened;
    }
    
    public void oo(final boolean on) {
        this.categoryOpened = on;
    }
    
    public void rf(final FontRenderer renderer) {
        this.k = 92;
        if (!this.c.isEmpty() && this.categoryOpened) {
            int h = 0;
            for (final ModuleDescRender c : this.c) {
                h += c.gh();
            }
            Gui.drawRect(this.x - 2, this.y, this.x + this.k + 2, this.y + this.bh + h + 4, new Color(0, 0, 0, 110).getRGB());
        }
        ModuleSettingsStateRenderer.d((float)(this.x - 2), (float)this.y, (float)(this.x + this.k + 2), (float)(this.y + this.bh + 3), -1);
        renderer.drawString(this.n4m ? this.pvp : this.categoryName.name(), (float)(this.x + 2), (float)(this.y + 4), Color.getHSBColor(System.currentTimeMillis() % (7500L / this.chromaSpeed) / (7500.0f / this.chromaSpeed), 1.0f, 1.0f).getRGB(), false);
        if (this.n4m) {
            return;
        }
        GL11.glPushMatrix();
        renderer.drawString(this.categoryOpened ? "-" : "+", (float)(this.x + 80), (float)(this.y + 4.5), Color.white.getRGB(), false);
        GL11.glPopMatrix();
        if (this.categoryOpened && !this.c.isEmpty()) {
            for (final ModuleDescRender c2 : this.c) {
                c2.render();
            }
        }
    }
    
    public void r3nd3r() {
        int o = this.bh + 3;
        for (final ModuleDescRender c : this.c) {
            c.so(o);
            o += c.gh();
        }
    }
    
    public int gx() {
        return this.x;
    }
    
    public int gy() {
        return this.y;
    }
    
    public int gw() {
        return this.k;
    }
    
    public void up(final int x, final int y) {
        if (this.id) {
            this.x(x - this.xx);
            this.y(y - this.yy);
        }
    }
    
    public boolean i(final int x, final int y) {
        return x >= this.x + 92 - 13 && x <= this.x + this.k && y >= this.y + 2.0f && y <= this.y + this.bh + 1;
    }
    
    public boolean d(final int x, final int y) {
        return x >= this.x + 77 && x <= this.x + this.k - 6 && y >= this.y + 2.0f && y <= this.y + this.bh + 1;
    }
    
    public boolean v(final int x, final int y) {
        return x >= this.x && x <= this.x + this.k && y >= this.y && y <= this.y + this.bh;
    }
}
