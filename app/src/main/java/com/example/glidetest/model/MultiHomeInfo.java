package com.example.glidetest.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class MultiHomeInfo implements MultiItemEntity {

    public static final int TYPE_BANNER = 1;
    public static final int TYPE_BANNER_BOTTOM = 2;
    public static final int TYPE_SINGLE_LINE = 3;
    public static final int TYPE_COLUMN_LINE = 4;
    public static final int TYPE_CARD_LINE = 5;
    public static final int TYPE_RECOMMEND = 6;

    public int itemType;

    public String recommend;

    public MultiHomeInfo setRecommend(String recommend) {
        this.recommend = recommend;
        return this;
    }

    public MultiHomeInfo setItemType(int itemType) {
        this.itemType = itemType;
        return this;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
