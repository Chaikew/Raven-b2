//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.combat;

import keystrokesmod.module.modules.client.SelfDestruct;
import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleHelper;
import keystrokesmod.module.ModuleSettings;
import keystrokesmod.module.ModuleSettings2;
import net.minecraft.util.AxisAlignedBB;
import java.util.List;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;
import net.minecraftforge.client.event.MouseEvent;
import java.util.Random;

public class Reach extends Module
{
    public static ModuleSettings2 minReach;
    public static ModuleSettings2 maxReach;
    public static ModuleSettings weaponOnly;
    public static ModuleSettings movingOnly;
    public static ModuleSettings sprintOnly;
    public static ModuleSettings hitThroughBlocks;
    public Random rand;
    
    public Reach() {
        super(new char[] { 'R', 'e', 'a', 'c', 'h' }, category.combat, 0);
        this.rand = new Random();
        this.registerSetting(Reach.minReach = new ModuleSettings2(new char[] { 'M', 'i', 'n' }, 3.1, 3.0, 6.0, 0.05));
        this.registerSetting(Reach.maxReach = new ModuleSettings2(new char[] { 'M', 'a', 'x' }, 3.3, 3.0, 6.0, 0.05));
        this.registerSetting(Reach.weaponOnly = new ModuleSettings(new char[] { 'W', 'e', 'a', 'p', 'o', 'n', ' ', 'O', 'n', 'l', 'y' }, false));
        this.registerSetting(Reach.movingOnly = new ModuleSettings(new char[] { 'M', 'o', 'v', 'i', 'n', 'g', ' ', 'O', 'n', 'l', 'y' }, false));
        this.registerSetting(Reach.sprintOnly = new ModuleSettings(new char[] { 'S', 'p', 'r', 'i', 'n', 't', ' ', 'O', 'n', 'l', 'y' }, false));
        this.registerSetting(Reach.hitThroughBlocks = new ModuleSettings(new char[] { 'H', 'i', 't', ' ', 'T', 'h', 'r', 'o', 'u', 'g', 'h', ' ', 'B', 'l', 'o', 'c', 'k', 's' }, false));
    }
    
    @SubscribeEvent
    public void onMove(final MouseEvent ev) {
        if (ModuleHelper.e() && !SelfDestruct.isDestructed) {
            if (Reach.weaponOnly.isToggled()) {
                if (Reach.mc.thePlayer.getCurrentEquippedItem() == null) {
                    return;
                }
                if (!(Reach.mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemSword) && !(Reach.mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemAxe)) {
                    return;
                }
            }
            if (Reach.movingOnly.isToggled() && Reach.mc.thePlayer.moveForward == 0.0 && Reach.mc.thePlayer.moveStrafing == 0.0) {
                return;
            }
            if (Reach.sprintOnly.isToggled() && !Reach.mc.thePlayer.isSprinting()) {
                return;
            }
            if (!Reach.hitThroughBlocks.isToggled() && Reach.mc.objectMouseOver != null) {
                final BlockPos zzzzz = Reach.mc.objectMouseOver.getBlockPos();
                if (zzzzz != null && Reach.mc.theWorld.getBlockState(zzzzz).getBlock() != Blocks.air) {
                    return;
                }
            }
            ModuleHelper.b(Reach.minReach, Reach.maxReach);
            final double zzzzzD2 = Reach.minReach.getInput() + this.rand.nextDouble() * (Reach.maxReach.getInput() - Reach.minReach.getInput());
            final Object[] zzzzzN = zzzzz(zzzzzD2, 0.0, 0.0f);
            if (zzzzzN == null) {
                return;
            }
            Reach.mc.objectMouseOver = new MovingObjectPosition((Entity)zzzzzN[0], (Vec3)zzzzzN[1]);
            Reach.mc.pointedEntity = (Entity)zzzzzN[0];
        }
    }
    
    public static Object[] zzzzz(final double zzzzzD, final double zzzzzE, final float zzzzzPT) {
        final Entity zzzzz2 = Reach.mc.getRenderViewEntity();
        Entity entity = null;
        if (zzzzz2 == null || Reach.mc.theWorld == null) {
            return null;
        }
        Reach.mc.mcProfiler.startSection("pick");
        final Vec3 zzzzz3 = zzzzz2.getPositionEyes(0.0f);
        final Vec3 zzzzz4 = zzzzz2.getLook(0.0f);
        final Vec3 zzzzz5 = zzzzz3.addVector(zzzzz4.xCoord * zzzzzD, zzzzz4.yCoord * zzzzzD, zzzzz4.zCoord * zzzzzD);
        Vec3 zzzzz6 = null;
        final float zzzzz7 = 1.0f;
        final List zzzzz8 = Reach.mc.theWorld.getEntitiesWithinAABBExcludingEntity(zzzzz2, zzzzz2.getEntityBoundingBox().addCoord(zzzzz4.xCoord * zzzzzD, zzzzz4.yCoord * zzzzzD, zzzzz4.zCoord * zzzzzD).expand(1.0, 1.0, 1.0));
        double zzzzz9 = zzzzzD;
        for (int zzzzz10 = 0; zzzzz10 < zzzzz8.size(); ++zzzzz10) {
            final Entity zzzzz11 = (Entity) zzzzz8.get(zzzzz10);
            if (zzzzz11.canBeCollidedWith()) {
                final float zzzzz12 = zzzzz11.getCollisionBorderSize();
                AxisAlignedBB zzzzz13 = zzzzz11.getEntityBoundingBox().expand((double)zzzzz12, (double)zzzzz12, (double)zzzzz12);
                zzzzz13 = zzzzz13.expand(zzzzzE, zzzzzE, zzzzzE);
                final MovingObjectPosition zzzzz14 = zzzzz13.calculateIntercept(zzzzz3, zzzzz5);
                if (zzzzz13.isVecInside(zzzzz3)) {
                    if (0.0 < zzzzz9 || zzzzz9 == 0.0) {
                        entity = zzzzz11;
                        zzzzz6 = ((zzzzz14 == null) ? zzzzz3 : zzzzz14.hitVec);
                        zzzzz9 = 0.0;
                    }
                }
                else if (zzzzz14 != null) {
                    final double zzzzz15 = zzzzz3.distanceTo(zzzzz14.hitVec);
                    if (zzzzz15 < zzzzz9 || zzzzz9 == 0.0) {
                        final boolean canRiderInteract = false;
                        if (zzzzz11 == zzzzz2.ridingEntity) {
                            if (zzzzz9 == 0.0) {
                                entity = zzzzz11;
                                zzzzz6 = zzzzz14.hitVec;
                            }
                        }
                        else {
                            entity = zzzzz11;
                            zzzzz6 = zzzzz14.hitVec;
                            zzzzz9 = zzzzz15;
                        }
                    }
                }
            }
        }
        if (zzzzz9 < zzzzzD && !(entity instanceof EntityLivingBase) && !(entity instanceof EntityItemFrame)) {
            entity = null;
        }
        Reach.mc.mcProfiler.endSection();
        if (entity == null || zzzzz6 == null) {
            return null;
        }
        return new Object[] { entity, zzzzz6 };
    }
    
    @Override
    public void guiUpdate() {
        ModuleHelper.b(Reach.minReach, Reach.maxReach);
    }
}
