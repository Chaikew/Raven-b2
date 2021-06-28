package keystrokesmod.module.modules.fun;

import keystrokesmod.module.Module;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.Vec3;

public class BarrierTrail extends Module
{
    public BarrierTrail() {
        super(new char[] { 'B', 'a', 'r', 'r', 'i', 'e', 'r', ' ', 'T', 'r', 'a', 'i', 'l' }, category.fun, 0);
    }

    @Override
    public void update() {
        final Vec3 vec = BarrierTrail.mc.thePlayer.getLookVec();
        final double x = BarrierTrail.mc.thePlayer.posX - vec.xCoord * 2.0;
        final double y = BarrierTrail.mc.thePlayer.posY + (BarrierTrail.mc.thePlayer.getEyeHeight() - 0.25);
        final double z = BarrierTrail.mc.thePlayer.posZ - vec.zCoord * 2.0;
        BarrierTrail.mc.thePlayer.worldObj.spawnParticle(EnumParticleTypes.BARRIER, x, y, z, 0.0, 0.0, 0.0, new int[] { 0 });
    }
}