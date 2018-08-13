package com.openxu.csp;

import android.util.Log;
import android.view.animation.Interpolator;

/**
 * Created by Admin on 2018/8/13.
 */

public class MyInterpolator  implements Interpolator {




    @Override
    public float getInterpolation(float t) {

        // return (float)(Math.sin(2 * cycles * Math.PI * (input)));

        float result = (float)(Math.sin(2 * 10 * Math.PI * (t)))*(1f-t);
        Log.e(getClass().getSimpleName(), "插值："+result);
        return result;
    }
}
