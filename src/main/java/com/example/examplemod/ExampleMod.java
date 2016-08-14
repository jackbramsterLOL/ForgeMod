package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod {
    public static final String MODID = "forgemod";
    public static final String VERSION = "1.0";
    public static Block football;
    public static Block stadium;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
        football = new BlockFootballs(Material.DRAGON_EGG);
        registerBlock(football, "football");

        stadium = new BlockStadium(Material.ANVIL);
        registerBlock(stadium, "stadium");

        registerItemModel(football,0);
        registerItemModel(stadium,0);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    static void registerBlock(Block block, String name)
    {
        block.setRegistryName(name);
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block), block.getRegistryName());
    }

    static void registerItemModel(Item i, int meta) {
        ResourceLocation loc = i.getRegistryName();
        ModelLoader.setCustomModelResourceLocation(i, meta, new ModelResourceLocation(loc, "inventory"));
    }

    static void registerItemModel(Block b, int meta)
    {
        registerItemModel(Item.getItemFromBlock(b), meta);
    }
}