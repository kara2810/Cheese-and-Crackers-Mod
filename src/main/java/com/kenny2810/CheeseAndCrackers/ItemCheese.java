package com.kenny2810.CheeseAndCrackers;


import CheeseAndCrackers.Entities.EntityCheese;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;

public class ItemCheese extends Item
{
    public ItemCheese(int par1)
    {
        super(par1);
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.tabMisc);
    }
    public void registerIcons(IconRegister iconRegister)
    {
      itemIcon = iconRegister.registerIcon("cheeseandcrackers:Cheese");
    }
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }

        par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!par2World.isRemote)
        {
            par2World.spawnEntityInWorld(new EntityCheese(par2World, par3EntityPlayer));
        }

        return par1ItemStack;
    }
    public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag)
    {
    	EntityPlayer player = (EntityPlayer) entity;
    if(player.getCurrentEquippedItem() !=null && player.getCurrentEquippedItem().itemID == this.itemID)
    {
    player.addPotionEffect((new PotionEffect(Potion.field_76444_x.getId(), 3, 4)));
    player.addPotionEffect((new PotionEffect(Potion.regeneration.getId(), 3, 4)));
    player.addPotionEffect((new PotionEffect(Potion.resistance.getId(), 3, 4)));
    }
    else
    {
    player.curePotionEffects(itemstack);
    }
    }
}



