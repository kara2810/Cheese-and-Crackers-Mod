	package com.kenny2810.CheeseAndCrackers.Items.Cheese;

	import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;

	import com.kenny2810.CheeseAndCrackers.*;

	import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.kenny2810.CheeseAndCrackers.Entities.EntityCracker;

	public class ResistanceCheese extends Item
	{
		public static String modid="CheeseAndCrackers";
	    public ResistanceCheese()
	    {
	        super();
	        setUnlocalizedName("Resistance Cheese");
	        setTextureName(modid + ":" + "cheese");
	        this.maxStackSize = 1;
	        this.setCreativeTab(CheeseAndCrackersMain.CheeseAndCrackersTab);
	    }
	    public void registerIcons(IIconRegister iconRegister)
	    {
	      itemIcon = iconRegister.registerIcon("CheeseAndCrackers:Cheese");
	    }
	    /**
	     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	     */
	    public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag)
	    {
	    	EntityPlayer player = (EntityPlayer) entity;
	    	ItemStack crackerStack = new ItemStack(CheeseAndCrackersMain.ResistanceCheese);
	    	
	    	if(player.getCurrentEquippedItem() != null && (player.getCurrentEquippedItem().isItemEqual(crackerStack))){
	    player.addPotionEffect((new PotionEffect(Potion.resistance.getId(), 1, 4)));
	    
	    }
	    else
	    {
	    player.curePotionEffects(itemstack);
	    }
	    }
	   
	}
	


