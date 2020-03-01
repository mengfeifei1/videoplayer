package cn.edu.hebtu.software.player.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.hebtu.software.player.Activity.SearchActivity;
import cn.edu.hebtu.software.player.R;

public class IndexFragment extends Fragment {
    private TextView searchView;
    private ImageView userPhoto; //个人头像
    private TextView hotView;
    private TextView cartoonView;
    private TextView peView;
    private TextView singView;
    private TextView lplView;
    private List<TextView> views = new ArrayList<>();
    private HotFragment hotFragment = new HotFragment();
    private CartoonFragment cartoonFragment = new CartoonFragment();
    private PeFragment peFragment = new PeFragment();
    private SingFragment singFragment = new SingFragment();
    private LpLFragment lpLFragment = new LpLFragment();
    private FragmentManager manager;
    private Fragment currentFragment = new Fragment();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index,container,false);
        searchView = view.findViewById(R.id.searchView);
        hotView = view.findViewById(R.id.hot);
        cartoonView = view.findViewById(R.id.cartoon);
        peView = view.findViewById(R.id.pe);
        singView = view.findViewById(R.id.sing);
        lplView = view.findViewById(R.id.lpl);
        manager = getChildFragmentManager();
        views.add(hotView);
        views.add(cartoonView);
        views.add(peView);
        views.add(singView);
        views.add(lplView);
        showFragment(hotFragment);
        setClickListener();
        return view;
    }

    //为每一个 TextView (模拟的选项) 添加监听器
    private void setClickListener(){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.hot:
                        showFragment(hotFragment);
                        break;
                    case R.id.cartoon:
                        showFragment(cartoonFragment);
                        break;
                    case R.id.pe:
                        showFragment(peFragment);
                        break;
                    case R.id.sing:
                        showFragment(singFragment);
                        break;
                    case R.id.lpl:
                        showFragment(lpLFragment);
                        break;
                    case R.id.searchView:
                        Intent intent = new Intent();
                        intent.setClass(getContext(),SearchActivity.class);
                        startActivity(intent);
                        break;
                }

                //点击改变效果
                for(TextView view : views){
                    TextView tmp = view.findViewById(v.getId());
                    if(tmp == view){
                        view.setTextColor(getResources().getColor(R.color.deepOrange));
                        view.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    }else{
                        view.setTextColor(getResources().getColor(R.color.deepGray));
                        view.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
                    }
                }
            }

        };
        hotView.setOnClickListener(listener);
        cartoonView.setOnClickListener(listener);
        peView.setOnClickListener(listener);
        singView.setOnClickListener(listener);
        lplView.setOnClickListener(listener);
        searchView.setOnClickListener(listener);
    }

    //显示出指定的页面
    private void showFragment(Fragment fragment){
        //创建 fragment 事务
        FragmentTransaction transaction = manager.beginTransaction();
        //判断传入的fragment 是否是当前正在显示的fragment
        if(fragment != currentFragment)
            transaction.hide(currentFragment);
        //判断要展示的 fragment 是否被添加过
        if(!fragment.isAdded())
            transaction.add(R.id.content,fragment);
        transaction.show(fragment);
        //提交事务
        transaction.commit();
        currentFragment = fragment;
    }
}
