//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.render.modules;

import java.awt.Color;

import keystrokesmod.module.ModuleDesc;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class ModuleDescRenderer2 extends ModuleDescRender
{
    private ModuleDesc desc;
    private ModuleDescRenderer p;
    private int o;
    private int x;
    private int y;
    
    public ModuleDescRenderer2(final ModuleDesc desc, final ModuleDescRenderer b, final int o) {
        this.desc = desc;
        this.p = b;
        this.x = b.category.gx() + b.category.gw();
        this.y = b.category.gy() + b.o;
        this.o = o;
    }
    
    @Override
    public void render() {
        GL11.glPushMatrix();
        GL11.glScaled(0.5, 0.5, 0.5);
        Minecraft.getMinecraft().fontRendererObj.drawString(this.desc.getDesc(), (float)((this.p.category.gx() + 4) * 2), (float)((this.p.category.gy() + this.o + 4) * 2), Color.HSBtoRGB(System.currentTimeMillis() % 3750L / 3750.0f, 0.8f, 0.8f), false);
        GL11.glPopMatrix();
    }
    
    @Override
    public void so(final int n) {
        this.o = n;
    }
}
