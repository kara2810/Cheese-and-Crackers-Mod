	package com.kenny2810.CheeseAndCrackers.Items.Crackers;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.kenny2810.CheeseAndCrackers.CheeseAndCrackersMain;
import com.kenny2810.CheeseAndCrackers.Entities.EntityCracker;

	public class CrackerFromHell extends Item
	{
		public static String modid="CheeseAndCrackers";
	    public CrackerFromHell()
	    {
	        super();
	        setUnlocalizedName("The Cracker from Hell");
	        setTextureName(modid + ":" + "cracker");
	        this.maxStackSize = 1;
	        this.setCreativeTab(CheeseAndCrackersMain.CheeseAndCrackersTab);;
	    }
	    public void registerIcons(IIconRegister iconRegister)
	    {
	      itemIcon = iconRegister.registerIcon("CheeseAndCrackers:cracker");
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
	            par2World.spawnEntityInWorld(new EntityCracker(par2World, par3EntityPlayer));
	        }

	        return par1ItemStack;
	    }
	   
	    public boolean hitEntity(ItemStack stack, EntityLivingBase hitEntity, EntityLivingBase attackingEntity) {
	            hitEntity.travelToDimension(-1);
	            return true;
	    }
	}
	


