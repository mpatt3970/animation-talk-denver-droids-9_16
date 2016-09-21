package person.mpatterson.animationtalk.ui;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Animatable2;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import java.util.ArrayDeque;
import java.util.Queue;

import person.mpatterson.animationtalk.R;
import person.mpatterson.animationtalk.helper.BaseActivity;
import person.mpatterson.animationtalk.helper.Phase;
import person.mpatterson.animationtalk.widget.BaseLayout;

/**
 * Created by michael on 9/5/16.
 */
public class QuestionsActivity extends BaseActivity {

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_questions;
    }

    @Override
    protected Queue<Phase> buildPhases() {
        Queue<Phase> phases = new ArrayDeque<>();

        Animatable2 slideOut = ((BaseLayout) findViewById(R.id.base_layout)).getAnimatable();
        phases.add(new Phase(slideOut, false, this));

        TextView v = (TextView) findViewById(R.id.questions);
        Animator textReveal = ObjectAnimator.ofObject(v, "textColor", new ArgbEvaluator(),
                v.getCurrentTextColor(), ContextCompat.getColor(this, android.R.color.white));
        textReveal.setDuration(3000);
        phases.add(new Phase(textReveal, true, this));

        return phases;
    }

    @Override
    protected Class getNextActivityClass() {
        return IntroActivity.class;
    }
}
