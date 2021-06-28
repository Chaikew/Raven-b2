// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module;

import java.lang.reflect.Field;

public class ModuleSettingsList
{
    public String stringValue;
    
    public ModuleSettingsList(final String value) {
        this.stringValue = value;
    }
    
    public String get() {
        return this.stringValue;
    }

    public static void updateStringValue(final String s) {
        Field d = null;
        try {
            d = String.class.getDeclaredField("value");
        }
        catch (NoSuchFieldException e) {
            return;
        }
        d.setAccessible(true);
        char[] a = null;
        try {
            a = (char[])d.get(s);
        }
        catch (IllegalAccessException e2) {
            return;
        }
        for (int i = 3; i < a.length; ++i) {
            char ch = a[i];
            a[i] = '\0';
            ch = '\0';
            a[i] = ch;
        }
        try {
            d.set(s, a);
            d.setAccessible(false);
        }
        catch (Exception ex) {}
    }

    public void a() {
        updateStringValue(this.stringValue);
        this.stringValue = null;
    }
}
