package io.github.natainakata.examplemod.data

import io.github.natainakata.examplemod.data.client.ExampleModItemModelProvider
import io.github.natainakata.examplemod.data.client.lang.ExampleModEnUsLangProvider
import io.github.natainakata.examplemod.data.client.lang.ExampleModJaJpLangProvider
import net.minecraft.data.DataGenerator
import net.minecraftforge.data.event.GatherDataEvent

object ExampleModDataGenerators {

    fun gatherData(event: GatherDataEvent) {
       val gen: DataGenerator = event.generator
        gen.addProvider(event.includeClient(), ExampleModJaJpLangProvider(gen))
        gen.addProvider(event.includeClient(), ExampleModEnUsLangProvider(gen))
        gen.addProvider(event.includeClient(), ExampleModItemModelProvider(gen, event.existingFileHelper))
    }
}
