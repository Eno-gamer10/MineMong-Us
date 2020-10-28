package fr.eno.minemongus.network;

import fr.eno.minemongus.References;
import fr.eno.minemongus.network.packets.PacketOpenGui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class NetworkManager
{
	private static final String PROTOCOL_VERSION = Integer.toString(1);
	private final SimpleChannel network;
	
	public NetworkManager(String channelName)
	{		
		this.network = NetworkRegistry.ChannelBuilder
				.named(new ResourceLocation(References.MOD_ID, channelName))
				.clientAcceptedVersions(PROTOCOL_VERSION::equals)
				.serverAcceptedVersions(PROTOCOL_VERSION::equals)
				.networkProtocolVersion(() -> PROTOCOL_VERSION)
				.simpleChannel();;
	}

	public void registerMessages()
	{
		int disc = 0;
		
		this.network.registerMessage(disc++, PacketOpenGui.class, PacketOpenGui::encode, PacketOpenGui::decode, PacketOpenGui::handle);
	}
	
	public SimpleChannel getNetwork()
	{
		return network;
	}
}