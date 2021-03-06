package cn.edu.hebtu.software.player.Activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cn.edu.hebtu.software.player.Adapter.SearchAdapter;
import cn.edu.hebtu.software.player.Bean.VideoBean;
import cn.edu.hebtu.software.player.R;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SearchActivity extends AppCompatActivity {
    private TextView tvBack;
    private TextView tvSearch;
    private ImageView ImgSearch;
    private ListView listView;
    private SearchAdapter searchAdapter;
    private List<VideoBean> searchList = new ArrayList<>();
    private String path = null;
    private OkHttpClient okHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        path = getResources().getString(R.string.server_path);
        tvBack = findViewById(R.id.tv_back);
        tvSearch = findViewById(R.id.tv_search);
        ImgSearch = findViewById(R.id.img_search);
        listView = findViewById(R.id.list);
        okHttpClient = new OkHttpClient();
        setTvBackListener();
    }

    //设置控件点击事件
    public void setTvBackListener (){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.tv_back:
                        finish();
                        break;
                    case R.id.img_search:
                        String title = (String) tvSearch.getText().toString();
                        SearchVideo searchVideo = new SearchVideo();
                        Log.e("title",title);
                        searchVideo.execute(title);
                        break;
                }
            }
        };
        tvBack.setOnClickListener(listener);
        ImgSearch.setOnClickListener(listener);
    }

    public class SearchVideo extends AsyncTask{
            @Override
            protected Object doInBackground(Object[] objects) {
                searchList.clear();
                String url = path+"video/title?videoTitle="+objects[0];
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
                        Log.e("video",videoBean.toString());
                        searchList.add(videoBean);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }catch (JSONException e) {
                    e.printStackTrace();
                }
                return searchList;
            }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            searchAdapter = new SearchAdapter(SearchActivity.this,R.layout.search_item,searchList);
            listView.setAdapter(searchAdapter);
            setVideoListView(listView);
        }
    }

    public void setVideoListView(ListView listView){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(SearchActivity.this,DetailActivity.class);
                intent.putExtra("videoBean",searchList.get(position));
                startActivity(intent);
            }
        });
    }

}
