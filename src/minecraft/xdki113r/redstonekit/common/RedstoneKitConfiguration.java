package xdki113r.redstonekit.common;

import java.io.File;
import java.net.URL;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class RedstoneKitConfiguration extends Configuration
{
	public RedstoneKitConfiguration(File file)
	{
		super(file);
	}

	public void forceCheckVersionOrEatMothercard(URL url, File file, String s)
	{
		s = "COMING SOON !";
	}

}
