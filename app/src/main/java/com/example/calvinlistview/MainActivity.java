package com.example.calvinlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private List<String> data = new ArrayList<>();
    private MyListAdapter mAdapter;
    private float mScreenHeigthPixels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

        mAdapter = new MyListAdapter(this, data);
        mListView = (ListView) findViewById(R.id.lv);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mAdapter.setCurPositon(position);
                mAdapter.notifyDataSetChanged();
                mListView.smoothScrollToPositionFromTop(position,(parent.getHeight()-view.getHeight())/2);
                Log.e("------",parent.getHeight()+""+view.getHeight());
            }
        });
    }

    private void initData() {
        data.add("推荐分类");
        data.add("电脑办公");
        data.add("运动户外");
        data.add("图书音像");
        data.add("家用电器");
        data.add("鞋靴箱包");
        data.add("食品生鲜");
        data.add("手机数码");
        data.add("钟表珠宝");
        data.add("家具建材");
        data.add("家居家纺");
        data.add("医药保健");
        data.add("汽车用品");
        data.add("个护化妆");
        data.add("潮流女装");
        data.add("品牌男装");
        data.add("母婴童装");
        data.add("居家生活");
        data.add("酒水饮料");
        data.add("玩具乐器");
        data.add("内衣配饰");
        data.add("奢侈礼品");
        data.add("宠物农资");
        data.add("计生情趣");
        data.add("京东金融");
        data.add("生活旅行");
    }
}
