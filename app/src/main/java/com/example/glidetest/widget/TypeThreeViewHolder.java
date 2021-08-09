package com.example.glidetest.widget;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.glidetest.model.DataModeThree;
import com.example.glidetest.R;

public class TypeThreeViewHolder extends TypeAbstractViewHolder<DataModeThree> {

    public ImageView avatar;
    public TextView name;
    public TypeThreeViewHolder(View itemView) {
        super(itemView);
        avatar = (ImageView)itemView.findViewById(R.id.avatar);
        name = (TextView)itemView.findViewById(R.id.name);
        itemView.setBackgroundColor(Color.BLACK);
    }
    @Override
    public void bindHolder(DataModeThree model){
        avatar.setBackgroundResource(model.avatarColor);
        name.setText(model.name);
    }
}