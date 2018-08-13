package com.openxu.csp;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 卡片View项
 * @author openXu
 */
public class CardItemView extends LinearLayout {

    private ImageView imageView;
    private TextView tv_num;
    public int num;

    private ObjectAnimator rotationAnim;

    public CardItemView(Context context) {
        this(context, null);
    }
    public CardItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public CardItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        inflate(context, R.layout.card_item, this);
        imageView = (ImageView) findViewById(R.id.imageView);
        tv_num = (TextView) findViewById(R.id.tv_num);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.carditem);
        int textNum = ta.getInteger(R.styleable.carditem_text_num, -1);
        num = textNum;
        tv_num.setText("第"+textNum+"个子控件");
        ta.recycle();
    }
    public void setImageSrc(int picId) {
        imageView.setImageResource(picId);
    }



    public void startAnim(float f){
        //1、让view从不透明到全透明，然后不透明
//        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f, 1f);
//        animator.setDuration(3000);
//        animator.start();
        //2、让view再3s内从0°旋转到360°
//        if(rotationAnim!=null)
//            rotationAnim.cancel();
        if(rotationAnim!=null)
            return;
        rotationAnim = ObjectAnimator.ofFloat(this, "rotation",  0,f);
        rotationAnim.setEvaluator(new FloatEvaluator());
        MyInterpolator in = new MyInterpolator();
        rotationAnim.setInterpolator(in);
        rotationAnim.setDuration(5000);
        rotationAnim.start();
        //3、让view从当前位置沿X轴方向向右平移500个像素，然后回到原位
//        float curTranslationX = this.getTranslationX();
//        rotationAnim = ObjectAnimator.ofFloat(this, "translationX", curTranslationX, 500f, curTranslationX);
//        rotationAnim.setDuration(3000);
//        rotationAnim.start();
//4、让view垂直方向放大3倍，然后缩放到原来的大小
//        rotationAnim = ObjectAnimator.ofFloat(this, "scaleY", 1f, 3f, 1f);
//        rotationAnim.setDuration(3000);
//        rotationAnim.start();
    }



}
