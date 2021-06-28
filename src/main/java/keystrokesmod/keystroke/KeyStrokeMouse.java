//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.keystroke;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.gui.Gui;
import java.awt.Color;
import org.lwjgl.input.Mouse;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;

public class KeyStrokeMouse
{
    private static String[] mouseButtonsText;
    private Minecraft mc;
    private int currentButton;
    private int d;
    private int e;
    private List<Long> f;
    private boolean g;
    private long h;
    private int i;
    private double j;
    
    public KeyStrokeMouse(final int currentButtonNumber, final int l, final int m) {
        this.mc = Minecraft.getMinecraft();
        this.f = new ArrayList<Long>();
        this.g = true;
        this.h = 0L;
        this.i = 255;
        this.j = 1.0;
        this.currentButton = currentButtonNumber;
        this.d = l;
        this.e = m;
    }
    
    public void n(final int o, final int p, final int color) {
        final boolean r = Mouse.isButtonDown(this.currentButton);
        final String s = KeyStrokeMouse.mouseButtonsText[this.currentButton];
        if (r != this.g) {
            this.g = r;
            this.h = System.currentTimeMillis();
            if (r) {
                this.f.add(this.h);
            }
        }
        if (r) {
            this.i = Math.min(255, (int)(2L * (System.currentTimeMillis() - this.h)));
            this.j = Math.max(0.0, 1.0 - (System.currentTimeMillis() - this.h) / 20.0);
        }
        else {
            this.i = Math.max(0, 255 - (int)(2L * (System.currentTimeMillis() - this.h)));
            this.j = Math.min(1.0, (System.currentTimeMillis() - this.h) / 20.0);
        }
        final int t = color >> 16 & 0xFF;
        final int u = color >> 8 & 0xFF;
        final int v = color & 0xFF;
        final int c = new Color(t, u, v).getRGB();
        Gui.drawRect(o + this.d, p + this.e, o + this.d + 34, p + this.e + 22, 2013265920 + (this.i << 16) + (this.i << 8) + this.i);
        if (KeyStroke.keyStrokeOutline) {
            Gui.drawRect(o + this.d, p + this.e, o + this.d + 34, p + this.e + 1, c);
            Gui.drawRect(o + this.d, p + this.e + 21, o + this.d + 34, p + this.e + 22, c);
            Gui.drawRect(o + this.d, p + this.e, o + this.d + 1, p + this.e + 22, c);
            Gui.drawRect(o + this.d + 33, p + this.e, o + this.d + 34, p + this.e + 22, c);
        }
        this.mc.fontRendererObj.drawString(s, o + this.d + 8, p + this.e + 4, -16777216 + ((int)(t * this.j) << 16) + ((int)(u * this.j) << 8) + (int)(v * this.j));
        final String w = KeyStrokeClickCounter.getLMB_CPS() + " CPS";
        final String x = KeyStrokeClickCounter.getRMB_CPS() + " CPS";
        final int y = this.mc.fontRendererObj.getStringWidth(w);
        final int z = this.mc.fontRendererObj.getStringWidth(x);
        final boolean a2 = this.currentButton == 0;
        final int b2 = a2 ? y : z;
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        this.mc.fontRendererObj.drawString(a2 ? w : x, (o + this.d + 17) * 2 - b2 / 2, (p + this.e + 14) * 2, -16777216 + ((int)(255.0 * this.j) << 16) + ((int)(255.0 * this.j) << 8) + (int)(255.0 * this.j));
        GL11.glScalef(2.0f, 2.0f, 2.0f);
    }
    
    static {
        KeyStrokeMouse.mouseButtonsText = new String[] { "LMB", "RMB" };
    }
}
