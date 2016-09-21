package person.mpatterson.animationtalk.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

import java.util.ArrayDeque;
import java.util.Queue;

import person.mpatterson.animationtalk.R;
import person.mpatterson.animationtalk.helper.BaseActivity;
import person.mpatterson.animationtalk.helper.Phase;

/**
 * Created by michael on 9/20/16.
 */
public class ObjectAnimatorActivity extends BaseActivity {
    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_object_animator;
    }

    @Override
    protected Queue<Phase> buildPhases() {
        View transX = findViewById(R.id.trans_x);
        View transY = findViewById(R.id.trans_y);
        View scaleX = findViewById(R.id.scale_x);
        View scaleY = findViewById(R.id.scale_y);
        View alpha = findViewById(R.id.alpha);
        View evaluator = findViewById(R.id.evaluator);
        Queue<Phase> phases = new ArrayDeque<>();

        Animator transXAnim = ObjectAnimator.ofFloat(transX, View.TRANSLATION_X, 0, -1200);
        transXAnim.setDuration(2000);
        phases.add(new Phase(transXAnim, false, this));

        Animator transYAnim = ObjectAnimator.ofFloat(transY, View.TRANSLATION_Y, 0, -600);
        transYAnim.setDuration(1000);
        phases.add(new Phase(transYAnim, false, this));

        Animator scaleXAnim = ObjectAnimator.ofFloat(scaleX, View.SCALE_X, 1, 0);
        scaleXAnim.setDuration(1000);
        phases.add(new Phase(scaleXAnim, false, this));

        Animator scaleYAnim = ObjectAnimator.ofFloat(scaleY, View.SCALE_Y, 1, 0);
        scaleYAnim.setDuration(1000);
        phases.add(new Phase(scaleYAnim, false, this));

        Animator alphaAnim = ObjectAnimator.ofFloat(alpha, View.ALPHA, 1, 0);
        alphaAnim.setDuration(1000);
        phases.add(new Phase(alphaAnim, false, this));

        Animator showEvaluator = ObjectAnimator.ofFloat(evaluator, View.ALPHA, 0, 1);
        showEvaluator.setDuration(1000);
        phases.add(new Phase(showEvaluator, false, this));

        return phases;
    }

    @Override
    protected Class getNextActivityClass() {
        return BadArgbEvaluatorActivity.class;
    }
}
