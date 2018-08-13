package com.openxu.csp;

import android.animation.TypeEvaluator;
import android.util.Log;

/**
 * Created by Admin on 2018/8/13.
 */

public class FloatEvaluator implements TypeEvaluator<Number> {

        public Float evaluate(float fraction, Number startValue, Number endValue) {
                Log.w(getClass().getSimpleName(), "计算器："+fraction+"   startValue="+startValue+  "    endValue="+endValue);
                float startFloat = startValue.floatValue();
                return startFloat + fraction * (endValue.floatValue() - startFloat);
        }

}