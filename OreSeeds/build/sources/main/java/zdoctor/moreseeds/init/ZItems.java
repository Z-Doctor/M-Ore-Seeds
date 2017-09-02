package zdoctor.moreseeds.init;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import zdoctor.lazymodder.builtin.helpers.PotionHelper;
import zdoctor.lazymodder.easy.items.EasyFood;
import zdoctor.moreseeds.crops.DiamondCrop;
import zdoctor.moreseeds.crops.EmeraldCrop;
import zdoctor.moreseeds.crops.GoldCrop;
import zdoctor.moreseeds.crops.IronCrop;
import zdoctor.moreseeds.crops.StrawberryCrop;

public class ZItems {
	public static Item diamondSeed;
	public static Item emeraldSeed;
	public static Item goldSeed;
	public static Item ironSeed;
	public static EasyFood strawberry;
	public static Item strawberrySeed;

	public static void preInit() {
		diamondSeed = new DiamondCrop().getSeed();
		emeraldSeed = new EmeraldCrop().getSeed();
		goldSeed = new GoldCrop().getSeed();
		ironSeed = new IronCrop().getSeed();
		
		strawberry = new EasyFood("Strawberry", 1, 0.3F, false) {
			int potionDur = 6;
			
			@Override
			protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
				Random rand = new Random();
				int num = rand.nextInt(21);
				if(num > 15 && !world.isRemote)
					player.addPotionEffect(new PotionEffect(PotionHelper.SPEED, this.potionDur*20));
				super.onFoodEaten(stack, world, player);
			}
		};
		
		strawberrySeed = new StrawberryCrop().getSeed();
	}
}
