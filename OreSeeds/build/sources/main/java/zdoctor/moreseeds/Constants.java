package zdoctor.moreseeds;

import java.util.Arrays;
import java.util.List;

public class Constants {

	public static final String GROWCATEGORY = "Growing Options";
	
	public static final String GROWPEACFUL = "GrowsInPeaceful";
	public static final String GROWPEACFULCOMMENT = "Whether or not ore crops can grow on peaceful.";
	public static final String GROWNETHER = "OnlyGrowsInNether";
	public static final String GROWNETHERCOMMENT = "Whether or not ore crops that grown on Netherrack only grow in the nether";
	public static final String ALLOWBONEMEAL = "AllowBonemeal";
	public static final String ALLOWBONEMEALCOMMENT = "Whether or not ore crops can use bonemeal";
	
	
	public static final String LOOTCATEGORY = "Loot Options";
	public static final String SEEDDROP = "DropNewSeeds";
	public static final String SEEDDROPCOMMENT = "Whether or not ore crops can drop new seeds.";

	public static final String DIAMONDSEEDCHANCE = "DimandSeedDrop";
	public static final String EMERALDSEEDCHANCE = "EmeraldSeedDrop";
	public static final String GOLDSEEDCHANCE = "GoldSeedDrop";
	public static final String IRONSEEDCHANCE = "IronSeedDrop";
	public static final String DROPCHANCECOMMENT = "Seed Drop Chance";
	public static final List<String> LOOTCATEGORYORDER = Arrays.asList(new String[] {SEEDDROP, DIAMONDSEEDCHANCE, EMERALDSEEDCHANCE, GOLDSEEDCHANCE, IRONSEEDCHANCE});

}
