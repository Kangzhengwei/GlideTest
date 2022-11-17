package com.example.glidetest.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.glidetest.R;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.tencent.smtt.sdk.TbsVideo;
import com.tencent.smtt.sdk.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JzvdStd;

public class VideoTestActivity extends AppCompatActivity {

    @BindView(R.id.detail_player)
    StandardGSYVideoPlayer detailPlayer;
    @BindView(R.id.jz_video)
    JzvdStd jzVideo;
    @BindView(R.id.webView)
    WebView webView;

    private String url = "https://v2.88zy.site/20210329/QxXZgi34/index.m3u8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_test);
        ButterKnife.bind(this);
        detailPlayer.setUp(url, true, "测试视频");
        detailPlayer.startPlayLogic();
        jzVideo.setUp(url, "");
        jzVideo.startVideo();
        webView.loadUrl(url);
       // startPlay(url);
    }

    /**
     * 直接调用播放视频
     *
     * @param videoUrl 视频地址
     */
    private void startPlay(String videoUrl) {
        //判断当前是否可用
        if (TbsVideo.canUseTbsPlayer(getApplicationContext())) {
            //播放视频
            TbsVideo.openVideo(getApplicationContext(), videoUrl);
        }
    }
}