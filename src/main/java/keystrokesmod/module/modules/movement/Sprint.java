//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.movement;

import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleHelper;
import keystrokesmod.module.ModuleSettings;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Sprint extends Module
{
    public static ModuleSettings a;
    
    public Sprint() {
        super(new char[] { 'S', 'p', 'r', 'i', 'n', 't' }, category.movement, 0);
        this.registerSetting(Sprint.a = new ModuleSettings(new char[] { 'O', 'm', 'n', 'i', 'S', 'p', 'r', 'i', 'n', 't' }, false));
    }
    
    @SubscribeEvent
    public void opt(final TickEvent.PlayerTickEvent e) {
        if (Sprint.mc.inGameHasFocus) {
            final EntityPlayerSP p = Sprint.mc.thePlayer;
            if (Sprint.a.isToggled()) {
                if (ModuleHelper.im() && p.getFoodStats().getFoodLevel() > 6) {
                    p.setSprinting(true);
                }
            }
            else {
                KeyBinding.setKeyBindState(Sprint.mc.gameSettings.keyBindSprint.getKeyCode(), true);
            }
        }
    }
}
