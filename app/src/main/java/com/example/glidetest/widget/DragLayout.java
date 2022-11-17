package com.example.glidetest.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.customview.widget.ViewDragHelper;

public class DragLayout extends FrameLayout {
    ViewDragHelper mViewDragHelper;
    public DragLayout(Context context) {
        this(context, null);
    }

    public DragLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 创建ViewDragHelper对象，回调参数用来控制子View的拖动
        mViewDragHelper = ViewDragHelper.create(this, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(@NonNull View child, int pointerId) {
                return true;
            }

            @Override
            public int clampViewPositionHorizontal(@NonNull View child, int left, int dx) {
                return Math.min(Math.max(0, left), getWidth() - child.getWidth());
            }

            @Override
            public int clampViewPositionVertical(@NonNull View child, int top, int dy) {
                return Math.min(Math.max(0, top), getBottom() - child.getHeight());
            }

            @Override
            public int getViewHorizontalDragRange(@NonNull View child) {
                return getMeasuredWidth()-child.getMeasuredWidth();
            }

            @Override
            public int getViewVerticalDragRange(@NonNull View child) {
                return getMeasuredHeight()-child.getMeasuredHeight();
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // 利用ViewDragHelper来判断是否需要截断
        return mViewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 利用ViewDragHelper来处理子View的拖拽
        mViewDragHelper.processTouchEvent(event);
        return true;
    }
}