package com.example.calvinlistview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 昭昭 on 2016/8/4.
 */

public class MyListAdapter extends BaseAdapter {
    private List<String> data = new ArrayList<>();
    private Context mContext;
    private LayoutInflater mInflater;
    private int curPositon;

    public void setCurPositon(int curPositon) {
        this.curPositon = curPositon;
    }

    public int getCurPositon() {
        return curPositon;
    }

    public MyListAdapter(Context context, List<String> data) {
        mContext = context;
        this.data = data;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item,null);
            vh = new ViewHolder();
            vh.tv = (TextView) convertView.findViewById(R.id.text1);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder)convertView.getTag();
        }
        vh.tv.setText(data.get(position));
        if (position == curPositon) {
            convertView.setBackgroundColor(Color.TRANSPARENT);
            vh.tv.setTextColor(Color.RED);
        }else{
            vh.tv.setTextColor(Color.BLACK);
            convertView.setBackgroundColor(Color.WHITE);
        }
        return convertView;
    }
    class ViewHolder {
        TextView tv;
    }
}
