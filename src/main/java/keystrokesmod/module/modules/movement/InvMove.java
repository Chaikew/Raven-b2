//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.movement;

import keystrokesmod.module.Module;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;
import net.minecraft.client.gui.GuiChat;

public class InvMove extends Module
{
    public InvMove() {
        super(new char[] { 'I', 'n', 'v', 'M', 'o', 'v', 'e' }, category.movement, 0);
    }
    
    @Override
    public void update() {
        if (InvMove.mc.currentScreen != null) {
            if (InvMove.mc.currentScreen instanceof GuiChat) {
                return;
            }
            final KeyBinding keyBindForward = InvMove.mc.gameSettings.keyBindForward;
            KeyBinding.setKeyBindState(InvMove.mc.gameSettings.keyBindForward.getKeyCode(), Keyboard.isKeyDown(InvMove.mc.gameSettings.keyBindForward.getKeyCode()));
            final KeyBinding keyBindBack = InvMove.mc.gameSettings.keyBindBack;
            KeyBinding.setKeyBindState(InvMove.mc.gameSettings.keyBindBack.getKeyCode(), Keyboard.isKeyDown(InvMove.mc.gameSettings.keyBindBack.getKeyCode()));
            final KeyBinding keyBindRight = InvMove.mc.gameSettings.keyBindRight;
            KeyBinding.setKeyBindState(InvMove.mc.gameSettings.keyBindRight.getKeyCode(), Keyboard.isKeyDown(InvMove.mc.gameSettings.keyBindRight.getKeyCode()));
            final KeyBinding keyBindLeft = InvMove.mc.gameSettings.keyBindLeft;
            KeyBinding.setKeyBindState(InvMove.mc.gameSettings.keyBindLeft.getKeyCode(), Keyboard.isKeyDown(InvMove.mc.gameSettings.keyBindLeft.getKeyCode()));
            final KeyBinding keyBindJump = InvMove.mc.gameSettings.keyBindJump;
            KeyBinding.setKeyBindState(InvMove.mc.gameSettings.keyBindJump.getKeyCode(), Keyboard.isKeyDown(InvMove.mc.gameSettings.keyBindJump.getKeyCode()));
            if (Keyboard.isKeyDown(208) && InvMove.mc.thePlayer.rotationPitch < 90.0f) {
                final EntityPlayerSP thePlayer = InvMove.mc.thePlayer;
                thePlayer.rotationPitch += 4.0f;
            }
            if (Keyboard.isKeyDown(200) && InvMove.mc.thePlayer.rotationPitch > -90.0f) {
                final EntityPlayerSP thePlayer2 = InvMove.mc.thePlayer;
                thePlayer2.rotationPitch -= 4.0f;
            }
            if (Keyboard.isKeyDown(205)) {
                final EntityPlayerSP thePlayer3 = InvMove.mc.thePlayer;
                thePlayer3.rotationYaw += 5.0f;
            }
            if (Keyboard.isKeyDown(203)) {
                final EntityPlayerSP thePlayer4 = InvMove.mc.thePlayer;
                thePlayer4.rotationYaw -= 5.0f;
            }
        }
    }
}
