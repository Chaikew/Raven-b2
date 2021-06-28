// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.render;

import keystrokesmod.module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;
import net.minecraftforge.client.event.RenderPlayerEvent;

public class Chams extends Module
{
    public Chams() {
        super(new char[] { 'C', 'h', 'a', 'm', 's' }, category.render, 0);
    }
    
    @SubscribeEvent
    public void onRenderPlayer(final RenderPlayerEvent.Pre e) {
        GL11.glEnable(32823);
        GL11.glPolygonOffset(1.0f, -1100000.0f);
    }
    
    @SubscribeEvent
    public void onRenderPlayer(final RenderPlayerEvent.Post e) {
        GL11.glDisable(32823);
        GL11.glPolygonOffset(1.0f, 1100000.0f);
    }
}
