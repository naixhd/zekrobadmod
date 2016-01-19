package tk.zekro.mhkc;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class expFuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		
		//Brennzeit 200 Ticks -> 10 Sekunden -> 1 Item Brennen
		
		if( fuel.getItem() == Items.diamond ) {
			return 64*200; //-> Brenndauer 64*1 Item 
		}
		
		
		if ( fuel.getItem() == Item.getItemFromBlock(Blocks.dirt) ) {
			return 1*200;
		}
		
		if ( fuel.getItem() == Item.getItemFromBlock(mhkc.instance.zekroBlock) ) {
			return 64*200;
		}
		
		return 0; /* 0 -> Sonst wüdre jedes Item den Brennwert (z.B.) 200 annehmen bei "return 200;"
				   * "0" -> Weist Item ab!     	
				   */
	}           

	
	
}
