//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.guis;

import java.io.IOException;

import keystrokesmod.main.ConfigManager;
import keystrokesmod.keystroke.KeyStroke;
import keystrokesmod.keystroke.KeyStrokeClickCounter;
import keystrokesmod.main.Ravenb2;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class KeyStrokeGui extends GuiScreen
{
    private static final String[] keyStrokeColors;
    private GuiButton modButton;
    private GuiButton colorButton;
    private GuiButton showMouseButton;
    private GuiButton outlineButton;
    private boolean d;
    private int lx;
    private int ly;
    
    public KeyStrokeGui() {
        this.d = false;
    }
    
    public void initGui() {
        final KeyStroke st = Ravenb2.getKeyStroke();
        this.buttonList.add(this.modButton = new GuiButton(0, this.width / 2 - 70, this.height / 2 - 28, 140, 20, "Mod: " + (KeyStroke.enabled ? "Enabled" : "Disabled")));
        this.buttonList.add(this.colorButton = new GuiButton(1, this.width / 2 - 70, this.height / 2 - 6, 140, 20, "Text color: " + KeyStrokeGui.keyStrokeColors[KeyStroke.currentColorNumber]));
        this.buttonList.add(this.showMouseButton = new GuiButton(2, this.width / 2 - 70, this.height / 2 + 16, 140, 20, "Show mouse buttons: " + (KeyStroke.showMouseButton ? "On" : "Off")));
        this.buttonList.add(this.outlineButton = new GuiButton(3, this.width / 2 - 70, this.height / 2 + 38, 140, 20, "Outline: " + (KeyStroke.keyStrokeOutline ? "On" : "Off")));
    }
    
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        Ravenb2.getKeyStrokeRenderer().renderKeystrokes();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    protected void actionPerformed(final GuiButton button) {
        final KeyStroke st = Ravenb2.getKeyStroke();
        if (button == this.modButton) {
            KeyStroke.enabled = !KeyStroke.enabled;
            this.modButton.displayString = "Mod: " + (KeyStroke.enabled ? "Enabled" : "Disabled");
        }
        else if (button == this.colorButton) {
            KeyStroke.currentColorNumber = ((KeyStroke.currentColorNumber == 6) ? 0 : (KeyStroke.currentColorNumber + 1));
            this.colorButton.displayString = "Text color: " + KeyStrokeGui.keyStrokeColors[KeyStroke.currentColorNumber];
        }
        else if (button == this.showMouseButton) {
            KeyStroke.showMouseButton = !KeyStroke.showMouseButton;
            this.showMouseButton.displayString = "Show mouse buttons: " + (KeyStroke.showMouseButton ? "On" : "Off");
        }
        else if (button == this.outlineButton) {
            KeyStroke.keyStrokeOutline = !KeyStroke.keyStrokeOutline;
            this.outlineButton.displayString = "Outline: " + (KeyStroke.keyStrokeOutline ? "On" : "Off");
        }
    }
    
    protected void mouseClicked(final int mouseX, final int mouseY, final int button) {
        try {
            super.mouseClicked(mouseX, mouseY, button);
        }
        catch (IOException ignored) {}
        if (button == 0) {
            KeyStrokeClickCounter.increaseLMB();
            final KeyStroke st = Ravenb2.getKeyStroke();
            final int startX = KeyStroke.x;
            final int startY = KeyStroke.y;
            final int endX = startX + 74;
            final int endY = startY + (KeyStroke.showMouseButton ? 74 : 50);
            if (mouseX >= startX && mouseX <= endX && mouseY >= startY && mouseY <= endY) {
                this.d = true;
                this.lx = mouseX;
                this.ly = mouseY;
            }
        }
        if (button == 1) {
            KeyStrokeClickCounter.increaseRMB();
        }
    }
    
    protected void mouseReleased(final int mouseX, final int mouseY, final int action) {
        super.mouseReleased(mouseX, mouseY, action);
        this.d = false;
    }
    
    protected void mouseClickMove(final int mouseX, final int mouseY, final int lastButtonClicked, final long timeSinceMouseClick) {
        super.mouseClickMove(mouseX, mouseY, lastButtonClicked, timeSinceMouseClick);
        if (!this.d) {
            return;
        }
        final KeyStroke st = Ravenb2.getKeyStroke();
        KeyStroke.x = KeyStroke.x + mouseX - this.lx;
        KeyStroke.y = KeyStroke.y + mouseY - this.ly;
        this.lx = mouseX;
        this.ly = mouseY;
    }
    
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    public void onGuiClosed() {
        ConfigManager.sc();
    }
    
    static {
        keyStrokeColors = new String[] { "White", "Red", "Green", "Blue", "Yellow", "Purple", "Rainbow" };
    }
}
