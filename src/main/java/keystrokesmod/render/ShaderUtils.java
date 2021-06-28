//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.render;

import java.lang.reflect.Method;

import keystrokesmod.guis.ClickGui;
import keystrokesmod.module.ModuleHelper;
import net.minecraft.client.renderer.EntityRenderer;
import org.apache.commons.lang3.ArrayUtils;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.shader.ShaderUniform;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.client.shader.Shader;
import java.util.List;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import java.lang.reflect.Field;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.Minecraft;

public class ShaderUtils
{
    private Minecraft mc;
    private static ResourceLocation blur;
    private Field listShaders;
    private String[] blurExclusions;
    public static long start;
    public static int fadeTime;
    
    public ShaderUtils() {
        this.mc = Minecraft.getMinecraft();
    }
    
    @SubscribeEvent
    public void onRenderTick(final TickEvent.RenderTickEvent e) {
        if (e.phase == TickEvent.Phase.END && this.mc.currentScreen != null && this.mc.entityRenderer.isShaderActive()) {
            final ShaderGroup sg = this.mc.entityRenderer.getShaderGroup();
            try {
                final List<Shader> shaders = (List<Shader>)this.listShaders.get(sg);
                for (final Shader s : shaders) {
                    final ShaderUniform su = s.getShaderManager().getShaderUniform("Progress");
                    if (su != null) {
                        su.set(this.getProgress());
                    }
                }
            }
            catch (IllegalArgumentException ex) {}
            catch (IllegalAccessException ex2) {}
        }
    }
    
    @SubscribeEvent
    public void onGuiOpen(final GuiOpenEvent e) {
        if (this.listShaders == null) {
            this.listShaders = ReflectionHelper.findField((Class)ShaderGroup.class, new String[] { "field_148031_d", "listShaders" });
        }
        if (ModuleHelper.e()) {
            if (!this.mc.entityRenderer.isShaderActive() && e.gui instanceof ClickGui && !ArrayUtils.contains((Object[])this.blurExclusions, (Object)e.gui.getClass().getName())) {
                this.loadCustomShader();
                ShaderUtils.start = System.currentTimeMillis();
            }
            else if (this.mc.entityRenderer.isShaderActive() && e.gui == null) {
                this.mc.entityRenderer.stopUseShader();
            }
        }
    }
    
    private float getProgress() {
        return Math.min((float)((System.currentTimeMillis() - ShaderUtils.start) / ShaderUtils.fadeTime), 1.0f);
    }
    
    private void loadCustomShader() {
        final Method m = ReflectionHelper.findMethod((Class)EntityRenderer.class, (Object)null, new String[] { "func_175069_a", "loadShader" }, new Class[] { ResourceLocation.class });
        m.setAccessible(true);
        try {
            m.invoke(this.mc.entityRenderer, ShaderUtils.blur);
            ShaderUtils.start = System.currentTimeMillis();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }
    
    static {
        ShaderUtils.blur = new ResourceLocation("keystrokesmod", "shaders/post/fade_in_blur.json");
        ShaderUtils.fadeTime = 1;
    }
}
