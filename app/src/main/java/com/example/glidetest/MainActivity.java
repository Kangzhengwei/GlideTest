package com.example.glidetest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.glidetest.gallery.GalleryActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    String url = "https://storage.cloud.google.com/vnovel/avatar/202104/e63b7c122ae274e45cef8a2cdac81e21.jpeg";
    //String url = "https://c-ssl.duitang.com/uploads/item/202007/01/20200701063944_5VaBk.jpeg";
    //String url="https://00f74ba44bb95592912b73a9a5336246e0a9c4db53-apidata.googleusercontent.com/download/storage/v1/b/vnovel/o/avatar%2F202104%2Fe63b7c122ae274e45cef8a2cdac81e21.jpeg?jk=AFshE3WwB3xmFVQBtNaKUxWNczhtVOY4F-3ekMF0ZJquQT0K9Csl25AXDMzOe_ryIA79xxXCfFRf-cZ1U6uuR3kxOxGhJnLxed1mVezMwAOXc0DXGEPk0M3vq41rkWihIuk67hA0fxLQu0jVIBNO9jCsl2H2NVLBqmA5r6tkpvf6pJx91b_2b_zo0muU3uwsr_NwJYvtHxzndXTT4wOLxTm7vy43nDlkA9S-NJlqFZQhZEwQ3uSun9Y8QsBEczGPHYk5iwzlza_EuRolb_siZJRIWY6UE1ScpbSBwqZIN7wRhzMn29fcUQhrvSyGTT8r-xg_o2pO0Ypm3Ok1yGaofTBnwd3s5EeGSvSuLcrwTibp5KbGI__979lQEYXfn7swd8prxCQpbL3RD8VeN_FEDd1nFunG_9nXIjthWOzuWLc4JJNAPdMvt2CoCGVzEgeAJe9kNqAPzuSfCKWQPwGrOOq-5MFra62c90eSzDMsegVxZWarYp_QikeSqTRnvvVLAN_Bvpn0UO-R2C5Xj1EY9Okl5wZV5tcLlvAKs9oDPdxR1ZFmhGv6b5tWmJOihP4FOXW3Hd_0TWYR9KVpK6Ef6K3d8TTss_B3g32UzFrVNaq64mipFr5p4qU29YqzZ6-HdxkJEuyw-AS6sX6x9vBbX2rRRQxJaxPsNcNoWpt8Q4XQT9iJ6Rq95XCEy5ze_GW4JRcUmeszzl8Z35S0VKatWuR8ud54Awc9ty4uCk4GQArqgCQn44rIxXfc07ujpGu71AVGjRu_7NUh_P-WO1T81GJAab8zgUhowoIlnCRlxZbDh70oam1hYWXKtzvwnON0vHXbNY7DEnJpUzB598yVUUipMM6R-sYZOr3bJskxy1clRYtcSEYkHlFjH12DWwFUh3PagFexXu89-4-TOT3tJp-yWLC9eeka4hWdWo7XBy-6R0d-kXXrzhvp_Gq2zuubTxffqZTzzjAgJHdFhmBMJKZfh6pNs3fHypdFzNlWEU_ySqgdkJ2wjg&isca=1";
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        RequestOptions options = new RequestOptions()
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        btn = findViewById(R.id.btn_gallery);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
                startActivity(intent);
            }
        });
        //Glide.with(this).load(url).apply(options).into(imageView);
        //GlideApp.with(this).load(url).apply(options).into(imageView);
    }
}