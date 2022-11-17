package com.example.glidetest.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glidetest.R;
import com.example.glidetest.adapter.InstanceAdapter;
import com.example.glidetest.util.Utils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InstenceActivity extends AppCompatActivity {

    List<String> list;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instence);
        ButterKnife.bind(this);
        list = Utils.setList();
        Button button = findViewById(R.id.button);
        refreshLayout.setEnableLoadMore(true);
        refreshLayout.setEnableRefresh(true);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add("789");
                list.add("456");
                Log.e("1223", Utils.list.toString());
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        InstanceAdapter adapter = new InstanceAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setNewInstance(list);

    }
}