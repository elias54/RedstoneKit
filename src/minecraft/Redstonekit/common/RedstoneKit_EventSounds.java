package Redstonekit.common;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RedstoneKit_EventSounds 
{
	@SideOnly(Side.CLIENT)
    @ForgeSubscribe
    public void onSound(SoundLoadEvent event)
    {
        try 
        {
        	
        }
        catch (Exception e)
        {
            System.err.println("Failed to register one or more sounds.");
        }
    }
}
