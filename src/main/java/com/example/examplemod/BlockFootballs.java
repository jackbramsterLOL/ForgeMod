package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumBlockRenderType;

/**
 * Created by Jammer on 14/08/2016.
 */
public class BlockFootballs extends Block {
    public BlockFootballs(Material materialIn) {
        super(materialIn);
//        setRegistryName("ball");
        setUnlocalizedName(ExampleMod.MODID.toLowerCase() + "football");
        setCreativeTab(CreativeTab.tab);
        setDefaultState(this.getDefaultState());
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }
}

