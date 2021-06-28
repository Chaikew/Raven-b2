//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.world;

import java.lang.reflect.Field;

import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleHelper;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import com.google.common.collect.Ordering;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import java.util.List;

public class AntiBot extends Module
{
    public static List<EntityPlayer> invalid;
    
    public AntiBot() {
        super(new char[] { 'A', 'n', 't', 'i', 'B', 'o', 't' }, category.world, 0);
    }
    
    @Override
    public void onEnable() {
        AntiBot.invalid.clear();
    }
    
    @Override
    public void onDisable() {
        AntiBot.invalid.clear();
    }
    
    @Override
    public void update() {
        if (ModuleHelper.e()) {
            for (final Entity a : AntiBot.mc.theWorld.loadedEntityList) {
                if (a instanceof EntityPlayer) {
                    final EntityPlayer e = (EntityPlayer)a;
                    if (e == AntiBot.mc.thePlayer || AntiBot.invalid.contains(e)) {
                        return;
                    }
                    final String f = e.getDisplayName().getFormattedText();
                    final String custom = e.getCustomNameTag();
                    final String name = e.getName();
                    if (e.isInvisible() && !f.startsWith("§c") && f.endsWith("§r") && custom.equals(name)) {
                        final double dx = Math.abs(e.posX - AntiBot.mc.thePlayer.posX);
                        final double dy = Math.abs(e.posY - AntiBot.mc.thePlayer.posY);
                        final double dz = Math.abs(e.posZ - AntiBot.mc.thePlayer.posZ);
                        final double dh = Math.sqrt(dx * dx + dz * dz);
                        if (dy < 13.0 && dy > 10.0 && dh < 3.0) {
                            final List<EntityPlayer> list = getTabPlayerList();
                            if (!list.contains(e)) {
                                AntiBot.invalid.add(e);
                            }
                        }
                    }
                    if (!custom.equalsIgnoreCase("") && custom.toLowerCase().contains("§c") && custom.toLowerCase().contains("§r")) {
                        AntiBot.invalid.add(e);
                    }
                    if (!f.startsWith("§") && f.endsWith("§r")) {
                        AntiBot.invalid.add(e);
                    }
                    if (e.isInvisible() && !custom.equalsIgnoreCase("") && custom.toLowerCase().contains("§c§c") && name.contains("§c")) {
                        AntiBot.invalid.add(e);
                    }
                    if (f.contains("§8[NPC]")) {
                        AntiBot.invalid.add(e);
                    }
                    if (!f.contains("§c") || custom.equalsIgnoreCase("")) {
                        continue;
                    }
                    AntiBot.invalid.add(e);
                }
            }
        }
    }
    
    public static List<EntityPlayer> getTabPlayerList() {
        final NetHandlerPlayClient var4 = AntiBot.mc.thePlayer.sendQueue;
        final List<EntityPlayer> list = new ArrayList<EntityPlayer>();
        Ordering o = null;
        try {
            final Field f = GuiPlayerTabOverlay.class.getDeclaredField("field_175252_a");
            f.setAccessible(true);
            o = (Ordering)f.get(GuiPlayerTabOverlay.class);
        }
        catch (NoSuchFieldException ex2) {
            ex2.printStackTrace();
            return null;
        }catch (IllegalAccessException ex3) {
            ex3.printStackTrace();
        }
        final List players = o.sortedCopy((Iterable)var4.getPlayerInfoMap());
        for (final Object ob : players) {
            final NetworkPlayerInfo info = (NetworkPlayerInfo)ob;
            if (info == null) {
                continue;
            }
            list.add(AntiBot.mc.theWorld.getPlayerEntityByName(info.getGameProfile().getName()));
        }
        return list;
    }
    
    static {
        AntiBot.invalid = new ArrayList<EntityPlayer>();
    }
}
