package io.github.natainakata.examplemod.block

import io.github.natainakata.examplemod.ExampleMod
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.Material
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object ExampleModBlocks {
    val REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.ID)

    // the returned ObjectHolderDelegate can be used as a property delegate
    // this is automatically registered by the deferred registry at the correct times
    /*val TEST_BLOCK by REGISTRY.registerObject("test_block") {
         Block(BlockBehaviour.Properties.of(Material.METAL).lightLevel { 15 }.strength(3.0f))
      }
    */
}
