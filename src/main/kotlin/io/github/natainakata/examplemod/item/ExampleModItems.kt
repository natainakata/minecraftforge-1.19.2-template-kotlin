package io.github.natainakata.examplemod.item

import io.github.natainakata.examplemod.ExampleMod
import io.github.natainakata.examplemod.ModCreativeTab
import net.minecraft.world.item.Item
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject

object ExampleModItems {
    val REGISTRY: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.ID)

    val TEST_INGOT: RegistryObject<Item> = REGISTRY.register("test_ingot") {
       Item(Item.Properties().tab(ModCreativeTab))
    }
}
