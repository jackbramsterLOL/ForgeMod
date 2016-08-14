package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Jammer on 14/08/2016.
 */
public class CreativeTab extends CreativeTabs {

    public static CreativeTab tab = new CreativeTab();

    public CreativeTab() {
        super("FootballMod");
    }

    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(ExampleMod.football);
    }
}

