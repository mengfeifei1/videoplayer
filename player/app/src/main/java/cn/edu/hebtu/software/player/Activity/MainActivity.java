package cn.edu.hebtu.software.player.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.hebtu.software.player.Fragment.IndexFragment;
import cn.edu.hebtu.software.player.Fragment.MyFragment;
import cn.edu.hebtu.software.player.Fragment.ProgramFragment;
import cn.edu.hebtu.software.player.R;

public class MainActivity extends AppCompatActivity {
    private TextView indexView;
    private TextView programView;
    private TextView myView;
    private List<TextView> views = new ArrayList<>();
    private IndexFragment indexFragment = new IndexFragment();
    private ProgramFragment programFragment = new ProgramFragment();
    private MyFragment myFragment = new MyFragment();
    private FragmentManager manager ;
    private Fragment currentFragment = new Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        indexView = findViewById(R.id.tv_index);
        programView = findViewById(R.id.tv_program);
        myView = findViewById(R.id.tv_my);
        manager = getSupportFragmentManager();

        views.add(indexView);
        views.add(programView);
        views.add(myView);
        showFragment(indexFragment);
        setClickListener();
    }

    //为每一个 TextView (模拟的选项) 添加监听器
    private void setClickListener(){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.tv_index:
                        showFragment(indexFragment);
                        break;
                    case R.id.tv_program:
                        showFragment(programFragment);
                        break;
                    case R.id.tv_my:
                        showFragment(myFragment);
                        break;
                }

                //点击改变效果
                for(TextView view : views){
                    TextView tmp = findViewById(v.getId());
                    if(tmp == view){
                        view.setTextColor(getResources().getColor(R.color.deepOrange));
                        view.setTextSize(TypedValue.COMPLEX_UNIT_SP,23);
                    }else{
                        view.setTextColor(getResources().getColor(R.color.deepGray));
                        view.setTextSize(TypedValue.COMPLEX_UNIT_SP,21);
                    }
                }
            }

        };
        indexView.setOnClickListener(listener);
        programView.setOnClickListener(listener);
        myView.setOnClickListener(listener);
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
