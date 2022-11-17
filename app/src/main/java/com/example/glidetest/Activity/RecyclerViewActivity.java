package com.example.glidetest.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.glidetest.R;
import com.example.glidetest.adapter.DemoAdapter;
import com.example.glidetest.model.DataModeOne;
import com.example.glidetest.model.DataModeThree;
import com.example.glidetest.model.DataModeTwo;
import com.example.glidetest.model.DataModel;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DemoAdapter mAdapter;

    int colors[] = {android.R.color.holo_red_dark,
            android.R.color.holo_blue_dark,
            android.R.color.holo_orange_dark};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.recyclerview);
        initUI();
    }

    private void initUI() {
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                //得到每个type的值
                int type = recyclerView.getAdapter().getItemViewType(position);
                if (type == DataModel.TYPE_THREE) {
                    return 4;
                } else if (type == DataModel.TYPE_TWO) {
                    return 4;
                } else {
                    return 4;
                }
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        mAdapter = new DemoAdapter(this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                GridLayoutManager manager = (GridLayoutManager) recyclerView.getLayoutManager();
                int position = manager.findLastVisibleItemPosition();
                int count = mAdapter.getItemCount();
                if (position + 3 >= count && dy > 0) {//最后两条数据，有下一页，向下滑动，请求间隔大于两毫秒
                    Log.e("TAG", "refresh");
                }
            }
        });
        initData();
    }


    /**
     * 此处主要是模拟数据。方便我们测试
     */
    private void initData() {
        //创建三个数据集合来模拟数据的展示
        ArrayList<DataModeOne> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DataModeOne data = new DataModeOne();
            data.avatarColor = colors[0];
            data.name = "name : " + 1;
            list1.add(data);
        }

        ArrayList<DataModeTwo> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DataModeTwo data = new DataModeTwo();
            data.avatarColor = colors[1];
            data.name = "name : " + 1;
            data.content = "content";
            list2.add(data);
        }

        ArrayList<DataModeThree> list3 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DataModeThree data = new DataModeThree();
            data.avatarColor = colors[2];
            data.name = "name : " + 1;
            data.content = "content";
            data.contentColor = colors[2];
            list3.add(data);
        }

        /**
         * 把数据添加到Adapter中去
         */
        mAdapter.addList(list1, list2, list3);
        mAdapter.notifyDataSetChanged();
    }
}