package com.example.glidetest.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.glidetest.R;
import com.example.glidetest.gallery.CustomGalleryAdapter;
import com.example.glidetest.gallery.GalleryItemBean;
import com.mengpeng.recyclerviewgallery.CarouselLayoutManager;
import com.mengpeng.recyclerviewgallery.CarouselZoomPostLayoutListener;
import com.mengpeng.recyclerviewgallery.CenterScrollListener;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private String[] pics = {"http://gss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/bd315c6034a85edfca479e4f48540923dc547596.jpg",
            "http://ww2.sinaimg.cn/large/005ImClmjw1ern9ybe83yj30zk0k01cm.jpg",
            "http://b-ssl.duitang.com/uploads/item/201802/13/20180213202427_vcykg.jpg",
            "http://i0.hdslb.com/bfs/article/3de475241c65c721c242f4f3f854fbd115fc0dd0.jpg",
            "http://b-ssl.duitang.com/uploads/item/201410/25/20141025181818_SSvPY.jpeg"};
   private CustomGalleryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        recyclerView = findViewById(R.id.recyclerview);
        //设置横滑
        CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL);
        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addOnScrollListener(new CenterScrollListener());
        //填充数据
        adapter = new CustomGalleryAdapter(getData(), this);
        recyclerView.setAdapter(adapter);
        //分页滑动效果
       /* recyclerView.setOnFlingListener(null);
        new CustomPagerSnapHelper().attachToRecyclerView(recyclerView);
        //滑动动画
        recyclerView.addOnScrollListener(new GalleryOnScrollListener());*/
    }

    private List<GalleryItemBean> getData() {
        List<GalleryItemBean> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            GalleryItemBean itemBean = new GalleryItemBean();
            itemBean.setImage(pics[i]);
            list.add(itemBean);
        }
        return list;
    }
}