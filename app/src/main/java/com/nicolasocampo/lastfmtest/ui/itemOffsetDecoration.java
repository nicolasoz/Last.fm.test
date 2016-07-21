package com.nicolasocampo.lastfmtest.ui;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.IntegerRes;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by Nicolás on 20/07/2016.
 */
public class itemOffsetDecoration extends RecyclerView.ItemDecoration {

    //la medida en pixeles
    private int mItemOffset;

    public itemOffsetDecoration(Context context, @IntegerRes int integerResId){
        int itemOffsetDp = context.getResources().getInteger(integerResId);
        mItemOffset = convertToPX(itemOffsetDp, context.getResources().getDisplayMetrics());
    }
    public int convertToPX (int offsetDp, DisplayMetrics metrics){
        return offsetDp * (metrics.densityDpi / 160);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
    }
}
