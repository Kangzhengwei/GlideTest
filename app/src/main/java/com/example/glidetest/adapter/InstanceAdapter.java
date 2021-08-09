package com.example.glidetest.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.glidetest.R;

import org.jetbrains.annotations.NotNull;

public class InstanceAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public InstanceAdapter() {
        super(R.layout.item_type_one);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, String s) {
        holder.setText(R.id.name, s);
    }
}
