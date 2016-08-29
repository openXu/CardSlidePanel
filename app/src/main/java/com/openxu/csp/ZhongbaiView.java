package com.openxu.csp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author openXu
 */
public class ZhongbaiView extends View {

    private String TAG = "ZhongbaiView";



    private Paint mRPaint;
    private Paint mLinePaint;

    private int r;
    private int r0 = 10;
    private int r1 = 20;

    private Point POINT_YUANXIN;
    private Point POINT_WAIMIAN;

    public ZhongbaiView(Context context) {
        this(context, null);
    }
    public ZhongbaiView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public ZhongbaiView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        mLinePaint = new Paint();
        mRPaint = new Paint();

        mLinePaint.setColor(Color.GRAY);
        mLinePaint.setStyle(Paint.Style.FILL);//设置填充
        mLinePaint.setStrokeWidth(3);//笔宽像素
        mLinePaint.setAntiAlias(true);//锯齿不显示

        mRPaint.setColor(Color.argb(255,234,234,234));
        mRPaint.setStyle(Paint.Style.FILL);//设置填充
        mRPaint.setStrokeWidth(2);//笔宽像素
        mRPaint.setAntiAlias(true);//锯齿不显示

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int hight = getMeasuredHeight();
        MyUtil.LOG_I(TAG, "控件宽高："+width+"  "+hight);
        r = width/2;

        POINT_YUANXIN = new Point();
        POINT_YUANXIN.x = r;
        POINT_YUANXIN.y = r;

        POINT_WAIMIAN = new Point();
        POINT_WAIMIAN.x = r1;
        POINT_WAIMIAN.y = r;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        //画灰色基准线
        canvas.drawLine(POINT_WAIMIAN.x, POINT_WAIMIAN.y,
                POINT_YUANXIN.x,POINT_YUANXIN.y , mLinePaint);

        canvas.drawCircle(POINT_WAIMIAN.x, POINT_WAIMIAN.y,r1,mRPaint);
        canvas.drawCircle(POINT_YUANXIN.x, POINT_YUANXIN.y,r0,mRPaint);

    }
}
