package com.example.glidetest.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.glidetest.R;
import com.example.glidetest.adapter.HorizontalAdapter;
import com.example.glidetest.model.MultiHomeInfo;
import com.example.glidetest.util.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HorizontalRVActivity extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.animation_view)
    LottieAnimationView animationView;
    @BindView(R.id.btn)
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_r_v);
        ButterKnife.bind(this);
        List<MultiHomeInfo> list = new ArrayList<>();
        list.add(new MultiHomeInfo().setItemType(MultiHomeInfo.TYPE_BANNER));
        list.add(new MultiHomeInfo().setItemType(MultiHomeInfo.TYPE_BANNER_BOTTOM));
        list.add(new MultiHomeInfo().setItemType(MultiHomeInfo.TYPE_SINGLE_LINE));
        list.add(new MultiHomeInfo().setItemType(MultiHomeInfo.TYPE_COLUMN_LINE));
        list.add(new MultiHomeInfo().setItemType(MultiHomeInfo.TYPE_CARD_LINE));
        for (String str : Utils.setList()) {
            list.add(new MultiHomeInfo().setItemType(MultiHomeInfo.TYPE_RECOMMEND).setRecommend(str));
        }

        HorizontalAdapter homeAdapter = new HorizontalAdapter();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = rv.getAdapter().getItemViewType(position);
                if (type == MultiHomeInfo.TYPE_RECOMMEND) {
                    return 1;
                } else {
                    return 3;
                }
            }
        });
        rv.setLayoutManager(gridLayoutManager);
        rv.setAdapter(homeAdapter);
        homeAdapter.setNewInstance(list);
        Map<String, String> map = new HashMap<>();
        map.put("type", "123");
        map.put("mulit", "123564");
        map.put("type", "456789");
        Log.e("HashMap", map.toString());
    }


    @OnClick({R.id.animation_view, R.id.btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.animation_view:
                animationView.setVisibility(View.GONE);
                break;
            case R.id.btn:
                animationView.setVisibility(View.VISIBLE);
                animationView.setAnimation(R.raw.lf30_editor_srnoycvf);
                animationView.playAnimation();
                break;
        }
    }
}