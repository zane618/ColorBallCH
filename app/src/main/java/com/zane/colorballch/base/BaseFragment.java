package com.zane.colorballch.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by shizhang on 2017/10/29.
 */

public abstract class BaseFragment<V extends BaseView, P extends BasePresenter<V>> extends Fragment {
    private P presenter;
    private V view;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (this.presenter == null) {
            this.presenter = createPresenter();
        }
        if (this.view == null) {
            this.view = createView();
        }
        if (this.presenter != null && this.view != null) {
            this.presenter.attachView(view);
        }
    }

    protected abstract V createView();

    protected abstract P createPresenter();

    public P getPresenter() {
        return presenter;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (this.presenter != null && this.view != null) {
            this.presenter.detachView();
        }
    }
}
