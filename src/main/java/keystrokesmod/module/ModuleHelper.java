//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module;

import keystrokesmod.module.modules.combat.AutoClicker;
import keystrokesmod.keystroke.KeyStrokeClickCounter;
import keystrokesmod.main.Ravenb2;
import org.lwjgl.input.Mouse;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.entity.Entity;
import java.lang.reflect.Field;
import net.minecraft.util.Timer;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ChatComponentText;
import java.util.Random;
import net.minecraft.client.Minecraft;

public class ModuleHelper
{
    private static Minecraft mc;
    private static Random random;
    public static String c;
    public static String hp;
    public static String mp;
    public static String il;
    public static String mmc;
    public static String ff;
    public static String pp;
    public static String sy;
    public static String vp;
    
    public static void sm(final String txt) {
        final String m = r(txt);
        if (e()) {
            Minecraft.getMinecraft().thePlayer.addChatMessage((IChatComponent)new ChatComponentText(m));
        }
    }
    
    public static String r(final String txt) {
        return txt.replaceAll("&", "§");
    }
    
    public static void b(final ModuleSettings2 c, final ModuleSettings2 d) {
        if (c.getInput() > d.getInput()) {
            final double p = c.getInput();
            c.setValue(d.getInput());
            d.setValue(p);
        }
    }
    
    public static boolean e() {
        return ModuleHelper.mc.thePlayer != null && ModuleHelper.mc.theWorld != null;
    }
    
    public static boolean hs(final String s) {
        if (ModuleHelper.mc.isSingleplayer()) {
            return false;
        }
        final String ip = s.equals("n") ? ModuleHelper.mc.getCurrentServerData().serverIP : s;
        return ip.contains(ModuleHelper.hp) || ip.contains(new String(new char[] { '2', '0', '9', '.', '2', '2', '2', '.', '1', '1', '5' }));
    }
    
    public static int f() {
        return ModuleHelper.mc.getNetHandler().getPlayerInfo(ModuleHelper.mc.thePlayer.getUniqueID()).getResponseTime();
    }
    
    public static Timer gt() {
        try {
            final Class<Minecraft> c = Minecraft.class;
            final Field f = c.getDeclaredField(new String(new char[] { 't', 'i', 'm', 'e', 'r' }));
            f.setAccessible(true);
            return (Timer)f.get(ModuleHelper.mc);
        }
        catch (Exception er) {
            try {
                final Class<Minecraft> c2 = Minecraft.class;
                final Field f2 = c2.getDeclaredField(new String(new char[] { 'f', 'i', 'e', 'l', 'd', '_', '7', '1', '4', '2', '8', '_', 'T' }));
                f2.setAccessible(true);
                return (Timer)f2.get(ModuleHelper.mc);
            }
            catch (Exception er2) {
                return null;
            }
        }
    }
    
    public static void rt() {
        gt().timerSpeed = 1.0f;
    }
    
    public static Random rd() {
        return ModuleHelper.random;
    }
    
    public static boolean im() {
        return ModuleHelper.mc.thePlayer.moveForward != 0.0f || ModuleHelper.mc.thePlayer.moveStrafing != 0.0f;
    }
    
    public static boolean sd() {
        return ModuleHelper.mc.thePlayer.isEating() || ModuleHelper.mc.thePlayer.isBlocking() || ModuleHelper.mc.thePlayer.isSneaking();
    }
    
    public static void r(final Entity s, final boolean packet) {
        if (s != null) {
            final float[] t = p(s);
            if (t != null) {
                final float y = t[0];
                final float p = t[1] + 4.0f;
                if (!packet) {
                    ModuleHelper.mc.thePlayer.rotationYaw = y;
                    ModuleHelper.mc.thePlayer.rotationPitch = p;
                }
                else {
                    ModuleHelper.mc.getNetHandler().addToSendQueue((Packet)new C03PacketPlayer.C05PacketPlayerLook(y, p, ModuleHelper.mc.thePlayer.onGround));
                }
            }
        }
    }
    
