package fr.eno.minemongus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.eno.minemongus.network.NetworkManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(References.MOD_ID)
public class MineMongUs
{
	public static NetworkManager NETWORK_INSTANCE;
	public static final Logger LOGGER = LogManager.getLogger(References.MOD_NAME);

	public MineMongUs()
	{
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
	}

	private void commonSetup(final FMLCommonSetupEvent event)
	{
		NETWORK_INSTANCE = new NetworkManager("main_channel");
		NETWORK_INSTANCE.registerMessages();
	}

	private void doClientStuff(final FMLClientSetupEvent event)
	{
	}
}
