package com.adam.sample;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.adam.easyanimator.R;
import com.adam.library.annotations.EasyAnimator;
import com.adam.library.invoker.AlphaAnimInvoker;

public class MainActivity extends Activity {

    @EasyAnimator(id = R.id.test, property = "alpha",repeatMode = ValueAnimator.REVERSE)
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlphaAnimInvoker.startAnimation(this);
    }
}
