package person.mpatterson.animationtalk.ui;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.support.v4.content.ContextCompat;
import android.util.Property;
import android.widget.TextView;

import java.util.ArrayDeque;
import java.util.Queue;

import person.mpatterson.animationtalk.R;
import person.mpatterson.animationtalk.helper.BaseActivity;
import person.mpatterson.animationtalk.helper.Phase;

/**
 * Created by michael on 9/20/16.
 */
public class GoodArgbEvaluatorActivity extends BaseActivity {
    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_argb_evaluator;
    }

    @Override
    protected Queue<Phase> buildPhases() {
        TextView view = (TextView) findViewById(R.id.argb_interpolator);
        Queue<Phase> phases = new ArrayDeque<>();

        Animator whiteToBackground = ObjectAnimator.ofObject(view, TEXT_COLOR, new ArgbEvaluator(), ContextCompat.getColor(this, android.R.color.white), ContextCompat.getColor(this, R.color.background_color));
        whiteToBackground.setDuration(2000);
        phases.add(new Phase(whiteToBackground, false, this));

        Animator backgroundToOrange = ObjectAnimator.ofObject(view, TEXT_COLOR, new ArgbEvaluator(), ContextCompat.getColor(this, R.color.background_color), ContextCompat.getColor(this, android.R.color.holo_orange_light));
        backgroundToOrange.setDuration(2000);
        phases.add(new Phase(backgroundToOrange, false, this));

        Animator orangeToGreen = ObjectAnimator.ofObject(view, TEXT_COLOR, new ArgbEvaluator(), ContextCompat.getColor(this, android.R.color.holo_orange_light), ContextCompat.getColor(this, android.R.color.holo_green_dark));
        orangeToGreen.setDuration(2000);
        phases.add(new Phase(orangeToGreen, false, this));

        Animator greenToWhite = ObjectAnimator.ofObject(view, TEXT_COLOR, new ArgbEvaluator(), ContextCompat.getColor(this, android.R.color.holo_green_dark), ContextCompat.getColor(this, android.R.color.white));
        greenToWhite.setDuration(2000);
        phases.add(new Phase(greenToWhite, false, this));

        return phases;
    }

    @Override
    protected Class getNextActivityClass() {
        return CircularRevealActivity.class;
    }

    public static final Property<TextView, Integer> TEXT_COLOR =
            new Property<TextView, Integer>(Integer.class, "textColor") {

                @Override
                public Integer get(TextView textView) {
                    return textView.getCurrentTextColor();
                }

                @Override
                public void set(TextView object, Integer value) {
                    object.setTextColor(value);
                }
            };
}
