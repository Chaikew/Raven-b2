//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.main;

import keystrokesmod.render.ShaderUtils;
import keystrokesmod.guis.AutoCfgMurdrMystGui;
import keystrokesmod.guis.ClickGui;
import keystrokesmod.guis.KeyStrokeGui;
import keystrokesmod.keystroke.KeyStroke;
import keystrokesmod.keystroke.KeyStrokeClickCounter;
import keystrokesmod.keystroke.KeyStrokeCommand;
import keystrokesmod.keystroke.KeyStrokeRenderer;
import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleHelper;
import keystrokesmod.module.modules.client.SelfDestruct;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraft.command.ICommand;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;

@Mod(modid = "keystrokesmod", name = "KeystrokesMod", version = "KMV5", acceptedMinecraftVersions = "[1.8.9]")
public class Ravenb2
{
    public static int a;
    public static int b;
    public static Minecraft mc;
    public static NotAName c;
    private static KeyStroke keyStroke;
    private static KeyStrokeRenderer keyStrokeRenderer;
    private static boolean isKeyStrokeEnabled;
    public static int ravenVersion;
    
    public Ravenb2() {
        Ravenb2.c = new NotAName();
    }
    
    @Mod.EventHandler
    public void init(final FMLInitializationEvent e) {
        Ravenb2.keyStrokeRenderer = new KeyStrokeRenderer();
        ClientCommandHandler.instance.registerCommand((ICommand)new KeyStrokeCommand());
        FMLCommonHandler.instance().bus().register((Object)this);
        FMLCommonHandler.instance().bus().register((Object)new AutoCfgMurdrMystGui());
        FMLCommonHandler.instance().bus().register((Object)new KeyStrokeClickCounter());
        FMLCommonHandler.instance().bus().register((Object)new KeyStrokeRenderer());
        FMLCommonHandler.instance().bus().register((Object)new ShaderUtils());
        Ravenb2.c.getModuleManager().register();
        ConfigManager.lc();
        ConfigManager.lc2();
        NotAName.clickGui = new ClickGui();
    }
    
    @SubscribeEvent
    public void onTick(final TickEvent.ClientTickEvent e) {
        if (ModuleHelper.e() && !SelfDestruct.isDestructed) {
            for (final Module mod : Ravenb2.c.getModuleManager().getMods()) {
                if (Ravenb2.mc.currentScreen == null) {
                    mod.keybind();
                }
                else if (Ravenb2.mc.currentScreen instanceof ClickGui) {
                    mod.guiUpdate();
                }
                if (mod.isEnabled()) {
                    mod.update();
                }
            }
        }
        if (Ravenb2.isKeyStrokeEnabled) {
            Ravenb2.mc.displayGuiScreen((GuiScreen)new KeyStrokeGui());
            Ravenb2.isKeyStrokeEnabled = false;
        }
    }
    
    public static KeyStroke getKeyStroke() {
        return Ravenb2.keyStroke;
    }
    
    public static KeyStrokeRenderer getKeyStrokeRenderer() {
        return Ravenb2.keyStrokeRenderer;
    }

    public static void enableKeyStroke() {
        Ravenb2.isKeyStrokeEnabled = true;
    }
    
    static {
        Ravenb2.a = 1;
        Ravenb2.b = 0;
        Ravenb2.mc = Minecraft.getMinecraft();
        Ravenb2.ravenVersion = 2;
    }
}
