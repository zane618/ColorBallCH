package com.zane.colorballch.model;

import java.io.Serializable;

/**
 * Created by shizhang on 2017/10/29.
 */

public class ColorBallBean implements Serializable {
    //0未选中  1不要  2要
    public int status;
    public int text;

    public ColorBallBean(int satus, int text) {
        this.status = satus;
        this.text = text;
    }
}
