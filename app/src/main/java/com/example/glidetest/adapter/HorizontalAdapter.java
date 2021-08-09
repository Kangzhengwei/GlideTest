package com.example.glidetest.adapter;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.glidetest.R;
import com.example.glidetest.model.MultiHomeInfo;
import com.example.glidetest.util.Utils;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HorizontalAdapter extends BaseMultiItemQuickAdapter<MultiHomeInfo, BaseViewHolder> {
    public HorizontalAdapter() {
        addItemType(MultiHomeInfo.TYPE_BANNER, R.layout.item_banner);
        addItemType(MultiHomeInfo.TYPE_BANNER_BOTTOM, R.layout.item_banner_bottom);
        addItemType(MultiHomeInfo.TYPE_SINGLE_LINE, R.layout.item_single_line);
        addItemType(MultiHomeInfo.TYPE_COLUMN_LINE, R.layout.item_cloum_line);
        addItemType(MultiHomeInfo.TYPE_CARD_LINE, R.layout.item_card_recycler);
        addItemType(MultiHomeInfo.TYPE_RECOMMEND, R.layout.item_type_one);
    }


    @Override
    protected void convert(@NotNull BaseViewHolder holder, MultiHomeInfo multiHomeInfo) {
        switch (multiHomeInfo.itemType) {
            case MultiHomeInfo.TYPE_BANNER:
                holder.getView(R.id.image);
                break;
            case MultiHomeInfo.TYPE_BANNER_BOTTOM:
                holder.setText(R.id.one, "1");
                break;
            case MultiHomeInfo.TYPE_SINGLE_LINE:
                RecyclerView singleRecycler = holder.getView(R.id.recyclerview);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                singleRecycler.setLayoutManager(layoutManager);
                InstanceAdapter adapter = new InstanceAdapter();
                singleRecycler.setAdapter(adapter);
                adapter.setNewInstance(Utils.setList());
                break;
            case MultiHomeInfo.TYPE_COLUMN_LINE:
                RecyclerView multiRecycler = holder.getView(R.id.recyclerview);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3, LinearLayoutManager.HORIZONTAL, false);
                multiRecycler.setLayoutManager(gridLayoutManager);
                InstanceAdapter adapter1 = new InstanceAdapter();
                multiRecycler.setAdapter(adapter1);
                adapter1.setNewInstance(Utils.setList());
                break;
            case MultiHomeInfo.TYPE_CARD_LINE:
                RecyclerView cardRecycler = holder.getView(R.id.recyclerview);
                LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                cardRecycler.setLayoutManager(layoutManager1);
                CardAdapter adapter2 = new CardAdapter();
                cardRecycler.setAdapter(adapter2);
                adapter2.setNewInstance(Utils.setList());
                break;
            case MultiHomeInfo.TYPE_RECOMMEND:
                holder.setText(R.id.name, "");
                break;
        }
    }
}
