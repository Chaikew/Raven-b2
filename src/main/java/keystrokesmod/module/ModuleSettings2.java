// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module;

import java.math.RoundingMode;
import java.math.BigDecimal;

public class ModuleSettings2 extends ModuleSettingsList
{
    private String n;
    private double v;
    private double a;
    private double m;
    private double i;
    
    public ModuleSettings2(final char[] settingName, final double defaultValue, final double min, final double max, final double intervals) {
        super(new String(settingName));
        this.n = new String(settingName);
        this.v = defaultValue;
        this.m = min;
        this.a = max;
        this.i = intervals;
    }
    
    @Override
    public String get() {
        return this.n;
    }
    
    public double getInput() {
        return r(this.v, 2);
    }
    
    public double geti() {
        return this.m;
    }

    public double geta() {
        return this.a;
    }
    
    public void setValue(double n) {
        n = c(n, this.m, this.a);
        n = Math.round(n * (1.0 / this.i)) / (1.0 / this.i);
        this.v = n;
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
