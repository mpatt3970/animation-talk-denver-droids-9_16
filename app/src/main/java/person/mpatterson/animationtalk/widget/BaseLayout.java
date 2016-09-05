package person.mpatterson.animationtalk.widget;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;

import person.mpatterson.animationtalk.R;

/**
 * Created by michael on 9/5/16.
 */
public class BaseLayout extends FrameLayout {

    private Drawable mBackground;

    public BaseLayout(Context context) {
        this(context, null, 0);
    }

    public BaseLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mBackground = ContextCompat.getDrawable(getContext(), R.drawable.animated_background);
        setBackground(mBackground);
    }

    public void startAnimation() {
        if (mBackground instanceof Animatable) {
            ((Animatable) mBackground).start();
            getHandler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    TextView v = (TextView) findViewById(R.id.questions);
                    Animator anim = ObjectAnimator.ofObject(v, "textColor", new ArgbEvaluator(),
                            v.getCurrentTextColor(), ContextCompat.getColor(getContext(), android.R.color.white));
                    anim.setDuration(3000);
                    anim.start();
                }
            }, 3000);
        }
    }
}
