package fr.eno.minemongus.network.packets;

import java.util.function.Supplier;

import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.NetworkEvent.Context;

public class PacketOpenGui
{
	private long screenId;
	private BlockPos pos;

	public PacketOpenGui(long screenIdIn, BlockPos posIn)
	{
		this.screenId = screenIdIn;
		this.pos = posIn;
	}
	
	public static void encode(PacketOpenGui msg, PacketBuffer buf)
	{
		buf.writeLong(msg.screenId);
		buf.writeBlockPos(msg.pos);
	}
	
	public static PacketOpenGui decode(PacketBuffer buf)
	{
		long id = buf.readLong();
		BlockPos pos = buf.readBlockPos();
		
		return new PacketOpenGui(id, pos);
	}
	
	public static void handle(PacketOpenGui msg, Supplier<Context> ctx)
	{
		
	}	
}