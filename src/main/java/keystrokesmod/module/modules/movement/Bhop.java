//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.movement;

import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleDesc;
import keystrokesmod.module.ModuleHelper;
import keystrokesmod.module.ModuleSettings2;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.MathHelper;

public class Bhop extends Module
{
    public static ModuleSettings2 mode;
    public static ModuleDesc moduleDesc;
    
    public Bhop() {
        super(new char[] { 'B', 'h', 'o', 'p' }, category.movement, 0);
        Bhop.mode = new ModuleSettings2(new char[] { 'M', 'o', 'd', 'e' }, 1.0, 1.0, 3.0, 1.0);
        Bhop.moduleDesc = new ModuleDesc("Current: Fast");
        this.registerSetting(Bhop.mode);
        this.registerSetting(Bhop.moduleDesc);
    }
    
    @Override
    public void update() {
        if (Bhop.mode.getInput() == 1.0) {
            if (ModuleHelper.im() && Bhop.mc.thePlayer.hurtTime < 5) {
                final float d = ModuleHelper.gd();
                if (Bhop.mc.thePlayer.onGround) {
                    Bhop.mc.thePlayer.motionY = 0.405;
                    final EntityPlayerSP thePlayer = Bhop.mc.thePlayer;
                    thePlayer.motionX -= MathHelper.sin(d) * 0.2f;
                    final EntityPlayerSP thePlayer2 = Bhop.mc.thePlayer;
                    thePlayer2.motionZ += MathHelper.cos(d) * 0.2f;
                }
                else {
                    final double c = ModuleHelper.gs();
                    final double s = (Math.abs(Bhop.mc.thePlayer.rotationYawHead - Bhop.mc.thePlayer.rotationYaw) < 90.0f) ? 1.0064 : 1.001;
                    Bhop.mc.thePlayer.motionX = -Math.sin(d) * s * c;
                    Bhop.mc.thePlayer.motionZ = Math.cos(d) * s * c;
                }
            }
        }
        else if (Bhop.mode.getInput() == 2.0) {
            if (ModuleHelper.im()) {
                ModuleHelper.ss(ModuleHelper.gbms() + 0.005, false);
                if (Bhop.mc.thePlayer.onGround) {
                    Bhop.mc.thePlayer.jump();
                    Bhop.mc.thePlayer.motionY = 0.42;
                }
                else {
                    ModuleHelper.ss((float) ModuleHelper.gs(), false);
                }
            }
            else {
                Bhop.mc.thePlayer.motionX = 0.0;
                Bhop.mc.thePlayer.motionZ = 0.0;
            }
        }
        else if (Bhop.mode.getInput() == 3.0) {
            if (Bhop.mc.thePlayer.onGround && ModuleHelper.im()) {
                Bhop.mc.thePlayer.jump();
            }
            ModuleHelper.ss(ModuleHelper.gbms(), true);
        }
    }
    
    @Override
    public void guiUpdate() {
        if (Bhop.mode.getInput() == 1.0) {
            Bhop.moduleDesc.setDesc("Current: Fast");
        }
        else if (Bhop.mode.getInput() == 2.0) {
            Bhop.moduleDesc.setDesc("Current: " + new String(new char[] { 'M', 'i', 'n', 'e', 'p', 'l', 'e', 'x' }));
        }
        else if (Bhop.mode.getInput() == 3.0) {
            Bhop.moduleDesc.setDesc("Current: " + new String(new char[] { 'N', 'C', 'P', ' ', '&', ' ', 'V', 'i', 'p', 'e', 'r' }));
        }
    }
}
