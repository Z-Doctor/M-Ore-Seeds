package zdoctor.moreseeds;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import zdoctor.lazymodder.easy.config.EasyConfig;
import zdoctor.moreseeds.proxy.CommonProxy;

@Mod(modid = ModMain.MODID, dependencies = ModMain.DEPENDS, guiFactory = ModMain.CONFIG_GUI)
public class ModMain {
	public static final String MODID = "moreseeds";
	public static final String DEPENDS = "required-after:lazymodder@[0.7,)";
	public static final String CONFIG_GUI = "zdoctor.moreseeds.config.ConfigGuiFactory";
	public static EasyConfig config;

	@SidedProxy(clientSide = "zdoctor.moreseeds.proxy.ClientProxy", serverSide = "zdoctor.moreseeds.proxy.ServerProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		this.proxy.preInit(e);
		config = new EasyConfig(e);
		config.registerBoolean(Constants.GROWCATEGORY, Constants.GROWPEACFUL, false, Constants.GROWPEACFULCOMMENT);
		config.registerBoolean(Constants.GROWCATEGORY, Constants.GROWNETHER, true, Constants.GROWNETHERCOMMENT);
		config.registerBoolean(Constants.GROWCATEGORY, Constants.ALLOWBONEMEAL, false, Constants.ALLOWBONEMEALCOMMENT);

		config.registerBoolean(Constants.LOOTCATEGORY, Constants.SEEDDROP, true, Constants.SEEDDROPCOMMENT);
		config.registerInt(Constants.LOOTCATEGORY, Constants.DIAMONDSEEDCHANCE, 5, 1, 100, Constants.DROPCHANCECOMMENT);
		config.registerInt(Constants.LOOTCATEGORY, Constants.EMERALDSEEDCHANCE, 10, 1, 100,
				Constants.DROPCHANCECOMMENT);
		config.registerInt(Constants.LOOTCATEGORY, Constants.GOLDSEEDCHANCE, 30, 1, 100, Constants.DROPCHANCECOMMENT);
		config.registerInt(Constants.LOOTCATEGORY, Constants.IRONSEEDCHANCE, 40, 1, 100, Constants.DROPCHANCECOMMENT);
		config.getConfig().setCategoryPropertyOrder(Constants.LOOTCATEGORY, Constants.LOOTCATEGORYORDER);

		config.close();
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		// AchievementRegistry.load();
		this.proxy.init(e);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		this.proxy.postInit(e);
	}

}
