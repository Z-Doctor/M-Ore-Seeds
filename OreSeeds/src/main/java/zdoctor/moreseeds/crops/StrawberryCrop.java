package zdoctor.moreseeds.crops;

import java.util.List;
import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import zdoctor.lazymodder.builtin.helpers.LootHelper;
import zdoctor.lazymodder.easy.blocks.EasyBlockCrops;
import zdoctor.lazymodder.easy.builders.RecipeBuilder;
import zdoctor.lazymodder.easy.interfaces.IHaveRecipe;
import zdoctor.moreseeds.init.ZItems;

public class StrawberryCrop extends CropBase implements IHaveRecipe {
	public StrawberryCrop() {
		super("StrawberryCrop", ZItems.strawberry);
		setVanilaGrowthConditionsFlags(EasyBlockCrops.ConditionFlags.ALL);
		LootHelper.addGrassDrop(new ItemStack(ZItems.strawberry), 4);
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> ret = new java.util.ArrayList<ItemStack>();
		int age = ((Integer) state.getValue(AGE)).intValue();
		Random rand = world instanceof World ? ((World) world).rand : new Random();
		if (age >= 7) {
			ret.add(new ItemStack(ZItems.strawberry, 4));
		}
		return ret;
	}

	@Override
	public void addRecipeToList(NonNullList<IRecipe> recipeList) {
		IRecipe recipe = new RecipeBuilder(this.getSeed()).map("s").where('s', ZItems.strawberry).buildShapeless();
		recipeList.add(recipe);
	}

}
