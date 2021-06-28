// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module;

import java.math.RoundingMode;
import java.math.BigDecimal;

public class ModuleSettings2 extends ModuleSettingsList
{
    private String settingName;
    private double defaultValue;
    private double max;
    private double min;
    private double intervals;
    
    public ModuleSettings2(final char[] settingName, final double defaultValue, final double min, final double max, final double intervals) {
        super(new String(settingName));
        this.settingName = new String(settingName);
        this.defaultValue = defaultValue;
        this.min = min;
        this.max = max;
        this.intervals = intervals;
    }
    
    @Override
    public String get() {
        return this.settingName;
    }
    
    public double getInput() {
        return r(this.defaultValue, 2);
    }
    
    public double geti() {
        return this.min;
    }

    public double geta() {
        return this.max;
    }
    
    public void setValue(double n) {
        n = c(n, this.min, this.max);
        n = Math.round(n * (1.0 / this.intervals)) / (1.0 / this.intervals);
        this.defaultValue = n;
    }
    
    public static double c(double v, final double i, final double a) {
        v = Math.max(i, v);
        v = Math.min(a, v);
        return v;
    }
    
    public static double r(final double v, final int p) {
        if (p < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bd = new BigDecimal(v);
        bd = bd.setScale(p, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
