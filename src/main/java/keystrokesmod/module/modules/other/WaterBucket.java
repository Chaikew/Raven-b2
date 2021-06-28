//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.other;

import keystrokesmod.module.modules.client.SelfDestruct;
import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleDesc;
import keystrokesmod.module.ModuleHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class WaterBucket extends Module
{
    public static ModuleDesc a;
    private boolean handling;
    
    public WaterBucket() {
        super(new char[] { 'W', 'a', 't', 'e', 'r', ' ', 'B', 'u', 'c', 'k', 'e', 't' }, category.other, 0);
        this.registerSetting(WaterBucket.a = new ModuleDesc("Credits: aycy"));
    }
    
    @SubscribeEvent
    public void onTick(final TickEvent.ClientTickEvent ev) {
        if (ModuleHelper.e() && !SelfDestruct.isDestructed) {
            if (WaterBucket.mc.isGamePaused() || ev.phase == TickEvent.Phase.END) {
                return;
            }
            if (this.inPosition() && this.holdWaterBucket()) {
                this.handling = true;
            }
            if (this.handling) {
                this.mlg();
                if (WaterBucket.mc.thePlayer.onGround || WaterBucket.mc.thePlayer.motionY > 0.0) {
                    this.reset();
                }
            }
        }
    }
    
    private boolean inPosition() {
        if (WaterBucket.mc.thePlayer.motionY < -0.6 && !WaterBucket.mc.thePlayer.onGround && !WaterBucket.mc.thePlayer.capabilities.isFlying && !WaterBucket.mc.thePlayer.capabilities.isCreativeMode && !this.handling) {
            final BlockPos playerPos = WaterBucket.mc.thePlayer.getPosition();
            for (int i = 1; i < 3; ++i) {
                final BlockPos blockPos = playerPos.down(i);
                final Block block = WaterBucket.mc.theWorld.getBlockState(blockPos).getBlock();
                if (block.isBlockSolid((IBlockAccess) WaterBucket.mc.theWorld, blockPos, EnumFacing.UP)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    private boolean holdWaterBucket() {
        if (this.containsItem(WaterBucket.mc.thePlayer.getHeldItem(), Items.water_bucket)) {
            return true;
        }
        for (int i = 0; i < InventoryPlayer.getHotbarSize(); ++i) {
            if (this.containsItem(WaterBucket.mc.thePlayer.inventory.mainInventory[i], Items.water_bucket)) {
                WaterBucket.mc.thePlayer.inventory.currentItem = i;
                return true;
            }
        }
        return false;
    }
    
    private void mlg() {
        final ItemStack heldItem = WaterBucket.mc.thePlayer.getHeldItem();
        if (this.containsItem(heldItem, Items.water_bucket) && WaterBucket.mc.thePlayer.rotationPitch >= 70.0f) {
            final MovingObjectPosition object = WaterBucket.mc.objectMouseOver;
            if (object.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK && object.sideHit == EnumFacing.UP) {
                WaterBucket.mc.playerController.sendUseItem((EntityPlayer) WaterBucket.mc.thePlayer, (World) WaterBucket.mc.theWorld, heldItem);
            }
        }
    }
    
    private void reset() {
        final ItemStack heldItem = WaterBucket.mc.thePlayer.getHeldItem();
        if (this.containsItem(heldItem, Items.bucket)) {
            WaterBucket.mc.playerController.sendUseItem((EntityPlayer) WaterBucket.mc.thePlayer, (World) WaterBucket.mc.theWorld, heldItem);
        }
        this.handling = false;
    }
    
    private boolean containsItem(final ItemStack itemStack, final Item item) {
        return itemStack != null && itemStack.getItem() == item;
    }
}
