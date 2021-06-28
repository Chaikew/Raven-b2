package keystrokesmod.module.modules.fun;

import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleSettings2;
import net.minecraft.client.entity.EntityPlayerSP;

public class ExtremeBobbing extends Module
{
    public static ModuleSettings2 level;
    private boolean b;

    public ExtremeBobbing() {
        super(new char[] { 'E', 'x', 't', 'r', 'e', 'm', 'e', ' ', 'B', 'o', 'b', 'b', 'i', 'n', 'g' }, category.fun, 0);
        this.registerSetting(ExtremeBobbing.level = new ModuleSettings2(new char[] { 'L', 'e', 'v', 'e', 'l' }, 0.1, 0.05, 2.5, 0.05));
    }

    @Override
    public void onEnable() {
        if (!(this.b = ExtremeBobbing.mc.gameSettings.viewBobbing)) {
            ExtremeBobbing.mc.gameSettings.viewBobbing = true;
        }
    }

    @Override
    public void onDisable() {
        ExtremeBobbing.mc.gameSettings.viewBobbing = this.b;
    }

    @Override
    public void update() {
        if (!ExtremeBobbing.mc.gameSettings.viewBobbing) {
            ExtremeBobbing.mc.gameSettings.viewBobbing = true;
        }
        if (ExtremeBobbing.mc.thePlayer.movementInput.moveForward != 0.0f || ExtremeBobbing.mc.thePlayer.movementInput.moveStrafe != 0.0f) {
            final EntityPlayerSP thePlayer = ExtremeBobbing.mc.thePlayer;
            thePlayer.cameraYaw += (float) ExtremeBobbing.level.getInput();
        }
    }
}