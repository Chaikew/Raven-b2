//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.render;

import java.util.ArrayList;
import java.awt.Color;

import keystrokesmod.render.RenderUtils;
import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleSettings;
import keystrokesmod.module.ModuleSettings2;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.BlockPos;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import java.util.List;

public class Xray extends Module
{
    public static ModuleSettings2 r;
    public static ModuleSettings a;
    public static ModuleSettings b;
    public static ModuleSettings c;
    public static ModuleSettings d;
    public static ModuleSettings e;
    public static ModuleSettings f;
    public static ModuleSettings g;
    public static ModuleSettings h;
    public static List<Block> ores;
    
    public Xray() {
        super(new char[] { 'X', 'r', 'a', 'y' }, category.render, 0);
        this.registerSetting(Xray.r = new ModuleSettings2(new char[] { 'R', 'a', 'n', 'g', 'e' }, 20.0, 5.0, 50.0, 1.0));
        this.registerSetting(Xray.a = new ModuleSettings(new char[] { 'I', 'r', 'o', 'n' }, true));
        this.registerSetting(Xray.b = new ModuleSettings(new char[] { 'G', 'o', 'l', 'd' }, true));
        this.registerSetting(Xray.c = new ModuleSettings(new char[] { 'D', 'i', 'a', 'm', 'o', 'n', 'd' }, true));
        this.registerSetting(Xray.d = new ModuleSettings(new char[] { 'E', 'm', 'e', 'r', 'a', 'l', 'd' }, true));
        this.registerSetting(Xray.e = new ModuleSettings(new char[] { 'L', 'a', 'p', 'i', 's' }, true));
        this.registerSetting(Xray.f = new ModuleSettings(new char[] { 'R', 'e', 'd', 's', 't', 'o', 'n', 'e' }, true));
        this.registerSetting(Xray.g = new ModuleSettings(new char[] { 'C', 'o', 'a', 'l' }, true));
        this.registerSetting(Xray.h = new ModuleSettings(new char[] { 'S', 'p', 'a', 'w', 'n', 'e', 'r' }, true));
        Xray.ores.add(Blocks.iron_ore);
        Xray.ores.add(Blocks.gold_ore);
        Xray.ores.add(Blocks.diamond_ore);
        Xray.ores.add(Blocks.emerald_ore);
        Xray.ores.add(Blocks.lapis_ore);
        Xray.ores.add(Blocks.redstone_ore);
        Xray.ores.add(Blocks.coal_ore);
        Xray.ores.add(Blocks.mob_spawner);
    }
    
    @SubscribeEvent
    public void orl(final RenderWorldLastEvent ev) {
        final BlockPos pos = Xray.mc.thePlayer.getPosition();
        for (int range = (int) Xray.r.getInput(), x = pos.getX() - range; x <= pos.getX() + range; ++x) {
            for (int z = pos.getZ() - range; z < pos.getZ() + range; ++z) {
                for (int y = pos.getY() - range; y < pos.getY() + range; ++y) {
                    final Block bl = Xray.mc.theWorld.getBlockState(new BlockPos(x, y, z)).getBlock();
                    if (Xray.ores.contains(bl)) {
                        if (Xray.a.isToggled() || !bl.equals(Blocks.iron_ore)) {
                            if (Xray.b.isToggled() || !bl.equals(Blocks.gold_ore)) {
                                if (Xray.c.isToggled() || !bl.equals(Blocks.diamond_ore)) {
                                    if (Xray.d.isToggled() || !bl.equals(Blocks.emerald_ore)) {
                                        if (Xray.e.isToggled() || !bl.equals(Blocks.lapis_ore)) {
                                            if (Xray.f.isToggled() || !bl.equals(Blocks.redstone_ore)) {
                                                if (Xray.g.isToggled() || !bl.equals(Blocks.coal_ore)) {
                                                    if (Xray.h.isToggled() || !bl.equals(Blocks.mob_spawner)) {
                                                        this.x(bl, new BlockPos(x, y, z));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void x(final Block b, final BlockPos bp) {
        final String[] rgb = this.z(b).split("-");
        final int red = Integer.parseInt(rgb[0]);
        final int green = Integer.parseInt(rgb[1]);
        final int blue = Integer.parseInt(rgb[2]);
        RenderUtils.re(bp, new Color(red, green, blue).getRGB());
    }
    
    private String z(final Block b) {
        int red = 0;
        int green = 0;
        int blue = 0;
        if (b.equals(Blocks.iron_ore)) {
            red = 255;
            green = 255;
            blue = 255;
        }
        else if (b.equals(Blocks.gold_ore)) {
            red = 255;
            green = 255;
        }
        else if (b.equals(Blocks.diamond_ore)) {
            green = 220;
            blue = 255;
        }
        else if (b.equals(Blocks.emerald_ore)) {
            red = 35;
            green = 255;
        }
        else if (b.equals(Blocks.lapis_ore)) {
            green = 50;
            blue = 255;
        }
        else if (b.equals(Blocks.redstone_ore)) {
            red = 255;
        }
        else if (b.equals(Blocks.mob_spawner)) {
            red = 30;
            blue = 135;
        }
        return red + "-" + green + "-" + blue;
    }
    
    static {
        Xray.ores = new ArrayList<Block>();
    }
}
