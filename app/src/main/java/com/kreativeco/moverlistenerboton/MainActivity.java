package com.kreativeco.moverlistenerboton;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button speakButton = (Button)findViewById(R.id.fucking_button);

        speakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                // TODO: DO something!
                Log.e("Boton tocado", "Fuck");
            }
        });

        animateDiagonalPan(speakButton);

    }


    private void animateDiagonalPan(Button v) {
        AnimatorSet animSetXY = new AnimatorSet();
        AnimatorSet animSetXY2 = new AnimatorSet();

        ObjectAnimator y1 = ObjectAnimator.ofFloat(v, "translationY", v.getX(), 300);
        y1.setRepeatMode(Animation.INFINITE);

        ObjectAnimator x1 = ObjectAnimator.ofFloat(v, "translationX", v.getY(), -1400);
        x1.setRepeatMode(Animation.INFINITE);

        animSetXY2.playTogether(x1, y1);
        animSetXY2.setInterpolator(new LinearInterpolator());
        animSetXY2.setDuration(13000);
        animSetXY2.start();

        ButtonAnimatorHelper b1 = new ButtonAnimatorHelper(v);

        ObjectAnimator y = ObjectAnimator.ofFloat(b1, "translationY", v.getX(), 300);

        ObjectAnimator x = ObjectAnimator.ofFloat(b1, "translationX", v.getY(), -1400);

        animSetXY.playTogether(x, y);
        animSetXY.setInterpolator(new LinearInterpolator());
        animSetXY.setDuration(13000);
        animSetXY.start();
    }

    public static class ButtonAnimatorHelper {

        final View mButton;
        TranslateAnimation animator;

        public ButtonAnimatorHelper(View button) {
            mButton = button;
        }

        public void setMarginLeft(final int margin) {
            final ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) mButton.getLayoutParams();

            params.leftMargin = margin;

            mButton.setLayoutParams(params);

        }
         private void getXButton(){
             mButton.getX();
         }

        private void getYButton(){
            mButton.getY();
        }

    }


}
