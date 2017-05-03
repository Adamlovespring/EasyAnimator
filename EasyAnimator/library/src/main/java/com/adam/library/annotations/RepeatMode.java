package com.adam.library.annotations;


import android.animation.ValueAnimator;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by adam on 2017/5/3.
 */
@Retention(RetentionPolicy.SOURCE)
@IntDef({ValueAnimator.RESTART,ValueAnimator.REVERSE})
public @interface RepeatMode {}

