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
    public static ModuleSettings2 speed;
    public static ModuleSettings2 fov;
    public static ModuleSettings2 distance;
    public static ModuleSettings clickAim;
    public static ModuleSettings weaponOnly;
    public static ModuleSettings aimInvis;
    public static ModuleSettings blatantMode;
    
    public AimAssist() {
        super(new char[] { 'A', 'i', 'm', 'A', 's', 's', 'i', 's', 't' }, category.combat, 0);
        AimAssist.speed = new ModuleSettings2(new char[] { 'S', 'p', 'e', 'e', 'd' }, 45.0, 1.0, 100.0, 1.0);
        AimAssist.fov = new ModuleSettings2(new char[] { 'F', 'O', 'V' }, 90.0, 15.0, 180.0, 1.0);
        AimAssist.distance = new ModuleSettings2(new char[] { 'D', 'i', 's', 't', 'a', 'n', 'c', 'e' }, 4.5, 1.0, 10.0, 0.5);
        AimAssist.clickAim = new ModuleSettings(new char[] { 'C', 'l', 'i', 'c', 'k', 'A', 'i', 'm' }, true);
        AimAssist.weaponOnly = new ModuleSettings(new char[] { 'W', 'e', 'a', 'p', 'o', 'n', ' ', 'O', 'n', 'l', 'y' }, false);
        AimAssist.aimInvis = new ModuleSettings(new char[] { 'A', 'i', 'm', ' ', 'I', 'n', 'v', 'i', 's' }, false);
        AimAssist.blatantMode = new ModuleSettings(new char[] { 'B', 'l', 'a', 't', 'a', 'n', 't', ' ', 'M', 'o', 'd', 'e' }, false);
        this.registerSetting(AimAssist.speed);
        this.registerSetting(AimAssist.fov);
        this.registerSetting(AimAssist.distance);
        this.registerSetting(AimAssist.clickAim);
        this.registerSetting(AimAssist.weaponOnly);
        this.registerSetting(AimAssist.aimInvis);
        this.registerSetting(AimAssist.blatantMode);
    }
    
    @Override
    public void update() {
        if (ModuleHelper.e() && !SelfDestruct.isDestructed) {
            if (AimAssist.weaponOnly.isToggled()) {
                if (AimAssist.mc.thePlayer.getCurrentEquippedItem() == null) {
                    return;
                }
                if (!(AimAssist.mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemSword) && !(AimAssist.mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemAxe)) {
                    return;
                }
            }
            if (AimAssist.clickAim.isToggled() && !ModuleHelper.ic()) {
                return;
            }
            final Entity h = this.j();
            if (!AimAssist.blatantMode.isToggled()) {
                if (h != null && (ModuleHelper.n(h) > 1.0 || ModuleHelper.n(h) < -1.0)) {
                    final boolean i = ModuleHelper.n(h) > 0.0;
                    final EntityPlayerSP thePlayer = AimAssist.mc.thePlayer;
                    thePlayer.rotationYaw += (float)(i ? (-(Math.abs(ModuleHelper.n(h)) / (101.0 - AimAssist.speed.getInput()))) : (Math.abs(ModuleHelper.n(h)) / (101.0 - AimAssist.speed.getInput())));
                }
            }
            else {
                ModuleHelper.r(h, false);
            }
        }
    }
    
    public Entity j() {
        Entity k = null;
        int f = (int) AimAssist.fov.getInput();
        for (final Entity ent : AimAssist.mc.theWorld.loadedEntityList) {
            if (ent.isEntityAlive() && ent != AimAssist.mc.thePlayer && AimAssist.mc.thePlayer.getDistanceToEntity(ent) <= AimAssist.distance.getInput() && ent instanceof EntityLivingBase) {
                if (Ravenb2.c.getModuleManager().getModule(AntiBot.class).isEnabled() && AntiBot.invalid.contains(ent)) {
                    return null;
                }
                if (!AimAssist.blatantMode.isToggled() && !o(ent, (float)f)) {
                    return null;
                }
                if (!AimAssist.aimInvis.isToggled() && ent.isInvisible()) {
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
