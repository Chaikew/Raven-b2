// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module;

public class ModuleSettings extends ModuleSettingsList
{
    private String n;
    private boolean v;
    
    public ModuleSettings(final char[] n, final boolean v) {
        super(new String(n));
        this.n = new String(n);
        this.v = v;
    }
    
    @Override
    public String get() {
        return this.n;
    }
    
    public boolean isToggled() {
        return this.v;
    }
    
    public void toggle() {
        this.v = !this.v;
    }
    
    public void enable() {
        this.v = true;
    }
    
    public void disable() {
        this.v = false;
    }
    
    public void setEnabled(final boolean b) {
        this.v = b;
    }
}
