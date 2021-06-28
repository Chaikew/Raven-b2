//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.disabled;

import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleHelper;
import keystrokesmod.module.ModuleSettings;
import keystrokesmod.module.ModuleSettings2;

public class Speed extends Module
{
    public static ModuleSettings2 speed;
    public static ModuleSettings strafeOnly;
    private boolean c;
    private boolean f;
    private double ps;
    private boolean bb;
    
    public Speed() {
        super(new char[] { 'S', 'p', 'e', 'e', 'd' }, category.movement, 0);
        this.c = false;
        this.f = true;
        this.ps = 0.0;
        this.bb = false;
        Speed.speed = new ModuleSettings2(new char[] { 'S', 'p', 'e', 'e', 'd' }, 1.01, 1.01, 3.0, 0.01);
        Speed.strafeOnly = new ModuleSettings(new char[] { 'S', 't', 'r', 'a', 'f', 'e', ' ', 'O', 'n', 'l', 'y' }, false);
        this.registerSetting(Speed.speed);
        this.registerSetting(Speed.strafeOnly);
    }
    
    @Override
    public void update() {
        if ((!Speed.strafeOnly.isToggled() && !ModuleHelper.im()) || (Speed.strafeOnly.isToggled() && Speed.mc.thePlayer.moveStrafing == 0.0f) || (Speed.mc.thePlayer.hurtTime == Speed.mc.thePlayer.maxHurtTime && Speed.mc.thePlayer.maxHurtTime > 0)) {
            return;
        }
        if (ModuleHelper.im() && !ModuleHelper.sd() && Speed.mc.thePlayer.isSprinting() && Speed.mc.thePlayer.onGround && Speed.mc.currentScreen == null) {
            double spd = this.ps;
            if (this.f) {
                this.f = false;
                spd = ModuleHelper.gs();
            }
            ModuleHelper.ss(spd * Speed.speed.getInput(), true);
            this.ps = spd;
        }
        else {
            this.f = true;
        }
    }
    
    @Override
    public void onDisable() {
        this.f = true;
        this.bb = true;
    }
}
