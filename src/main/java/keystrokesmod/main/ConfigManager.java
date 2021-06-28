//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;

import keystrokesmod.module.UpdateModules;
import keystrokesmod.keystroke.KeyStroke;
import keystrokesmod.module.modules.client.Gui;
import keystrokesmod.module.modules.combat.AutoClicker;
import keystrokesmod.module.modules.combat.Reach;
import keystrokesmod.module.modules.combat.Velocity;
import net.minecraft.client.Minecraft;

public class ConfigManager
{
    private static Minecraft mc;
    
    public static void sc() {
        try {
            final File file = new File(ConfigManager.mc.mcDataDir + File.separator + "keystrokesmod", "config");
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            final FileWriter writer = new FileWriter(file, false);
            writer.write(KeyStroke.x + "\n" + KeyStroke.y + "\n" + KeyStroke.currentColorNumber + "\n" + KeyStroke.showMouseButton + "\n" + KeyStroke.enabled + "\n" + KeyStroke.keyStrokeOutline);
            writer.close();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }
    
    public static void lc() {
        try {
            final File file = new File(ConfigManager.mc.mcDataDir + File.separator + "keystrokesmod", "config");
            if (!file.exists()) {
                return;
            }
            final BufferedReader reader = new BufferedReader(new FileReader(file));
            int i = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                switch (++i) {
                    case 1: {
                        KeyStroke.x = Integer.parseInt(line);
                        continue;
                    }
                    case 2: {
                        KeyStroke.y = Integer.parseInt(line);
                        continue;
                    }
                    case 3: {
                        KeyStroke.currentColorNumber = Integer.parseInt(line);
                        continue;
                    }
                    case 4: {
                        KeyStroke.showMouseButton = Boolean.parseBoolean(line);
                        continue;
                    }
                    case 5: {
                        KeyStroke.enabled = Boolean.parseBoolean(line);
                        continue;
                    }
                    case 6: {
                        KeyStroke.keyStrokeOutline = Boolean.parseBoolean(line);
                        continue;
                    }
                    default: {
                        continue;
                    }
                }
            }
            reader.close();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }
    
    public static void sc2() {
        try {
            final File file = new File(ConfigManager.mc.mcDataDir + File.separator + "keystrokes", "config");
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            final FileWriter writer = new FileWriter(file, false);
            writer.write(UpdateModules.theme + "\n" + UpdateModules.r1 + "\n" + UpdateModules.r2 + "\n" + UpdateModules.r3 + "\n" + UpdateModules.r4 + "\n" + UpdateModules.r5 + "\n" + UpdateModules.r6 + "\n" + UpdateModules.r7 + "\n" + UpdateModules.v1 + "\n" + UpdateModules.v2 + "\n" + UpdateModules.v3 + "\n" + UpdateModules.v4 + "\n" + UpdateModules.au1 + "\n" + UpdateModules.au2 + "\n" + UpdateModules.au3 + "\n" + UpdateModules.au4 + "\n" + UpdateModules.au5 + "\n" + UpdateModules.au6 + "\n" + UpdateModules.au7 + "\n" + UpdateModules.au8 + "\n" + UpdateModules.au9);
            writer.close();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }
    
    public static void lc2() {
        try {
            final File file = new File(ConfigManager.mc.mcDataDir + File.separator + "keystrokes", "config");
            if (!file.exists()) {
                return;
            }
            final BufferedReader reader = new BufferedReader(new FileReader(file));
            int i = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                switch (++i) {
                    case 1: {
                        Gui.a.setValue(Double.parseDouble(line));
                        continue;
                    }
                    case 2: {
                        Reach.a.setValue(Double.parseDouble(line));
                        continue;
                    }
                    case 3: {
                        Reach.b.setValue(Double.parseDouble(line));
                        continue;
                    }
                    case 4: {
                        Reach.c.setEnabled(Boolean.parseBoolean(line));
                        continue;
                    }
                    case 5: {
                        Reach.d.setEnabled(Boolean.parseBoolean(line));
                        continue;
                    }
                    case 6: {
                        Reach.e.setEnabled(Boolean.parseBoolean(line));
                        continue;
                    }
                    case 7: {
                        Reach.f.setEnabled(Boolean.parseBoolean(line));
                        continue;
                    }
                    case 8: {
                        Ravenb2.c.getModuleManager().getModule(Reach.class).setbind(Integer.parseInt(line));
                        continue;
                    }
                    case 9: {
                        Velocity.a.setValue(Double.parseDouble(line));
                        continue;
                    }
                    case 10: {
                        Velocity.b.setValue(Double.parseDouble(line));
                        continue;
                    }
                    case 11: {
                        Velocity.c.setValue(Double.parseDouble(line));
                        continue;
                    }
                    case 12: {
                        Ravenb2.c.getModuleManager().getModule(Velocity.class).setbind(Integer.parseInt(line));
                        continue;
                    }
                    case 13: {
                        AutoClicker.a.setValue(Double.parseDouble(line));
                        continue;
                    }
                    case 14: {
                        AutoClicker.b.setValue(Double.parseDouble(line));
                        continue;
                    }
                    case 15: {
                        AutoClicker.c.setValue(Double.parseDouble(line));
                        continue;
                    }
                    case 16: {
                        AutoClicker.d.setEnabled(Boolean.parseBoolean(line));
                        continue;
                    }
                    case 17: {
                        AutoClicker.e.setEnabled(Boolean.parseBoolean(line));
                        continue;
                    }
                    case 18: {
                        AutoClicker.inv.setEnabled(Boolean.parseBoolean(line));
                        continue;
                    }
                    case 19: {
                        AutoClicker.p.setEnabled(Boolean.parseBoolean(line));
                        continue;
                    }
                    case 20: {
                        AutoClicker.q.setEnabled(Boolean.parseBoolean(line));
                        continue;
                    }
                    case 21: {
                        Ravenb2.c.getModuleManager().getModule(AutoClicker.class).setbind(Integer.parseInt(line));
                        continue;
                    }
                    default: {
                        continue;
                    }
                }
            }
            reader.close();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }
    
    static {
        ConfigManager.mc = Minecraft.getMinecraft();
    }
}
