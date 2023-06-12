package io.github.natainakata.examplemod.data.client.lang

import io.github.natainakata.examplemod.ExampleMod
import io.github.natainakata.examplemod.item.ExampleModItems
import net.minecraft.data.DataGenerator
import net.minecraftforge.common.data.LanguageProvider

class ExampleModEnUsLangProvider(gen: DataGenerator) : LanguageProvider(gen, ExampleMod.ID, "en_us") {
    override fun addTranslations() {
       add(ExampleModItems.TEST_INGOT.get(), "Test Ingot")
    }
}
