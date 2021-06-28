//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.fun;

import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleSettings2;
import net.minecraft.client.entity.EntityPlayerSP;

public class Spin extends Module
{
    public static ModuleSettings2 a;
    public static ModuleSettings2 b;
    private float yaw;

    public Spin() {
        super(new char[] { 'S', 'p', 'i', 'n' }, category.fun, 0);
        Spin.a = new ModuleSettings2(new char[] { 'R', 'o', 't', 'a', 't', 'i', 'o', 'n' }, 360.0, 30.0, 360.0, 1.0);
        Spin.b = new ModuleSettings2(new char[] { 'S', 'p', 'e', 'e', 'd' }, 25.0, 1.0, 60.0, 1.0);
        this.registerSetting(Spin.a);
        this.registerSetting(Spin.b);
    }

    @Override
    public void onEnable() {
        this.yaw = Spin.mc.thePlayer.rotationYaw;
    }

    @Override
    public void onDisable() {
        this.yaw = 0.0f;
    }

    @Override
    public void update() {
        final double left = this.yaw + Spin.a.getInput() - Spin.mc.thePlayer.rotationYaw;
        if (left < Spin.b.getInput()) {
            final EntityPlayerSP thePlayer = Spin.mc.thePlayer;
            thePlayer.rotationYaw += (float)left;
            this.disable();
        }
        else {
            final EntityPlayerSP thePlayer2 = Spin.mc.thePlayer;
            thePlayer2.rotationYaw += (float)Spin.b.getInput();
            if (Spin.mc.thePlayer.rotationYaw >= this.yaw + Spin.a.getInput()) {
                this.disable();
            }
        }
    }
}