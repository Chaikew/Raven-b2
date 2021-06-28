//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.movement;

import keystrokesmod.main.Ravenb2;
import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleHelper;
import keystrokesmod.module.ModuleSettings2;

public class Boost extends Module
{
    public static ModuleSettings2 multiplier;
    public static ModuleSettings2 time;
    private int i;
    private boolean t;
    
    public Boost() {
        super(new char[] { 'B', 'o', 'o', 's', 't' }, category.movement, 0);
        this.i = 0;
        this.t = false;
        this.registerSetting(Boost.multiplier = new ModuleSettings2(new char[] { 'M', 'u', 'l', 't', 'i', 'p', 'l', 'i', 'e', 'r' }, 2.0, 1.0, 3.0, 0.05));
        this.registerSetting(Boost.time = new ModuleSettings2(new char[] { 'T', 'i', 'm', 'e', ' ', '(', 'T', 'i', 'c', 'k', 's', ')' }, 15.0, 1.0, 50.0, 1.0));
    }
    
    @Override
    public void onEnable() {
        if (Ravenb2.c.getModuleManager().getModule(Timer.class).isEnabled()) {
            this.t = true;
            Ravenb2.c.getModuleManager().getModule(Timer.class).disable();
        }
    }
    
    @Override
    public void onDisable() {
        this.i = 0;
        if (ModuleHelper.gt().timerSpeed != 1.0f) {
            ModuleHelper.rt();
        }
        if (this.t) {
            Ravenb2.c.getModuleManager().getModule(Timer.class).enable();
        }
    }
    
    @Override
    public void update() {
        if (this.i == 0) {
            this.i = Boost.mc.thePlayer.ticksExisted;
        }
        ModuleHelper.gt().timerSpeed = (float) Boost.multiplier.getInput();
        if (this.i == Boost.mc.thePlayer.ticksExisted - Boost.time.getInput()) {
            ModuleHelper.rt();
            this.disable();
        }
    }
}
