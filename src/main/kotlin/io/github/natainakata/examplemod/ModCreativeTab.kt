package io.github.natainakata.examplemod

import io.github.natainakata.examplemod.item.ExampleModItems
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack

object ModCreativeTab : CreativeModeTab(CreativeModeTab.TABS.size, "examplemod") {
    override fun makeIcon(): ItemStack {
        return ItemStack(ExampleModItems.TEST_INGOT.get())
    }
}
