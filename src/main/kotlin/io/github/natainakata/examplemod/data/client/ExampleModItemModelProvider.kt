package io.github.natainakata.examplemod.data.client

import io.github.natainakata.examplemod.ExampleMod
import io.github.natainakata.examplemod.item.ExampleModItems
import net.minecraft.data.DataGenerator
import net.minecraftforge.client.model.generators.ItemModelProvider
import net.minecraftforge.common.data.ExistingFileHelper

class ExampleModItemModelProvider(gen: DataGenerator, existFile: ExistingFileHelper): ItemModelProvider(gen, ExampleMod.ID, existFile) {
    override fun registerModels() {
        basicItem(ExampleModItems.TEST_INGOT.get())
    }
}
