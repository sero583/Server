package org.cloudburstmc.server.block.trait.serializer;

import org.cloudburstmc.server.block.BlockState;
import org.cloudburstmc.server.block.BlockTraits;
import org.cloudburstmc.server.block.trait.BlockTrait;
import org.cloudburstmc.server.block.trait.BlockTraitSerializers.TraitSerializer;
import org.cloudburstmc.server.utils.data.StoneSlabType;

import javax.annotation.ParametersAreNonnullByDefault;

import static org.cloudburstmc.server.block.serializer.util.BedrockStateTags.*;

@ParametersAreNonnullByDefault
public class StoneSlabSerializer implements TraitSerializer<StoneSlabType> {

    private static final String[] BEDROCK_TRAITS = {
            TAG_STONE_SLAB_TYPE,
            TAG_STONE_SLAB_TYPE_2,
            TAG_STONE_SLAB_TYPE_3,
            TAG_STONE_SLAB_TYPE_4,
    };

    @Override
    public String getName(BlockState state, BlockTrait<?> blockTrait) {
        StoneSlabType type = state.ensureTrait(BlockTraits.STONE_SLAB_TYPE);
        int index = blockTrait.getIndex(type);

        return BEDROCK_TRAITS[index >> 3];
    }
}
