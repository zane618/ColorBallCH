package com.zane.colorballch.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zane.colorballch.R;

import java.util.List;

/**
 * Created by shizhang on 2017/10/29.
 */

public class ResultAdapter extends BaseAdapter{
    private Context context;
    private List<String> datas;

    public ResultAdapter(List<String> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    ViewH viewH;

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.adapter_red, null);
            viewH = new ViewH();
            viewH.ball = view.findViewById(R.id.ball);
            viewH.ball.setTextColor(Color.parseColor("#FFFFFF"));
            view.setTag(viewH);
        } else {
            viewH = (ViewH) view.getTag();
        }
        viewH.ball.setText(datas.get(i));
        if (i != 0 && (i + 1) % 7 == 0) {
            viewH.ball.setBackgroundResource(R.drawable.shape_blue);
        } else {
            viewH.ball.setBackgroundResource(R.drawable.shape_fire_red);
        }
        return view;
    }

    public static class ViewH{
        public TextView ball;
    }
}
