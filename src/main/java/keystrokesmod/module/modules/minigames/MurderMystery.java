//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.minigames;

import java.util.ArrayList;

import keystrokesmod.main.Ravenb2;
import keystrokesmod.render.RenderUtils;
import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleHelper;
import keystrokesmod.module.ModuleSettings;
import keystrokesmod.module.modules.client.SelfDestruct;
import keystrokesmod.module.modules.render.PlayerESP;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.Item;
import net.minecraft.entity.Entity;
import java.awt.Color;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import java.util.List;

public class MurderMystery extends Module
{
    public static ModuleSettings a;
    public static ModuleSettings b;
    public static ModuleSettings c;
    public static boolean a1;
    public static int a2;
    private static List<EntityPlayer> m;
    private static List<EntityPlayer> bw;
    
    public MurderMystery() {
        super(new char[] { 'M', 'u', 'r', 'd', 'e', 'r', 'M', 'y', 's', 't', 'e', 'r', 'y' }, category.minigames, 0);
        MurderMystery.a = new ModuleSettings(new char[] { 'A', 'l', 'e', 'r', 't' }, true);
        MurderMystery.b = new ModuleSettings(new char[] { 'S', 'e', 'a', 'r', 'c', 'h', ' ', 'D', 'e', 't', 'e', 'c', 't', 'i', 'v', 'e' }, true);
        MurderMystery.c = new ModuleSettings(new char[] { 'A', 'n', 'n', 'o', 'u', 'n', 'c', 'e', ' ', 'M', 'u', 'r', 'd', 'e', 'r', 'e', 'r' }, false);
        this.registerSetting(MurderMystery.b);
        this.registerSetting(MurderMystery.c);
    }
    
    @Override
    public void onEnable() {
        MurderMystery.mc.displayGuiScreen((GuiScreen)null);
        MurderMystery.a1 = !ModuleHelper.hs("n");
    }
    
    @Override
    public void onDisable() {
        MurderMystery.a1 = false;
        MurderMystery.a2 = 0;
    }
    
    @SubscribeEvent
    public void o(final RenderWorldLastEvent ev) {
        if (!ModuleHelper.e() || SelfDestruct.isDestructed) {
            return;
        }
        if (Ravenb2.c.getModuleManager().getModule(PlayerESP.class).isEnabled()) {
            Ravenb2.c.getModuleManager().getModule(PlayerESP.class).disable();
        }
        if (MurderMystery.mc.thePlayer.getWorldScoreboard() != null && MurderMystery.mc.thePlayer.getWorldScoreboard().getObjectiveInDisplaySlot(1) != null) {
            final String d = MurderMystery.mc.thePlayer.getWorldScoreboard().getObjectiveInDisplaySlot(1).getDisplayName();
            if (d.contains("MURDER") || d.contains("MYSTERY")) {
                for (final EntityPlayer en : MurderMystery.mc.theWorld.playerEntities) {
                    if (en != MurderMystery.mc.thePlayer && !en.isInvisible() && !en.getDisplayName().getUnformattedText().startsWith(ModuleHelper.r("&8[NPC]"))) {
                        if (en.getHeldItem() != null && en.getHeldItem().hasDisplayName()) {
                            final Item i = en.getHeldItem().getItem();
                            if (i instanceof ItemSword || i instanceof ItemAxe || en.getHeldItem().getDisplayName().replaceAll("§", "").equals("aKnife")) {
                                if (!MurderMystery.m.contains(en)) {
                                    MurderMystery.m.add(en);
                                    if (MurderMystery.a.isToggled()) {
                                        MurderMystery.mc.thePlayer.playSound("note.pling", 1.0f, 1.0f);
                                        ModuleHelper.sm("&7[&cALERT&7] &e" + en.getName() + " &3is a murderer!");
                                    }
                                    if (MurderMystery.c.isToggled()) {
                                        MurderMystery.mc.thePlayer.sendChatMessage(en.getName() + " is a murderer!");
                                    }
                                }
                            }
                            else if (i instanceof ItemBow && MurderMystery.b.isToggled() && !MurderMystery.bw.contains(en)) {
                                MurderMystery.bw.add(en);
                                if (MurderMystery.a.isToggled()) {
                                    ModuleHelper.sm("&7[&cALERT&7] &e" + en.getName() + " &3has a bow!");
                                }
                                if (MurderMystery.c.isToggled()) {
                                    MurderMystery.mc.thePlayer.sendChatMessage(en.getName() + " has a bow!");
                                }
                            }
                        }
                        int rgb = Color.green.getRGB();
                        if ((MurderMystery.m.contains(en) && !MurderMystery.bw.contains(en)) || (MurderMystery.m.contains(en) && MurderMystery.bw.contains(en))) {
                            rgb = Color.red.getRGB();
                        }
                        if (!MurderMystery.m.contains(en) && MurderMystery.bw.contains(en)) {
                            rgb = Color.orange.getRGB();
                        }
                        RenderUtils.ee((Entity)en, rgb, false, 1);
                    }
                }
            }
            else {
                this.c();
            }
        }
        else {
            this.c();
        }
    }
    
    private void c() {
        if (MurderMystery.m.size() > 0) {
            MurderMystery.m.clear();
        }
        if (MurderMystery.bw.size() > 0) {
            MurderMystery.bw.clear();
        }
    }
    
    static {
        MurderMystery.a1 = false;
        MurderMystery.a2 = 0;
        MurderMystery.m = new ArrayList<EntityPlayer>();
        MurderMystery.bw = new ArrayList<EntityPlayer>();
    }
}
