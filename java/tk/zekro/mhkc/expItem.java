package tk.zekro.mhkc;

import ibxm.Player;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class expItem extends Item {

	public expItem(String unlocalizedName) {
		super();
		this.setUnlocalizedName(unlocalizedName);	
		
		GameRegistry.registerItem(this, "zekroItem"); 
		/*   OPTIONAL: (zu GameRegistry.registerItem(zekroItem, "zekroItem");)
		 *   GameRegistry.registerItem(this, this.getUnlocalizedName().substring(5));
		 *   									                       -> "substring(5)" entfernt das "tile.".
		 */
		
		this.registerTexture();
		
	}
	
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		
		playerIn.setFire(5);
		
		return itemStackIn;
	}
	
	public void registerTexture() {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("mhkc:" + getUnlocalizedName().substring(5), "inventory"));
		
		
	}
	
}
