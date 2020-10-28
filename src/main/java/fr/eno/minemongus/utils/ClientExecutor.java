package fr.eno.minemongus.utils;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.DistExecutor.SafeRunnable;

public class ClientExecutor implements SafeRunnable
{
	private long screenId;
	Minecraft mc = Minecraft.getInstance();

	public ClientExecutor(long screenIdIn)
	{
		this.screenId = screenIdIn;
	}
	
	@Override
	public void run()
	{
	}
}