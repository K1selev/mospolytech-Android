package com.example.twod_animation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Animation.AnimationListener {
    private TransitionDrawable mTransition;
    private boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image = (ImageView)findViewById(R.id.transition_image);
        image.setOnClickListener(this);
        Resources res = this.getResources();

        image.setImageResource(R.drawable.oval);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);
        animation.setAnimationListener(this);
        image.startAnimation(animation);
        mTransition =
                (TransitionDrawable) ResourcesCompat.getDrawable(res,
                        R.drawable.transition, null);
        image.setImageDrawable(mTransition);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        if (flag) {
            mTransition.startTransition(2000);
            flag = false;
        }
        else
        {
            mTransition.reverseTransition(2000);
            flag = true;
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}