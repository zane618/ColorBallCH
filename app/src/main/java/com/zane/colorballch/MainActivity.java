package com.zane.colorballch;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AlertDialog;

import com.zane.colorballch.about.AboutActivity;
import com.zane.colorballch.adapter.RedAdapter;
import com.zane.colorballch.adapter.ResultAdapter;
import com.zane.colorballch.base.BaseActivity;
import com.zane.colorballch.model.ColorBallBean;
import com.zane.colorballch.utilty.DateUtil;

import java.util.List;

public class MainActivity extends BaseActivity<MainView, MainPresenter> implements MainView{
    private GridView redRec;
    private GridView blueRec;
    private GridView resultRec;
    private RedAdapter redAdapter;
    private RedAdapter blueAdapter;
    private ResultAdapter resultAdapter;
    private MainPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verification();
        initviews();

    }

    private void verification() {
        //就不用mvp了
        SharedPreferences sp = this.getSharedPreferences("install_time", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if (!sp.getString("install_time", "").equals("")) {
            int hours = DateUtil.x(sp.getString("install_time", "2016-06-01 12:00"));
            if (hours > 24) {
                final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("提示");
                dialog.setMessage("应用签名过期了，获取正版请联系开发者微信zane-618");
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
            dialog.show();
                return;
            }
        } else {
            editor.putString("install_time", DateUtil.nowDateStr());
            editor.commit();
        }
    }

    private void initviews() {
        getSupportActionBar().setTitle("双色球小助手");
        presenter = getPresenter();
        redRec = (GridView) findViewById(R.id.red_rec);
        blueRec = (GridView) findViewById(R.id.blue_rec);
        resultRec = (GridView) findViewById(R.id.result_rec);
        redRec.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                presenter.updateRedGrid(i);
            }
        });
        blueRec.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                presenter.updateBlueGrid(i);
            }
        });
        findViewById(R.id.btn_random).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.random();
            }
        });
        findViewById(R.id.btn_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.clearScreen();
            }
        });
        presenter.init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                    startActivity(new Intent(MainActivity.this, AboutActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected MainView createView() {
        return this;
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void onRedGridInit(List<ColorBallBean> reds) {
        redAdapter = new RedAdapter(reds, this);
        redRec.setAdapter(redAdapter);
    }

    @Override
    public void onBlueGridInit(List<ColorBallBean> blues) {
        blueAdapter = new RedAdapter(blues, this);
        blueRec.setAdapter(blueAdapter);
    }

    @Override
    public void onResultGridInit(List<String> resultBalls) {
        resultAdapter = new ResultAdapter(resultBalls, this);
        resultRec.setAdapter(resultAdapter);
    }

    @Override
    public void updateRed() {
        redAdapter.notifyDataSetChanged();
    }

    @Override
    public void updateBlue() {
        blueAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRandomOne() {
        resultAdapter.notifyDataSetChanged();
    }
}
