// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.keystroke;

import java.util.Iterator;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class KeyStrokeClickCounter
{
    private static List<Long> LMB_CPS;
    private static List<Long> RMB_CPS;
    
    public KeyStrokeClickCounter() {
        KeyStrokeClickCounter.LMB_CPS = new ArrayList<Long>();
        KeyStrokeClickCounter.RMB_CPS = new ArrayList<Long>();
    }
    
    @SubscribeEvent
    public void onMouseEvent(final MouseEvent e) {
        if (e.buttonstate) {
            if (e.button == 0) {
                increaseLMB();
            }
            if (e.button == 1) {
                increaseRMB();
            }
        }
    }
    
    public static void increaseLMB() {
        KeyStrokeClickCounter.LMB_CPS.add(System.currentTimeMillis());
    }
    
    public static int getLMB_CPS() {
        final Iterator<Long> lmb_cps = KeyStrokeClickCounter.LMB_CPS.iterator();
        while (lmb_cps.hasNext()) {
            if (lmb_cps.next() < System.currentTimeMillis() - 1000L) {
                lmb_cps.remove();
            }
        }
        return KeyStrokeClickCounter.LMB_CPS.size();
    }
    
    public static void increaseRMB() {
        KeyStrokeClickCounter.RMB_CPS.add(System.currentTimeMillis());
    }
    
    public static int getRMB_CPS() {
        final Iterator<Long> rmb_cps = KeyStrokeClickCounter.RMB_CPS.iterator();
        while (rmb_cps.hasNext()) {
            if (rmb_cps.next() < System.currentTimeMillis() - 1000L) {
                rmb_cps.remove();
            }
        }
        return KeyStrokeClickCounter.RMB_CPS.size();
    }
}
