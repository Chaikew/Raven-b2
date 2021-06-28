//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.keystroke;

import keystrokesmod.main.Ravenb2;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.CommandBase;

public class KeyStrokeCommand extends CommandBase
{
    public String getCommandName() {
        return "keystrokesmod";
    }
    
    public void processCommand(final ICommandSender sender, final String[] args) {
        Ravenb2.enableKeyStroke();
    }
    
    public String getCommandUsage(final ICommandSender sender) {
        return "/keystrokesmod";
    }
    
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    public boolean canCommandSenderUseCommand(final ICommandSender sender) {
        return true;
    }
}
