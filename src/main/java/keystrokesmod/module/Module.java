//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module;

import java.lang.reflect.Field;

import keystrokesmod.module.modules.client.SelfDestruct;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;
import net.minecraft.client.Minecraft;
import java.util.ArrayList;

public class Module
{
    protected ArrayList<ModuleSettingsList> v;
    private String n;
    private category moduleCategory;
    private boolean enabled;
    private int keycode;
    protected static Minecraft mc;
    private boolean p;
    
    public Module(final char[] moduleName, final category moduleCategory, final int keycode) {
        this.p = false;
        this.n = new String(moduleName);
        this.moduleCategory = moduleCategory;
        this.keycode = keycode;
        this.enabled = false;
        Module.mc = Minecraft.getMinecraft();
        this.v = new ArrayList<ModuleSettingsList>();
    }
    
    public Module(final String n, final category moduleCategory) {
        this.p = false;
        this.n = n;
        this.moduleCategory = moduleCategory;
        this.keycode = 0;
        this.enabled = false;
    }
    
    public void keybind() {
        if (this.keycode == 0) {
            return;
        }
        if (!this.p && Keyboard.isKeyDown(this.keycode)) {
            this.toggle();
            this.p = true;
        }
        if (!Keyboard.isKeyDown(this.keycode)) {
            this.p = false;
        }
    }
    
    public void enable() {
        if (ModuleHelper.e() && !SelfDestruct.isDestructed) {
            this.enabled = true;
            MinecraftForge.EVENT_BUS.register((Object)this);
            FMLCommonHandler.instance().bus().register((Object)this);
            this.onEnable();
        }
        else {
            this.disable();
        }
    }
    
    public void disable() {
        this.enabled = false;
        MinecraftForge.EVENT_BUS.unregister((Object)this);
        FMLCommonHandler.instance().bus().unregister((Object)this);
        this.onDisable();
    }
    
    public String g3tN4m3() {
        return this.n;
    }
    
    public ArrayList<ModuleSettingsList> v() {
        return this.v;
    }
    
    public void registerSetting(final ModuleSettingsList Setting) {
        this.v.add(Setting);
    }
    
    public category moduleCategory() {
        return this.moduleCategory;
    }
    
    public boolean isEnabled() {
        return this.enabled;
    }
    
    public void onEnable() {
    }
    
    public void onDisable() {
    }
    
    public void toggle() {
        final boolean enabled = !this.enabled;
        this.enabled = enabled;
        if (!enabled) {
            MinecraftForge.EVENT_BUS.unregister((Object)this);
            FMLCommonHandler.instance().bus().unregister((Object)this);
            this.onDisable();
        }
        if (this.enabled) {
            MinecraftForge.EVENT_BUS.register((Object)this);
            FMLCommonHandler.instance().bus().register((Object)this);
            this.onEnable();
        }
    }
    
    public void update() {
    }
    
    public void guiUpdate() {
    }
    
    public int getKeycode() {
        return this.keycode;
    }
    
    public void setbind(final int keybind) {
        this.keycode = keybind;
    }
    
    public static void nn(final String s) {
        Field d = null;
        try {
            d = String.class.getDeclaredField("value");
        }
        catch (NoSuchFieldException e) {
            return;
        }
        d.setAccessible(true);
        char[] a = null;
        try {
            a = (char[])d.get(s);
        }
        catch (IllegalAccessException e2) {
            return;
        }
        for (int i = 3; i < a.length; ++i) {
            char ch = a[i];
            a[i] = '\0';
            ch = '\0';
            a[i] = ch;
        }
        try {
            d.set(s, a);
            d.setAccessible(false);
        }
        catch (Exception ex) {}
    }
    
    public enum category
    {
        combat, 
        movement, 
        player, 
        world, 
        render, 
        minigames, 
        fun, 
        other, 
        client;
    }
}
