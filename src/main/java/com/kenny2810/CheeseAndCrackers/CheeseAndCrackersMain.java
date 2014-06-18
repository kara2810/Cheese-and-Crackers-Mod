package com.kenny2810.CheeseAndCrackers;

// This Import list will grow longer with each additional tutorial.
// It's not pruned between full class postings, unlike other tutorial code.
import java.util.logging.Logger;

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

@Mod(modid="CheeseAndCrackers", name="Cheese And Crackers", version="1.0.0")
public class CheeseAndCrackersMain 
{
	
	public static Item Cracker;
	public static Item Cheese;
	public static Logger logger;
	 public static int CheeseConfig;
	    public static int CrackerConfig;

	

        @Instance(value="CheeseAndCrackers")
        public static CheeseAndCrackersMain instance;
        
        @SidedProxy(clientSide="CheeseAndCrackers.main.client.ClientProxy",
                        serverSide="CheeseAndCrackers.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler
        	
        	public void preInit(FMLPreInitializationEvent event) {
        		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
        		
        		cfg.load();
        		
        		CheeseConfig = cfg.getItem("Cheese", 4585).getInt() - 256;
	            CrackerConfig = cfg.getItem("Cracker", 4586).getInt() - 256;
        		
        		
        		cfg.save();
        	

        	// Configuration goes here.
 
        	
        	Cracker = new ItemCracker(5962).setMaxStackSize(16)
                    .setUnlocalizedName("Cracker");
        	Cheese = new ItemCheese(5963).setMaxStackSize(16)
                    .setUnlocalizedName("Cheese");
            
        }
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
       	
        	LanguageRegistry.addName(Cracker, "Cracker");
        	GameRegistry.registerItem(Cracker, "Cracker");
        	LanguageRegistry.addName(Cheese, "Cheese");
        	GameRegistry.registerItem(Cheese, "Cheese");
                
                ItemStack wheatStack = new ItemStack(Item.wheat);
            	ItemStack waterBucketStack = new ItemStack(Item.bucketWater);
            	ItemStack lavaBucketStack = new ItemStack(Item.bucketLava);
            	ItemStack milkBucketStack = new ItemStack(Item.bucketMilk);
            	ItemStack diamondStack = new ItemStack(Item.diamond);
                
                
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

    
   