package tk.zekro.mhkc;

import com.sun.prism.Material;

import net.minecraft.block.BlockCommandBlock;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tk.zekro.mhkc.proxies.mhkc_proxy;
import net.minecraftforge.fml.common.SidedProxy;

//=Annotation
@Mod(modid="mhkc", name="mhkc", version="1.0.1-0047")
public class mhkc {

	@Instance(value="mhkc")
	public static mhkc instance;
	
	//BLÖCKE
	public expBlock zekroBlock;
	public expBlock zekro2Block;
	
	//ITEMS
	expItem zekroItem;
	
	
	@SidedProxy(clientSide="tk.zekro.mhkc.proxies.mhkc_clientproxy", serverSide="tk.zekro.mhkc.proxies.mhkc_proxy")
	public static mhkc_proxy proxy;
	
	
	//Wird vor dem Initialisieren der Mod aufgerufen (Config, Updates usw..)
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {}
	
	//Eigentliches Laden der Mod
	@EventHandler
	public void load(FMLInitializationEvent event) {
		 proxy.registerRenderers();
		 
		 
		 loadBlocks(); //erst Block laden
		 loadItems(); //Läd die Items
		 loadrecepies(); //damit er dann in die Recepies eingeorndet werden kann
		 
		 GameRegistry.registerFuelHandler(new expFuelHandler());
		 
	}
	
	//Weitere Modfuktionen NACH Laden der Mod
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
	//Erstellen einer Methode - i.d.F laden der Recepies
	private void loadrecepies() {
		
		 //Shapeless Crafting Recepies
		 GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 1), Blocks.coal_block, Blocks.coal_block, Blocks.coal_block, Blocks.coal_block, Blocks.coal_block, Blocks.coal_block, Blocks.coal_block, Blocks.coal_block, Blocks.coal_block);
		 
		 //Shaped Crafting Recepies
		 GameRegistry.addShapedRecipe(new ItemStack (Items.diamond, 3),
				 "X  ",
				 " Y ",
				 "  X",
				 Character.valueOf('X'), Blocks.coal_block,
		 		 Character.valueOf('Y'), Items.gold_ingot);
		 GameRegistry.addShapedRecipe(new ItemStack (this.zekroBlock, 1), 
				 "XXX",
				 "XOX",
				 "XXX",
				 Character.valueOf('X'), Items.stick,
				 Character.valueOf('O'), Items.diamond);
		
		 
		 //Schmelzrezepte
		 GameRegistry.addSmelting(new ItemStack(Blocks.coal_block), new ItemStack(Items.diamond, 1), 60.0F);	
	}
	
	//Laden/Registrieren BLÖCKE
	private void loadBlocks() {
		
		//1. expBlock "zekroBlock"
		zekroBlock = new expBlock(net.minecraft.block.material.Material.rock, "zekroBlock", 1.0F, 1.0F, 1, "pickaxe");
		GameRegistry.registerBlock(zekroBlock, "zekroBlock");
		zekroBlock.registerTexture();
		zekroBlock.setCreativeTab(CreativeTabs.tabBlock);
		
		//2. expBlock "zekro2Block"
		zekro2Block = new expBlock(net.minecraft.block.material.Material.wood, "zekro2Block", 1F, 1F, 1F, "axe");
		GameRegistry.registerBlock(zekro2Block, "zekro2Block");
		zekro2Block.registerTexture();
		zekro2Block.setCreativeTab(CreativeTabs.tabBlock);
		
		
	}
	
	//Laden/Registrieren ITEMS
	private void loadItems() {
		
		zekroItem = new expItem("zekroItem");
		zekroItem.setCreativeTab(CreativeTabs.tabMisc);
		
	}
	
}