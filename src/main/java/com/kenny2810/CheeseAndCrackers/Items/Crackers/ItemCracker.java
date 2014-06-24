package com.kenny2810.CheeseAndCrackers.Items.Crackers;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;



import com.kenny2810.CheeseAndCrackers.CheeseAndCrackersMain;
import com.kenny2810.CheeseAndCrackers.Entities.EntityCracker;

public class ItemCracker extends ItemFood
{
	public static String modid="CheeseAndCrackers";
    public ItemCracker(int healamount ,boolean feedtoanimals)
    {
        super(healamount, feedtoanimals);
        setUnlocalizedName("Cracker");
        setTextureName(modid + ":" + "Cracker");
        this.maxStackSize = 64;
        this.setCreativeTab(CheeseAndCrackersMain.CheeseAndCrackersTab);
    }
    public void registerIcons(IIconRegister iconRegister)
    {
      itemIcon = iconRegister.registerIcon("CheeseAndCrackers:Cracker");
    }
    
   
}
