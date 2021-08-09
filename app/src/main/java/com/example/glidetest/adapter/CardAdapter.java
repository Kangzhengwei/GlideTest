package com.example.glidetest.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.glidetest.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CardAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public CardAdapter() {
        super(R.layout.item_card_layout);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, String s) {

    }
}
