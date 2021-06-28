// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.render;

import keystrokesmod.module.modules.client.SelfDestruct;
import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleHelper;
import keystrokesmod.module.ModuleSettings;
import keystrokesmod.module.ModuleSettings2;

public class HUD extends Module
{
    public static boolean a;
    public static ModuleSettings2 red;
    public static ModuleSettings2 green;
    public static ModuleSettings2 blue;
    public static ModuleSettings rainbow;
    public static ModuleSettings chroma;
    public static ModuleSettings bright;
    
    public HUD() {
        super(new char[] { 'H', 'U', 'D' }, category.render, 0);
        HUD.red = new ModuleSettings2(new char[] { 'R', 'e', 'd' }, 150.0, 0.0, 255.0, 1.0);
        HUD.green = new ModuleSettings2(new char[] { 'G', 'r', 'e', 'e', 'n' }, 150.0, 0.0, 255.0, 1.0);
        HUD.blue = new ModuleSettings2(new char[] { 'B', 'l', 'u', 'e' }, 255.0, 0.0, 255.0, 1.0);
        HUD.rainbow = new ModuleSettings(new char[] { 'R', 'a', 'i', 'n', 'b', 'o', 'w' }, false);
        HUD.chroma = new ModuleSettings(new char[] { 'C', 'h', 'r', 'o', 'm', 'a' }, true);
        HUD.bright = new ModuleSettings(new char[] { 'B', 'r', 'i', 'g', 'h', 't' }, false);
        this.registerSetting(HUD.red);
        this.registerSetting(HUD.green);
        this.registerSetting(HUD.blue);
        this.registerSetting(HUD.rainbow);
        this.registerSetting(HUD.chroma);
        this.registerSetting(HUD.bright);
    }
    
    @Override
    public void onEnable() {
        if (ModuleHelper.e() && !SelfDestruct.isDestructed) {
            HUD.a = true;
        }
    }
    
    @Override
    public void onDisable() {
        HUD.a = false;
    }
}
