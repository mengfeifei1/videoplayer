package cn.edu.hebtu.software.player.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import cn.edu.hebtu.software.player.Bean.VideoBean;
import cn.edu.hebtu.software.player.R;

public class SearchAdapter extends BaseAdapter {
    private Context context;
    private int itemLayout;
    private List<VideoBean> searchList = new ArrayList<>();

    public SearchAdapter(Context context, int itemLayout, List<VideoBean> searchList) {
        this.context = context;
        this.itemLayout = itemLayout;
        this.searchList = searchList;
    }

    @Override
    public int getCount() { return searchList.size(); }

    @Override
    public Object getItem(int position) {
        return searchList.get(position);
    }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(null == convertView){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(itemLayout,null);
        }
        TextView tvTitle = convertView.findViewById(R.id.conent);
        String title = searchList.get(position).getVideoTitle();
        if(title.length()<12){
            tvTitle.setText(title);
        }else{
            tvTitle.setText(title.substring(0,12)+"......");
        }
        return convertView;
    }
}
