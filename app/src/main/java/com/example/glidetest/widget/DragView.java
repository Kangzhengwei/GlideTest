package com.example.glidetest.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import androidx.customview.widget.ViewDragHelper;


public class DragView extends FrameLayout {

    private int width; //  测量宽度 FreeView的宽度
    private int height; // 测量高度 FreeView的高度
    private Context context;
    private float downX; //点击时的x坐标
    private float downY;  // 点击时的y坐标
    private int startLeft, startTop, startRight, startBottom; //记录初始位置
    private boolean isStart = true;
    //是否拖动标识
    private boolean isDrag = false;
    private OnViewDownClickListener onViewDownClickListener;

    // 处理点击事件和滑动时间冲突时使用 返回是否拖动标识
    public boolean isDrag() {
        return isDrag;
    }

    // 初始化属性
    public DragView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public void setOnViewDownClickListener(OnViewDownClickListener onViewDownClickListener) {
        this.onViewDownClickListener = onViewDownClickListener;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 获取屏宽高 和 可是适用范围 （我的需求是可在屏幕内拖动 不超出范围 也不需要隐藏）
        width = getMeasuredWidth();
        height = getMeasuredHeight();
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (isStart) {
            startLeft = left;
            startTop = top;
            startRight = right;
            startBottom = bottom;
            isStart = false;
        }
    }

    public void recovery() {
        layout(startLeft, startTop, startRight, startBottom);
    }

    /**
     * 处理事件分发
     *
     * @param event
     * @return
     */

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        View child = getChildAt(0);

        if (this.isEnabled()) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: // 点击动作处理 每次点击时将拖动状态改为 false 并且记录下点击时的坐标 downX downY
                    isDrag = false;
                    downX = event.getX(); // 点击触屏时的x坐标 用于离开屏幕时的x坐标作计算
                    downY = event.getY(); // 点击触屏时的y坐标 用于离开屏幕时的y坐标作计算
                    break;
                case MotionEvent.ACTION_MOVE: // 滑动动作处理 记录离开屏幕时的 moveX  moveY 用于计算距离 和 判断滑动事件和点击事件 并作出响应
                    getParent().requestDisallowInterceptTouchEvent(true);
                    final float moveX = event.getX() - downX;
                    final float moveY = event.getY() - downY;
                    Log.d("DragView", moveX + "/moveX");
                    Log.d("DragView", moveY + "/moveY");
                    int l, r, t, b; // 上下左右四点移动后的偏移量
                    //计算偏移量 设置偏移量 = 3 时 为判断点击事件和滑动事件的峰值
                    if (Math.abs(moveX) > 1.5 || Math.abs(moveY) > 1.5) { // 偏移量的绝对值大于 3 为 滑动时间 并根据偏移量计算四点移动后的位置
                        Log.d("DragView", child.getLeft() + "/getLeft");
                        Log.d("DragView", child.getWidth() + "/getWidth");
                        l = (int) (child.getLeft() + moveX);
                        r = (int) (child.getRight() + moveX);
                        t = (int) (child.getTop() + moveY);
                        b = (int) (child.getHeight() + moveY);
                        Log.d("DragView", l + "/l");
                        Log.d("DragView", r + "/r");
                        Log.d("DragView", t + "/t");
                        Log.d("DragView", b + "/b");
                        //不划出边界判断,最大值为边界值
                        // 如果你的需求是可以划出边界 此时你要计算可以划出边界的偏移量 最大不能超过自身宽度或者是高度  如果超过自身的宽度和高度 view 划出边界后 就无法再拖动到界面内了 注意
                    /*    if (l < 0) { // left 小于 0 就是滑出边界 赋值为 0 ; right 右边的坐标就是自身宽度 如果可以划出边界 left right top bottom 最小值的绝对值 不能大于自身的宽高
                            l = 0;
                            r = l + width;
                        } else if (r > width) { // 判断 right 并赋值
                            r = width;
                            l = r - width;
                        }
                        if (t < 0) { // top
                            t = 0;
                            b = t + height;
                        } else if (b > height) { // bottom
                            b = height;
                            t = b - height;
                        }
*/
                        //  this.layout(l, t, r, b); // 重置view在layout 中位置
                        child.layout(l, t, r, b);
                        isDrag = true;  // 重置 拖动为 true
                    } else {
                        isDrag = false; // 小于峰值3时 为点击事件
                    }
                    break;
                case MotionEvent.ACTION_UP: // 不处理
                    if (!isDrag) {
                        if (onViewDownClickListener != null)
                            onViewDownClickListener.OnViewClick();
                    }
                case MotionEvent.ACTION_CANCEL:
                    setPressed(false);
                    break;
            }
            return true;
        }
        return false;
    }

    public interface OnViewDownClickListener {
        void OnViewClick();
    }
}
