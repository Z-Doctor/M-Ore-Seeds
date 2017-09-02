package zdoctor.moreseeds.config;

import java.util.Random;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import zdoctor.lazymodder.easy.config.EasyConfig;
import zdoctor.lazymodder.easy.config.EasyConfigGui;
import zdoctor.moreseeds.ModMain;

public class ConfigGuiFactory extends EasyConfigGui {
	public ConfigGuiFactory() {
	}
	
	public ConfigGuiFactory(FMLPreInitializationEvent e) {
		super(e, "Default");
	}
	
	@Override
	public String getTitle() {
		return getRandomGreeting();
	}
	
	public String getRandomGreeting() {
		Random msg = new Random();
		switch (msg.nextInt(11)) {
		case 0:
			return "You want to do what to my config?";
		case 1:
			return "Was this text always here?";
		case 3:
			return "... Oh sorry, didn't see you come in.";
		case 4:
			return "Do I amuse you?";
		case 5:
			return "I'm so lonely. :(";
		case 6:
			return "Your back! :D";
		case 7:
			return "Can I take your order?";
		case 8:
			return "Hello there. want to see my config. ;)";
		case 9:
			return "Nope, I'm not magic. I was just born this way.";
		case 10:
			return "Why you no check for update! D:<";
		default:
			return "How did you see this text?";
		}
	}

	@Override
	public EasyConfig getEasyConfig() {
		return ModMain.config;
	}
}
