// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.main;

import keystrokesmod.guis.ClickGui;
import keystrokesmod.module.ModuleManager;

public class NotAName
{
    public static ModuleManager moduleManager;
    public static ClickGui clickGui;
    private static int c;

    public NotAName() {
        NotAName.moduleManager = new ModuleManager();
    }
    
    public ModuleManager getModuleManager() {
        return NotAName.moduleManager;
    }

    static {
        NotAName.c = -1;
    }
}
