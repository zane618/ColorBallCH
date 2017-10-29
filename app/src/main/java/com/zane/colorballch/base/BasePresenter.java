package com.zane.colorballch.base;

/**
 * Created by shizhang on 2017/10/29.
 */

public abstract class BasePresenter<V extends BaseView> {
    private V view;

    public V getView() {
        return view;
    }

    public void attachView(V view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }
}
