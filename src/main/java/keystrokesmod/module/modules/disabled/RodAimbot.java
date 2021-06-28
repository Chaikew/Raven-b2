//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.disabled;

import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleHelper;
import keystrokesmod.module.ModuleSettings;
import keystrokesmod.module.ModuleSettings2;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemFishingRod;
import net.minecraftforge.client.event.MouseEvent;
import java.util.TimerTask;
import java.util.Timer;

public class RodAimbot extends Module
{
    public static ModuleSettings2 a;
    public static ModuleSettings2 b;
    public static ModuleSettings c;
    public static ModuleSettings d;
    private Timer timer;
    private TimerTask timerTask;
    
    public RodAimbot() {
        super(new char[] { 'R', 'o', 'd', 'A', 'i', 'm', 'b', 'o', 't' }, category.combat, 0);
        this.registerSetting(RodAimbot.a = new ModuleSettings2(new char[] { 'F', 'O', 'V' }, 90.0, 15.0, 360.0, 1.0));
        this.registerSetting(RodAimbot.b = new ModuleSettings2(new char[] { 'D', 'i', 's', 't', 'a', 'n', 'c', 'e' }, 4.5, 1.0, 10.0, 0.5));
        this.registerSetting(RodAimbot.c = new ModuleSettings(new char[] { 'P', 'a', 'c', 'k', 'e', 't' }, true));
        this.registerSetting(RodAimbot.d = new ModuleSettings(new char[] { 'A', 'i', 'm', ' ', 'I', 'n', 'v', 'i', 's' }, false));
    }
    
    @SubscribeEvent
    public void x(final MouseEvent e) {
        if (e.button == 1 && e.buttonstate && RodAimbot.mc.thePlayer.getCurrentEquippedItem() != null && RodAimbot.mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemFishingRod) {
            final Entity ent = this.j();
            if (ent != null) {
                e.setCanceled(true);
                if (this.timerTask != null) {
                    this.timerTask.cancel();
                }
                this.timer = new Timer();
                this.timerTask = new TimerTask() {
                    int i = 0;
                    
                    @Override
                    public void run() {
                        ++this.i;
                        if (this.i == 10) {
                            ModuleHelper.r(ent, RodAimbot.c.isToggled());
                            Module.mc.playerController.sendUseItem((EntityPlayer) Module.mc.thePlayer, (World) Module.mc.theWorld, Module.mc.thePlayer.getCurrentEquippedItem());
                            RodAimbot.this.timerTask.cancel();
                            RodAimbot.this.timer.cancel();
                        }
                        else {
                            ModuleHelper.r(ent, RodAimbot.c.isToggled());
                        }
                    }
                };
                this.timer.scheduleAtFixedRate(this.timerTask, 0L, 7L);
            }
        }
    }
    
    public Entity j() {
        Entity k = null;
        int f = (int) RodAimbot.a.getInput();
        for (final Object ent : RodAimbot.mc.theWorld.loadedEntityList) {
            final Entity l = (Entity)ent;
            if (l.isEntityAlive() && l != RodAimbot.mc.thePlayer && RodAimbot.mc.thePlayer.getDistanceToEntity(l) <= RodAimbot.b.getInput() && l instanceof EntityLivingBase && o(l, (float)f)) {
                if (!RodAimbot.d.isToggled() && l.isInvisible()) {
                    return null;
                }
                k = l;
                f = (int)n(l);
            }
        }
        return k;
    }
    
    public static float m(final Entity ent) {
        final double x = ent.posX - RodAimbot.mc.thePlayer.posX;
        final double y = ent.posY - RodAimbot.mc.thePlayer.posY;
        final double z = ent.posZ - RodAimbot.mc.thePlayer.posZ;
        double yaw = Math.atan2(x, z) * 57.2957795;
        yaw = -yaw;
        double pitch = Math.asin(y / Math.sqrt(x * x + y * y + z * z)) * 57.2957795;
        pitch = -pitch;
        return (float)yaw;
    }
    
    public static double n(final Entity en) {
        return ((RodAimbot.mc.thePlayer.rotationYaw - m(en)) % 360.0 + 540.0) % 360.0 - 180.0;
    }
    
    public static boolean o(final Entity entity, float b) {
        b *= 0.5;
        final double v = ((RodAimbot.mc.thePlayer.rotationYaw - m(entity)) % 360.0 + 540.0) % 360.0 - 180.0;
        return (v > 0.0 && v < b) || (-b < v && v < 0.0);
    }
}
