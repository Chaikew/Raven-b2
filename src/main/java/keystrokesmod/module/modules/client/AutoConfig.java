//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.client;

import keystrokesmod.main.Ravenb2;
import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleHelper;
import keystrokesmod.module.ModuleSettings;
import keystrokesmod.module.modules.combat.AutoClicker;
import keystrokesmod.module.modules.combat.Reach;
import keystrokesmod.module.modules.combat.Velocity;
import net.minecraft.client.gui.GuiScreen;

public class AutoConfig extends Module
{
    public static ModuleSettings a1;
    public static ModuleSettings a2;
    public static ModuleSettings a3;
    public static ModuleSettings a4;
    public static boolean a5;
    public static boolean a6;
    public static int a7;
    
    public AutoConfig() {
        super(new char[] { 'A', 'u', 't', 'o', 'C', 'o', 'n', 'f', 'i', 'g' }, category.client, 0);
        AutoConfig.a1 = new ModuleSettings(new char[] { 'C', 'o', 'n', 's', 'i', 'd', 'e', 'r', ' ', 'P', 'i', 'n', 'g' }, true);
        AutoConfig.a2 = new ModuleSettings(new char[] { 'C', 'o', 'n', 'f', 'i', 'g', 'u', 'r', 'e', ' ', 'R', 'e', 'a', 'c', 'h' }, true);
        AutoConfig.a3 = new ModuleSettings(new char[] { 'C', 'o', 'n', 'f', 'i', 'g', 'u', 'r', 'e', ' ', 'V', 'e', 'l', 'o', 'c', 'i', 't', 'y' }, true);
        AutoConfig.a4 = new ModuleSettings(new char[] { 'C', 'o', 'n', 'f', 'i', 'g', 'u', 'r', 'e', ' ', 'A', 'u', 't', 'o', 'c', 'l', 'i', 'c', 'k', 'e', 'r' }, true);
        this.registerSetting(AutoConfig.a1);
        this.registerSetting(AutoConfig.a2);
        this.registerSetting(AutoConfig.a3);
        this.registerSetting(AutoConfig.a4);
    }
    
    @Override
    public void onEnable() {
        AutoConfig.mc.displayGuiScreen((GuiScreen)null);
        if (AutoConfig.mc.isSingleplayer()) {
            AutoConfig.a6 = true;
        }
        else {
            AutoConfig.a5 = true;
        }
    }
    
    @Override
    public void onDisable() {
        AutoConfig.a7 = 0;
        AutoConfig.a6 = false;
        AutoConfig.a5 = false;
    }
    
    public static void a(final int p, final String s) {
        Ravenb2.c.getModuleManager().getModule(Reach.class).enable();
        final String i = s.toLowerCase();
        if (ModuleHelper.hs(i) || i.contains(ModuleHelper.mp)) {
            if (AutoConfig.a1.isToggled()) {
                if (p >= 200) {
                    Reach.a.setValue(3.5);
                    Reach.b.setValue(3.8);
                }
                if (p >= 170 && p < 200) {
                    Reach.a.setValue(3.5);
                    Reach.b.setValue(3.7);
                }
                if (p >= 120 && p < 170) {
                    Reach.a.setValue(3.4);
                    Reach.b.setValue(3.6);
                }
                if (p >= 100 && p < 120) {
                    Reach.a.setValue(3.3);
                    Reach.b.setValue(3.5);
                }
                if (p >= 40 && p < 100) {
                    Reach.a.setValue(3.2);
                    Reach.b.setValue(3.4);
                }
                if (p >= 0 && p < 40) {
                    Reach.a.setValue(3.2);
                    Reach.b.setValue(3.3);
                }
            }
            else {
                Reach.a.setValue(3.3);
                Reach.b.setValue(3.5);
            }
        }
        else if (i.contains(ModuleHelper.mmc) || i.contains(ModuleHelper.il)) {
            if (AutoConfig.a1.isToggled() && p >= 170) {
                Reach.a.setValue(3.0);
                Reach.b.setValue(3.1);
            }
        }
        else if (i.contains(ModuleHelper.sy)) {
            if (AutoConfig.a1.isToggled()) {
                if (p >= 170) {
                    Reach.a.setValue(3.1);
                    Reach.b.setValue(3.3);
                }
                if (p >= 150 && p < 170) {
                    Reach.a.setValue(3.1);
                    Reach.b.setValue(3.2);
                }
                if (p >= 100 && p < 150) {
                    Reach.a.setValue(3.0);
                    Reach.b.setValue(3.1);
                }
            }
        }
        else if (i.contains(ModuleHelper.ff) || i.contains(ModuleHelper.pp) || i.contains(ModuleHelper.vp)) {
            if (AutoConfig.a1.isToggled()) {
                if (p >= 170) {
                    Reach.a.setValue(3.3);
                    Reach.b.setValue(3.5);
                }
                if (p >= 150 && p < 170) {
                    Reach.a.setValue(3.2);
                    Reach.b.setValue(3.4);
                }
                if (p >= 100 && p < 150) {
                    Reach.a.setValue(3.2);
                    Reach.b.setValue(3.4);
                }
                if (p >= 0 && p < 100) {
                    Reach.a.setValue(3.1);
                    Reach.b.setValue(3.3);
                }
            }
            else {
                Reach.a.setValue(3.1);
                Reach.b.setValue(3.3);
            }
        }
        else if (AutoConfig.a1.isToggled()) {
            if (p >= 170) {
                Reach.a.setValue(3.3);
                Reach.b.setValue(3.5);
            }
            if (p >= 150 && p < 170) {
                Reach.a.setValue(3.3);
                Reach.b.setValue(3.4);
            }
            if (p >= 100 && p < 150) {
                Reach.a.setValue(3.2);
                Reach.b.setValue(3.4);
            }
            if (p >= 0 && p < 100) {
                Reach.a.setValue(3.1);
                Reach.b.setValue(3.3);
            }
        }
        else {
            Reach.a.setValue(3.1);
            Reach.b.setValue(3.3);
        }
    }
    
