//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.client;

import keystrokesmod.module.Module;
import net.minecraft.client.gui.GuiScreen;

public class SelfDestruct extends Module
{
    public static boolean isDestructed;
    
    public SelfDestruct() {
        super(new char[] { 'S', 'e', 'l', 'f', ' ', 'D', 'e', 's', 't', 'r', 'u', 'c', 't' }, category.client, 0);
    }
    
    @Override
    public void onEnable() {
        SelfDestruct.mc.displayGuiScreen((GuiScreen)null);
        SelfDestruct.isDestructed = true;
        this.disable();
    }
    
    static {
        SelfDestruct.isDestructed = false;
    }
}
