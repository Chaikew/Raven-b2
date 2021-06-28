//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.guis;

import keystrokesmod.render.ChromaManager;
import keystrokesmod.main.Ravenb2;
import keystrokesmod.module.UpdateModules;
import keystrokesmod.module.Module;
import keystrokesmod.render.modules.ModuleDescRender;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.EntityLivingBase;
import java.awt.Color;
import java.util.ArrayList;
import net.minecraft.client.gui.GuiScreen;

public class ClickGui extends GuiScreen
{
    public static ArrayList<ChromaManager> c4tL1st;
    
    public ClickGui() {
        ClickGui.c4tL1st = new ArrayList<ChromaManager>();
        int y = 5;
        Module.category[] values;
        for (int length = (values = Module.category.values()).length, i = 0; i < length; ++i) {
            final Module.category c = values[i];
            final ChromaManager f = new ChromaManager(c);
            f.y(y);
            ClickGui.c4tL1st.add(f);
            y += 20;
        }
    }
    
    public void initGui() {
        super.initGui();
    }
    
    public void drawScreen(final int x, final int y, final float p) {
        this.drawCenteredString(this.fontRendererObj, "r", this.width / 2 + 1, this.height / 4 - 25, Color.HSBtoRGB((System.currentTimeMillis() + 1500L) % 5000L / 4750.0f, 0.8f, 0.8f));
        this.drawCenteredString(this.fontRendererObj, "a", this.width / 2, this.height / 4 - 15, Color.HSBtoRGB((System.currentTimeMillis() + 1200L) % 5000L / 4750.0f, 0.8f, 0.8f));
        this.drawCenteredString(this.fontRendererObj, "v", this.width / 2, this.height / 4 - 5, Color.HSBtoRGB((System.currentTimeMillis() + 900L) % 5000L / 4750.0f, 0.8f, 0.8f));
        this.drawCenteredString(this.fontRendererObj, "e", this.width / 2, this.height / 4 + 5, Color.HSBtoRGB((System.currentTimeMillis() + 600L) % 5000L / 4750.0f, 0.8f, 0.8f));
        this.drawCenteredString(this.fontRendererObj, "n", this.width / 2, this.height / 4 + 15, Color.HSBtoRGB((System.currentTimeMillis() + 300L) % 5000L / 4750.0f, 0.8f, 0.8f));
        this.drawCenteredString(this.fontRendererObj, "b" + Ravenb2.ravenVersion, this.width / 2 + 1, this.height / 4 + 30, Color.HSBtoRGB((System.currentTimeMillis() + 0L) % 5000L / 4750.0f, 0.8f, 0.8f));
        for (final ChromaManager c : ClickGui.c4tL1st) {
            c.rf(this.fontRendererObj);
            c.up(x, y);
            for (final ModuleDescRender m : c.gc()) {
                m.uu(x, y);
            }
        }
        this.re(x, y, (EntityLivingBase)this.mc.thePlayer);
    }
    
    public void mouseClicked(final int x, final int y, final int mo) {
        for (final ChromaManager c4t : c4tL1st) {
            if (c4t.v(x, y) && !c4t.i(x, y) && !c4t.d(x, y) && mo == 0) {
                c4t.d(true);
                c4t.xx = x - c4t.gx();
                c4t.yy = y - c4t.gy();
            }
            if (c4t.d(x, y) && mo == 0) {
                c4t.oo(!c4t.fv());
            }
            if (c4t.i(x, y) && mo == 0) {
                c4t.cv(!c4t.p());
            }
            if (c4t.fv() && !c4t.gc().isEmpty()) {
                for (final ModuleDescRender c : c4t.gc()) {
                    c.onCl1ck(x, y, mo);
                }
            }
        }
    }
    
    public void keyTyped(final char t, final int k) {
        for (final ChromaManager c4t : ClickGui.c4tL1st) {
            if (c4t.fv() && k != 1 && !c4t.gc().isEmpty()) {
                for (final ModuleDescRender c : c4t.gc()) {
                    c.ky(t, k);
                }
            }
        }
        if (k == 1) {
            this.mc.displayGuiScreen((GuiScreen)null);
        }
    }
    
    public void mouseReleased(final int x, final int y, final int s) {
        if (s == 0) {
            for (final ChromaManager c4t : ClickGui.c4tL1st) {
                c4t.d(false);
            }
            for (final ChromaManager c4t : ClickGui.c4tL1st) {
                if (c4t.fv() && !c4t.gc().isEmpty()) {
                    for (final ModuleDescRender c : c4t.gc()) {
                        c.mr(x, y, s);
                    }
                }
            }
        }
    }
    
    public void onGuiClosed() {
        UpdateModules.ss();
    }
    
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    private void re(final int x, final int y, final EntityLivingBase e) {
        GuiInventory.drawEntityOnScreen(this.width - 25, this.height - 10, 40, (float)(this.width - 25 - x), (float)(this.height - 50 - y), e);
    }
}
