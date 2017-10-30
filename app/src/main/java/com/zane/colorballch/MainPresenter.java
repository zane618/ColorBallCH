package com.zane.colorballch;

import com.zane.colorballch.base.BasePresenter;
import com.zane.colorballch.model.MainModel;

/**
 * Created by shizhang on 2017/10/29.
 */

public class MainPresenter extends BasePresenter<MainView> {
    private MainModel mainModel;

    public MainPresenter() {
        this.mainModel = new MainModel();
    }

    public void init() {
        if (getView() != null) {
            getView().onRedGridInit(mainModel.getRedBalls());
            getView().onBlueGridInit(mainModel.getBlueBalls());
            getView().onResultGridInit(mainModel.getResultBalls());
        }
    }

    public void updateRedGrid(int redPosition) {
        mainModel.updateRedBalls(redPosition);
        getView().updateRed();
    }

    public void updateBlueGrid(int bluePosition) {
        mainModel.updateBlueBalls(bluePosition);
        getView().updateBlue();
    }

    public void random() {
        mainModel.random();
        getView().onRandomOne();
    }

    public void clearScreen() {
        mainModel.clearScreen();
        getView().onRandomOne();
    }
}
