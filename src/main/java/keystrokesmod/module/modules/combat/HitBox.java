//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.combat;

import keystrokesmod.module.modules.client.SelfDestruct;
import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleHelper;
import keystrokesmod.module.ModuleSettings2;
import net.minecraft.util.AxisAlignedBB;
import java.util.List;
import net.minecraft.util.Vec3;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.entity.Entity;

public class HitBox extends Module
{
    public static ModuleSettings2 multiplier;
    private Entity pointedEntity;
    private MovingObjectPosition moving;
    
    public HitBox() {
        super(new char[] { 'H', 'i', 't', 'B', 'o', 'x' }, category.combat, 0);
        this.registerSetting(HitBox.multiplier = new ModuleSettings2(new char[] { 'M', 'u', 'l', 't', 'i', 'p', 'l', 'i', 'e', 'r' }, 1.2000000476837158, 1.0, 10.0, 0.10000000149011612));
    }
    
    @SubscribeEvent
    public void m(final MouseEvent e) {
        if (ModuleHelper.e() && !SelfDestruct.isDestructed && e.button == 0 && e.buttonstate && this.moving != null) {
            HitBox.mc.objectMouseOver = this.moving;
        }
    }
    
    @SubscribeEvent
    public void onTick(final TickEvent.ClientTickEvent e) {
        this.getMouseOver(1.0f);
    }
    
    private void getMouseOver(final float partialTicks) {
        if (HitBox.mc.getRenderViewEntity() != null && HitBox.mc.theWorld != null) {
            HitBox.mc.pointedEntity = null;
            final double d0 = 3.0;
            this.moving = HitBox.mc.getRenderViewEntity().rayTrace(d0, partialTicks);
            double d2 = d0;
            final Vec3 vec3 = HitBox.mc.getRenderViewEntity().getPositionEyes(partialTicks);
            if (this.moving != null) {
                d2 = this.moving.hitVec.distanceTo(vec3);
            }
            final Vec3 vec4 = HitBox.mc.getRenderViewEntity().getLook(partialTicks);
            final Vec3 vec5 = vec3.addVector(vec4.xCoord * d0, vec4.yCoord * d0, vec4.zCoord * d0);
            this.pointedEntity = null;
            Vec3 vec6 = null;
            final float f1 = 1.0f;
            final List list = HitBox.mc.theWorld.getEntitiesWithinAABBExcludingEntity(HitBox.mc.getRenderViewEntity(), HitBox.mc.getRenderViewEntity().getEntityBoundingBox().addCoord(vec4.xCoord * d0, vec4.yCoord * d0, vec4.zCoord * d0).expand((double)f1, (double)f1, (double)f1));
            double d3 = d2;
            for (int i = 0; i < list.size(); ++i) {
                final Entity entity = (Entity) list.get(i);
                if (entity.canBeCollidedWith()) {
                    final float f2 = (float)(0.12999999523162842 * HitBox.multiplier.getInput());
                    final AxisAlignedBB axisalignedbb = entity.getEntityBoundingBox().expand((double)f2, (double)f2, (double)f2);
                    final MovingObjectPosition movingobjectposition = axisalignedbb.calculateIntercept(vec3, vec5);
                    if (axisalignedbb.isVecInside(vec3)) {
                        if (0.0 < d3 || d3 == 0.0) {
                            this.pointedEntity = entity;
                            vec6 = ((movingobjectposition == null) ? vec3 : movingobjectposition.hitVec);
                            d3 = 0.0;
                        }
                    }
                    else if (movingobjectposition != null) {
                        final double d4 = vec3.distanceTo(movingobjectposition.hitVec);
                        if (d4 < d3 || d3 == 0.0) {
                            if (entity == HitBox.mc.getRenderViewEntity().ridingEntity && !entity.canRiderInteract()) {
                                if (d3 == 0.0) {
                                    this.pointedEntity = entity;
                                    vec6 = movingobjectposition.hitVec;
                                }
                            }
                            else {
                                this.pointedEntity = entity;
                                vec6 = movingobjectposition.hitVec;
                                d3 = d4;
                            }
                        }
                    }
                }
            }
            if (this.pointedEntity != null && (d3 < d2 || this.moving == null)) {
                this.moving = new MovingObjectPosition(this.pointedEntity, vec6);
                if (this.pointedEntity instanceof EntityLivingBase || this.pointedEntity instanceof EntityItemFrame) {
                    HitBox.mc.pointedEntity = this.pointedEntity;
                }
            }
        }
    }
}
