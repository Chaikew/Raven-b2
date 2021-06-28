//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.render;

import keystrokesmod.main.Ravenb2;
import keystrokesmod.render.RenderUtils;
import keystrokesmod.module.modules.client.SelfDestruct;
import keystrokesmod.module.*;
import keystrokesmod.module.modules.world.AntiBot;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import java.awt.Color;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class PlayerESP extends Module
{
    public static ModuleSettings2 a;
    public static ModuleSettings2 b;
    public static ModuleSettings2 c;
    public static ModuleSettings d;
    public static ModuleSettings2 e;
    public static ModuleSettings f;
    public static ModuleDesc g;
    public static ModuleSettings h;
    
    public PlayerESP() {
        super(new char[] { 'P', 'l', 'a', 'y', 'e', 'r', 'E', 'S', 'P' }, category.render, 0);
        PlayerESP.f = new ModuleSettings(new char[] { 'I', 'n', 'v', 'i', 's', 'i', 'b', 'l', 'e' }, true);
        PlayerESP.h = new ModuleSettings(new char[] { 'R', 'e', 'd', ' ', 'o', 'n', ' ', 'D', 'a', 'm', 'a', 'g', 'e' }, true);
        PlayerESP.a = new ModuleSettings2(new char[] { 'R', 'e', 'd' }, 0.0, 0.0, 255.0, 1.0);
        PlayerESP.b = new ModuleSettings2(new char[] { 'G', 'r', 'e', 'e', 'n' }, 255.0, 0.0, 255.0, 1.0);
        PlayerESP.c = new ModuleSettings2(new char[] { 'B', 'l', 'u', 'e' }, 0.0, 0.0, 255.0, 1.0);
        PlayerESP.d = new ModuleSettings(new char[] { 'R', 'a', 'i', 'n', 'b', 'o', 'w' }, false);
        PlayerESP.e = new ModuleSettings2(new char[] { 'M', 'o', 'd', 'e' }, 1.0, 1.0, 4.0, 1.0);
        PlayerESP.g = new ModuleDesc(ModuleHelper.c + "BoxShaded");
        this.registerSetting(PlayerESP.a);
        this.registerSetting(PlayerESP.b);
        this.registerSetting(PlayerESP.c);
        this.registerSetting(PlayerESP.d);
        this.registerSetting(PlayerESP.e);
        this.registerSetting(PlayerESP.g);
        this.registerSetting(PlayerESP.f);
        this.registerSetting(PlayerESP.h);
    }
    
    @SubscribeEvent
    public void o(final RenderWorldLastEvent ev) {
        if (!ModuleHelper.e() || SelfDestruct.isDestructed) {
            return;
        }
        for (final EntityPlayer en : PlayerESP.mc.theWorld.playerEntities) {
            if (en != PlayerESP.mc.thePlayer && (!Ravenb2.c.getModuleManager().getModule(AntiBot.class).isEnabled() || !AntiBot.invalid.contains(en))) {
                if (!PlayerESP.f.isToggled() && en.isInvisible()) {
                    return;
                }
                int rgb = 0;
                if (!PlayerESP.d.isToggled()) {
                    rgb = new Color((int) PlayerESP.a.getInput(), (int) PlayerESP.b.getInput(), (int) PlayerESP.c.getInput()).getRGB();
                }
                else {
                    float hue = (float)((System.currentTimeMillis() - 15L) % 6000L);
                    hue /= 6000.0f;
                    rgb = Color.getHSBColor(hue, 1.0f, 1.0f).getRGB();
                }
                RenderUtils.ee((Entity)en, rgb, PlayerESP.h.isToggled(), (int) PlayerESP.e.getInput());
            }
        }
    }
    
    @Override
    public void guiUpdate() {
        if (PlayerESP.e.getInput() == 1.0) {
            PlayerESP.g.setDesc(ModuleHelper.c + "Outline Shaded");
        }
        else if (PlayerESP.e.getInput() == 2.0) {
            PlayerESP.g.setDesc(ModuleHelper.c + "Outline");
        }
        else if (PlayerESP.e.getInput() == 3.0) {
            PlayerESP.g.setDesc(ModuleHelper.c + "Shaded");
        }
        else if (PlayerESP.e.getInput() == 4.0) {
            PlayerESP.g.setDesc(ModuleHelper.c + "2D");
        }
    }
}
