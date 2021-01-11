package com.zane.colorballch.kt.custom

import androidx.recyclerview.widget.RecyclerView

class GridSpacesItemDecoration : RecyclerView.ItemDecoration {
    private var includeEdge = false
    private var spacing = 0

    constructor(spacing: Int, includeEdge: Boolean) {
        this.includeEdge = includeEdge
        this.spacing = spacing
    }



}