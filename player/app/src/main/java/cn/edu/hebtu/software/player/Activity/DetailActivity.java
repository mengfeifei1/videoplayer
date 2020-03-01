package cn.edu.hebtu.software.player.Activity;


import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import cn.edu.hebtu.software.player.Adapter.VideoAdapter;
import cn.edu.hebtu.software.player.Bean.BoolBean;
import cn.edu.hebtu.software.player.Bean.VideoBean;
import cn.edu.hebtu.software.player.R;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class DetailActivity extends AppCompatActivity {
    private VideoView videoView;
    private TextView titleView;
    private VideoBean videoBean;
    private OkHttpClient okHttpClient;
    private String path;
    private Boolean follow;
    private Boolean shou;
    BoolBean boolBean = new BoolBean();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);
        path = getResources().getString(R.string.server_path);
        okHttpClient = new OkHttpClient();
        Intent intent = getIntent();
        videoBean = (VideoBean) getIntent().getSerializableExtra("videoBean");
        GetViewById();
        initVideoPath();
        Log.e("url",videoBean.getVideoUrl());
    }

    //获取控件
    public void GetViewById() {
        videoView = findViewById(R.id.videoView);
        titleView = findViewById(R.id.tv_title);
        titleView.setText(videoBean.getVideoTitle());
        GetShouAndFollow getShouAndFollow = new GetShouAndFollow();
        getShouAndFollow.execute(videoBean.getVideoId());
    }
    //判断视频是否被关注  是否被收藏
    private class GetShouAndFollow extends AsyncTask {
        @Override
        protected Object doInBackground(Object[] objects) {
            String url = path+"bool/heart?videoId="+objects[0]+"&userId=1";
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Call call = okHttpClient.newCall(request);
            try {
                Response response = call.execute();
                String rel = response.body().string();
                JSONObject videoObject = new JSONObject(rel);
                String array = videoObject.getJSONArray("boolList").toString();
                Gson gson = new Gson();
                JsonArray jsonArray=gson.fromJson(array,JsonArray.class);
                for(int i=0;i<jsonArray.size();i++){
                    boolBean =gson.fromJson(jsonArray.get(i),BoolBean.class);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }catch (JSONException e) {
                e.printStackTrace();
            }
            return boolBean;
        }
    }
    //视频播放
    public void initVideoPath(){
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(Uri.parse(path+videoBean.getVideoUrl()));
        videoView.start();
    }
}
