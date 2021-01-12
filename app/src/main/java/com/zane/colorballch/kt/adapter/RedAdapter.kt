package com.zane.colorballch.kt.adapter

import android.graphics.Color
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.zane.colorballch.R
import com.zane.colorballch.kt.bean.ColorBall

class RedAdapter : BaseQuickAdapter<ColorBall, BaseViewHolder> {

    constructor(data: MutableList<ColorBall>?) : super(R.layout.item_red_layout, data)

    override fun convert(holder: BaseViewHolder, item: ColorBall) {
        val tvBall = holder.getView<TextView>(R.id.tv_ball)
        tvBall.text = item.num.toString()
        when (item.status) {
            0 -> {
                tvBall.setBackgroundResource(R.drawable.shape_red)
                tvBall.setTextColor(Color.parseColor("#FF2D51"))
            }
            1 -> {
                tvBall.setBackgroundResource(R.drawable.shape_red)
                tvBall.setTextColor(Color.parseColor("#FFFFFF"))
            }
            2 -> {
                tvBall.setTextColor(Color.parseColor("#FFFFFF"))
                tvBall.setBackgroundResource(R.drawable.shape_blue)
            }

        }
    }
}