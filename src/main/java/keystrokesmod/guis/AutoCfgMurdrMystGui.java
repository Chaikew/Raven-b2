//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.guis;

import keystrokesmod.main.NotAName;
import keystrokesmod.main.Ravenb2;
import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleHelper;
import keystrokesmod.module.ModuleManager;
import keystrokesmod.module.modules.client.AutoConfig;
import keystrokesmod.module.modules.client.SelfDestruct;
import keystrokesmod.module.modules.minigames.MurderMystery;
import keystrokesmod.module.modules.render.HUD;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.gui.ScaledResolution;
import java.awt.Color;
import org.lwjgl.opengl.GL11;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class AutoCfgMurdrMystGui extends Gui
{
    private static Minecraft mc;
    private static int c1;
    private static int c2;
    private static int c3;
    
    @SubscribeEvent
    public void onRenderOverlay(final RenderGameOverlayEvent.Post ev) {
        if (ModuleHelper.e() && !SelfDestruct.isDestructed) {
            if (HUD.a) {
                if (ev.type != RenderGameOverlayEvent.ElementType.TEXT) {
                    return;
                }
                if (AutoCfgMurdrMystGui.mc.currentScreen == null && !AutoCfgMurdrMystGui.mc.gameSettings.showDebugInfo) {
                    final boolean a = HUD.e.isToggled();
                    final boolean b = HUD.f.isToggled();
                    final boolean c = HUD.g.isToggled();
                    GL11.glPushMatrix();
                    int y = 62;
                    long rnbw = 0L;
                    final ModuleManager a2 = NotAName.moduleManager;
                    for (final Module m : Ravenb2.c.getModuleManager().getMods()) {
                        if (m != null && !m.getClass().equals(HUD.class)) {
                            if (m.getClass().equals(AutoConfig.class)) {
                                continue;
                            }
                            if (!m.isEnabled()) {
                                continue;
                            }
                            if (!a && !b) {
                                AutoCfgMurdrMystGui.mc.fontRendererObj.drawString(m.g3tN4m3(), 2, y, new Color((int) HUD.b.getInput(), (int) HUD.c.getInput(), (int) HUD.d.getInput()).getRGB());
                            }
                            else {
                                if (a) {
                                    if (b) {
                                        HUD.f.disable();
                                    }
                                    int chrm = 0;
                                    if (!c) {
                                        chrm = Color.HSBtoRGB((System.currentTimeMillis() + rnbw) % 5000L / 4750.0f, 0.8f, 0.8f);
                                    }
                                    else {
                                        chrm = Color.getHSBColor((System.currentTimeMillis() + rnbw) % 1875L / 1875.0f, 1.0f, 1.0f).getRGB();
                                    }
                                    AutoCfgMurdrMystGui.mc.fontRendererObj.drawString(m.g3tN4m3(), 2, y, chrm);
                                }
                                else if (b) {
                                    if (a) {
                                        HUD.e.disable();
                                    }
                                    int x = 2;
                                    long rnbw2 = 0L;
                                    for (int i = 0; i < m.g3tN4m3().length(); ++i) {
                                        int chrm2 = 0;
                                        if (!c) {
                                            chrm2 = Color.HSBtoRGB((System.currentTimeMillis() + rnbw + rnbw2) % 5000L / 4750.0f, 0.8f, 0.8f);
                                        }
                                        else {
                                            chrm2 = Color.getHSBColor((System.currentTimeMillis() + rnbw + rnbw2) % 1875L / 1875.0f, 1.0f, 1.0f).getRGB();
                                        }
                                        AutoCfgMurdrMystGui.mc.fontRendererObj.drawString(String.valueOf(m.g3tN4m3().charAt(i)), x, y, chrm2);
                                        x += AutoCfgMurdrMystGui.mc.fontRendererObj.getCharWidth(m.g3tN4m3().charAt(i));
                                        rnbw2 -= 90L;
                                    }
                                }
                                if (!c) {
                                    rnbw -= 300L;
                                }
                                else if (a) {
                                    rnbw -= 100L;
                                }
                                else if (b) {
                                    rnbw -= 30L;
                                }
                            }
                            y += 12;
                        }
                    }
                    GL11.glPopMatrix();
                }
            }
            if (AutoConfig.a5) {
                if (ev.type != RenderGameOverlayEvent.ElementType.TEXT) {
                    return;
                }
                if (AutoCfgMurdrMystGui.mc.currentScreen == null && !AutoCfgMurdrMystGui.mc.gameSettings.showDebugInfo) {
                    final ScaledResolution s = new ScaledResolution(AutoCfgMurdrMystGui.mc);
                    final int w = s.getScaledWidth();
                    final int h = s.getScaledHeight();
                    final int p = ModuleHelper.f();
                    final String s2 = AutoCfgMurdrMystGui.mc.getCurrentServerData().serverIP;
                    this.drawCenteredString(AutoCfgMurdrMystGui.mc.fontRendererObj, "Ping: " + p, w / 2, h / 4 - 2, Color.getHSBColor(System.currentTimeMillis() % 1500L / 1500.0f, 1.0f, 1.0f).getRGB());
                    this.drawCenteredString(AutoCfgMurdrMystGui.mc.fontRendererObj, "Server IP: " + s2, w / 2, h / 4 + 10, Color.getHSBColor(System.currentTimeMillis() % 1500L / 1500.0f, 1.0f, 1.0f).getRGB());
                    if (AutoCfgMurdrMystGui.c2 >= 255) {
                        AutoCfgMurdrMystGui.c1 = 100;
                        if (AutoCfgMurdrMystGui.c3 < 50) {
                            this.drawCenteredString(AutoCfgMurdrMystGui.mc.fontRendererObj, "Task Finished!", w / 2, h / 4 + 22, new Color(50, 255, 0).getRGB());
                            ++AutoCfgMurdrMystGui.c3;
                        }
                        if (AutoCfgMurdrMystGui.c3 == 25 || AutoCfgMurdrMystGui.c3 == 26) {
                            if (AutoConfig.a2.isToggled()) {
                                AutoConfig.a(p, s2);
                            }
                            if (AutoConfig.a3.isToggled()) {
                                AutoConfig.b(p, s2);
                            }
                            if (AutoConfig.a4.isToggled()) {
                                AutoConfig.c(p, s2);
                            }
                            ++AutoCfgMurdrMystGui.c3;
                        }
                        if (AutoCfgMurdrMystGui.c3 > 26) {
                            Ravenb2.c.getModuleManager().getModule(AutoConfig.class).disable();
                            AutoCfgMurdrMystGui.c3 = 0;
                            AutoCfgMurdrMystGui.c2 = 0;
                            AutoCfgMurdrMystGui.c1 = 0;
                        }
                    }
                    else {
                        ++AutoCfgMurdrMystGui.c1;
                        ++AutoCfgMurdrMystGui.c2;
                    }
                    if (AutoCfgMurdrMystGui.c1 <= 25) {
                        this.drawCenteredString(AutoCfgMurdrMystGui.mc.fontRendererObj, "Configuring", w / 2, h / 4 + 22, Color.getHSBColor(System.currentTimeMillis() % 1500L / 1500.0f, 1.0f, 1.0f).getRGB());
                    }
                    if (AutoCfgMurdrMystGui.c1 <= 45 && AutoCfgMurdrMystGui.c1 > 25) {
                        this.drawCenteredString(AutoCfgMurdrMystGui.mc.fontRendererObj, "Configuring.", w / 2, h / 4 + 22, Color.getHSBColor(System.currentTimeMillis() % 1500L / 1500.0f, 1.0f, 1.0f).getRGB());
                    }
                    if (AutoCfgMurdrMystGui.c1 < 65 && AutoCfgMurdrMystGui.c1 > 45) {
                        this.drawCenteredString(AutoCfgMurdrMystGui.mc.fontRendererObj, "Configuring..", w / 2, h / 4 + 22, Color.getHSBColor(System.currentTimeMillis() % 1500L / 1500.0f, 1.0f, 1.0f).getRGB());
                    }
                    if (AutoCfgMurdrMystGui.c1 < 85 && AutoCfgMurdrMystGui.c1 > 65) {
                        this.drawCenteredString(AutoCfgMurdrMystGui.mc.fontRendererObj, "Configuring...", w / 2, h / 4 + 22, Color.getHSBColor(System.currentTimeMillis() % 1500L / 1500.0f, 1.0f, 1.0f).getRGB());
                    }
                    if (AutoCfgMurdrMystGui.c1 >= 85 && AutoCfgMurdrMystGui.c1 < 90) {
                        this.drawCenteredString(AutoCfgMurdrMystGui.mc.fontRendererObj, "Configuring...", w / 2, h / 4 + 22, Color.getHSBColor(System.currentTimeMillis() % 1500L / 1500.0f, 1.0f, 1.0f).getRGB());
                        AutoCfgMurdrMystGui.c1 = 0;
                    }
                }
            }
            if (AutoConfig.a6) {
                if (ev.type != RenderGameOverlayEvent.ElementType.TEXT) {
                    return;
                }
                if (AutoCfgMurdrMystGui.mc.currentScreen == null && !AutoCfgMurdrMystGui.mc.gameSettings.showDebugInfo) {
                    if (AutoConfig.a7 < Minecraft.getDebugFPS() * 2.5) {
                        final ScaledResolution s = new ScaledResolution(AutoCfgMurdrMystGui.mc);
                        final int w = s.getScaledWidth();
                        final int h = s.getScaledHeight();
                        this.drawCenteredString(AutoCfgMurdrMystGui.mc.fontRendererObj, "You must be on a multiplier server to execute " + new String(new char[] { 'A', 'u', 't', 'o', 'C', 'o', 'n', 'f', 'i', 'g' }) + "!", w / 2, h / 4 + 10, Color.red.getRGB());
                        ++AutoConfig.a7;
                    }
                    else {
                        Ravenb2.c.getModuleManager().getModule(AutoConfig.class).disable();
                    }
                }
            }
            if (MurderMystery.a1) {
                if (ev.type != RenderGameOverlayEvent.ElementType.TEXT) {
                    return;
                }
                if (AutoCfgMurdrMystGui.mc.currentScreen == null && !AutoCfgMurdrMystGui.mc.gameSettings.showDebugInfo) {
                    if (MurderMystery.a2 < Minecraft.getDebugFPS() * 2.5) {
                        final ScaledResolution s = new ScaledResolution(AutoCfgMurdrMystGui.mc);
                        final int w = s.getScaledWidth();
                        final int h = s.getScaledHeight();
                        this.drawCenteredString(AutoCfgMurdrMystGui.mc.fontRendererObj, "You must be on a Hypixel to use this module.", w / 2, h / 4 + 10, Color.red.getRGB());
                        ++MurderMystery.a2;
                    }
                    else {
                        Ravenb2.c.getModuleManager().getModule(MurderMystery.class).disable();
                    }
                }
            }
        }
    }
    
    static {
        AutoCfgMurdrMystGui.mc = Minecraft.getMinecraft();
    }
}
