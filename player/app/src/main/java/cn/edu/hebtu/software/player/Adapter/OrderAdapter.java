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

public class OrderAdapter extends BaseAdapter {
    private Context context;
    private int itemLayout;
    private List<VideoBean> orderList = new ArrayList<>();
    private String path;

    public OrderAdapter(Context context, int itemLayout, List<VideoBean> orderList,String path) {
        this.context = context;
        this.itemLayout = itemLayout;
        this.orderList = orderList;
        this.path = path;
    }
    @Override
    public int getCount() { return orderList.size(); }

    @Override
    public Object getItem(int position) { return orderList.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(null == convertView){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(itemLayout,null);
        }
        ImageView imageView = convertView.findViewById(R.id.img_photo);
        Glide.with(context)
                .load(path+orderList.get(position).getVideoPic())
                .into(imageView);
        TextView tvTitle = convertView.findViewById(R.id.tv_title);
        String title = orderList.get(position).getVideoTitle();
        if(title.length()<32){
            tvTitle.setText(title);
        }else{
            tvTitle.setText(title.substring(0,32)+"......");
        }
        TextView tvZan = convertView.findViewById(R.id.tv_zan);
        tvZan.setText(String.valueOf(orderList.get(position).getVideoZanNum()));
        TextView tvOrder = convertView.findViewById(R.id.order);
        tvOrder.setText(String.valueOf(orderList.get(position).getOrder()));
        return convertView;
    }
}
