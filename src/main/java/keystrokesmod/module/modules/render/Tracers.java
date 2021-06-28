//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.render;

import keystrokesmod.render.RenderUtils;
import keystrokesmod.module.modules.client.SelfDestruct;
import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleHelper;
import keystrokesmod.module.ModuleSettings;
import keystrokesmod.module.ModuleSettings2;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import java.awt.Color;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class Tracers extends Module
{
    public static ModuleSettings invisible;
    public static ModuleSettings2 red;
    public static ModuleSettings2 green;
    public static ModuleSettings2 blue;
    public static ModuleSettings rainbow;
    public static ModuleSettings2 lineWidth;
    private boolean g;
    
    public Tracers() {
        super(new char[] { 'T', 'r', 'a', 'c', 'e', 'r', 's' }, category.render, 0);
        this.registerSetting(Tracers.invisible = new ModuleSettings(new char[] { 'I', 'n', 'v', 'i', 's', 'i', 'b', 'l', 'e' }, true));
        this.registerSetting(Tracers.lineWidth = new ModuleSettings2(new char[] { 'L', 'i', 'n', 'e', ' ', 'W', 'i', 'd', 't', 'h' }, 1.0, 1.0, 5.0, 1.0));
        this.registerSetting(Tracers.red = new ModuleSettings2(new char[] { 'R', 'e', 'd' }, 0.0, 0.0, 255.0, 1.0));
        this.registerSetting(Tracers.green = new ModuleSettings2(new char[] { 'G', 'r', 'e', 'e', 'n' }, 255.0, 0.0, 255.0, 1.0));
        this.registerSetting(Tracers.blue = new ModuleSettings2(new char[] { 'B', 'l', 'u', 'e' }, 0.0, 0.0, 255.0, 1.0));
        this.registerSetting(Tracers.rainbow = new ModuleSettings(new char[] { 'R', 'a', 'i', 'n', 'b', 'o', 'w' }, false));
    }
    
    @Override
    public void onEnable() {
        this.g = Tracers.mc.gameSettings.viewBobbing;
        if (this.g) {
            Tracers.mc.gameSettings.viewBobbing = false;
        }
    }
    
    @Override
    public void update() {
        if (Tracers.mc.gameSettings.viewBobbing) {
            Tracers.mc.gameSettings.viewBobbing = false;
        }
    }
    
    @Override
    public void onDisable() {
        Tracers.mc.gameSettings.viewBobbing = this.g;
    }
    
    @SubscribeEvent
    public void o(final RenderWorldLastEvent ev) {
        if (!ModuleHelper.e() || SelfDestruct.isDestructed) {
            return;
        }
        for (final EntityPlayer en : Tracers.mc.theWorld.playerEntities) {
            if (en != Tracers.mc.thePlayer && !en.getDisplayName().getUnformattedText().startsWith(ModuleHelper.r("&8[NPC]"))) {
                if (!Tracers.invisible.isToggled() && en.isInvisible()) {
                    return;
                }
                int rgb = 0;
                if (!Tracers.rainbow.isToggled()) {
                    rgb = new Color((int) Tracers.red.getInput(), (int) Tracers.green.getInput(), (int) Tracers.blue.getInput()).getRGB();
                }
                else {
                    float hue = (float)((System.currentTimeMillis() - 15L) % 6000L);
                    hue /= 6000.0f;
                    rgb = Color.getHSBColor(hue, 1.0f, 1.0f).getRGB();
                }
                RenderUtils.dtl((Entity)en, rgb, (float) Tracers.lineWidth.getInput());
            }
        }
    }
}
