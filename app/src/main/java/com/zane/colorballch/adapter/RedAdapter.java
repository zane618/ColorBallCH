package com.zane.colorballch.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zane.colorballch.R;
import com.zane.colorballch.model.ColorBallBean;

import java.util.List;

/**
 * Created by shizhang on 2017/10/29.
 */

public class RedAdapter extends BaseAdapter{
    private Context context;
    private List<ColorBallBean> datas;

    public RedAdapter(List<ColorBallBean> datas, Context context) {
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
            view.setTag(viewH);
        } else {
            viewH = (ViewH) view.getTag();
        }
        ColorBallBean bean = datas.get(i);
        viewH.ball.setText(bean.text + "");
        switch (bean.status) {
            case 0:
                viewH.ball.setBackgroundResource(R.drawable.shape_white);
                viewH.ball.setTextColor(Color.parseColor("#FF2D51"));
                break;
            case 1:
                viewH.ball.setBackgroundResource(R.drawable.shape_red);
                viewH.ball.setTextColor(Color.parseColor("#FFFFFF"));
                break;
            case 2:
                viewH.ball.setTextColor(Color.parseColor("#FFFFFF"));
                viewH.ball.setBackgroundResource(R.drawable.shape_blue);
        }
        return view;
    }

    public static class ViewH{
        public TextView ball;
    }
}
