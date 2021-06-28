//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.render.modules;

import keystrokesmod.BindKey;
import org.lwjgl.input.Keyboard;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class AutoConfigDescRender extends ModuleDescRender
{
    private boolean h;
    private boolean isBinding;
    private ModuleDescRenderer moduleDescRenderer;
    private int o;
    private int x;
    private int y;
    
    public AutoConfigDescRender(final ModuleDescRenderer moduleDescRenderer, final int o) {
        this.moduleDescRenderer = moduleDescRenderer;
        this.x = moduleDescRenderer.chromaManager.gx() + moduleDescRenderer.chromaManager.gw();
        this.y = moduleDescRenderer.chromaManager.gy() + moduleDescRenderer.o;
        this.o = o;
    }
    
    @Override
    public void so(final int n) {
        this.o = n;
    }
    
    @Override
    public void render() {
        if (this.moduleDescRenderer.mod.g3tN4m3().equalsIgnoreCase(new String(new char[] { 'A', 'u', 't', 'o', 'C', 'o', 'n', 'f', 'i', 'g' }))) {
            GL11.glPushMatrix();
            GL11.glScaled(0.5, 0.5, 0.5);
            Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("Auto-configurate modules.", (float)((this.moduleDescRenderer.chromaManager.gx() + 4) * 2), (float)((this.moduleDescRenderer.chromaManager.gy() + this.o + 3) * 2), Color.HSBtoRGB(System.currentTimeMillis() % 3750L / 3750.0f, 0.8f, 0.8f));
            GL11.glPopMatrix();
            return;
        }
        GL11.glPushMatrix();
        GL11.glScaled(0.5, 0.5, 0.5);
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(this.isBinding ? BindKey.binding : (BindKey.bind + ": " + Keyboard.getKeyName(this.moduleDescRenderer.mod.getKeycode())), (float)((this.moduleDescRenderer.chromaManager.gx() + 4) * 2), (float)((this.moduleDescRenderer.chromaManager.gy() + this.o + 3) * 2), Color.HSBtoRGB(System.currentTimeMillis() % 3750L / 3750.0f, 0.8f, 0.8f));
        GL11.glPopMatrix();
    }
    
    @Override
    public void uu(final int x, final int y) {
        this.h = this.i(x, y);
        this.y = this.moduleDescRenderer.chromaManager.gy() + this.o;
        this.x = this.moduleDescRenderer.chromaManager.gx();
    }
    
    @Override
    public void onCl1ck(final int x, final int y, final int b) {
        if (this.i(x, y) && b == 0 && this.moduleDescRenderer.po) {
            this.isBinding = !this.isBinding;
        }
    }
    
    @Override
    public void ky(final char t, final int keybind) {
        if (this.moduleDescRenderer.mod.g3tN4m3().equalsIgnoreCase(new String(new char[] { 'A', 'u', 't', 'o', 'C', 'o', 'n', 'f', 'i', 'g' }))) {
            return;
        }
        if (this.isBinding) {
            if (keybind == 11) {
                this.moduleDescRenderer.mod.setbind(0);
            }
            else {
                this.moduleDescRenderer.mod.setbind(keybind);
            }
            this.isBinding = false;
        }
    }
    
    public boolean i(final int x, final int y) {
        return x > this.x && x < this.x + this.moduleDescRenderer.chromaManager.gw() && y > this.y - 1 && y < this.y + 12;
    }
    
    @Override
    public int gh() {
        return 16;
    }
}