    public static void b(final int p, final String s) {
        Ravenb2.c.getModuleManager().getModule(Velocity.class).enable();
        final String i = s.toLowerCase();
        if (ModuleHelper.hs(i) || i.contains(ModuleHelper.mp)) {
            if (AutoConfig.a1.isToggled()) {
                if (p >= 170) {
                    Velocity.a.setValue(85.0);
                    Velocity.b.setValue(98.0);
                }
                if (p >= 120 && p < 170) {
                    Velocity.a.setValue(88.0);
                    Velocity.b.setValue(98.0);
                }
                if (p >= 20 && p < 120) {
                    Velocity.a.setValue(91.0);
                    Velocity.b.setValue(100.0);
                }
                if (p >= 0 && p < 20) {
                    Velocity.a.setValue(93.0);
                    Velocity.b.setValue(100.0);
                }
            }
            else {
                Velocity.a.setValue(90.0);
                Velocity.b.setValue(100.0);
            }
        }
        else if (i.contains(ModuleHelper.pp) || i.contains(ModuleHelper.ff) || i.contains(ModuleHelper.sy) || i.contains(ModuleHelper.vp)) {
            if (AutoConfig.a1.isToggled()) {
                if (p >= 170) {
                    Velocity.a.setValue(88.0);
                    Velocity.b.setValue(100.0);
                }
                if (p >= 150 && p < 170) {
                    Velocity.a.setValue(89.0);
                    Velocity.b.setValue(100.0);
                }
                if (p >= 120 && p < 150) {
                    Velocity.a.setValue(90.0);
                    Velocity.b.setValue(100.0);
                }
                if (p >= 80 && p < 120) {
                    Velocity.a.setValue(92.0);
                    Velocity.b.setValue(100.0);
                }
                if (p >= 40 && p < 80) {
                    Velocity.a.setValue(94.0);
                    Velocity.b.setValue(100.0);
                }
                if (p >= 0 && p < 40) {
                    Velocity.a.setValue(95.0);
                    Velocity.b.setValue(100.0);
                }
            }
            else {
                Velocity.a.setValue(95.0);
                Velocity.b.setValue(100.0);
            }
        }
        else if (i.contains(ModuleHelper.mmc) || i.contains(ModuleHelper.il)) {
            if (AutoConfig.a1.isToggled()) {
                if (p >= 120) {
                    Velocity.a.setValue(94.0);
                    Velocity.b.setValue(100.0);
                }
                if (p >= 80 && p < 120) {
                    Velocity.a.setValue(95.0);
                    Velocity.b.setValue(100.0);
                }
                if (p >= 40 && p < 80) {
                    Velocity.a.setValue(96.0);
                    Velocity.b.setValue(100.0);
                }
                if (p >= 0 && p < 40) {
                    Velocity.a.setValue(97.0);
                    Velocity.b.setValue(100.0);
                }
            }
            else {
                Velocity.a.setValue(95.0);
                Velocity.b.setValue(100.0);
            }
        }
        else {
            Ravenb2.c.getModuleManager().getModule(Velocity.class).enable();
            if (AutoConfig.a1.isToggled()) {
                if (p >= 170) {
                    Velocity.a.setValue(90.0);
                    Velocity.b.setValue(100.0);
                }
                if (p >= 150 && p < 170) {
                    Velocity.a.setValue(92.0);
                    Velocity.b.setValue(100.0);
                }
                if (p >= 120 && p < 150) {
                    Velocity.a.setValue(93.0);
                    Velocity.b.setValue(100.0);
                }
                if (p >= 80 && p < 120) {
                    Velocity.a.setValue(94.0);
                    Velocity.b.setValue(100.0);
                }
                if (p >= 40 && p < 80) {
                    Velocity.a.setValue(95.0);
                    Velocity.b.setValue(100.0);
                }
                if (p >= 0 && p < 40) {
                    Velocity.a.setValue(96.0);
                    Velocity.b.setValue(100.0);
                }
            }
            else {
                Velocity.a.setValue(95.0);
                Velocity.b.setValue(100.0);
            }
        }
    }
    
    public static void c(final int p, final String s) {
        Ravenb2.c.getModuleManager().getModule(AutoClicker.class).enable();
        final String i = s.toLowerCase();
        if (ModuleHelper.hs(i) || i.contains(ModuleHelper.mp) || i.contains(ModuleHelper.pp) || i.contains(ModuleHelper.ff) || i.contains(ModuleHelper.vp) || i.contains(ModuleHelper.sy)) {
            AutoClicker.a.setValue(12.0);
            AutoClicker.b.setValue(16.0);
        }
        else {
            AutoClicker.a.setValue(9.0);
            AutoClicker.b.setValue(14.0);
            AutoClicker.c.setValue(0.0);
        }
    }
    
    static {
        AutoConfig.a5 = false;
        AutoConfig.a6 = false;
        AutoConfig.a7 = 0;
    }
}
