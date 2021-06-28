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
    public static ModuleSettings2 red;
    public static ModuleSettings2 green;
    public static ModuleSettings2 blue;
    public static ModuleSettings rainbow;
    public static ModuleSettings2 mode;
    public static ModuleSettings invisible;
    public static ModuleDesc moduleDesc;
    public static ModuleSettings redOnDalage;
    
    public PlayerESP() {
        super(new char[] { 'P', 'l', 'a', 'y', 'e', 'r', 'E', 'S', 'P' }, category.render, 0);
        PlayerESP.invisible = new ModuleSettings(new char[] { 'I', 'n', 'v', 'i', 's', 'i', 'b', 'l', 'e' }, true);
        PlayerESP.redOnDalage = new ModuleSettings(new char[] { 'R', 'e', 'd', ' ', 'o', 'n', ' ', 'D', 'a', 'm', 'a', 'g', 'e' }, true);
        PlayerESP.red = new ModuleSettings2(new char[] { 'R', 'e', 'd' }, 0.0, 0.0, 255.0, 1.0);
        PlayerESP.green = new ModuleSettings2(new char[] { 'G', 'r', 'e', 'e', 'n' }, 255.0, 0.0, 255.0, 1.0);
        PlayerESP.blue = new ModuleSettings2(new char[] { 'B', 'l', 'u', 'e' }, 0.0, 0.0, 255.0, 1.0);
        PlayerESP.rainbow = new ModuleSettings(new char[] { 'R', 'a', 'i', 'n', 'b', 'o', 'w' }, false);
        PlayerESP.mode = new ModuleSettings2(new char[] { 'M', 'o', 'd', 'e' }, 1.0, 1.0, 4.0, 1.0);
        PlayerESP.moduleDesc = new ModuleDesc(ModuleHelper.c + "BoxShaded");
        this.registerSetting(PlayerESP.red);
        this.registerSetting(PlayerESP.green);
        this.registerSetting(PlayerESP.blue);
        this.registerSetting(PlayerESP.rainbow);
        this.registerSetting(PlayerESP.mode);
        this.registerSetting(PlayerESP.moduleDesc);
        this.registerSetting(PlayerESP.invisible);
        this.registerSetting(PlayerESP.redOnDalage);
    }
    
    @SubscribeEvent
    public void o(final RenderWorldLastEvent ev) {
        if (!ModuleHelper.e() || SelfDestruct.isDestructed) {
            return;
        }
        for (final EntityPlayer en : PlayerESP.mc.theWorld.playerEntities) {
            if (en != PlayerESP.mc.thePlayer && (!Ravenb2.c.getModuleManager().getModule(AntiBot.class).isEnabled() || !AntiBot.invalid.contains(en))) {
                if (!PlayerESP.invisible.isToggled() && en.isInvisible()) {
                    return;
                }
                int rgb = 0;
                if (!PlayerESP.rainbow.isToggled()) {
                    rgb = new Color((int) PlayerESP.red.getInput(), (int) PlayerESP.green.getInput(), (int) PlayerESP.blue.getInput()).getRGB();
                }
                else {
                    float hue = (float)((System.currentTimeMillis() - 15L) % 6000L);
                    hue /= 6000.0f;
                    rgb = Color.getHSBColor(hue, 1.0f, 1.0f).getRGB();
                }
                RenderUtils.ee((Entity)en, rgb, PlayerESP.redOnDalage.isToggled(), (int) PlayerESP.mode.getInput());
            }
        }
    }
    
    @Override
    public void guiUpdate() {
        if (PlayerESP.mode.getInput() == 1.0) {
            PlayerESP.moduleDesc.setDesc(ModuleHelper.c + "Outline Shaded");
        }
        else if (PlayerESP.mode.getInput() == 2.0) {
            PlayerESP.moduleDesc.setDesc(ModuleHelper.c + "Outline");
        }
        else if (PlayerESP.mode.getInput() == 3.0) {
            PlayerESP.moduleDesc.setDesc(ModuleHelper.c + "Shaded");
        }
        else if (PlayerESP.mode.getInput() == 4.0) {
            PlayerESP.moduleDesc.setDesc(ModuleHelper.c + "2D");
        }
    }
}
