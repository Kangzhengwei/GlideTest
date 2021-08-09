package com.example.glidetest.widget;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public abstract class TypeAbstractViewHolder<T> extends RecyclerView.ViewHolder{

    public TypeAbstractViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindHolder(T model);
}
