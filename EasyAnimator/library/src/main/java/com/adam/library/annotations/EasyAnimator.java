package com.adam.library.annotations;

import android.animation.ValueAnimator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by adam on 2017/5/3.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EasyAnimator {
    int id();
    String property();
    float startAlpha() default 1f;
    float endAlpha() default 0f;
    long duration() default 2000;
    long startDelay()default 0;
    int repeatCount() default 1;
    @RepeatMode int repeatMode() default ValueAnimator.RESTART;
}
