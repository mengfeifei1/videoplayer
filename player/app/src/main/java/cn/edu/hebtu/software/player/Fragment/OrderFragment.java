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
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.hebtu.software.player.Activity.DetailActivity;
import cn.edu.hebtu.software.player.Adapter.OrderAdapter;
import cn.edu.hebtu.software.player.Bean.VideoBean;
import cn.edu.hebtu.software.player.R;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OrderFragment extends Fragment {
    private ListView listView;
    private OrderAdapter orderAdapter;
    private List<VideoBean> orderList = new ArrayList<>();
    private String path = null;
    private OkHttpClient okHttpClient;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order,container,false);
        listView = view.findViewById(R.id.list);
        path = getResources().getString(R.string.server_path);
        okHttpClient = new OkHttpClient();
        GetVideo getVideo = new GetVideo();
        getVideo.execute();
        return view;
    }

     //从数据库里面取出视频
        private class GetVideo extends AsyncTask {
            @Override
            protected Object doInBackground(Object[] objects) {
                String url = path+"video/order";
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
                        videoBean.setOrder(i+1);
                        orderList.add(videoBean);
                        Log.e("order",orderList.get(i).getVideoTitle());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }catch (JSONException e) {
                    e.printStackTrace();
                }
                return orderList;
            }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            orderAdapter = new OrderAdapter(getActivity(),R.layout.order_item,orderList,path);
            listView.setAdapter(orderAdapter);
            setVideoListView(listView);
        }
    }


    public void setVideoListView(ListView listView){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(getContext(), DetailActivity.class);
                intent.putExtra("videoBean",orderList.get(position));
                startActivity(intent);
            }
        });
    }
}
