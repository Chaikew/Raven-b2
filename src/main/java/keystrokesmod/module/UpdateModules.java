// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module;

import keystrokesmod.main.ConfigManager;
import keystrokesmod.main.Ravenb2;
import keystrokesmod.module.modules.client.Gui;
import keystrokesmod.module.modules.combat.AutoClicker;
import keystrokesmod.module.modules.combat.Reach;
import keystrokesmod.module.modules.combat.Velocity;

public class UpdateModules
{
    public static double theme;
    public static double r1;
    public static double r2;
    public static boolean r3;
    public static boolean r4;
    public static boolean r5;
    public static boolean r6;
    public static int r7;
    public static double v1;
    public static double v2;
    public static double v3;
    public static int v4;
    public static double au1;
    public static double au2;
    public static double au3;
    public static boolean au4;
    public static boolean au5;
    public static boolean au6;
    public static boolean au7;
    public static boolean au8;
    public static int au9;
    
    public static void ss() {
        UpdateModules.theme = Gui.settings.getInput();
        UpdateModules.r1 = Reach.minReach.getInput();
        UpdateModules.r2 = Reach.maxReach.getInput();
        UpdateModules.r3 = Reach.weaponOnly.isToggled();
        UpdateModules.r4 = Reach.movingOnly.isToggled();
        UpdateModules.r5 = Reach.sprintOnly.isToggled();
        UpdateModules.r6 = Reach.hitThroughBlocks.isToggled();
        UpdateModules.r7 = Ravenb2.c.getModuleManager().getModule(Reach.class).getKeycode();
        UpdateModules.v1 = Velocity.horizontal.getInput();
        UpdateModules.v2 = Velocity.vertical.getInput();
        UpdateModules.v3 = Velocity.chance.getInput();
        UpdateModules.v4 = Ravenb2.c.getModuleManager().getModule(Velocity.class).getKeycode();
        UpdateModules.au1 = AutoClicker.minCPS.getInput();
        UpdateModules.au2 = AutoClicker.maxCPS.getInput();
        UpdateModules.au3 = AutoClicker.jitter.getInput();
        UpdateModules.au4 = AutoClicker.weaponOnly.isToggled();
        UpdateModules.au5 = AutoClicker.breakBlocks.isToggled();
        UpdateModules.au6 = AutoClicker.inventoryFill.isToggled();
        UpdateModules.au7 = AutoClicker.leftClick.isToggled();
        UpdateModules.au8 = AutoClicker.rightClick.isToggled();
        UpdateModules.au9 = Ravenb2.c.getModuleManager().getModule(AutoClicker.class).getKeycode();
        ConfigManager.sc2();
    }
    
    static {
        UpdateModules.theme = 1.0;
        UpdateModules.r1 = 3.1;
        UpdateModules.r2 = 3.3;
        UpdateModules.r3 = false;
        UpdateModules.r4 = false;
        UpdateModules.r5 = false;
        UpdateModules.r6 = false;
        UpdateModules.r7 = 0;
        UpdateModules.v1 = 96.0;
        UpdateModules.v2 = 100.0;
        UpdateModules.v3 = 100.0;
        UpdateModules.v4 = 0;
        UpdateModules.au1 = 9.0;
        UpdateModules.au2 = 12.0;
        UpdateModules.au3 = 0.0;
        UpdateModules.au4 = false;
        UpdateModules.au5 = false;
        UpdateModules.au6 = false;
        UpdateModules.au7 = true;
        UpdateModules.au8 = false;
        UpdateModules.au9 = 0;
    }
}
