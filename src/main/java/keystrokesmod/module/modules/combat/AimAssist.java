//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.combat;

import keystrokesmod.module.modules.world.AntiBot;
import keystrokesmod.main.Ravenb2;
import keystrokesmod.module.modules.client.SelfDestruct;
import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleHelper;
import keystrokesmod.module.ModuleSettings;
import keystrokesmod.module.ModuleSettings2;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;

public class AimAssist extends Module
{
    public static ModuleSettings2 a;
    public static ModuleSettings2 b;
    public static ModuleSettings2 c;
    public static ModuleSettings d;
    public static ModuleSettings e;
    public static ModuleSettings f;
    public static ModuleSettings g;
    
    public AimAssist() {
        super(new char[] { 'A', 'i', 'm', 'A', 's', 's', 'i', 's', 't' }, category.combat, 0);
        AimAssist.a = new ModuleSettings2(new char[] { 'S', 'p', 'e', 'e', 'd' }, 45.0, 1.0, 100.0, 1.0);
        AimAssist.b = new ModuleSettings2(new char[] { 'F', 'O', 'V' }, 90.0, 15.0, 180.0, 1.0);
        AimAssist.c = new ModuleSettings2(new char[] { 'D', 'i', 's', 't', 'a', 'n', 'c', 'e' }, 4.5, 1.0, 10.0, 0.5);
        AimAssist.d = new ModuleSettings(new char[] { 'C', 'l', 'i', 'c', 'k', 'A', 'i', 'm' }, true);
        AimAssist.e = new ModuleSettings(new char[] { 'W', 'e', 'a', 'p', 'o', 'n', ' ', 'O', 'n', 'l', 'y' }, false);
        AimAssist.f = new ModuleSettings(new char[] { 'A', 'i', 'm', ' ', 'I', 'n', 'v', 'i', 's' }, false);
        AimAssist.g = new ModuleSettings(new char[] { 'B', 'l', 'a', 't', 'a', 'n', 't', ' ', 'M', 'o', 'd', 'e' }, false);
        this.registerSetting(AimAssist.a);
        this.registerSetting(AimAssist.b);
        this.registerSetting(AimAssist.c);
        this.registerSetting(AimAssist.d);
        this.registerSetting(AimAssist.e);
        this.registerSetting(AimAssist.f);
        this.registerSetting(AimAssist.g);
    }
    
    @Override
    public void update() {
        if (ModuleHelper.e() && !SelfDestruct.isDestructed) {
            if (AimAssist.e.isToggled()) {
                if (AimAssist.mc.thePlayer.getCurrentEquippedItem() == null) {
                    return;
                }
                if (!(AimAssist.mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemSword) && !(AimAssist.mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemAxe)) {
                    return;
                }
            }
            if (AimAssist.d.isToggled() && !ModuleHelper.ic()) {
                return;
            }
            final Entity h = this.j();
            if (!AimAssist.g.isToggled()) {
                if (h != null && (ModuleHelper.n(h) > 1.0 || ModuleHelper.n(h) < -1.0)) {
                    final boolean i = ModuleHelper.n(h) > 0.0;
                    final EntityPlayerSP thePlayer = AimAssist.mc.thePlayer;
                    thePlayer.rotationYaw += (float)(i ? (-(Math.abs(ModuleHelper.n(h)) / (101.0 - AimAssist.a.getInput()))) : (Math.abs(ModuleHelper.n(h)) / (101.0 - AimAssist.a.getInput())));
                }
            }
            else {
                ModuleHelper.r(h, false);
            }
        }
    }
    
    public Entity j() {
        Entity k = null;
        int f = (int) AimAssist.b.getInput();
        for (final Entity ent : AimAssist.mc.theWorld.loadedEntityList) {
            if (ent.isEntityAlive() && ent != AimAssist.mc.thePlayer && AimAssist.mc.thePlayer.getDistanceToEntity(ent) <= AimAssist.c.getInput() && ent instanceof EntityLivingBase) {
                if (Ravenb2.c.getModuleManager().getModule(AntiBot.class).isEnabled() && AntiBot.invalid.contains(ent)) {
                    return null;
                }
                if (!AimAssist.g.isToggled() && !o(ent, (float)f)) {
                    return null;
                }
                if (!AimAssist.f.isToggled() && ent.isInvisible()) {
                    return null;
                }
                k = ent;
                f = (int) ModuleHelper.n(ent);
            }
        }
        return k;
    }
    
    public static boolean o(final Entity entity, float b) {
        b *= 0.5;
        final double v = ((AimAssist.mc.thePlayer.rotationYaw - ModuleHelper.m(entity)) % 360.0 + 540.0) % 360.0 - 180.0;
        return (v > 0.0 && v < b) || (-b < v && v < 0.0);
    }
}
