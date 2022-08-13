package com.harin.customviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomView extends View {

    private Rect mRect;
    private Paint mSquarePaint;
    private static final int DEFAULT_SQUARE_SIZE = 200;
    private int squareColor;
    private int squareSize;

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

    private void init(@Nullable AttributeSet attrs) {
        mRect = new Rect();
        mSquarePaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        if (attrs == null)
            return;

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomView);

        squareColor = typedArray.getColor(R.styleable.CustomView_square_color, Color.GREEN);
        squareSize = typedArray.getDimensionPixelSize(R.styleable.CustomView_square_size, DEFAULT_SQUARE_SIZE);

        mSquarePaint.setColor(squareColor);

        typedArray.recycle();
    }

    /**
     * change color
     */
    public void changeColor() {
        mSquarePaint.setColor(
                mSquarePaint.getColor() == squareColor ? Color.GREEN : squareColor
        );
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        mRect.top = 10;
        mRect.left = 10;
        mRect.bottom = mRect.top + squareSize;
        mRect.right = mRect.left + squareSize;

        canvas.drawRect(mRect, mSquarePaint);
    }
}
