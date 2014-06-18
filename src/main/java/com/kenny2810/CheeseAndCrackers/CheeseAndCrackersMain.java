package com.kenny2810.CheeseAndCrackers;

// This Import list will grow longer with each additional tutorial.
// It's not pruned between full class postings, unlike other tutorial code.
import java.util.logging.Logger;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="CheeseAndCrackers", name="Cheese And Crackers", version="1.1.0")
public class CheeseAndCrackersMain 
{
	
	public static Item Cracker;
	public static Item Cheese;
	public static Logger logger;
	 public static int CheeseConfig;
	    public static int CrackerConfig;

	

        @Instance(value="CheeseAndCrackers")
        public static CheeseAndCrackersMain instance;
        
        @SidedProxy(clientSide="com.kenny2810.CheeseAndCrackers.Client.ClientProxy",
                        serverSide="com.kenny2810.CheeseAndCrackers.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler
        	
        	public void preInit(FMLPreInitializationEvent event) {
        	// Configuration goes here.
 
        	
        	Cracker = new ItemCracker(5962).setMaxStackSize(16)
                    .setUnlocalizedName("Cracker");
        	Cheese = new ItemCheese(5963).setMaxStackSize(16)
                    .setUnlocalizedName("Cheese");
            
        }
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
       	
        	//LanguageRegistry.addName(Cracker, "Cracker");
        	GameRegistry.registerItem(Cracker, "Cracker");
        	//LanguageRegistry.addName(Cheese, "Cheese");
        	GameRegistry.registerItem(Cheese, "Cheese");
                
                ItemStack wheatStack = new ItemStack(Items.wheat);
            	ItemStack waterBucketStack = new ItemStack(Items.water_bucket);
            	ItemStack lavaBucketStack = new ItemStack(Items.lava_bucket);
            	ItemStack milkBucketStack = new ItemStack(Items.milk_bucket);
            	ItemStack diamondStack = new ItemStack(Items.diamond);
                
                
                GameRegistry.addShapelessRecipe(new ItemStack(CheeseAndCrackersMain.Cracker, 1),
                        wheatStack, waterBucketStack, diamondStack);
                
                GameRegistry.addShapelessRecipe(new ItemStack(CheeseAndCrackersMain.Cheese, 1),
                		milkBucketStack, lavaBucketStack, diamondStack);
                              
                // End Basic Blocks
                
                proxy.registerRenderers();
        }
        @EventHandler
        public void postInit(FMLPreInitializationEvent e) 
        {
        }
        
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {
                // Stub Method
        }
      
    }

    
   