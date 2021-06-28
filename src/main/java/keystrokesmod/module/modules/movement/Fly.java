//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.movement;

import keystrokesmod.module.modules.client.SelfDestruct;
import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleDesc;
import keystrokesmod.module.ModuleHelper;
import keystrokesmod.module.ModuleSettings2;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.Timer;

public class Fly extends Module
{
    public static ModuleSettings2 a;
    public static ModuleDesc b;
    private float f;
    private int i;
    private boolean g;
    private String aw;
    
    public Fly() {
        super(new char[] { 'F', 'l', 'y' }, category.movement, 0);
        this.aw = new String(new char[] { 'A', 'i', 'r', 'W', 'a', 'l', 'k' });
        Fly.a = new ModuleSettings2(new char[] { 'M', 'o', 'd', 'e' }, 1.0, 1.0, 4.0, 1.0);
        Fly.b = new ModuleDesc(ModuleHelper.c + "New " + this.aw);
        this.registerSetting(Fly.a);
        this.registerSetting(Fly.b);
    }
    
    @Override
    public void onEnable() {
        this.f = Fly.mc.thePlayer.stepHeight;
    }
    
    @Override
    public void onDisable() {
        ModuleHelper.rt();
        Fly.mc.thePlayer.stepHeight = this.f;
        if (Fly.mc.thePlayer.capabilities.isFlying) {
            Fly.mc.thePlayer.capabilities.isFlying = false;
        }
    }
    
    @Override
    public void update() {
        if (!ModuleHelper.e() || SelfDestruct.isDestructed) {
            return;
        }
        if (Fly.a.getInput() != 4.0 && Fly.mc.thePlayer.capabilities.isFlying) {
            Fly.mc.thePlayer.capabilities.isFlying = false;
        }
        if (Fly.a.getInput() == 1.0) {
            Fly.mc.thePlayer.motionY = 0.0;
            Fly.mc.thePlayer.onGround = true;
            for (int i = 0; i < 3; ++i) {
                Fly.mc.thePlayer.setPosition(Fly.mc.thePlayer.posX, Fly.mc.thePlayer.posY + 3.0E-12, Fly.mc.thePlayer.posZ);
                if (Fly.mc.thePlayer.ticksExisted % 3 == 0) {
                    Fly.mc.thePlayer.setPosition(Fly.mc.thePlayer.posX, Fly.mc.thePlayer.posY - 3.0E-12, Fly.mc.thePlayer.posZ);
                }
            }
        }
        else if (Fly.a.getInput() == 2.0) {
            if (Fly.mc.gameSettings.keyBindForward.isKeyDown()) {
                Fly.mc.thePlayer.stepHeight = 0.0f;
                ++this.i;
                if (this.i == 2) {
                    Fly.mc.thePlayer.setPosition(Fly.mc.thePlayer.posX, Fly.mc.thePlayer.posY + 1.0E-10, Fly.mc.thePlayer.posZ);
                    this.i = 0;
                }
                Fly.mc.thePlayer.motionY = 0.0;
                Fly.mc.thePlayer.onGround = true;
            }
            if (Fly.mc.gameSettings.keyBindJump.isPressed()) {
                Fly.mc.thePlayer.setPosition(Fly.mc.thePlayer.posX, Fly.mc.thePlayer.posY + 0.4, Fly.mc.thePlayer.posZ);
            }
        }
        else if (Fly.a.getInput() == 3.0) {
            if (ModuleHelper.gt().timerSpeed >= 2.0f) {
                ModuleHelper.rt();
            }
            Fly.mc.thePlayer.motionY = 0.0;
            Fly.mc.thePlayer.setPosition(Fly.mc.thePlayer.posX, Fly.mc.thePlayer.posY + 0.005, Fly.mc.thePlayer.posZ);
            Fly.mc.thePlayer.setPosition(Fly.mc.thePlayer.posX, Fly.mc.thePlayer.posY - 0.005, Fly.mc.thePlayer.posZ);
            if (Fly.mc.thePlayer.ticksExisted % 3 == 0) {
                Fly.mc.thePlayer.setPosition(Fly.mc.thePlayer.posX, Fly.mc.thePlayer.posY + 0.001, Fly.mc.thePlayer.posZ);
                Fly.mc.thePlayer.setPosition(Fly.mc.thePlayer.posX, Fly.mc.thePlayer.posY + 1.0E-9, Fly.mc.thePlayer.posZ);
            }
            if (Fly.mc.thePlayer.ticksExisted % 5 == 0) {
                if (ModuleHelper.im()) {
                    final Timer gt = ModuleHelper.gt();
                    gt.timerSpeed += 0.05f;
                }
                else {
                    ModuleHelper.rt();
                }
            }
            Fly.mc.thePlayer.onGround = true;
        }
        else if (Fly.a.getInput() == 4.0) {
            Fly.mc.thePlayer.capabilities.isFlying = true;
            if (Fly.mc.gameSettings.keyBindJump.isPressed()) {
                final EntityPlayerSP thePlayer = Fly.mc.thePlayer;
                thePlayer.motionY += 0.2;
            }
            if (Fly.mc.gameSettings.keyBindSneak.isPressed()) {
                final EntityPlayerSP thePlayer2 = Fly.mc.thePlayer;
                thePlayer2.motionY -= 0.2;
            }
            if (Fly.mc.gameSettings.keyBindForward.isPressed()) {
                Fly.mc.thePlayer.capabilities.setFlySpeed(0.1f);
            }
        }
    }
    
    @SubscribeEvent
    public void onTick(final TickEvent.ClientTickEvent e) {
        if (e.phase.equals((Object)TickEvent.Phase.END) && Fly.a.getInput() == 1.0 && Fly.mc.gameSettings.keyBindJump.isPressed()) {
            Fly.mc.thePlayer.jump();
            Fly.mc.thePlayer.motionY = 0.41999998688697815;
            Fly.mc.thePlayer.onGround = true;
        }
    }
    
    @Override
    public void guiUpdate() {
        if (Fly.a.getInput() == 1.0) {
            Fly.b.setDesc(ModuleHelper.c + "New " + this.aw);
        }
        else if (Fly.a.getInput() == 2.0) {
            Fly.b.setDesc(ModuleHelper.c + "Old " + this.aw);
        }
        else if (Fly.a.getInput() == 3.0) {
            Fly.b.setDesc(ModuleHelper.c + "Timer " + this.aw);
        }
        else if (Fly.a.getInput() == 4.0) {
            Fly.b.setDesc(ModuleHelper.c + "No AC");
        }
    }
}
