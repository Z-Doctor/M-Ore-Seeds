package zdoctor.moreseeds.crops;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import zdoctor.lazymodder.builtin.helpers.BlockFinderHelpers.Scanners;
import zdoctor.lazymodder.easy.builders.RecipeBuilder;
import zdoctor.lazymodder.easy.interfaces.IHaveRecipe;
import zdoctor.moreseeds.Constants;
import zdoctor.moreseeds.ModMain;

public class DiamondCrop extends CropBase implements IHaveRecipe {
	public DiamondCrop() {
		super("DiamondCrop", Items.DIAMOND, Blocks.COAL_BLOCK);
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return ModMain.config.getBoolean(Constants.ALLOWBONEMEAL) && canGrow(worldIn, pos, state, worldIn.isRemote);
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		if (super.canGrow(worldIn, pos, state, isClient)) {
			boolean check1 = ModMain.config.getBoolean(Constants.GROWPEACFUL) ? true
					: worldIn.getDifficulty() != EnumDifficulty.PEACEFUL;
			if (check1)
				return Scanners.checkSurrondingsFor(Blocks.LAVA, worldIn, pos.down(), true);
		}
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		java.util.List<ItemStack> ret = new ArrayList<ItemStack>();
		int age = ((Integer) state.getValue(AGE)).intValue();
		Random rand = world instanceof World ? ((World) world).rand : new Random();

		ret.add(new ItemStack(getSeed(), 1));

		if (age >= 7) {
			ret.add(new ItemStack(Items.DIAMOND, 1));
			if (rand.nextInt(100) + 1 <= ModMain.config.getInt(Constants.DIAMONDSEEDCHANCE)) {
				if (ModMain.config.getBoolean(Constants.SEEDDROP))
					ret.add(new ItemStack(this.getSeed(), 1));
			}
		}
		return ret;
	}

	@Override
	public void addRecipeToList(NonNullList<IRecipe> recipeList) {
		IRecipe recipe = new RecipeBuilder(this.getSeed()).map("ddd", "dnd", "ddd").where('d', Blocks.DIAMOND_BLOCK)
				.where('n', Items.NETHER_STAR).buildShaped();
		recipeList.add(recipe);
	}

}
