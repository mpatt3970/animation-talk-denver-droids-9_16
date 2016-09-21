package person.mpatterson.animationtalk.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import person.mpatterson.animationtalk.R;
import person.mpatterson.animationtalk.helper.BaseActivity;
import person.mpatterson.animationtalk.helper.Phase;

public class InterpolatorsActivity extends BaseActivity {

    private float width;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_interpolators;
    }

    @Override
    protected Queue<Phase> buildPhases() {
        Resources res = getResources();
        width = 600 * res.getDisplayMetrics().density - res.getDimensionPixelOffset(R.dimen.white_ball_size);

        View ballLinear = findViewById(R.id.linear_ball_anim);
        View ballAccel = findViewById(R.id.accell_ball_anim);
        View ballAccelDecel = findViewById(R.id.accell_decel_ball_anim);
        View ballDecel = findViewById(R.id.decel_ball_anim);
        View ballBounce = findViewById(R.id.bounce_ball_anim);

        Interpolator linearInterpolator = new LinearInterpolator();
        Interpolator accelerateInterpolator = new AccelerateInterpolator();
        Interpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        Interpolator decelerateInterpolator = new DecelerateInterpolator();
        Interpolator bounceInterpolator = new BounceInterpolator();

        Animator animatorLinear = getForwardAnimator(ballLinear, linearInterpolator);
        Animator animatorAccelerate = getForwardAnimator(ballAccel, accelerateInterpolator);
        Animator animatorAccelerateDecelerate = getForwardAnimator(ballAccelDecel, accelerateDecelerateInterpolator);
        Animator animatorDecelerate = getForwardAnimator(ballDecel, decelerateInterpolator);
        Animator animatorBounce = getForwardAnimator(ballBounce, bounceInterpolator);

        Animator reverseAnimatorLinear = getReverseAnimator(ballLinear, linearInterpolator);
        Animator reverseAnimatorAccelerate = getReverseAnimator(ballAccel, accelerateInterpolator);
        Animator reverseAnimatorAccelerateDecelerate = getReverseAnimator(ballAccelDecel, accelerateDecelerateInterpolator);
        Animator reverseAnimatorDecelerate = getReverseAnimator(ballDecel, decelerateInterpolator);
        Animator reverseAnimatorBounce = getReverseAnimator(ballBounce, bounceInterpolator);

        List<Animator> animators = Arrays.asList(animatorLinear,
                animatorAccelerate,
                animatorAccelerateDecelerate,
                animatorDecelerate,
                animatorBounce);

        Phase p = new Phase(animators, false, this);
        Queue<Phase> phaseQueue = new ArrayDeque<>();
        phaseQueue.add(p);
        phaseQueue.add(new Phase(reverseAnimatorBounce, false, this));
        phaseQueue.add(new Phase(reverseAnimatorDecelerate, true, this));
        phaseQueue.add(new Phase(reverseAnimatorAccelerateDecelerate, true, this));
        phaseQueue.add(new Phase(reverseAnimatorAccelerate, true, this));
        phaseQueue.add(new Phase(reverseAnimatorLinear, true, this));

        return phaseQueue;
    }

    private Animator getForwardAnimator(View ball, Interpolator interpolator) {
        return getAnimator(ball, interpolator, 0, width);
    }

    private Animator getReverseAnimator(View ball, Interpolator interpolator) {
        return getAnimator(ball, interpolator, width, 0);
    }

    private Animator getAnimator(View ball, Interpolator interpolator, float start, float end) {
        Animator animator = ObjectAnimator.ofFloat(ball, View.TRANSLATION_X, start, end);
        animator.setDuration(1000);
        animator.setInterpolator(interpolator);
        return animator;
    }

    @Override
    protected Class getNextActivityClass() {
        return ObjectAnimatorActivity.class;
    }
}
