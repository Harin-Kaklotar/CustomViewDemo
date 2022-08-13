package com.harin.customviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomView extends View {

    Rect mRect;
    Paint mPaint;
    private static final int DEFAULT_SQUARE_SIZE = 100;

    public CustomView(Context context) {
        super(context);
        init(null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        mRect = new Rect();

        mRect.top = 10;
        mRect.left = 10;
        mRect.bottom = mRect.top + DEFAULT_SQUARE_SIZE;
        mRect.right = mRect.left + DEFAULT_SQUARE_SIZE;

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
    }

    /**
     * change color
     */
    public void changeColor() {
        mPaint.setColor(
                mPaint.getColor() == Color.RED ? Color.GREEN : Color.RED
        );
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(mRect, mPaint);
    }
}
