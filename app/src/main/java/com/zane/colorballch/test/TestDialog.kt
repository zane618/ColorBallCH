package com.zane.colorballch.test

import android.app.Dialog
import android.content.Context
import android.os.Handler
import com.zane.colorballch.R

class TestDialog: Dialog {
    constructor(context: Context):super(context) {
        initLayout()
    }

    private fun initLayout() {
        setContentView(R.layout.test_dialog)
    }


    override fun show() {
        super.show()
        Handler().postDelayed(Runnable {
            dismiss()
        }, 4000)
    }

    override fun dismiss() {
//        super.dismiss()
    }
}