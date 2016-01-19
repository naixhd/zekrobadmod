package tk.zekro.mhkc;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.minecart.MinecartCollisionEvent;

public class expBlock extends Block {

	//Construktor, übernahme festgelegter Eigenschaften für alle erstellte Blöcke:
	public expBlock(Material material, String unlocalizedName, float hardness, float resistance, float lightlevel, String tool) {
		super(material);
		
		this.setUnlocalizedName(unlocalizedName);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setLightLevel(lightlevel);
		this.setHarvestLevel(tool, 3);
	}
	
	
	
	//TEXTUREN - Registrieren der eigenen Textur im Item Model Mesher
	public void registerTexture() {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
			.register(Item.getItemFromBlock(this), 0, new ModelResourceLocation("mhkc:" + this.getUnlocalizedName().substring(5)));
	}

}