    public static float[] p(final Entity q) {
        if (q == null) {
            return null;
        }
        final double diffX = q.posX - ModuleHelper.mc.thePlayer.posX;
        double diffY;
        if (q instanceof EntityLivingBase) {
            final EntityLivingBase EntityLivingBase = (EntityLivingBase)q;
            diffY = EntityLivingBase.posY + EntityLivingBase.getEyeHeight() * 0.9 - (ModuleHelper.mc.thePlayer.posY + ModuleHelper.mc.thePlayer.getEyeHeight());
        }
        else {
            diffY = (q.getEntityBoundingBox().minY + q.getEntityBoundingBox().maxY) / 2.0 - (ModuleHelper.mc.thePlayer.posY + ModuleHelper.mc.thePlayer.getEyeHeight());
        }
        final double diffZ = q.posZ - ModuleHelper.mc.thePlayer.posZ;
        final double dist = MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ);
        final float yaw = (float)(Math.atan2(diffZ, diffX) * 180.0 / 3.141592653589793) - 90.0f;
        final float pitch = (float)(-(Math.atan2(diffY, dist) * 180.0 / 3.141592653589793));
        return new float[] { ModuleHelper.mc.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float(yaw - ModuleHelper.mc.thePlayer.rotationYaw), ModuleHelper.mc.thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float(pitch - ModuleHelper.mc.thePlayer.rotationPitch) };
    }
    
    public static double n(final Entity en) {
        return ((ModuleHelper.mc.thePlayer.rotationYaw - m(en)) % 360.0 + 540.0) % 360.0 - 180.0;
    }
    
    public static float m(final Entity ent) {
        final double x = ent.posX - ModuleHelper.mc.thePlayer.posX;
        final double y = ent.posY - ModuleHelper.mc.thePlayer.posY;
        final double z = ent.posZ - ModuleHelper.mc.thePlayer.posZ;
        double yaw = Math.atan2(x, z) * 57.2957795;
        yaw = -yaw;
        double pitch = Math.asin(y / Math.sqrt(x * x + y * y + z * z)) * 57.2957795;
        pitch = -pitch;
        return (float)yaw;
    }
    
    public static void ss(final double s, final boolean m) {
        if (m && !im()) {
            return;
        }
        ModuleHelper.mc.thePlayer.motionX = -Math.sin(gd()) * s;
        ModuleHelper.mc.thePlayer.motionZ = Math.cos(gd()) * s;
    }
    
    public static float gd() {
        float yw = ModuleHelper.mc.thePlayer.rotationYaw;
        if (ModuleHelper.mc.thePlayer.moveForward < 0.0f) {
            yw += 180.0f;
        }
        float f = 1.0f;
        if (ModuleHelper.mc.thePlayer.moveForward < 0.0f) {
            f = -0.5f;
        }
        else if (ModuleHelper.mc.thePlayer.moveForward > 0.0f) {
            f = 0.5f;
        }
        else {
            f = 1.0f;
        }
        if (ModuleHelper.mc.thePlayer.moveStrafing > 0.0f) {
            yw -= 90.0f * f;
        }
        if (ModuleHelper.mc.thePlayer.moveStrafing < 0.0f) {
            yw += 90.0f * f;
        }
        yw *= 0.017453292f;
        return yw;
    }
    
    public static double gs() {
        return Math.sqrt(ModuleHelper.mc.thePlayer.motionX * ModuleHelper.mc.thePlayer.motionX + ModuleHelper.mc.thePlayer.motionZ * ModuleHelper.mc.thePlayer.motionZ);
    }
    
    public static double gbms() {
        double b = 0.2873;
        if (ModuleHelper.mc.thePlayer.isPotionActive(Potion.moveSpeed)) {
            final int a = ModuleHelper.mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier();
            b *= 1.0 + 0.2 * (a + 1);
        }
        return b;
    }
    
    public static boolean ic() {
        boolean ic = false;
        final int c = KeyStrokeClickCounter.getLMB_CPS();
        final boolean ac = Ravenb2.c.getModuleManager().getModule(AutoClicker.class).isEnabled();
        if (ac && Mouse.isButtonDown(0)) {
            ic = true;
        }
        if (c > 3 && !ac) {
            ic = true;
        }
        return ic;
    }
    
    static {
        ModuleHelper.mc = Minecraft.getMinecraft();
        ModuleHelper.random = new Random();
        ModuleHelper.c = new String(new char[] { 'C', 'u', 'r', 'r', 'e', 'n', 't', ':', ' ' });
        ModuleHelper.hp = new String(new char[] { 'h', 'y', 'p', 'i', 'x', 'e', 'l', '.', 'n', 'e', 't' });
        ModuleHelper.mp = new String(new char[] { 'm', 'i', 'n', 'e', 'p', 'l', 'e', 'x', '.', 'n', 'e', 't' });
        ModuleHelper.il = new String(new char[] { 'i', 'n', 'v', 'a', 'd', 'e', 'd', 'l', 'a', 'n', 'd', 's', '.', 'n', 'e', 't' });
        ModuleHelper.mmc = new String(new char[] { 'm', 'i', 'n', 'e', 'm', 'e', 'n', '.', 'c', 'l', 'u', 'b' });
        ModuleHelper.ff = new String(new char[] { 'f', 'a', 'i', 't', 'h', 'f', 'u', 'l', 'm', 'c', '.', 'c', 'o', 'm' });
        ModuleHelper.pp = new String(new char[] { 'p', 'v', 'p', 't', 'e', 'm', 'p', 'l', 'e', '.', 'c', 'o', 'm' });
        ModuleHelper.sy = new String(new char[] { 's', 'y', 'u', 'u', '.', 'n', 'e', 't' });
        ModuleHelper.vp = new String(new char[] { 'v', 'e', 'l', 't', 'p', 'v', 'p', '.', 'c', 'o', 'm' });
    }
}
