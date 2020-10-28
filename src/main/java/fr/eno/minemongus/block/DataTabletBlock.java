package fr.eno.minemongus.block;

import fr.eno.minemongus.MineMongUs;
import fr.eno.minemongus.network.packets.PacketOpenGui;
import fr.eno.minemongus.tileentity.TileDataTablet;
import fr.eno.minemongus.utils.ServerScreenList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.PacketDistributor;

public class DataTabletBlock extends Block
{
	private final boolean isDownload;
	
	public DataTabletBlock(boolean isDownload)
	{
		super(Block.Properties.create(Material.IRON).doesNotBlockMovement().hardnessAndResistance(9999999).noDrops());
		this.isDownload = isDownload;
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
	{
		if(worldIn.isRemote)
		{
			return ActionResultType.PASS;
		}
		else
		{
			TileEntity tileentity = worldIn.getTileEntity(pos);
			
			if(tileentity instanceof TileDataTablet)
			{
				if(pos.withinDistance(player.getPosition(), 3))
				{
					MineMongUs.NETWORK_INSTANCE.getNetwork().send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) player), new PacketOpenGui(isDownload ? ServerScreenList.DOWNLOAD_SCREEN_ID : ServerScreenList.UPLOAD_SCREEN_ID, pos));
					
					return ActionResultType.SUCCESS;
				}
			}
			
			return ActionResultType.PASS;				
		}
			
	}

	public boolean isDownload()
	{
		return isDownload;
	}
}