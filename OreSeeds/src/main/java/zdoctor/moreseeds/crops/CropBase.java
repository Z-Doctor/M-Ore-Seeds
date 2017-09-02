package zdoctor.moreseeds.crops;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zdoctor.lazymodder.easy.blocks.EasyBlockCrops;

public class CropBase extends EasyBlockCrops {
	public CropBase(String name, Item crop) {
		this(name, crop, Blocks.FARMLAND);
	}
	
	public CropBase(String name, Item crop, Block farmLand) {
		this(name, crop, farmLand, Material.PLANTS);
	}

	public CropBase(String name, Item crop, Block farmLand, Material material) {
		super(name, crop, farmLand, material);
		setVanilaGrowthConditionsFlags();
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (canGrow(worldIn, pos, state, worldIn.isRemote))
			super.updateTick(worldIn, pos, state, rand);
	}
	

	@Override
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
		return (isFullGrown(state) || canGrow(worldIn, pos, state, worldIn.isRemote)) && getFarmLand() == worldIn.getBlockState(pos.down()).getBlock();
	}
	
	// Have to override this other wise it wont build. dont know why
	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return !this.isMaxAge(state);
	}
	
}