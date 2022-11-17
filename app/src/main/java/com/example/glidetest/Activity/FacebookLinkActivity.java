package com.example.glidetest.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.example.glidetest.R;
import com.lzx.starrysky.SongInfo;
import com.lzx.starrysky.StarrySky;

import java.io.IOException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class FacebookLinkActivity extends AppCompatActivity {

    //WebView webView;
    Button btn;
    private AudioManager audioManager;

    private String uri = "fb://profile/103085035341194";
    private String url = "https://www.facebook.com/VNovel-Webnovels-Fun-103085035341194";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_link);
        // webView=findViewById(R.id.webview);
        btn = findViewById(R.id.btn);
        //webView.loadUrl("file:///android_asset/testLink.html");
        btn.setOnClickListener(v -> intentToFaceBook(uri, url));
        String url = "https://asset.vnovel.us/chapter_mp3/b634d1c6fb3a6aaa56d2a4b5c08f01c0.mp3";
      /*  SongInfo info=new SongInfo();
        info.setSongId("123456");
        info.setSongUrl(url);
        StarrySky.with().playMusicByInfo(info);*/
        //initMediaPlayer();
        //test();
    }

    public boolean intentToFaceBook(String fbUrl, String webUrl) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        try {
            if (!TextUtils.isEmpty(fbUrl)) {
                if (isPackageExisted(this, "com.facebook.katana")) {
                    intent.setData(Uri.parse(getFacebookPageURL(this, webUrl, fbUrl)));
                } else {
                    intent.setData(Uri.parse(webUrl));
                }
            } else {
                intent.setData(Uri.parse(webUrl));
            }
            startActivityForResult(intent, 10);
        } catch (Exception e) {
            e.printStackTrace();
            intent.setData(Uri.parse(webUrl));
            startActivityForResult(intent, 10);
        }
        return true;
    }

    public static boolean isPackageExisted(Context c, String targetPackage) {
        PackageManager pm = c.getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo(targetPackage, PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
        return true;
    }

    public static String getFacebookPageURL(Context context, String webUrl, String fbUrl) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + webUrl;
            } else { //older versions of fb app
                return fbUrl;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return webUrl; //normal web url
        }
    }

    private void initMediaPlayer() {
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        playMusic();
        setMusic();
    }

    private void setMusic() {
        String url = "https://asset.vnovel.us/chapter_mp3/b634d1c6fb3a6aaa56d2a4b5c08f01c0.mp3";
        new Thread(() -> {
            try {
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.reset();
                mediaPlayer.setDataSource(url);
                mediaPlayer.prepare();
                mediaPlayer.start();
                mediaPlayer.setLooping(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }

    private void playMusic() {
        String url = "https://asset.vnovel.us/divide-piece/20210419/98fd1ceca94c65ed884d530cd199b1a58763.mp3";
        new Thread(() -> {
            try {
                MediaPlayer player = new MediaPlayer();
                player.reset();
                player.setDataSource(url);
                player.prepare();
                player.start();
                player.setLooping(true);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();

    }


    public enum MP_COMMAND {
        START,
        STOP,
        PAUSE
    }

    /**
     * Uses threads to execute synced commands for the current video media player and
     * background music player in tandem.
     */
    public void syncedCommand(MediaPlayer player1, MediaPlayer player2, MP_COMMAND command) {
        final CyclicBarrier commandBarrier = new CyclicBarrier(2);
        new Thread(new SyncedCommandService(commandBarrier, player1, command)).start();
        new Thread(new SyncedCommandService(commandBarrier, player2, command)).start();
    }

    /**
     * Inner class that starts a given media player synchronously
     * with other threads utilizing SyncedStartService
     */
    private class SyncedCommandService implements Runnable {
        private final CyclicBarrier mCommandBarrier;
        private MP_COMMAND mCommand;
        private MediaPlayer mMediaPlayer;

        public SyncedCommandService(CyclicBarrier barrier, MediaPlayer player, MP_COMMAND command) {
            mCommandBarrier = barrier;
            mMediaPlayer = player;
            mCommand = command;
        }

        @Override
        public void run() {
            try {
                mCommandBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            switch (mCommand) {
                case START:
                    mMediaPlayer.start();
                    break;
                case STOP:
                    mMediaPlayer.stop();
                    break;
                case PAUSE:
                    mMediaPlayer.pause();
                    break;
                default:
                    break;
            }
        }
    }


    private void test() {
        new Thread(() -> {
            try {
                MediaPlayer mediaPlayer1 = new MediaPlayer();
                String url = "https://asset.vnovel.us/chapter_mp3/b634d1c6fb3a6aaa56d2a4b5c08f01c0.mp3";
                mediaPlayer1.reset();
                mediaPlayer1.setDataSource(url);
                mediaPlayer1.prepare();
                mediaPlayer1.setLooping(true);
                MediaPlayer mediaPlayer2 = new MediaPlayer();
                String path = "https://asset.vnovel.us/divide-piece/20210419/98fd1ceca94c65ed884d530cd199b1a58763.mp3";
                mediaPlayer2.reset();
                mediaPlayer2.setDataSource(path);
                mediaPlayer2.prepare();
                mediaPlayer2.setLooping(true);
                syncedCommand(mediaPlayer1, mediaPlayer2, MP_COMMAND.START);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

    }
}