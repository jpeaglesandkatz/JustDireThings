package com.direwolf20.justdirethings.common.network.data;

import com.direwolf20.justdirethings.JustDireThings;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record ExperienceHolderPayload(
        boolean add,
        int levels
) implements CustomPacketPayload {
    public static final Type<ExperienceHolderPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(JustDireThings.MODID, "experience_holder"));

    @Override
    public Type<ExperienceHolderPayload> type() {
        return TYPE;
    }

    public static final StreamCodec<FriendlyByteBuf, ExperienceHolderPayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.BOOL, ExperienceHolderPayload::add,
            ByteBufCodecs.INT, ExperienceHolderPayload::levels,
            ExperienceHolderPayload::new
    );
}