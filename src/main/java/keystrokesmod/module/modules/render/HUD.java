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
    public static ModuleSettings2 b;
    public static ModuleSettings2 c;
    public static ModuleSettings2 d;
    public static ModuleSettings e;
    public static ModuleSettings f;
    public static ModuleSettings g;
    
    public HUD() {
        super(new char[] { 'H', 'U', 'D' }, category.render, 0);
        HUD.b = new ModuleSettings2(new char[] { 'R', 'e', 'd' }, 150.0, 0.0, 255.0, 1.0);
        HUD.c = new ModuleSettings2(new char[] { 'G', 'r', 'e', 'e', 'n' }, 150.0, 0.0, 255.0, 1.0);
        HUD.d = new ModuleSettings2(new char[] { 'B', 'l', 'u', 'e' }, 255.0, 0.0, 255.0, 1.0);
        HUD.e = new ModuleSettings(new char[] { 'R', 'a', 'i', 'n', 'b', 'o', 'w' }, false);
        HUD.f = new ModuleSettings(new char[] { 'C', 'h', 'r', 'o', 'm', 'a' }, true);
        HUD.g = new ModuleSettings(new char[] { 'B', 'r', 'i', 'g', 'h', 't' }, false);
        this.registerSetting(HUD.b);
        this.registerSetting(HUD.c);
        this.registerSetting(HUD.d);
        this.registerSetting(HUD.e);
        this.registerSetting(HUD.f);
        this.registerSetting(HUD.g);
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
