//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.player;

import keystrokesmod.module.modules.client.SelfDestruct;
import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.lang.reflect.Field;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class FastPlace extends Module
{
    public FastPlace() {
        super(new char[] { 'F', 'a', 's', 't', 'P', 'l', 'a', 'c', 'e' }, category.player, 0);
    }
    
    @SubscribeEvent
    public void a(final TickEvent.PlayerTickEvent b) {
        if (ModuleHelper.e() && !SelfDestruct.isDestructed) {
            try {
                final Field c = Minecraft.class.getDeclaredField("field_71467_ac");
                c.setAccessible(true);
                c.set(FastPlace.mc, 0);
            }
            catch (Exception d) {
                try {
                    final Field e = Minecraft.class.getDeclaredField("rightClickDelayTimer");
                    e.setAccessible(true);
                    e.set(FastPlace.mc, 0);
                }
                catch (Exception f) {
                    this.disable();
                }
            }
        }
    }
}
