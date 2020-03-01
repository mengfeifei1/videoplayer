package cn.edu.hebtu.software.player.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import cn.edu.hebtu.software.player.Bean.VideoBean;
import cn.edu.hebtu.software.player.R;


public class VideoAdapter extends BaseAdapter{
    private Context context;
    private int itemLayout;
    private List<VideoBean> videoList = new ArrayList<>();
    private String path;

    public VideoAdapter(Context context, int itemLayout, List<VideoBean> videoList,String path) {
        this.context = context;
        this.itemLayout = itemLayout;
        this.videoList = videoList;
        this.path = path;
    }

    @Override
    public int getCount() { return videoList.size(); }
    @Override
    public Object getItem(int position) { return videoList.get(position); }
    @Override
    public long getItemId(int position) { return position; }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(null == convertView){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(itemLayout,null);
        }
        ImageView imgVideo = convertView.findViewById(R.id.img_video);
        Glide.with(context)
                .load(path+videoList.get(position).getVideoPic())
                .into(imgVideo);
        TextView tvTitle = convertView.findViewById(R.id.tv_title);
        String title = videoList.get(position).getVideoTitle();
        if(title.length()<19){
            tvTitle.setText(title);
        }else{
            tvTitle.setText(title.substring(0,19)+"......");
        }
        return convertView;
    }
}
