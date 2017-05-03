package com.adam.library.invoker;

import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;


import com.adam.library.annotations.EasyAnimator;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by adam on 2017/5/3.
 */

public class AlphaAnimInvoker {

    private static final String METHOD_FIND_VIEW_BY_ID = "findViewById";

    public static void startAnimation(Object object) {
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) { // 遍历所有字段
            // 获取字段的注解，如果没有ViewInject注解，则返回null
            EasyAnimator annotation = field.getAnnotation(EasyAnimator.class);
            if (annotation != null) {
                int id = annotation.id();
                String property = annotation.property();
                float startAlpha = annotation.startAlpha();
                float endAlpha = annotation.endAlpha();
                long duration = annotation.duration();
                long startDelay = annotation.startDelay();
                int repeatCount = annotation.repeatCount();
                int repeatMode = annotation.repeatMode();
                try {
                    // 获取类中的findViewById方法，参数为int
                    Method method = clazz.getMethod(METHOD_FIND_VIEW_BY_ID, int.class);
                    // 执行该方法，返回一个Object类型的View实例
                    Object resView = method.invoke(object, id);
                    field.setAccessible(true);
                    // 把字段的值设置为该View的实例
                    field.set(object, resView);
                    if(resView instanceof View){
                        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat((View)resView,property,startAlpha,endAlpha);
                        alphaAnimation.setDuration(duration);
                        alphaAnimation.setRepeatCount(repeatCount);
                        alphaAnimation.setRepeatMode(repeatMode);
                        alphaAnimation.setStartDelay(startDelay);
                        alphaAnimation.start();
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void startAnimation(Object object, AnimatorListenerAdapter animatorListenerAdapter) {
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) { // 遍历所有字段
            // 获取字段的注解，如果没有ViewInject注解，则返回null
            EasyAnimator annotation = field.getAnnotation(EasyAnimator.class);
            if (annotation != null) {
                int id = annotation.id();
                String property = annotation.property();
                float startAlpha = annotation.startAlpha();
                float endAlpha = annotation.endAlpha();
                long duration = annotation.duration();
                long startDelay = annotation.startDelay();
                int repeatCount = annotation.repeatCount();
                int repeatMode = annotation.repeatMode();
                try {
                    // 获取类中的findViewById方法，参数为int
                    Method method = clazz.getMethod(METHOD_FIND_VIEW_BY_ID, int.class);
                    // 执行该方法，返回一个Object类型的View实例
                    Object resView = method.invoke(object, id);
                    field.setAccessible(true);
                    // 把字段的值设置为该View的实例
                    field.set(object, resView);
                    if(resView instanceof View){
                        ObjectAnimator animation = ObjectAnimator.ofFloat((View)resView,property,startAlpha,endAlpha);
                        animation.setDuration(duration);
                        animation.setRepeatCount(repeatCount);
                        animation.setRepeatMode(repeatMode);
                        animation.setStartDelay(startDelay);
                        if(animatorListenerAdapter != null){
                            animation.addListener(animatorListenerAdapter);
                        }
                        animation.start();
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
