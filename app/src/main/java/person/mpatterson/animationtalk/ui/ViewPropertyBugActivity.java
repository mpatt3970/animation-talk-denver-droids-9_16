package person.mpatterson.animationtalk.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import java.util.ArrayDeque;
import java.util.Queue;

import person.mpatterson.animationtalk.R;
import person.mpatterson.animationtalk.helper.BaseActivity;
import person.mpatterson.animationtalk.helper.Phase;

/**
 * Created by michael on 9/20/16.
 */
public class ViewPropertyBugActivity extends BaseActivity {

    private View animatedView;
    private boolean pause;
    private boolean exit;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_view_property_bug;
    }

    @Override
    protected Queue<Phase> buildPhases() {
        animatedView = findViewById(R.id.animated_view);
        View reveal = findViewById(R.id.reveal_code);
        Queue<Phase> phases = new ArrayDeque<>();
        Animator animator = ObjectAnimator.ofFloat(reveal, View.ALPHA, 0f, 1f);
        animator.setDuration(1000);
        phases.add(new Phase(animator, false, this));
        return phases;
    }

    @Override
    protected Class getNextActivityClass() {
        if (exit) {
            return AndMoreActivity.class;
        } else if (pause) {
            exit = true;
            animatedView.animate().setListener(null);
        } else {
            pause = true;
            // start animation
            animatedView.animate()
                    .setDuration(2000)
                    .scaleXBy(1.5f)
                    .scaleYBy(1.5f)
                    .setListener(animatorListener)
                    .setInterpolator(new AccelerateDecelerateInterpolator());
        }
        return null;
    }

    private Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animator) {

        }

        @Override
        public void onAnimationEnd(Animator animator) {
            animatedView.animate()
                    .scaleXBy(-1.5f)
                    .scaleYBy(-1.5f);
        }

        @Override
        public void onAnimationCancel(Animator animator) {

        }

        @Override
        public void onAnimationRepeat(Animator animator) {

        }
    };
}
