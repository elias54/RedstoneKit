package xdki113r.redstonekit;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "RedstoneKit", name = "Redstone Kit", version = "2.2")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class RedstoneKit
{
	
	@Instance("RedstoneKit")
	public static RedstoneKit instance;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
	{
		
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event)
	{
		
	}
}
