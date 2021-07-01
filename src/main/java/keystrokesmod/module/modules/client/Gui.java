//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.client;

import keystrokesmod.module.modules.minigames.MurderMystery;
import keystrokesmod.main.NotAName;
import keystrokesmod.main.Ravenb2;
import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleDesc;
import keystrokesmod.module.ModuleHelper;
import keystrokesmod.module.ModuleSettings2;
import net.minecraft.client.gui.GuiScreen;

public class Gui extends Module
{
    public static ModuleSettings2 settings;
    public static ModuleDesc b;
    
    public Gui() {
        super(new char[] { 'G', 'u', 'i' }, category.client, 54);
        this.registerSetting(Gui.settings = new ModuleSettings2(new char[] {'T', 'h', 'e', 'm', 'e'}, 1.0, 1.0, 3.0, 1.0));
        this.registerSetting(Gui.b = new ModuleDesc(ModuleHelper.c + "b" + Ravenb2.ravenVersion));
    }
    
    @Override
    public void onEnable() {
        if (!ModuleHelper.e() || SelfDestruct.isDestructed || Ravenb2.c.getModuleManager().getModule(AutoConfig.class).isEnabled() || MurderMystery.a1) {
            this.disable();
        }
        else {
            Gui.mc.displayGuiScreen((GuiScreen) NotAName.clickGui);
            this.toggle();
        }
    }
    
    @Override
    public void guiUpdate() {
        if (Gui.settings.getInput() == 1.0) {
            Gui.b.setDesc(ModuleHelper.c + "b" + Ravenb2.ravenVersion);
        }
        if (Gui.settings.getInput() == 2.0) {
            Gui.b.setDesc(ModuleHelper.c + "b" + (Ravenb2.ravenVersion - 1));
        }
        if (Gui.settings.getInput() == 3.0) {
            Gui.b.setDesc(ModuleHelper.c + "Dark");
        }
    }
}
