// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module;

public class ModuleDesc extends ModuleSettingsList
{
    private String t;
    
    public ModuleDesc(final String t) {
        super(t);
        this.t = t;
    }
    
    public String getDesc() {
        return this.t;
    }
    
    public void setDesc(final String t) {
        this.t = t;
    }
}
