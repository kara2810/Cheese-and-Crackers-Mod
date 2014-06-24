package com.kenny2810.CheeseAndCrackers.Block;

import com.kenny2810.CheeseAndCrackers.CheeseAndCrackersMain;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class featherBlock extends Block{

	public featherBlock(Material rock) {
		super(rock);
		setHardness(4.0F); 
		setStepSound(Block.soundTypePiston); 
		setBlockName("Feather Block");
		setCreativeTab(CheeseAndCrackersMain.CheeseAndCrackersTab);
		// TODO Auto-generated constructor stub
	}

}
