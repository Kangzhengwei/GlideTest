package com.example.glidetest.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.glidetest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@SuppressLint("NonConstantResourceId")
public class MainActivity extends AppCompatActivity {


    @BindView(R.id.btn_gallery)
    Button btnGallery;
    @BindView(R.id.btn_glide_test)
    Button btnGlideTest;
    @BindView(R.id.btn_HorizontalRVActivity)
    Button btnHorizontalRVActivity;
    @BindView(R.id.btn_ScrollingActivity)
    Button btnScrollingActivity;
    @BindView(R.id.btn_InstenceActivity)
    Button btnInstenceActivity;
    @BindView(R.id.btn_RecyclerViewActivity)
    Button btnRecyclerViewActivity;
    @BindView(R.id.btn_FacebookLinkActivity)
    Button btnFacebookLinkActivity;
    @BindView(R.id.btn_X5webview)
    Button btnX5webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_gallery, R.id.btn_glide_test, R.id.btn_HorizontalRVActivity, R.id.btn_ScrollingActivity, R.id.btn_InstenceActivity, R.id.btn_RecyclerViewActivity, R.id.btn_FacebookLinkActivity, R.id.btn_X5webview,R.id.btn_videoPlay})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_gallery:
                startActivity(new Intent(this, GalleryActivity.class));
                break;
            case R.id.btn_glide_test:
                startActivity(new Intent(this, GlideTestActivity.class));
                break;
            case R.id.btn_HorizontalRVActivity:
                startActivity(new Intent(this, HorizontalRVActivity.class));
                break;
            case R.id.btn_ScrollingActivity:
                startActivity(new Intent(this, ScrollingActivity.class));
                break;
            case R.id.btn_InstenceActivity:
                startActivity(new Intent(this, InstenceActivity.class));
                break;
            case R.id.btn_RecyclerViewActivity:
                startActivity(new Intent(this, RecyclerViewActivity.class));
                break;
            case R.id.btn_FacebookLinkActivity:
                startActivity(new Intent(this, FacebookLinkActivity.class));
                break;
            case R.id.btn_X5webview:
                startActivity(new Intent(this, X5MainActivity.class));
                break;
            case R.id.btn_videoPlay:
                startActivity(new Intent(this,VideoTestActivity.class));
                break;
            case R.id.test_jiaozi:
                startActivity(new Intent(this,VieoPlayActivity.class));
                break;
        }
    }
}