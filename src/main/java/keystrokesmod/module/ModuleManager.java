// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module;

import keystrokesmod.module.modules.client.AutoConfig;
import keystrokesmod.module.modules.client.Gui;
import keystrokesmod.module.modules.client.SelfDestruct;
import keystrokesmod.module.modules.combat.*;
import keystrokesmod.module.modules.disabled.RodAimbot;
import keystrokesmod.module.modules.disabled.Speed;
import keystrokesmod.module.modules.fun.BarrierTrail;
import keystrokesmod.module.modules.fun.ExtremeBobbing;
import keystrokesmod.module.modules.fun.Spin;
import keystrokesmod.module.modules.minigames.MurderMystery;
import keystrokesmod.module.modules.movement.*;
import keystrokesmod.module.modules.other.WaterBucket;
import keystrokesmod.module.modules.player.FastPlace;
import keystrokesmod.module.modules.player.NoFall;
import keystrokesmod.module.modules.render.*;
import keystrokesmod.module.modules.world.AntiBot;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager
{
    public List<Module> modsList;
    
    public ModuleManager() {
        modsList = new ArrayList<Module>();
    }
    
    public void register() {
        // combat
        this.addModule(new AutoClicker());
        this.addModule(new AimAssist());
        this.addModule(new HitBox());
        this.addModule(new Reach());
        this.addModule(new Velocity());

        // movement
        this.addModule(new Bhop());
        this.addModule(new Boost());
        this.addModule(new Fly());
        this.addModule(new InvMove());
        this.addModule(new Sprint());
        this.addModule(new Timer());

        // player
        this.addModule(new FastPlace());
        this.addModule(new NoFall());

        // world
        this.addModule(new AntiBot());

        // render
        this.addModule(new Chams());
        this.addModule(new ChestESP());
        this.addModule(new PlayerESP());
        this.addModule(new Tracers());
        this.addModule(new HUD());
        this.addModule(new Xray());

        // minigames
        this.addModule(new MurderMystery());

        // fun
        this.addModule(new Spin()); // 1.
        this.addModule(new ExtremeBobbing()); // 2.
        this.addModule(new BarrierTrail()); // 3. 1,2,3 were in the same class idk why

        // other
        this.addModule(new WaterBucket());

        // client
        this.addModule(new AutoConfig());
        this.addModule(new Gui());
        this.addModule(new SelfDestruct());

        // this.addModule(new Speed()); Disabled in raven b2 but class still in jar, idk why
        // this.addModule(new RodAimbot()); Disabled in raven b2 but class still in jar, idk why
    }
    
    private void addModule(final Module m) {
        modsList.add(m);
    }
    
    public List<Module> getMods() {
        return modsList;
    }

    public Module getModule(final Class<? extends Module> a) {
        for (final Module module : getMods()) {
            if (module.getClass() == a) {
                return module;
            }
        }
        return null;
    }
    
    public List<Module> inCategory(final Module.category theCategories) {
        final List<Module> perCategoryModList = new ArrayList<Module>();
        for (final Module mod : this.getMods()) {
            if (mod.moduleCategory().equals(theCategories)) {
                perCategoryModList.add(mod);
            }
        }
        return perCategoryModList;
    }
}
