package com.zane.colorballch;

import com.zane.colorballch.base.BaseView;
import com.zane.colorballch.model.ColorBallBean;

import java.util.List;

/**
 * Created by shizhang on 2017/10/29.
 */

public interface MainView extends BaseView {

    void onRedGridInit(List<ColorBallBean> reds);
    void onBlueGridInit(List<ColorBallBean> blues);

    void updateRed();

    void updateBlue();
    void onRandomOne(String result);
}
