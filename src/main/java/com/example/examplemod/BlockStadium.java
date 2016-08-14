package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by Jammer on 14/08/2016.
 */
public class BlockStadium extends Block{
        public BlockStadium(Material materialIn) {
            super(materialIn);
//            setRegistryName("stadium");
            setUnlocalizedName(ExampleMod.MODID.toLowerCase() + "stadium");
            setCreativeTab(CreativeTab.tab);
        }

        @Override
        public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
            worldIn.setBlockState(pos.up(), Blocks.GLASS.getDefaultState());
            for (int i = 0; i < 3; i++) {
                worldIn.setBlockState(pos.up(10), Blocks.GLASS.getDefaultState());
                worldIn.setBlockState(pos.up(10).east(i), Blocks.GLASS.getDefaultState());
            }
            int radius = 25;
            for (int tx = -radius; tx < radius + 1; tx++) {
                for (int ty = -radius; ty < radius + 1; ty++) {
                    for (int tz = -radius; tz < radius + 1; tz++) {
                        if (Math.sqrt(Math.pow(tx, 2) + Math.pow(ty, 2) + Math.pow(tz, 2)) <= radius - 2) {
                            BlockPos pos1 = pos.add(tx, ty, tz);
                            IBlockState state = worldIn.getBlockState(pos1);
                            Block block = state.getBlock();
                            if (block != Blocks.BEDROCK) {
                                worldIn.setBlockState(pos1, Blocks.GLASS.getDefaultState(), 3);
                            }
                        }
                    }
                }
            }
            return super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);


        }
}
