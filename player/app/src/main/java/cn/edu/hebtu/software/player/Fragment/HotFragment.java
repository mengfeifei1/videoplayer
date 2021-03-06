package cn.edu.hebtu.software.player.Fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cn.edu.hebtu.software.player.Activity.DetailActivity;
import cn.edu.hebtu.software.player.Adapter.VideoAdapter;
import cn.edu.hebtu.software.player.Bean.VideoBean;
import cn.edu.hebtu.software.player.R;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HotFragment extends Fragment {
    private GridView gridView;
    private VideoAdapter videoAdapter;
    private List<VideoBean> videoList = new ArrayList<>();
    private String path = null;
    private OkHttpClient okHttpClient;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video,container,false);
        path = getResources().getString(R.string.server_path);
        gridView = view.findViewById(R.id.root);
        okHttpClient = new OkHttpClient();
        GetVideo getVideo = new GetVideo();
        getVideo.execute();
        return view;
    }

    private class GetVideo extends AsyncTask {
        @Override
        protected Object doInBackground(Object[] objects) {
            String url = path+"video/all";
            Log.e("url",url);
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Call call = okHttpClient.newCall(request);
            try {
                Response response = call.execute();
                String rel = response.body().string();
                JSONObject videoObject = new JSONObject(rel);
                String array = videoObject.getJSONArray("videoList").toString();
                Gson gson = new Gson();
                JsonArray jsonArray=gson.fromJson(array,JsonArray.class);
                for(int i=0;i<jsonArray.size();i++){
                    VideoBean videoBean = new VideoBean();
                    videoBean =gson.fromJson(jsonArray.get(i),VideoBean.class);
                    videoList.add(videoBean);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }catch (JSONException e) {
                e.printStackTrace();
            }
            return videoList;
        }
        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            videoAdapter = new VideoAdapter(getActivity(), R.layout.video_item,videoList,path);
            gridView.setAdapter(videoAdapter);
            setVideoGridView(gridView);
        }
    }

    //gridview点击事件
    public void setVideoGridView(GridView gridView){
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(getContext(), DetailActivity.class);
                intent.putExtra("videoBean",videoList.get(position));
                startActivity(intent);
            }
        });
    }
}
