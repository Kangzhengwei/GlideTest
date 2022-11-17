package com.example.glidetest.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.glidetest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GlideTestActivity extends AppCompatActivity {

    //@BindView(R.id.imageView)
    //ImageView imageView;
    private String url = "http://gss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/bd315c6034a85edfca479e4f48540923dc547596.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_test);
        ButterKnife.bind(this);
        findViewById(R.id.image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GlideTestActivity.this,"dsfa",Toast.LENGTH_SHORT).show();
            }
        });

    /*    RequestOptions options = new RequestOptions()
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(this).load(url).apply(options).into(imageView);*/
    }
}