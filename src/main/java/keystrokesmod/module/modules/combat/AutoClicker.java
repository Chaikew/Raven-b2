//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.combat;

import java.nio.ByteBuffer;

import keystrokesmod.module.modules.client.SelfDestruct;
import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleHelper;
import keystrokesmod.module.ModuleSettings;
import keystrokesmod.module.ModuleSettings2;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.BlockPos;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;
import net.minecraft.client.gui.inventory.GuiInventory;
import org.lwjgl.input.Mouse;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.client.gui.GuiScreen;
import java.util.Random;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AutoClicker extends Module
{
    public static ModuleSettings2 a;
    public static ModuleSettings2 b;
    public static ModuleSettings2 c;
    public static ModuleSettings d;
    public static ModuleSettings e;
    public static ModuleSettings p;
    public static ModuleSettings q;
    public static ModuleSettings inv;
    private Method gs;
    private static Field f;
    private static Field g;
    private static Field h;
    private long i;
    private long j;
    private long k;
    private long l;
    private double m;
    private boolean n;
    private Random o;
    
    public AutoClicker() {
        super(new char[] { 'A', 'u', 't', 'o', 'C', 'l', 'i', 'c', 'k', 'e', 'r' }, category.combat, 0);
        this.registerSetting(AutoClicker.a = new ModuleSettings2(new char[] { 'M', 'i', 'n', ' ', 'C', 'P', 'S' }, 9.0, 1.0, 20.0, 0.5));
        this.registerSetting(AutoClicker.b = new ModuleSettings2(new char[] { 'M', 'a', 'x', ' ', 'C', 'P', 'S' }, 12.0, 1.0, 20.0, 0.5));
        this.registerSetting(AutoClicker.c = new ModuleSettings2(new char[] { 'J', 'i', 't', 't', 'e', 'r' }, 0.0, 0.0, 3.0, 0.1));
        this.registerSetting(AutoClicker.p = new ModuleSettings(new char[] { 'L', 'e', 'f', 't', ' ', 'C', 'l', 'i', 'c', 'k' }, true));
        this.registerSetting(AutoClicker.q = new ModuleSettings(new char[] { 'R', 'i', 'g', 'h', 't', ' ', 'C', 'l', 'i', 'c', 'k' }, false));
        this.registerSetting(AutoClicker.inv = new ModuleSettings(new char[] { 'I', 'n', 'v', 'e', 'n', 't', 'o', 'r', 'y', ' ', 'F', 'i', 'l', 'l' }, false));
        this.registerSetting(AutoClicker.d = new ModuleSettings(new char[] { 'W', 'e', 'a', 'p', 'o', 'n', ' ', 'O', 'n', 'l', 'y' }, false));
        this.registerSetting(AutoClicker.e = new ModuleSettings(new char[] { 'B', 'r', 'e', 'a', 'k', ' ', 'B', 'l', 'o', 'c', 'k', 's' }, false));
        this.o = new Random();
        try {
            this.gs = GuiScreen.class.getDeclaredMethod("func_73864_a", Integer.TYPE, Integer.TYPE, Integer.TYPE);
        }
        catch (Exception e1) {
            try {
                this.gs = GuiScreen.class.getDeclaredMethod("mouseClicked", Integer.TYPE, Integer.TYPE, Integer.TYPE);
            }
            catch (Exception e2) {
                this.disable();
            }
        }
    }
    
    @SubscribeEvent
    public void k(final TickEvent.RenderTickEvent ev) {
        if (!ModuleHelper.e() || SelfDestruct.isDestructed) {
            return;
        }
        ModuleHelper.b(AutoClicker.a, AutoClicker.b);
        if (AutoClicker.mc.currentScreen == null) {
            Mouse.poll();
            if (Mouse.isButtonDown(0) && AutoClicker.p.isToggled()) {
                if (!AutoClicker.mc.inGameHasFocus) {
                    return;
                }
                this.dc(AutoClicker.mc.gameSettings.keyBindAttack.getKeyCode(), 0);
            }
            else if (Mouse.isButtonDown(1) && AutoClicker.q.isToggled()) {
                if (!AutoClicker.mc.inGameHasFocus) {
                    return;
                }
                this.dc(AutoClicker.mc.gameSettings.keyBindUseItem.getKeyCode(), 1);
            }
            else {
                this.i = 0L;
                this.j = 0L;
            }
        }
        else if (AutoClicker.mc.currentScreen instanceof GuiInventory) {
            if (Mouse.isButtonDown(0) && (Keyboard.isKeyDown(54) || Keyboard.isKeyDown(42))) {
                if (!AutoClicker.inv.isToggled()) {
                    return;
                }
                if (this.i == 0L || this.j == 0L) {
                    this.gd();
                    return;
                }
                if (System.currentTimeMillis() > this.j) {
                    this.gd();
                    this.ci(AutoClicker.mc.currentScreen);
                }
            }
            else {
                this.i = 0L;
                this.j = 0L;
            }
        }
    }
    
    public void dc(final int key, final int mouse) {
        if (AutoClicker.d.isToggled()) {
            if (AutoClicker.mc.thePlayer.getCurrentEquippedItem() == null) {
                return;
            }
            if (!(AutoClicker.mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemSword) && !(AutoClicker.mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemAxe)) {
                return;
            }
        }
        if (AutoClicker.e.isToggled() && AutoClicker.mc.objectMouseOver != null) {
            final BlockPos p = AutoClicker.mc.objectMouseOver.getBlockPos();
            if (p != null) {
                if (AutoClicker.mc.theWorld.getBlockState(p).getBlock() != Blocks.air) {
                    KeyBinding.setKeyBindState(key, true);
                    KeyBinding.onTick(key);
                    return;
                }
                KeyBinding.setKeyBindState(key, false);
            }
        }
        if (AutoClicker.c.getInput() > 0.0) {
            final double a = AutoClicker.c.getInput() * 0.45;
            if (this.o.nextBoolean()) {
                final EntityPlayerSP thePlayer = AutoClicker.mc.thePlayer;
                thePlayer.rotationYaw += (float)(this.o.nextFloat() * a);
            }
            else {
                final EntityPlayerSP thePlayer2 = AutoClicker.mc.thePlayer;
                thePlayer2.rotationYaw -= (float)(this.o.nextFloat() * a);
            }
            if (this.o.nextBoolean()) {
                final EntityPlayerSP thePlayer3 = AutoClicker.mc.thePlayer;
                thePlayer3.rotationPitch += (float)(this.o.nextFloat() * (a * 0.45));
            }
            else {
                final EntityPlayerSP thePlayer4 = AutoClicker.mc.thePlayer;
                thePlayer4.rotationPitch -= (float)(this.o.nextFloat() * (a * 0.45));
            }
        }
        if (this.j > 0L && this.i > 0L) {
            if (System.currentTimeMillis() > this.j) {
                KeyBinding.setKeyBindState(key, true);
                KeyBinding.onTick(key);
                this.c(mouse, true);
                this.gd();
            }
            else if (System.currentTimeMillis() > this.i) {
                KeyBinding.setKeyBindState(key, false);
                this.c(mouse, false);
            }
        }
        else {
            this.gd();
        }
    }
    
    public void gd() {
        final double a = AutoClicker.a.getInput();
        final double b = AutoClicker.b.getInput();
        final double c = a + this.o.nextDouble() * (b - a);
        long d = (int)Math.round(1000.0 / c);
        if (System.currentTimeMillis() > this.k) {
            if (!this.n && this.o.nextInt(100) >= 85) {
                this.n = true;
                this.m = 1.1 + this.o.nextDouble() * 0.15;
            }
            else {
                this.n = false;
            }
            this.k = System.currentTimeMillis() + 500L + this.o.nextInt(1500);
        }
        if (this.n) {
            d *= (long)this.m;
        }
        if (System.currentTimeMillis() > this.l) {
            if (this.o.nextInt(100) >= 80) {
                d += 50L + this.o.nextInt(100);
            }
            this.l = System.currentTimeMillis() + 500L + this.o.nextInt(1500);
        }
        this.j = System.currentTimeMillis() + d;
        this.i = System.currentTimeMillis() + d / 2L - this.o.nextInt(10);
    }
    
    public void c(final int keycode, final boolean state) {
        final MouseEvent m = new MouseEvent();
        AutoClicker.g.setAccessible(true);
        try {
            AutoClicker.g.set(m, keycode);
        }
        catch (IllegalAccessException er) {
            er.printStackTrace();
        }
        AutoClicker.g.setAccessible(false);
        AutoClicker.f.setAccessible(true);
        try {
            AutoClicker.f.set(m, state);
        }
        catch (IllegalAccessException er) {
            er.printStackTrace();
        }
        AutoClicker.f.setAccessible(false);
        MinecraftForge.EVENT_BUS.post((Event)m);
        try {
            AutoClicker.h.setAccessible(true);
            final ByteBuffer buffer = (ByteBuffer) AutoClicker.h.get(null);
            AutoClicker.h.setAccessible(false);
            buffer.put(keycode, (byte)(state ? 1 : 0));
        }
        catch (IllegalAccessException er) {
            er.printStackTrace();
        }
    }
    
    private void ci(final GuiScreen s) {
        final int a = Mouse.getX() * s.width / AutoClicker.mc.displayWidth;
        final int b = s.height - Mouse.getY() * s.height / AutoClicker.mc.displayHeight - 1;
        final int c = 0;
        try {
            this.gs.setAccessible(true);
            this.gs.invoke(s, a, b, c);
            this.gs.setAccessible(false);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    static {
        try {
            AutoClicker.g = MouseEvent.class.getDeclaredField("button");
        }
        catch (NoSuchFieldException er) {
            er.printStackTrace();
        }
        try {
            AutoClicker.f = MouseEvent.class.getDeclaredField("buttonstate");
        }
        catch (NoSuchFieldException er) {
            er.printStackTrace();
        }
        try {
            AutoClicker.h = Mouse.class.getDeclaredField("buttons");
        }
        catch (NoSuchFieldException er) {
            er.printStackTrace();
        }
    }
}
