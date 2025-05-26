package com.ryan.pastamod.datagen;

import com.ryan.pastamod.PastaMod;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider{
        public ModItemModelProvider(PackOutput output, ExistingFileHelper exFileHelper) {
            super(output, PastaMod.MODID, exFileHelper);
    }

    @Override
    protected void registerModels() {
        
    }
}
